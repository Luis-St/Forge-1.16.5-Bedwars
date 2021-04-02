package net.luis.bedwars.base.capability.interfaces;

import java.util.List;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IGame {
	
	void startGame();
	void stopGame();
	
	boolean isGameStopped();
	boolean isGameStarted();
	
	void add(BlockPos pos);
	void reset(World world);
	List<BlockPos> get();
	void set(List<BlockPos> changeList);
	
	CompoundNBT serializeNBT();
	void deserializeNBT(CompoundNBT nbt);
	
}
