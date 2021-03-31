package net.luis.bedwars.common.base.capability.handler;

import net.luis.bedwars.common.base.capability.interfaces.IGame;
import net.luis.bedwars.common.base.util.BlockGameChangeList;
import net.minecraft.nbt.CompoundNBT;

public class GameHandler implements IGame {

	private boolean game = false;
	private final BlockGameChangeList changeList = new BlockGameChangeList();
	
	public GameHandler() {
		
	}
	
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
		return !game;
	}

	@Override
	public boolean isGameStarted() {
		return game;
	}
	
	@Override
	public BlockGameChangeList getChangeList() {
		return this.changeList;
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
