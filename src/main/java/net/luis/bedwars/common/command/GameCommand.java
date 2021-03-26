package net.luis.bedwars.common.command;

import com.mojang.brigadier.CommandDispatcher;

import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;
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
			
			if (gameHandler.isGameStarted()) {
				
				source.sendFeedback(new StringTextComponent("The game is running"), true);
				
			} else {
				
				source.sendFeedback(new StringTextComponent("The game is paused"), true);
				
			}
			
		});
		
		return 1;
		
	}
	
	// TODO : add bed rea message
	
	private static int startGame(CommandSource source, ServerWorld world) {
		
		// TODO: info for all player && tp all player to their respawn point
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			gameHandler.startGame();
			source.sendFeedback(new StringTextComponent("Start the game"), true);
			
		});
		
		
		return 1;
		
	}
	
	private static int stopGame(CommandSource source, ServerWorld world) {
		
		// TODO: info for all player && set all player in creative
		
		world.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			gameHandler.stopGame();
			source.sendFeedback(new StringTextComponent("Stop the game"), true);
			
		});
		
		return 1;
		
	}
	
}
