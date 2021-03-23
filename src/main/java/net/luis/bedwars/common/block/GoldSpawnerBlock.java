package net.luis.bedwars.common.block;

import net.luis.bedwars.common.base.block.ISpawnerBlock;
import net.luis.bedwars.common.tileentities.SpawnBlockTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class GoldSpawnerBlock extends Block implements ISpawnerBlock {

	public GoldSpawnerBlock() {
		
		super(AbstractBlock.Properties.from(Blocks.GOLD_BLOCK));
		
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
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		
		TileEntity tileEntity = world.getTileEntity(pos);
		
		if (tileEntity instanceof SpawnBlockTileEntity) {
			
			SpawnBlockTileEntity spawnBlockTileEntity = (SpawnBlockTileEntity) tileEntity;
			
			if (player.abilities.isCreativeMode) {
				
				if (player.isSneaking()) {
					
					if (spawnBlockTileEntity.isSpawner()) {
						
						spawnBlockTileEntity.setSpawner(false);
						
						if (!world.isRemote) {
							
							player.sendMessage(new StringTextComponent("Der Block ist nun kein Spawner"), player.getUniqueID());
							
						}
						
					} else {
						
						spawnBlockTileEntity.setSpawner(true);
						
						if (!world.isRemote) {
							
							player.sendMessage(new StringTextComponent("Der Block ist nun ein Spawner"), player.getUniqueID());
							
						}
						
					}
					
				} else {
					
					if (!world.isRemote) {
						
						player.sendMessage(new StringTextComponent("Der Block ist Aktuell "
								+ (spawnBlockTileEntity.isSpawner() ? "ein" : "kein") + " Spawner"),
								player.getUniqueID());
						
					}
					
				}
				
				return ActionResultType.SUCCESS;
				
			}
			
		}
		
		return ActionResultType.PASS;
		
	}

	@Override
	public Item getSpawnItem() {
		
		return Items.GOLD_INGOT;
		
	}

	@Override
	public int getSpawnTime() {
		
		return 600;
		
	}

}
