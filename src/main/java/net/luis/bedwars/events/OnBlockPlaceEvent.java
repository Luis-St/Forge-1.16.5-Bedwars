package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			
			if (!player.abilities.isCreativeMode) {
				
				event.setCanceled(!isBedwarsBlock(block));
				
			}
			
		}
		
	}
	
	public static boolean isBedwarsBlock(Block block) {
		
		if (block == Blocks.CUT_SANDSTONE) {
			
			return true;
			
		} else if (block == Blocks.PACKED_ICE) {
			
			return true;
			
		} else if (block == Blocks.GLASS) {
			
			return true;
			
		} else if (block == Blocks.SANDSTONE_STAIRS) {
			
			return true;
			
		} else if (block == Blocks.END_STONE) {
			
			return true;
			
		} else if (block == Blocks.NETHERITE_BLOCK) {
			
			return true;
			
		} else if (block == Blocks.LADDER) {
			
			return true;
			
		} else if (block == Blocks.COBWEB) {
			
			return true;
			
		} else if (block == Blocks.NETHERITE_BLOCK) {
			
			return true;
			
		} else if (block == Blocks.SLIME_BLOCK) {
			
			return true;
			
		} else if (block == Blocks.TNT) {
			
			return true;
			
		} else if (block == Blocks.CHEST) {
			
			return true;
			
		} else if (block == Blocks.ENDER_CHEST) {
			
			return true;
			
		}
		
		return false;
		
	}

}
