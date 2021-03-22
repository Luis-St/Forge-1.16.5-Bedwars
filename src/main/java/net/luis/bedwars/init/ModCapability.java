package net.luis.bedwars.init;

import java.util.concurrent.Callable;

import net.luis.bedwars.common.base.capability.BedwarsHandler;
import net.luis.bedwars.common.base.capability.IBedwars;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.util.LazyOptional;

public class ModCapability {
	
	public static Capability<IBedwars> BEDWARS = null;
	
	public static class BagpackStorage implements IStorage<IBedwars> {
		@Override
		public INBT writeNBT(Capability<IBedwars> capability, IBedwars instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IBedwars> capability, IBedwars instance, Direction side, INBT nbt) {
		}
	}
	
	public static class BagpackFactory implements Callable<IBedwars> {
		@Override
		public IBedwars call() throws Exception {
			return null;
		}
	}
	
	public static class BagpackProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private BedwarsHandler bedwarsHandler = new BedwarsHandler();
		private LazyOptional<BedwarsHandler> bedwarsOptional = LazyOptional.of(() -> bedwarsHandler);
		
		public BagpackProvider() {
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == BEDWARS ? (LazyOptional<T>) bedwarsOptional : LazyOptional.empty();
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			CompoundNBT nbt = new CompoundNBT();
			nbt.putInt("bedHeadPosX", this.bedwarsHandler.getBedHeadPosX());
			nbt.putInt("bedHeadPosY", this.bedwarsHandler.getBedHeadPosY());
			nbt.putInt("bedHeadPosZ", this.bedwarsHandler.getBedHeadPosZ());
			
			nbt.putInt("bedFootPosX", this.bedwarsHandler.getBedFootPosX());
			nbt.putInt("bedFootPosY", this.bedwarsHandler.getBedFootPosY());
			nbt.putInt("bedFootPosZ", this.bedwarsHandler.getBedFootPosZ());
			
			nbt.putInt("respawnPosX", this.bedwarsHandler.getRespawnPosX());
			nbt.putInt("respawnPosY", this.bedwarsHandler.getRespawnPosY());
			nbt.putInt("respawnPosZ", this.bedwarsHandler.getRespawnPosZ());
			
			nbt.putBoolean("hasBed", this.bedwarsHandler.hasBed());
			nbt.putBoolean("canRespawn", this.bedwarsHandler.canRespawn());
			
			return nbt;
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			this.bedwarsHandler.setBedHeadPosX(nbt.getInt("bedHeadPosX"));
			this.bedwarsHandler.setBedHeadPosY(nbt.getInt("bedHeadPosY"));
			this.bedwarsHandler.setBedHeadPosZ(nbt.getInt("bedHeadPosZ"));
			
			this.bedwarsHandler.setBedFootPosX(nbt.getInt("bedFootPosX"));
			this.bedwarsHandler.setBedFootPosY(nbt.getInt("bedFootPosY"));
			this.bedwarsHandler.setBedFootPosZ(nbt.getInt("bedFootPosZ"));
			
			this.bedwarsHandler.setRespawnPosX(nbt.getInt("respawnPosX"));
			this.bedwarsHandler.setRespawnPosY(nbt.getInt("respawnPosY"));
			this.bedwarsHandler.setRespawnPosZ(nbt.getInt("respawnPosZ"));
			
			this.bedwarsHandler.setHasBed(nbt.getBoolean("hasBed"));
			this.bedwarsHandler.setCanRespawn(nbt.getBoolean("canRespawn"));
			
		}
		
	}

}
