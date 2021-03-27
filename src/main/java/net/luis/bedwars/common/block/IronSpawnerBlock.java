package net.luis.bedwars.common.block;

import net.luis.bedwars.common.base.block.ISpawnerBlock;
import net.luis.bedwars.common.tileentities.SpawnBlockTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class IronSpawnerBlock extends Block implements ISpawnerBlock {
	
	public IronSpawnerBlock() {
		
		super(AbstractBlock.Properties.from(Blocks.IRON_BLOCK));
		
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		
		return true;
		
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		
		return new SpawnBlockTileEntity();
		
	}
	
	@Override
	public Item getSpawnItem() {
		
		return Items.IRON_INGOT;
		
	}

	@Override
	public int getSpawnTime() {
		
		return 300;
		
	}

}
