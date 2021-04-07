package net.luis.bedwars.events.player;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnPlayerTickEvent {
	
	@SubscribeEvent
	public static void PlayerTick(TickEvent.PlayerTickEvent event) {
		
		PlayerEntity player = event.player;
		World world = player.getEntityWorld();
		
		if (world.getGameTime() % 20 == 0) {
			
			if (event.phase == Phase.START && player instanceof ServerPlayerEntity) {
				
				ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
				serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					if (world instanceof ServerWorld) {
						
						ServerWorld serverWorld = (ServerWorld) world;
						serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
							
							if (bedwarsHandler.hasBed() && gameHandler.isGameStarted()) {
								
								serverPlayer.setGameType(GameType.SURVIVAL);
								
							}
							
						});
						
					}
					
					if (bedwarsHandler.getGunpowderCooldown() > 0) {
						
						bedwarsHandler.setGunpowderCooldown(bedwarsHandler.getGunpowderCooldown() - 1);
						
					}
					
					if (bedwarsHandler.getBlazeRodCooldown() > 0) {
						
						bedwarsHandler.setBlazeRodCooldown(bedwarsHandler.getBlazeRodCooldown() - 1);
						
					}
					
					if (bedwarsHandler.canTeleport()) {
						
						if (bedwarsHandler.getGunpowderTeleportCooldown() > 0) {
							
							if (bedwarsHandler.getGunpowderTeleportCooldown() > 0) {

								bedwarsHandler.setGunpowderTeleportCooldown(bedwarsHandler.getGunpowderTeleportCooldown() - 1);
								serverPlayer.addExperienceLevel(-1);

							}
							
						}
						
					}
					
				});
				
			}
			
		}
		
	}

}
