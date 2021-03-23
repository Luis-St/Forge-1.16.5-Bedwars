package net.luis.bedwars.common.base.side;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WebBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SideHelper {
	
	private final World world;
	private final BlockPos pos;
	
	public SideHelper(World world, BlockPos pos) {
		
		this.world = world;
		this.pos = pos;
		
	}
	
	public Side getHorizontalOrRandomSide(Side fallBack) {
		
		List<Side> sideList = this.getAvailabledSides();
		
		if (sideList.contains(Side.UP)) {
			
			return Side.UP;
			
		} else {
			
			return sideList.contains(Side.DOWN) ? Side.DOWN : fallBack;
			
		}
		
	}
	
	public Side getRandomAvailabledSide() {
		
		List<Side> sideList = this.getAvailabledSides();
		Side side = null;
		
		if (sideList.size() > 0 && !sideList.isEmpty()) {
			
			Random rng = new Random();
			side = sideList.get(rng.nextInt(sideList.size()));
			
		}
		
		return side;
		
	}
	
	public List<Side> getAvailabledSides() {
		
		Side[] sides = Side.values();
		List<Side> sideList = new ArrayList<Side>();
		
		for (Side side : sides) {
			
			int posX = this.pos.getX();
			int posY = this.pos.getY();
			int posZ = this.pos.getZ();
			double sideX = side.getX();
			double sideY = side.getY();
			double sideZ = side.getZ();
			
			Block block = this.world.getBlockState(new BlockPos(posX + sideX, posY + sideY, posZ + sideZ)).getBlock();
			
			if (block instanceof AirBlock || block instanceof WebBlock) {
				
				sideList.add(side);
				
			}
			
		}
		
		return sideList;
		
	}
	
	public boolean isOnSideAir(Side side) {
		
		int posX = this.pos.getX();
		int posY = this.pos.getY();
		int posZ = this.pos.getZ();
		double sideX = side.getX();
		double sideY = side.getY();
		double sideZ = side.getZ();
		
		return this.world.getBlockState(new BlockPos(posX + sideX, posY + sideY, posZ + sideZ)).getBlock() instanceof AirBlock;
		
	}
	
	public boolean isOnSideCobweb(Side side) {
		
		int posX = this.pos.getX();
		int posY = this.pos.getY();
		int posZ = this.pos.getZ();
		double sideX = side.getX();
		double sideY = side.getY();
		double sideZ = side.getZ();
		
		return this.world.getBlockState(new BlockPos(posX + sideX, posY + sideY, posZ + sideZ)).getBlock() == Blocks.COBWEB;
		
	}
	
	public Side getSideForSpawn() {
		
		Block up = this.world.getBlockState(this.pos.up()).getBlock();
		Block down = this.world.getBlockState(this.pos.up()).getBlock();
		Block north = this.world.getBlockState(this.pos.up()).getBlock();
		Block east = this.world.getBlockState(this.pos.up()).getBlock();
		Block south = this.world.getBlockState(this.pos.up()).getBlock();
		Block west = this.world.getBlockState(this.pos.up()).getBlock();
		
		if (up instanceof AirBlock || up instanceof WebBlock) {
			
			return Side.UP;
			
		} else if (down instanceof AirBlock || down instanceof WebBlock) {
			
			return Side.DOWN;
			
		} else if (north instanceof AirBlock || north instanceof WebBlock) {
			
			return Side.NORTH;
			
		} else if (east instanceof AirBlock || east instanceof WebBlock) {
			
			return Side.EAST;
			
		} else if (south instanceof AirBlock || south instanceof WebBlock) {
			
			return Side.SOUTH;
			
		} else if (west instanceof AirBlock || west instanceof WebBlock) {
			
			return Side.WEST;
			
		}
		
		return Side.NULL;
		
	}

}
