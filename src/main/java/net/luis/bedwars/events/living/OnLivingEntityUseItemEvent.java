package net.luis.bedwars.events.living;

import net.luis.bedwars.Bedwars;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnLivingEntityUseItemEvent {
	
	@SubscribeEvent
	public static void LivingEntityUseItem(LivingEntityUseItemEvent.Finish event) {
		
		LivingEntity livingEntity = event.getEntityLiving();
		
		if (livingEntity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) livingEntity;
			ItemStack stack = event.getItem();
			
			if (stack.getItem() instanceof PotionItem) {
				
				Potion potion = PotionUtils.getPotionFromItem(stack);
				
				if (potion == Potions.WATER) {
					
					player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 400, 0, true, false));
					
				}
				
				event.setResultStack(ItemStack.EMPTY);
				
			}
			
		}
		
	}

}