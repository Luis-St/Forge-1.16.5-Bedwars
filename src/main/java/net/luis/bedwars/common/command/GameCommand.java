package net.luis.bedwars.common.command;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class GameCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		
		dispatcher.register(Commands.literal("game").requires(commandSource -> {
			
			return commandSource.hasPermissionLevel(3);
			
		}).then(Commands.literal("start").executes(context -> {
			
			return 0;
			
		})).then(Commands.literal("stop").executes(context -> {
			
			return 0;
			
		})));
		
	}
	
	private static void stopGame() {
		
		
		
	}
	
	private static void startGame() {
		
		
		
	}

}
