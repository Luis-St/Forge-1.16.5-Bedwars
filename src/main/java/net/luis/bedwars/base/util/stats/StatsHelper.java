package net.luis.bedwars.base.util.stats;

import net.luis.bedwars.base.capability.interfaces.IGame;
import net.luis.bedwars.init.ModGameCapability;
import net.luis.bedwars.init.ModStatsCapability;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.server.ServerWorld;

public class StatsHelper {
	
	private final ServerPlayerEntity serverPlayer;
	private final ServerWorld serverWorld;
	
	public StatsHelper(ServerPlayerEntity serverPlayer) {
		
		this.serverPlayer = serverPlayer;
		this.serverWorld = serverPlayer.getServerWorld();
		
	}
	
	private boolean isGameStarted() {
		
		IGame gameHandler = this.serverWorld.getCapability(ModGameCapability.GAME, null).orElseThrow(() -> new NullPointerException());
		return gameHandler.isGameStarted();
		
	}
	
	public void addKill() {
		
		if (this.isGameStarted()) {
			
			this.serverPlayer.getCapability(ModStatsCapability.STATS, null).ifPresent(statsHandler -> {
				
				statsHandler.addKill();
				
			});
			
		}
		
	}
	
	public void addDeath() {
		
		if (this.isGameStarted()) {
			
			this.serverPlayer.getCapability(ModStatsCapability.STATS, null).ifPresent(statsHandler -> {
				
				statsHandler.addDeath();
				
			});
			
		}
		
	}
	
	public void addRound() {
		
		if (this.isGameStarted()) {
			
			this.serverPlayer.getCapability(ModStatsCapability.STATS, null).ifPresent(statsHandler -> {
				
				statsHandler.addRound();
				
			});
			
		}
		
	}
	
	public void addWin() {
		
		this.serverPlayer.getCapability(ModStatsCapability.STATS, null).ifPresent(statsHandler -> {
			
			statsHandler.addWin();
			
		});
		
	}
	
	public void addBrokenBed() {
		
		if (this.isGameStarted()) {
			
			this.serverPlayer.getCapability(ModStatsCapability.STATS, null).ifPresent(statsHandler -> {
				
				statsHandler.addBrokenBed();
				
			});
			
		}
		
	}
	
}
