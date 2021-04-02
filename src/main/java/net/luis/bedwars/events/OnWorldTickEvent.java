package net.luis.bedwars.events;

import java.util.List;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.events.block.OnBlockInteractEvent;
import net.luis.bedwars.events.block.OnBlockInteractEvent.ColorText;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.block.BedBlock;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnWorldTickEvent {
	
	@SubscribeEvent
	public static void WorldTick(TickEvent.WorldTickEvent event) {
		
		World world = event.world;
		
		if (world instanceof ServerWorld) {
			
			ServerWorld serverWorld = (ServerWorld) world;
			List<ServerPlayerEntity> players = serverWorld.getPlayers();
			
			for (ServerPlayerEntity player : players) {
				
				player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					BlockPos bedHead = new BlockPos(bedwarsHandler.getBedHeadPos());
					BlockPos bedFoot = new BlockPos(bedwarsHandler.getBedFootPos());
					
					if (world.getBlockState(bedHead).getBlock() instanceof BedBlock) {
						
						if (world.getBlockState(bedFoot).getBlock() instanceof BedBlock) {
							
							ColorText color = OnBlockInteractEvent.getColor((BedBlock) world.getBlockState(bedFoot).getBlock());
							
							if (color.getColor() == bedwarsHandler.getTeamColor()) {
								
								bedwarsHandler.setHasBed(true);
								bedwarsHandler.setCanRespawn(true);
								
							} else {
								
								setFalse(bedwarsHandler);
								
							}
							
						} else {
							
							setFalse(bedwarsHandler);
							
						}
						
					} else {
						
						setFalse(bedwarsHandler);
						
					}
					
				});
				
			}
			
		}
		
	}
	
	public static void setFalse(IBedwars bedwarsHandler) {
		
		bedwarsHandler.setCanRespawn(false);
		bedwarsHandler.setHasBed(false);
		
	}

}
