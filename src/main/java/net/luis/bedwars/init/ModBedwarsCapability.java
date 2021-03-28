package net.luis.bedwars.init;

import java.util.concurrent.Callable;

import net.luis.bedwars.common.base.capability.handler.BedwarsHandler;
import net.luis.bedwars.common.base.capability.interfaces.IBedwars;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.LazyOptional;

public class ModBedwarsCapability {
	
	public static Capability<IBedwars> BEDWARS = null;
	
	public static class BedwarsStorage implements IStorage<IBedwars> {
		@Override
		public INBT writeNBT(Capability<IBedwars> capability, IBedwars instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IBedwars> capability, IBedwars instance, Direction side, INBT nbt) {
		}
	}
	
	public static class BedwarsFactory implements Callable<IBedwars> {
		@Override
		public IBedwars call() throws Exception {
			return null;
		}
	}
	
	public static class BedwarsProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private BedwarsHandler bedwarsHandler = new BedwarsHandler();
		private LazyOptional<BedwarsHandler> bedwarsOptional = LazyOptional.of(() -> bedwarsHandler);
		
		public BedwarsProvider() {
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == BEDWARS ? (LazyOptional<T>) bedwarsOptional : LazyOptional.empty();
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			return this.bedwarsHandler.serializeNBT();
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			this.bedwarsHandler.deserializeNBT(nbt);
			
		}
		
	}

}
