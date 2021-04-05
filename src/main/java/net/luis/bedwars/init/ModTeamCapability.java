package net.luis.bedwars.init;

import java.util.concurrent.Callable;

import net.luis.bedwars.base.capability.handler.TeamHandler;
import net.luis.bedwars.base.capability.interfaces.ITeam;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ModTeamCapability {
	
	@CapabilityInject(ITeam.class)
	public static Capability<ITeam> TEAM = null;
	
	public static class TeamStorage implements IStorage<ITeam> {
		@Override
		public INBT writeNBT(Capability<ITeam> capability, ITeam instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<ITeam> capability, ITeam instance, Direction side, INBT nbt) {
		}
	}
	
	public static class TeamFactory implements Callable<ITeam> {
		@Override
		public ITeam call() throws Exception {
			return null;
		}
	}
	
	public static class TeamProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private TeamHandler teamHandler = new TeamHandler();
		private LazyOptional<TeamHandler> teamOptional = LazyOptional.of(() -> teamHandler);
		
		public TeamProvider() {
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == TEAM ? (LazyOptional<T>) teamOptional : LazyOptional.empty();
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			return this.teamHandler.serializeNBT();
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			this.teamHandler.deserializeNBT(nbt);;
			
		}
		
	}

}
