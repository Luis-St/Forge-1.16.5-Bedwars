package net.luis.bedwars.base.capability.handler;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.base.capability.interfaces.IGame;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GameHandler implements IGame {

	private boolean game = false;
	private List<BlockPos> changeList = new ArrayList<BlockPos>();
	
	@Override
	public void startGame() {
		this.game = true;
	}

	@Override
	public void stopGame() {
		this.game = false;
	}

	@Override
	public boolean isGameStopped() {
		return this.game == false;
	}

	@Override
	public boolean isGameStarted() {
		return this.game == true;
	}
	
	@Override
	public void add(BlockPos pos) {
		this.changeList.add(pos);
	}

	@Override
	public void reset(World world) {
		for (BlockPos blockPos : this.changeList) {
			if (!(world.getBlockState(blockPos).getBlock() instanceof AirBlock)) {
				world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 3);
			}
		}
	}

	@Override
	public List<BlockPos> get() {
		return this.changeList;
	}
	
	@Override
	public void set(List<BlockPos> changeList) {
		this.changeList = changeList;
	}
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putBoolean("game", this.game);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.game = nbt.getBoolean("game");
	}

}
