package net.luis.bedwars.common.command;

import java.util.List;

import com.mojang.brigadier.CommandDispatcher;

import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.server.ServerWorld;

public class GameCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		
		dispatcher.register(Commands.literal("game").requires(commandSource -> {
			
			return commandSource.hasPermissionLevel(2);
			
		}).executes(context -> {
			
			return infoGame(context.getSource(), context.getSource().getWorld());
			
		}).then(Commands.literal("start").executes(context -> {
			
			return startGame(context.getSource(), context.getSource().getWorld());
			
		})).then(Commands.literal("stop").executes(context -> {
			
			return stopGame(context.getSource(), context.getSource().getWorld());
			
		})));
		
	}
	
	public static int infoGame(CommandSource source, ServerWorld world) {
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			boolean flag = gameHandler.isGameStarted();
			source.sendFeedback(new StringTextComponent(flag ? "The game is running" : "The game is paused"), true);
			
		});
		
		return 1;
		
	}
	
	private static int startGame(CommandSource source, ServerWorld world) {
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			gameHandler.startGame();
			List<ServerPlayerEntity> players = world.getPlayers();
			
			for (ServerPlayerEntity player : players) {
				
				player.sendMessage(new StringTextComponent("Start the game"), player.getUniqueID());
				player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					player.setGameType(GameType.SURVIVAL);
					player.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
							bedwarsHandler.getRespawnPosY() + 0.5, bedwarsHandler.getRespawnPosZ() + 0.5);
					
				});
				
			}
			
		});
		
		
		return 1;
		
	}
	
	private static int stopGame(CommandSource source, ServerWorld world) {
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			gameHandler.stopGame();
			List<ServerPlayerEntity> players = world.getPlayers();
			
			for (ServerPlayerEntity player : players) {
				
				player.sendMessage(new StringTextComponent("Stop the game"), player.getUniqueID());
				player.setGameType(GameType.CREATIVE);
				player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					player.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
							bedwarsHandler.getRespawnPosY() + 0.5, bedwarsHandler.getRespawnPosZ() + 0.5);
					
				});
				
			}
			
		});
		
		return 1;
		
	}
	
}
