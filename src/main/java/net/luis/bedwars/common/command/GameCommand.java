package net.luis.bedwars.common.command;

import java.util.List;
import java.util.stream.Collectors;

import com.mojang.brigadier.CommandDispatcher;

import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.base.util.ChatRank;
import net.luis.bedwars.base.util.TeamColor;
import net.luis.bedwars.base.util.stats.StatsHelper;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraft.world.server.ServerWorld;

public class GameCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		
		dispatcher.register(Commands.literal("game").requires(commandSource -> {
			
			return commandSource.hasPermissionLevel(2);
			
		}).executes(context -> {
			
			return gameInfo(context.getSource(), context.getSource().getWorld());
			
		}).then(Commands.literal("start").executes(context -> {
			
			return gameStart(context.getSource(), context.getSource().getWorld());
		
		})).then(Commands.literal("stop").executes(context -> {
			
			return gameStop(context.getSource().getWorld());
		
		}))
//		.then(Commands.literal("options").executes(context -> {
//			
//			return gameOptions(context.getSource());
//			
//		}))
		.then(Commands.literal("reset").executes(context -> {
			
			return gameReset(context.getSource(), context.getSource().getWorld());
			
		})).then(Commands.literal("rank").requires(commandSource -> {
			
			return commandSource.hasPermissionLevel(3);
			
		}).then(Commands.literal("get").then(Commands.argument("player", EntityArgument.player()).executes(context -> {
			
			return gameGetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"));
			
		}))).then(Commands.literal("set").then(Commands.argument("player", EntityArgument.player()).then(Commands.literal("zombie_fighter").executes(context -> {
							
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRank.ZOMBIE_FIGHTER);
							
		})).then(Commands.literal("skeleton_sniper").executes(context -> {
							
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRank.SKELETON_SNIPER);
							
		})).then(Commands.literal("creeper_defuser").executes(context -> {
							
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRank.CREEPER_DEFUSER);
							
		})).then(Commands.literal("wither_killer").executes(context -> {
							
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRank.WITHER_KILLER);
							
		})).then(Commands.literal("dragon_slayer").executes(context -> {
							
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRank.DRAGON_SLAYER);
							
		})).then(Commands.literal("minecraft_god").executes(context -> {
							
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRank.MINECRAFT_GOD);
							
		})).then(Commands.literal("server_admin").executes(context -> {
							
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRank.SERVER_ADMIN);
							
		}))))));
		
	}
	
	private static int gameInfo(CommandSource source, ServerWorld serverWorld) {
		
		serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			boolean flag = gameHandler.isGameStarted();
			source.sendFeedback(new StringTextComponent(flag ? "The game is running" : "The game is paused"), true);
			
		});
		
		return 1;
		
	}
	
	private static int gameStart(CommandSource source, ServerWorld serverWorld) {
		
		serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			if (gameHandler.isGameStopped()) {
				
				gameHandler.startGame();
				List<ServerPlayerEntity> players = serverWorld.getPlayers();
				
				for (ServerPlayerEntity serverPlayer : players) {
					
					serverPlayer.sendMessage(new StringTextComponent("Start the game"), serverPlayer.getUniqueID());
					serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
						
						serverPlayer.setGameType(GameType.SURVIVAL);
						serverPlayer.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
								bedwarsHandler.getRespawnPosY() + 0.5, bedwarsHandler.getRespawnPosZ() + 0.5);
						serverPlayer.inventory.clear(); 
						serverPlayer.getInventoryEnderChest().clear();
						serverPlayer.addPotionEffect(new EffectInstance(Effects.SATURATION, 10, 9, false, false));
						serverPlayer.addPotionEffect(new EffectInstance(Effects.REGENERATION, 10, 9, false, false));
						
					});
					
					StatsHelper statsHelper = new StatsHelper(serverPlayer);
					statsHelper.addRound();				
				
				}
				
			} else {
				
				source.sendFeedback(new StringTextComponent("The game is already running"), true);
				
			}
			
		});
		
		
		return 1;
		
	}
	
	private static int gameStop(ServerWorld serverWorld) {
		
		serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			gameHandler.stopGame();
			List<ServerPlayerEntity> players = serverWorld.getPlayers();
			sendTeamWinMessage(players, serverWorld);
			
			for (ServerPlayerEntity serverPlayer : players) {
				
				serverPlayer.sendMessage(new StringTextComponent("Stop the game"), serverPlayer.getUniqueID());
				serverPlayer.setGameType(GameType.CREATIVE);
				serverPlayer.getInventoryEnderChest().clear();
				serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					serverPlayer.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
							bedwarsHandler.getRespawnPosY() + 0.5, bedwarsHandler.getRespawnPosZ() + 0.5);
					serverPlayer.inventory.clear(); 
					serverPlayer.getInventoryEnderChest().clear();
					
				});
				
			}
			
		});
		
		return 1;
		
	}
	
	private static void sendTeamWinMessage(List<ServerPlayerEntity> players, ServerWorld serverWorld) {
		
		List<ServerPlayerEntity> allPlayers = serverWorld.getPlayers();
		List<ServerPlayerEntity> survivingPlayers = allPlayers;
		survivingPlayers.removeIf(serverPlayer -> serverPlayer.isSpectator());
		ServerPlayerEntity player = survivingPlayers.get(0);
		
		if (player != null) {
			
			IBedwars bedwarsHandler = player.getCapability(ModBedwarsCapability.BEDWARS, null).orElseThrow(NullPointerException::new);
			TeamColor teamColor = bedwarsHandler.getTeamColor();
			
			ITextComponent firstPart = (new StringTextComponent("The team ")).mergeStyle(TextFormatting.RESET);
			ITextComponent secondPart = (new StringTextComponent(teamColor.getName())).mergeStyle(teamColor.getTextFormatting());
			ITextComponent thirdPart = (new StringTextComponent(" win the game")).mergeStyle(TextFormatting.RESET);
			
			for (ServerPlayerEntity serverPlayer : allPlayers) {
				
				serverPlayer.sendMessage(new StringTextComponent("").append(firstPart).append(secondPart).append(thirdPart), player.getUniqueID());
				
			}
			
			for (ServerPlayerEntity serverPlayer : survivingPlayers) {
				
				StatsHelper statsHelper = new StatsHelper(serverPlayer);
				statsHelper.addWin();
				
			}
			
		}
		
	}
	
//	private static int gameOptions(CommandSource source) {
//		
//		source.sendFeedback(new StringTextComponent("There are currently no options"), true);
//		source.sendFeedback(new StringTextComponent("Options will be added in future versions"), true);
//		source.sendFeedback(new StringTextComponent("If this is not the newest version, please update to a newer version"), true);
//		
//		return 1;
//		
//	}
	
	private static int gameReset(CommandSource source, ServerWorld serverWorld) {
		
		serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			if (gameHandler.isGameStopped()) {
				
				int i = gameHandler.getChanges().size();
				gameHandler.resetChanges(serverWorld);
				
				source.sendFeedback(new StringTextComponent("Reset the game"), true);
				source.sendFeedback(new StringTextComponent("Removed " + i + " Blocks"), true);
				
				List<Entity> entities = serverWorld.getEntities().collect(Collectors.toList());
				int j = 0;
				
				for (Entity entity : entities) {
					
					if (entity instanceof ItemEntity) {
						
						entity.remove();
						j++;
						
					}
					
				}
				
				source.sendFeedback(new StringTextComponent("Removed " + j + " Items"), true);
				
			}
			
		});
		
		return 1;
		
	}
	
	private static int gameSetChatRank(CommandSource source, ServerPlayerEntity serverPlayer, ChatRank chatRank) {
		
		serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
			
			bedwarsHandler.setChatRank(chatRank);
			ITextComponent component = new StringTextComponent(chatRank.getRankName()).mergeStyle(chatRank.getRankFormatting());
			source.sendFeedback(new StringTextComponent("The Player " + serverPlayer.getName().getString() + " has now the Chat Rank ").append(component), true);
			
		});
		
		return 1;
		
	}
	
	private static int gameGetChatRank(CommandSource source, ServerPlayerEntity serverPlayer) {
		
		serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
			
			ChatRank chatRank = bedwarsHandler.getChatRank();
			ITextComponent component = new StringTextComponent(chatRank.getRankName()).mergeStyle(chatRank.getRankFormatting());
			source.sendFeedback(new StringTextComponent("The Player " + serverPlayer.getName().getString() + " has the Chat Rank ").append(component), true);
			
		});
		
		return 1;
		
	}
	
}
