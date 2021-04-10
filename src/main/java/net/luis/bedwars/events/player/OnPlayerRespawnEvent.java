package net.luis.bedwars.events.player;

import java.util.List;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.base.util.TeamColor;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnPlayerRespawnEvent {
	
	@SubscribeEvent
	public static void PlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
		
		PlayerEntity player = event.getPlayer();
		
		if (player instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			
			serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
				
				serverPlayer.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
						bedwarsHandler.getRespawnPosY(), bedwarsHandler.getRespawnPosZ() + 0.5);
				
				if (!bedwarsHandler.canRespawn()) {

					serverPlayer.setGameType(GameType.SPECTATOR);
					
					if (isTeamDestroyed(serverPlayer.getServerWorld(), bedwarsHandler.getTeamColor())) {
						
						sendTeamDestroyedMessage(serverPlayer.getServerWorld(), bedwarsHandler.getTeamColor());
						
					}
					
				}
				
			});
			
		}
		
	}
	
	public static boolean isTeamDestroyed(ServerWorld serverWorld, TeamColor teamColor) {
		
		List<ServerPlayerEntity> players = serverWorld.getPlayers();
		int i = 0;
		
		for (ServerPlayerEntity serverPlayer : players) {
			
			IBedwars bedwarsHandler = serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).orElseThrow(NullPointerException::new);
			
			if (bedwarsHandler.getTeamColor() == teamColor) {
				
				i++;
				
			}
			
		}
		
		return i == 0;
		
	}
	
	public static void sendTeamDestroyedMessage(ServerWorld serverWorld, TeamColor teamColor) {
		
		List<ServerPlayerEntity> players = serverWorld.getPlayers();
		ITextComponent firstPart = (new StringTextComponent("The team ")).mergeStyle(TextFormatting.RESET);
		ITextComponent secondPart = (new StringTextComponent(teamColor.getName())).mergeStyle(teamColor.getTextFormatting());
		ITextComponent thirdPart = (new StringTextComponent(" was destroyed")).mergeStyle(TextFormatting.RESET);
		
		for (ServerPlayerEntity player : players) {
			
			player.sendMessage(new StringTextComponent("").append(firstPart).append(secondPart).append(thirdPart), player.getUniqueID());
			
		}
		
	}
	
}
