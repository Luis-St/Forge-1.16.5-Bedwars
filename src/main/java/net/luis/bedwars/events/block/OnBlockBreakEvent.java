package net.luis.bedwars.events.block;

import java.util.List;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnBlockBreakEvent {
	
	@SubscribeEvent
	public static void BlockBreak(BlockEvent.BreakEvent event) {
		
		BlockState state = event.getState();
		PlayerEntity eventPlayer = event.getPlayer();
		World world = (World) event.getWorld();
		
		if (!eventPlayer.abilities.isCreativeMode) {
			
			if (state.getBlock() instanceof BedBlock) {
				
				if (world instanceof ServerWorld && eventPlayer instanceof ServerPlayerEntity) {
					
					ServerWorld serverWorld = (ServerWorld) world;
					List<ServerPlayerEntity> players = serverWorld.getPlayers();
					
					serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
						
						if (gameHandler.isGameStarted()) {
							
							for (ServerPlayerEntity player : players) {
								
								player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
									
									if (bedwarsHandler.hasBedAt(event.getPos())) {
										
										sendBedBreakMessage(players, bedwarsHandler.getTeamColor());
										
									}
									
								});
								
							}
							
						}
						
					});
					
				}
				
			} else {
				
				isBedwarsBlock(event, state.getBlock());
				
			}
			
		}
		
	}
	
	public static void sendBedBreakMessage(List<ServerPlayerEntity> players, DyeColor color) {
		
		for (ServerPlayerEntity player : players) {
			
			player.sendMessage(new StringTextComponent("Das Bett von Team " + color.getTranslationKey() + " wurde abgebaut"), player.getUniqueID());
			
		}
		
	}
	
	public static void isBedwarsBlock(BlockEvent.BreakEvent event, Block block) {
		
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
			
		} else if (block instanceof AbstractPlantBlock) {
			
			event.setCanceled(false);
			
		} else if (block instanceof IPlantable) {
			
			event.setCanceled(false);
			
		} else if (block instanceof FlowerBlock) {
			
			event.setCanceled(false);
			
		} else {
			
			event.setCanceled(true);
			
		}
		
	}

}
