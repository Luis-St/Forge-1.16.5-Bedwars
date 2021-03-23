package net.luis.bedwars.common.tileentities;

import net.luis.bedwars.common.base.block.ISpawnerBlock;
import net.luis.bedwars.common.base.side.Side;
import net.luis.bedwars.common.base.side.SideHelper;
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
	
	private boolean isSpawner;

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
				
				if (this.isSpawner()) {
					
					ISpawnerBlock spawnerBlock = (ISpawnerBlock) block;
					this.spawnItem(world, pos, spawnerBlock.getSpawnItem(), spawnerBlock.getSpawnTime());
					
				}
				
			}
			
		}
		
	}

	protected void spawnItem(World world, BlockPos pos, Item item, int time) {
		
		if (!world.isRemote) {
			
			if (world.getGameTime() % time == 0) {
				
				SideHelper sideHelper = new SideHelper(world, pos);
				Side side = sideHelper.getHorizontalOrRandomSide(sideHelper.getRandomAvailabledSide());
				ItemEntity itemEntity = this.creatItem(side, world, pos, item, sideHelper.isOnSideCobweb(side));
				itemEntity.setDefaultPickupDelay();
				
				if (side.canSpawn()) {
					
					world.addEntity(itemEntity);
					
				}
				
			}
			
		}
		
	}
	
	protected ItemEntity creatItem(Side side, World world, BlockPos pos, Item item , boolean cobweb) {
		
		int posX = pos.getX();
		int posY = pos.getY();
		int posZ = pos.getZ();
		double sideX = side.getX();
		double sideY = side.getY();
		double sideZ = side.getZ();
		
		ItemEntity itemEntity = new ItemEntity(world, posX + sideX, posY + sideY, posZ + sideZ, new ItemStack(item));
		
		if (cobweb) {
			
			itemEntity.setMotion(0, 0, 0);
			
		}
		
		return itemEntity;
		
	}
	
	protected boolean disableItemMotion(SideHelper sideHelper, Side side) {
		
		return sideHelper.isOnSideCobweb(side);
		
	}

	public boolean isSpawner() {
		
		return isSpawner;
		
	}

	public void setSpawner(boolean isSpawner) {
		
		this.isSpawner = isSpawner;
		
	}
	
}
