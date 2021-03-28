package net.luis.bedwars.common.base.capability.interfaces;

import net.minecraft.nbt.CompoundNBT;

public interface IGame {
	
	void startGame();
	
	void stopGame();
	
	boolean isGameStopped();
	
	boolean isGameStarted();
	
	CompoundNBT serializeNBT();
	
	void deserializeNBT(CompoundNBT nbt);
	
}
