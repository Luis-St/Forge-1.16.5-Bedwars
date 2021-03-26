package net.luis.bedwars.common.item;

import net.luis.bedwars.Bedwars;
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
import net.minecraft.world.World;

public class BlazeRodItem extends Item {
	
	public BlazeRodItem() {
		
		super(new Item.Properties().group(Bedwars.BEDWARS));
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		if (player instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			BlockPos pos = new BlockPos(serverPlayer.getPosX(), serverPlayer.getPosY() - 2, serverPlayer.getPosZ());
			
			if (world.getBlockState(pos).getBlock() instanceof AirBlock) {
				
				this.creatPlatform(world, pos, Blocks.GLASS);
				player.fallDistance /= 4;
				
				if (player.abilities.isCreativeMode) {
					
					player.getHeldItemMainhand().shrink(1);
					
				}
				
				
			}
			
		}
		
		return super.onItemRightClick(world, player, hand);
		
	}
	
	public void creatPlatform(World world, BlockPos pos, Block block) {
		
		world.setBlockState(pos, block.getDefaultState(), 3);
		world.setBlockState(pos.north(), block.getDefaultState(), 3);
		world.setBlockState(pos.east(), block.getDefaultState(), 3);
		world.setBlockState(pos.south(), block.getDefaultState(), 3);
		world.setBlockState(pos.west(), block.getDefaultState(), 3);
		world.setBlockState(pos.north().east(), block.getDefaultState(), 3);
		world.setBlockState(pos.east().south(), block.getDefaultState(), 3);
		world.setBlockState(pos.south().west(), block.getDefaultState(), 3);
		world.setBlockState(pos.west().north(), block.getDefaultState(), 3);
		world.setBlockState(pos.north(2), block.getDefaultState(), 3);
		world.setBlockState(pos.east(2), block.getDefaultState(), 3);
		world.setBlockState(pos.south(2), block.getDefaultState(), 3);
		world.setBlockState(pos.west(2), block.getDefaultState(), 3);
		
	}

}
