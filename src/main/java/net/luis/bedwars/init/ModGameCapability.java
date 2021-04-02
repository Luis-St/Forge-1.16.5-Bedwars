package net.luis.bedwars.init;

import java.util.concurrent.Callable;

import net.luis.bedwars.base.capability.handler.GameHandler;
import net.luis.bedwars.base.capability.interfaces.IGame;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ModGameCapability {
	
	public static Capability<IGame> GAME = null;
	
	public static class GameStorage implements IStorage<IGame> {
		@Override
		public INBT writeNBT(Capability<IGame> capability, IGame instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IGame> capability, IGame instance, Direction side, INBT nbt) {
		}
	}
	
	public static class GameFactory implements Callable<IGame> {
		@Override
		public IGame call() throws Exception {
			return null;
		}
	}
	
	public static class GameProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private GameHandler gameHandler = new GameHandler();
		private LazyOptional<GameHandler> gameOptional = LazyOptional.of(() -> gameHandler);
		
		public GameProvider() {
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == GAME ? (LazyOptional<T>) gameOptional : LazyOptional.empty();
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			return this.gameHandler.serializeNBT();
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			this.gameHandler.deserializeNBT(nbt);
			
		}
		
	}

}
