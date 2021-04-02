package net.luis.bedwars.events.living;

import net.luis.bedwars.Bedwars;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnLivingDropsEvent {
	
	@SubscribeEvent
	public static void LivingDrops(LivingDropsEvent event) {
		
		LivingEntity livingEntity = event.getEntityLiving();
		
		if (livingEntity instanceof PlayerEntity) {
			
			event.setCanceled(true);
			
		}
		
	}

}
