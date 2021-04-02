package net.luis.bedwars.events.living;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnLivingDamageEvent {
	
	@SubscribeEvent
	public static void LivingDamage(LivingDamageEvent event) {
		
		LivingEntity targetEntity = event.getEntityLiving();
		LivingEntity attackerEntity = (LivingEntity) event.getSource().getTrueSource();
		
		if (targetEntity instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity targetServerPlayer = (ServerPlayerEntity) targetEntity;
			
			if (attackerEntity instanceof ServerPlayerEntity) {
				
				ServerPlayerEntity attackerServerPlayer = (ServerPlayerEntity) attackerEntity;
				
				targetServerPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(targetHandler -> {
					
					attackerServerPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(attackeHandler -> {
						
						if (targetHandler.getTeamColor() == attackeHandler.getTeamColor()) {
							
							event.setCanceled(true);
							
						}
						
					});
					
				});
				
			}
			
		}
		
	}

}
