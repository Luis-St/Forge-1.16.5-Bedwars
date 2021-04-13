package net.luis.bedwars.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;

import net.luis.bedwars.base.util.stats.Stats;
import net.luis.bedwars.init.ModStatsCapability;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class StatsCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		
		dispatcher.register(Commands.literal("stats").executes(context -> {
			
			return statsPrint(context.getSource(), context.getSource().asPlayer());
			
		}).then(Commands.literal("get").executes(context -> {
			
			return statsPrint(context.getSource(), context.getSource().asPlayer());
			
		}).then(Commands.argument("player", EntityArgument.player()).executes(context -> {
			
			return statsPrint(context.getSource(), EntityArgument.getPlayer(context, "player"));
			
		}))).then(Commands.literal("modifiy").requires(commandSource -> {
			
			return commandSource.hasPermissionLevel(2);
			
		}).then(Commands.argument("player", EntityArgument.player()).then(Commands.literal("kills")
				.then(Commands.argument("value", IntegerArgumentType.integer(0)).executes(context -> {
			
			return statsModify(context.getSource(), EntityArgument.getPlayer(context, "player"), "kills", IntegerArgumentType.getInteger(context, "value"));
			
		}))).then(Commands.literal("deaths").then(Commands.argument("value", IntegerArgumentType.integer(0)).executes(context -> {
			
			return statsModify(context.getSource(), EntityArgument.getPlayer(context, "player"), "deaths", IntegerArgumentType.getInteger(context, "value"));
			
		}))).then(Commands.literal("rounds").then(Commands.argument("value", IntegerArgumentType.integer(0)).executes(context -> {
			
			return statsModify(context.getSource(), EntityArgument.getPlayer(context, "player"), "rounds", IntegerArgumentType.getInteger(context, "value"));
			
		}))).then(Commands.literal("wins").then(Commands.argument("value", IntegerArgumentType.integer(0)).executes(context -> {
			
			return statsModify(context.getSource(), EntityArgument.getPlayer(context, "player"), "wins", IntegerArgumentType.getInteger(context, "value"));
			
		}))).then(Commands.literal("broken_beds").then(Commands.argument("value", IntegerArgumentType.integer(0)).executes(context -> {
			
			return statsModify(context.getSource(), EntityArgument.getPlayer(context, "player"), "broken beds", IntegerArgumentType.getInteger(context, "value"));
			
		}))))));
		
	}
	
	private static int statsPrint(CommandSource source, ServerPlayerEntity serverPlayer) {
		
		serverPlayer.getCapability(ModStatsCapability.STATS, null).ifPresent(statsHandler -> {
			
			Stats stats = statsHandler.getStats();
			stats.print(serverPlayer);
			
		});
		
		return 1;
		
	}
	
	private static int statsModify(CommandSource source, ServerPlayerEntity serverPlayer, String stat, int value) {
		
		serverPlayer.getCapability(ModStatsCapability.STATS, null).ifPresent(statsHandler -> {
			
			String name = serverPlayer.getName().getString();
			
			switch (stat) {
			case "kills": {
				statsHandler.setKills(value);
				source.sendFeedback(new StringTextComponent("Set the " + stat + " of the player " + name + " to " + value), true);
			} break;
			case "deaths": {
				statsHandler.setDeaths(value);
				source.sendFeedback(new StringTextComponent("Set the " + stat + " of the player " + name + " to " + value), true);
			} break;
			case "rounds": {
				statsHandler.setRounds(value);
				source.sendFeedback(new StringTextComponent("Set the " + stat + " of the player " + name + " to " + value), true);
			} break;
			case "wins": {
				statsHandler.setWins(value);
				source.sendFeedback(new StringTextComponent("Set the " + stat + " of the player " + name + " to " + value), true);
			} break;
			case "broken beds": {
				statsHandler.setBrokenBeds(value);
				source.sendFeedback(new StringTextComponent("Set the " + stat + " of the player " + name + " to " + value), true);
			} break;
			default: break;
			}
			
		});
		
		return 1;
		
	}

}
