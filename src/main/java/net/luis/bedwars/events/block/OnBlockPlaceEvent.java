package net.luis.bedwars.events.block;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnBlockPlaceEvent {
	
	@SubscribeEvent
	public static void BlockPlace(BlockEvent.EntityPlaceEvent event) {
		
		Block block = event.getState().getBlock();
		Entity entity = event.getEntity();
		World world = (World) event.getWorld();
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			
			if (!player.abilities.isCreativeMode) {
				
				isBedwarsBlock(event, block);
				
			}
			
			if (!event.isCanceled()) {
				
				if (world instanceof ServerWorld) {
					
					ServerWorld serverWorld = (ServerWorld) world;
					
					serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
						
						if (gameHandler.isGameStarted()) {
							
							BlockPos pos = event.getPos();
							gameHandler.addChange(pos);
							Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.toString().replace("BlockPos", " "));
							
						}
						
					});
					
				}
				
			}
			
		}
		
	}
	
	public static void isBedwarsBlock(BlockEvent.EntityPlaceEvent event, Block block) {
		
		if (block == Blocks.CUT_SANDSTONE) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.PACKED_ICE) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.GLASS) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.SANDSTONE_STAIRS) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.END_STONE) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.IRON_BLOCK) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.LADDER) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.COBWEB) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.SLIME_BLOCK) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.TNT) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.CHEST) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.ENDER_CHEST) {
			
			event.setCanceled(false);
			
		} else if (block instanceof FireBlock) {
			
			event.setCanceled(false);
			
		} else {
			
			event.setCanceled(true);
			
		}
		
	}

}
