package net.luis.bedwars.common.base.util;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPosContext {
	
	private final BlockPos pos;
	private final BlockState oldState;
	private final BlockState newState;
	
	public BlockPosContext(BlockPos pos, BlockState oldState, BlockState newState) {
		
		this.pos = pos;
		this.oldState = oldState;
		this.newState = newState;
		
	}
	
	public BlockPosContext(BlockPos pos, BlockState newState) {
		
		this(pos, Blocks.AIR.getDefaultState(), newState);
		
	}
	
	public BlockPos getPos() {
		
		return this.pos;
		
	}
	
	public BlockState getOldState() {
		
		return this.oldState;
		
	}
	
	public BlockState getNewState() {
		
		return this.newState;
		
	}
	
	public boolean oldEqualsCurrent(World world) {
		
		BlockState currentState = world.getBlockState(this.getPos());
		
		return currentState.getBlock() == this.getOldState().getBlock();
		
	}
	
	public boolean oldEqualsNew(World world) {
		
		return this.getNewState().getBlock() == this.getOldState().getBlock();
		
	}
	
	public void replaceWithOldState(World world) {
		
		if (!this.oldEqualsCurrent(world)) {
			
			world.setBlockState(this.getPos(), this.getOldState(), 3);
			
		}
		
	}
	
}
