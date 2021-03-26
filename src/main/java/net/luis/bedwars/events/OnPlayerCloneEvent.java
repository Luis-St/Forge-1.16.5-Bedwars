package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnPlayerCloneEvent {
	
	@SubscribeEvent
	public static void LivingUpdate(PlayerEvent.Clone event) {
		
		PlayerEntity oldPlayer = event.getOriginal();
		PlayerEntity newPlayer = event.getPlayer();
		
		oldPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(oldHandler -> {
			
			newPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(newHandler -> {
				
				CompoundNBT nbt = oldHandler.serializeNBT();
				newHandler.deserializeNBT(nbt);
				
			});;
			
		});;
		
	}

}
