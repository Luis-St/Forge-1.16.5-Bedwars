package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnLivingUpdateEvent {
	
	@SubscribeEvent
	public static void LivingUpdate(LivingEvent.LivingUpdateEvent event) {
		
		LivingEntity livingEntity = event.getEntityLiving();
		
		if (livingEntity instanceof VillagerEntity) {
			
			VillagerEntity villager = (VillagerEntity) livingEntity;
			VillagerData data = villager.getVillagerData();
			villager.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 9, false, false));
			villager.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 9, false, false));
			
			if (data.getLevel() == 5) {
				
				villager.setNoAI(true);
				villager.setSilent(true);
				
			}
			
		}
		
	}

}
