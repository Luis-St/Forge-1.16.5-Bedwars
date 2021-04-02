package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnExplosionEvent {
	
	// TODO : ExplosionEvent.Start -> creat own explosion
	
	@SubscribeEvent
	public static void Explosion(ExplosionEvent.Detonate event) {
		
		event.getAffectedBlocks().clear();
		
	}

}
