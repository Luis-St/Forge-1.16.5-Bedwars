package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnBlockBreakEvent {
	
	@SubscribeEvent
	public static void BlockBreak(BlockEvent.BreakEvent event) {
		
		BlockState block = event.getState();
		PlayerEntity player = event.getPlayer();
		
		if (!player.abilities.isCreativeMode) {
			
			event.setCanceled(!isBedwarsBlock(block.getBlock()));
			
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
			
		} else if (block instanceof BedBlock) {
			
			return true;
			
		}
		
		return false;
		
	}

}
