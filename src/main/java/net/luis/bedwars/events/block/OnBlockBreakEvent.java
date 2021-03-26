package net.luis.bedwars.events.block;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBlocks;
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
		
		BlockState state = event.getState();
		PlayerEntity player = event.getPlayer();
		
		if (!player.abilities.isCreativeMode) {
			
			isBedwarsBlock(event, state.getBlock());
			
		}
		
	}
	
	public static void isBedwarsBlock(BlockEvent.BreakEvent event, Block block) {
		
		if (block == Blocks.CUT_SANDSTONE) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.PACKED_ICE) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.SANDSTONE_STAIRS) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.END_STONE) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.NETHERITE_BLOCK) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.LADDER) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.COBWEB) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.NETHERITE_BLOCK) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.SLIME_BLOCK) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.TNT) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.CHEST) {
			
			event.setCanceled(false);
			
		} else if (block == Blocks.ENDER_CHEST) {
			
			event.setCanceled(false);
			
		} else if (block instanceof BedBlock) {
			
			event.setCanceled(false);
			
		} else if (block == ModBlocks.BLOCK_OF_IRON.get()) {
			
			event.setCanceled(false);
			
		} else {
			
			event.setCanceled(true);
			
		}
		
	}

}
