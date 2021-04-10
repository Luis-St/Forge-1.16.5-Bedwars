package net.luis.bedwars.events.living;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.base.util.stats.StatsHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnLivingDeathEvent {
	
	@SubscribeEvent
	public static void LivingDeath(LivingDeathEvent event) {
		
		LivingEntity livingEntity = event.getEntityLiving();
		
		if (livingEntity instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity target = (ServerPlayerEntity) livingEntity;
			Entity entity = event.getSource().getTrueSource();
			
			if (entity instanceof ServerPlayerEntity) {
				
				ServerPlayerEntity attacker = (ServerPlayerEntity) entity;
				StatsHelper statsAttacker = new StatsHelper(attacker);
				
				statsAttacker.addKill();
				
			}
			
			StatsHelper statsTarget = new StatsHelper(target);
			statsTarget.addDeath();
			
		}
		
	}
	
}