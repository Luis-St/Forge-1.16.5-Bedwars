package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnVillagerTradesEvent {
	
	@SubscribeEvent
	public static void VillagerTrade(VillagerTradesEvent event) {
		
		
		
	}

}
