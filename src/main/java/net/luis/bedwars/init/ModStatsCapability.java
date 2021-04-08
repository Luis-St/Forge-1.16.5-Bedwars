package net.luis.bedwars.init;

import java.util.concurrent.Callable;

import net.luis.bedwars.base.capability.handler.StatsHandler;
import net.luis.bedwars.base.capability.interfaces.IStats;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ModStatsCapability {
	
	@CapabilityInject(IStats.class)
	public static Capability<IStats> BEDWARS = null;
	
	public static class StatsStorage implements IStorage<IStats> {
		@Override
		public INBT writeNBT(Capability<IStats> capability, IStats instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IStats> capability, IStats instance, Direction side, INBT nbt) {
		}
	}
	
	public static class StatsFactory implements Callable<IStats> {
		@Override
		public IStats call() throws Exception {
			return null;
		}
	}
	
	public static class StatsProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private StatsHandler statsHandler = new StatsHandler();
		private LazyOptional<StatsHandler> statsOptional = LazyOptional.of(() -> statsHandler);
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == BEDWARS ? (LazyOptional<T>) statsOptional : LazyOptional.empty();
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			return this.statsHandler.serializeNBT();
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			this.statsHandler.deserializeNBT(nbt);
			
		}
		
	}

}
