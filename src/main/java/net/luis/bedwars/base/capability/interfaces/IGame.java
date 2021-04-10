package net.luis.bedwars.base.capability.interfaces;

import java.util.List;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IGame extends SerializeNBT {
	
	void startGame();
	void stopGame();
	
	boolean isGameStopped();
	boolean isGameStarted();
	
	void addChange(BlockPos pos);
	void resetChanges(World world);
	List<BlockPos> getChanges();
	void setChanges(List<BlockPos> changeList);
	
}
