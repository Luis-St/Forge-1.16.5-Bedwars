package net.luis.bedwars.base.capability.handler;

import net.luis.bedwars.base.capability.interfaces.IStats;
import net.luis.bedwars.base.util.stats.Stats;
import net.minecraft.nbt.CompoundNBT;

public class StatsHandler implements IStats {
	
	// TODO : add win stats
	// TODO : add winChance stats
	
	// TODO : team list to game cap -> add team when bed broken -> check if two bed broken -> stop
	// TODO : player list to game cap
	
	private Stats stats = new Stats();

	@Override
	public Stats getStats() {
		return this.stats;
	}

	@Override
	public void setStats(Stats stats) {
		this.stats = stats;
	}

	@Override
	public void resetStats() {
		this.stats.reset();
	}

	@Override
	public double getKills() {
		return this.stats.getKills();
	}

	@Override
	public void setKills(double kills) {
		this.stats.setKills(kills);
	}
	
	@Override
	public void addKill() {
		this.stats.addKill();;
	}
	
	@Override
	public double getDeaths() {
		return this.stats.getDeaths();
	}

	@Override
	public void setDeaths(double deaths) {
		this.stats.setDeaths(deaths);
	}
	
	@Override
	public void addDeath() {
		this.stats.addDeath();
	}

	@Override
	public double getKd() {
		return this.stats.getKd();
	}

	@Override
	public double getRounds() {
		return this.stats.getRounds();
	}

	@Override
	public void setRounds(double rounds) {
		this.stats.setRounds(rounds);
	}
	
	@Override
	public void addRound() {
		this.stats.addRound();
	}

	@Override
	public double getWins() {
		return this.stats.getWins();
	}

	@Override
	public void setWins(double wins) {
		this.stats.setWins(wins);
	}
	
	@Override
	public void addWin() {
		this.stats.addWin();
	}

	@Override
	public double getWinChance() {
		return this.stats.getWinChance();
	}

	@Override
	public double getBrokenBeds() {
		return this.stats.getBrokenBeds();
	}

	@Override
	public void setBrokenBeds(double brokenBeds) {
		this.stats.setBrokenBeds(brokenBeds);
	}
	
	@Override
	public void addBrokenBed() {
		this.stats.addBrokenBed();
	}
	
	@Override
	public CompoundNBT serializeNBT() {
		return this.stats.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.stats.deserializeNBT(nbt);
	}

}
