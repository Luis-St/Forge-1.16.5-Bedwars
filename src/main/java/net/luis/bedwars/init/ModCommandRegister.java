package net.luis.bedwars.init;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.command.GameCommand;
import net.luis.bedwars.common.command.StatsCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class ModCommandRegister {
	
	@SubscribeEvent
	public static void AttachCapabilitiesEntity(RegisterCommandsEvent event) {
		
		GameCommand.register(event.getDispatcher());
		StatsCommand.register(event.getDispatcher());
		
	}

}
