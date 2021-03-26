package net.luis.bedwars.events.player;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.GameType;
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
			
			player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
				
				if (!bedwarsHandler.canRespawn()) {
					
					player.setGameType(GameType.SPECTATOR);
					player.setPositionAndUpdate(bedwarsHandler.getRespawnPosX(), bedwarsHandler.getRespawnPosY(), bedwarsHandler.getRespawnPosZ());
					
				}
				
			});
			
		}
		
	}

}
