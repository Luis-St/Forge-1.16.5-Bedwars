package net.luis.bedwars.common.command;

import java.util.List;

import com.mojang.brigadier.CommandDispatcher;

import net.luis.bedwars.base.util.ChatRank;
import net.luis.bedwars.common.command.args.ChatRankArgument;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
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
			
			return gameStop(context.getSource(), context.getSource().getWorld());
		
		})).then(Commands.literal("options").executes(context -> {
			
			return gameOptions(context.getSource());
			
		})).then(Commands.literal("reset").executes(context -> {
			
			return gameReset(context.getSource(), context.getSource().getWorld());
			
		})).then(Commands.literal("rank").requires(commandSource -> {
			
			return commandSource.hasPermissionLevel(4);
			
		}).then(Commands.literal("set")
			.then(Commands.argument("player", EntityArgument.player())
			.then(Commands.argument("chat_rank", ChatRankArgument.chatRank())).executes(context -> {
			
			return gameSetChatRank(context.getSource(), EntityArgument.getPlayer(context, "player"), ChatRankArgument.getChatRank(context, "chat_rank"));
			
		})))));
		
	}
	
	private static int gameInfo(CommandSource source, ServerWorld world) {
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			boolean flag = gameHandler.isGameStarted();
			source.sendFeedback(new StringTextComponent(flag ? "The game is running" : "The game is paused"), true);
			
		});
		
		return 1;
		
	}
	
	private static int gameStart(CommandSource source, ServerWorld world) {
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			gameHandler.startGame();
			List<ServerPlayerEntity> players = world.getPlayers();
			
			for (ServerPlayerEntity player : players) {
				
				player.sendMessage(new StringTextComponent("Start the game"), player.getUniqueID());
				player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					player.setGameType(GameType.SURVIVAL);
					player.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
							bedwarsHandler.getRespawnPosY() + 0.5, bedwarsHandler.getRespawnPosZ() + 0.5);
					player.inventory.clear(); 
					player.getInventoryEnderChest().clear();
					player.addPotionEffect(new EffectInstance(Effects.SATURATION, 10, 9));
					player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 10, 9));
					
				});
				
			}
			
		});
		
		
		return 1;
		
	}
	
	private static int gameStop(CommandSource source, ServerWorld world) {
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			gameHandler.stopGame();
			List<ServerPlayerEntity> players = world.getPlayers();
			
			for (ServerPlayerEntity player : players) {
				
				player.sendMessage(new StringTextComponent("Stop the game"), player.getUniqueID());
				player.setGameType(GameType.CREATIVE);
				player.getInventoryEnderChest().clear();
				player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					player.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
							bedwarsHandler.getRespawnPosY() + 0.5, bedwarsHandler.getRespawnPosZ() + 0.5);
					player.inventory.clear(); 
					player.getInventoryEnderChest().clear();
					
				});
				
			}
			
		});
		
		return 1;
		
	}
	
	private static int gameOptions(CommandSource source) {
		
		source.sendFeedback(new StringTextComponent("There are currently no options"), true);
		source.sendFeedback(new StringTextComponent("Options will be added in future versions"), true);
		source.sendFeedback(new StringTextComponent("If this is not the newest version, please update to a newer version"), true);
		
		return 1;
		
	}
	
	private static int gameReset(CommandSource source, ServerWorld world) {
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			if (gameHandler.isGameStopped()) {
				
				int i = gameHandler.get().size();
				gameHandler.reset(world);
				List<ServerPlayerEntity> players = world.getPlayers();
				
				for (ServerPlayerEntity player : players) {
					
					player.sendMessage(new StringTextComponent("Reset the game"), player.getUniqueID());
					player.sendMessage(new StringTextComponent("Removed " + i + " Blocks"), player.getUniqueID());
					
				}
				
			}
			
		});
		
		return 1;
		
	}
	
	private static int gameSetChatRank(CommandSource source, ServerPlayerEntity serverPlayer, ChatRank chatRank) {
		
		serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
			
			bedwarsHandler.setChatRank(chatRank);
			source.sendFeedback(new StringTextComponent("The Player " + serverPlayer.getName() + " has now the Chat Rank " + chatRank.getRankName()), true);
			
		});
		
		return 1;
		
	}
	
}
