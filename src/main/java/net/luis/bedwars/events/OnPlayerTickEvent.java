package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnPlayerTickEvent {
	
	@SubscribeEvent
	public static void WorldTick(TickEvent.PlayerTickEvent event) {
		
		PlayerEntity player = event.player;
		
		if (player.getEntityWorld().getGameTime() % 10 == 0) {
			
			if (event.phase == Phase.START) {
				
				player.getCapability(ModCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					
					
				});
				
			}
			
		}
		
	}

}
