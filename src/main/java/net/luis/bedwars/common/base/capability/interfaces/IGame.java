package net.luis.bedwars.common.base.capability.interfaces;

import net.luis.bedwars.common.base.util.BlockGameChangeList;
import net.minecraft.nbt.CompoundNBT;

public interface IGame {
	
	void startGame();
	void stopGame();
	
	boolean isGameStopped();
	boolean isGameStarted();
	
	BlockGameChangeList getChangeList();
	
	CompoundNBT serializeNBT();
	void deserializeNBT(CompoundNBT nbt);
	
}
