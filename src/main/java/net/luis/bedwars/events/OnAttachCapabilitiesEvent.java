package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModGameCapability;
import net.luis.bedwars.init.ModTeamCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnAttachCapabilitiesEvent {
	
	@SubscribeEvent
	public static void AttachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event) {
		
		if (event.getObject() instanceof PlayerEntity) {
			
			event.addCapability(new ResourceLocation(Bedwars.MOD_ID, "bedwars_capability"), new ModBedwarsCapability.BedwarsProvider());
			
		}
		
	}
	
	@SubscribeEvent
	public static void AttachCapabilitiesWorld(AttachCapabilitiesEvent<World> event) {
		
		if (event.getObject() instanceof ServerWorld) {
			
			event.addCapability(new ResourceLocation(Bedwars.MOD_ID, "game_capability"), new ModGameCapability.GameProvider());
			
		}
		
		if (event.getObject() instanceof World) {
			
			event.addCapability(new ResourceLocation(Bedwars.MOD_ID, "team_capability"), new ModTeamCapability.TeamProvider());
			
		}
		
	}

}
