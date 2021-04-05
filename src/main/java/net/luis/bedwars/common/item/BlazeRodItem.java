package net.luis.bedwars.common.item;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModGameCapability;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BlazeRodItem extends Item {
	
	public BlazeRodItem() {
		
		super(new Item.Properties().group(Bedwars.BEDWARS));
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		if (player instanceof ServerPlayerEntity && world instanceof ServerWorld) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			ServerWorld serverWorld = (ServerWorld) world;
			BlockPos pos = new BlockPos(serverPlayer.getPosX(), serverPlayer.getPosY() - 2, serverPlayer.getPosZ());
			
			if (world.getBlockState(pos).getBlock() instanceof AirBlock) {
				
				serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					if (bedwarsHandler.getBlazeRodCooldown() == 0) {
						
						bedwarsHandler.setBlazeRodCooldown(5);
						this.creatPlatform(serverWorld, pos, Blocks.GLASS);
						player.fallDistance /= 4;
						
						if (!player.abilities.isCreativeMode) {
							
							player.getHeldItemMainhand().shrink(1);
							
						}
						
					} else {
						
						serverPlayer.sendMessage(new StringTextComponent("You can use this item in "
								+ bedwarsHandler.getBlazeRodCooldown() + " seconds"), player.getUniqueID());
						
					}
					
				});
				
				
			}
			
		}
		
		return super.onItemRightClick(world, player, hand);
		
	}
	
	public void creatPlatform(ServerWorld serverWorld, BlockPos pos, Block block) {
		
		serverWorld.getCapability(ModGameCapability.GAME, null).ifPresent(gameHandler -> {
			
			if (serverWorld.getBlockState(pos).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos, block.getDefaultState(), 3);
				gameHandler.add(pos);
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.toString().replace("BlockPos", " "));
				
			} 
			
			if (serverWorld.getBlockState(pos.north()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.north(), block.getDefaultState(), 3);
				gameHandler.add(pos.north());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.north().toString().replace("BlockPos", " "));
				
			} 
			
			if (serverWorld.getBlockState(pos.east()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.east(), block.getDefaultState(), 3);
				gameHandler.add(pos.east());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.east().toString().replace("BlockPos", " "));
				
			} 
			
			if (serverWorld.getBlockState(pos.south()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.south(), block.getDefaultState(), 3);
				gameHandler.add(pos.south());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.south().toString().replace("BlockPos", " "));
				
			}
			
			if (serverWorld.getBlockState(pos.west()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.west(), block.getDefaultState(), 3);
				gameHandler.add(pos.west());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.west().toString().replace("BlockPos", " "));
				
			} 
			
			if (serverWorld.getBlockState(pos.north().east()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.north().east(), block.getDefaultState(), 3);
				gameHandler.add(pos.north().east());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.north().east().toString().replace("BlockPos", " "));
				
			}
			
			if (serverWorld.getBlockState(pos.east().south()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.east().south(), block.getDefaultState(), 3);
				gameHandler.add(pos.east().south());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.east().south().toString().replace("BlockPos", " "));
				
			}
			
			if (serverWorld.getBlockState(pos.south().west()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.south().west(), block.getDefaultState(), 3);
				gameHandler.add(pos.south().west());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.south().west().toString().replace("BlockPos", " "));
				
			}
			
			if (serverWorld.getBlockState(pos.west().north()).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.west().north(), block.getDefaultState(), 3);
				gameHandler.add(pos.west().north());
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.west().north().toString().replace("BlockPos", " "));
				
			}
			
			if (serverWorld.getBlockState(pos.north(2)).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.north(2), block.getDefaultState(), 3);
				gameHandler.add(pos.north(2));
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.north(2).toString().replace("BlockPos", " "));
				
			}  
			
			if (serverWorld.getBlockState(pos.east(2)).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.east(2), block.getDefaultState(), 3);
				gameHandler.add(pos.east(2));
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.east(2).toString().replace("BlockPos", " "));
				
			}
		
			if (serverWorld.getBlockState(pos.south(2)).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.south(2), block.getDefaultState(), 3);
				gameHandler.add(pos.south(2));
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.south(2).toString().replace("BlockPos", " "));
				
			} 
			
			if (serverWorld.getBlockState(pos.west(2)).getBlock() instanceof AirBlock) {
				
				serverWorld.setBlockState(pos.west(2), block.getDefaultState(), 3);
				gameHandler.add(pos.west(2));
				Bedwars.LOGGER.info("Add Pos to Block Change List" + pos.west(2).toString().replace("BlockPos", " "));
				
			}
			
		});
		
	}

}
