package net.luis.bedwars.common.tileentities;

import net.luis.bedwars.common.base.block.ISpawnerBlock;
import net.luis.bedwars.init.ModTileEntityType;
import net.minecraft.block.Block;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpawnBlockTileEntity extends TileEntity implements ITickableTileEntity {

	public SpawnBlockTileEntity() {
		
		super(ModTileEntityType.SPAWNER.get());
		
	}

	@Override
	public void tick() {
		
		World world = this.getWorld();
		BlockPos pos = this.getPos();
		
		if (world != null) {
			
			Block block = world.getBlockState(pos).getBlock();
			
			if (block instanceof ISpawnerBlock) {
				
				ISpawnerBlock spawnerBlock = (ISpawnerBlock) block;
				this.spawnItem(world, pos, spawnerBlock.getSpawnItem(), spawnerBlock.getSpawnTime());
				
			}
			
		}
		
	}

	protected void spawnItem(World world, BlockPos pos, Item item, int time) {
		
		if (!world.isRemote) {
			
			if (world.getGameTime() % time == 0) {
				
				ItemEntity itemEntity = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, new ItemStack(item));
				itemEntity.setDefaultPickupDelay();
				world.addEntity(itemEntity);
				
			}
			
		}
		
	}
	
}
