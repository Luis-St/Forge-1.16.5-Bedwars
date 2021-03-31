package net.luis.bedwars.common.base.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class BlockGameChangeList {
	
	private List<BlockPosContext> changeList;
	
	public BlockGameChangeList() {
		
	}
	
	public BlockGameChangeList(BlockPosContext... blockPosContext) {
		
		this.changeList = new ArrayList<BlockPosContext>();
		changeList.addAll(changeList);
		
	}
	
	public BlockGameChangeList(List<BlockPos> pos, List<BlockState> oldState, List<BlockState> newState) {
		
		int size = pos.size();
		List<BlockPosContext> changeList = new ArrayList<BlockPosContext>();
		
		if (size == oldState.size() && size == newState.size()) {
			
			for (int i = 0; i < pos.size(); i++) {
				
				changeList.add(new BlockPosContext(pos.get(i), oldState.get(i), newState.get(i)));
				
			}
			
		} else {
			
			throw new IllegalArgumentException("The lists given in the constructor do not have the same length");
			
		}
		
		this.changeList = changeList;
		
	}
	
	public void creat() {
		
		if (this.changeList == null) {
			
			this.changeList = new ArrayList<BlockPosContext>();
			
		}
		
	}
	
	public void add(BlockPosContext blockPosContext) {
		
		this.changeList.add(blockPosContext);
		
	}
	
	public void remove(int i) {
		
		this.changeList.remove(i);
		
	}
	
	public void removeFirst() {
		
		if (!this.changeList.isEmpty()) {
			
			this.remove(0);
			
		}
		
	}
	
	public void removeAll() {
		
		this.changeList.clear();
		
	}
	
}
