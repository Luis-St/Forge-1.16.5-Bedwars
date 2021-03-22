package net.luis.bedwars.events;

import java.util.List;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.base.capability.IBedwars;
import net.luis.bedwars.init.ModCapability;
import net.minecraft.block.BedBlock;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.BedTileEntity;
import net.minecraft.tileentity.TileEntity;
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
				
				player.getCapability(ModCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					BlockPos bedHead = new BlockPos(bedwarsHandler.getBedHeadPos());
					BlockPos bedFoot = new BlockPos(bedwarsHandler.getBedFootPos());
					
					if (world.getBlockState(bedHead).getBlock() instanceof BedBlock) {
						
						if (world.getBlockState(bedFoot).getBlock() instanceof BedBlock) {
							
							TileEntity tileEntity = world.getTileEntity(bedFoot);
							
							if (tileEntity instanceof BedTileEntity) {
								
								DyeColor color = ((BedTileEntity) tileEntity).getColor();
								
								if (color == bedwarsHandler.getTeamColor()) {
									
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
