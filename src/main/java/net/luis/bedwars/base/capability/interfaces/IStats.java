package net.luis.bedwars.base.capability.interfaces;

import net.luis.bedwars.base.util.stats.Stats;

public interface IStats extends SerializeNBT {
	
	Stats getStats();
	void setStats(Stats stats);
	void resetStats();
	
	double getKills();
	void setKills(double kills);
	void addKill();
	
	double getDeaths();
	void setDeaths(double deaths);
	void addDeath();
	
	double getKd();
	
	double getRounds();
	void setRounds(double rounds);
	void addRound();
	
	double getWins();
	void setWins(double wins);
	void addWin();
	
	double getWinChance();
	
	double getBrokenBeds();
	void setBrokenBeds(double brokenBeds);
	void addBrokenBed();
	
}
