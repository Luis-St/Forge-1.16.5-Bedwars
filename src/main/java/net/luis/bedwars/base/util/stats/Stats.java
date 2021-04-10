package net.luis.bedwars.base.util.stats;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.base.capability.interfaces.SerializeNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class Stats implements SerializeNBT {
	
	private double kills = 0;
	private double deaths = 0;
	private double kd = 0.0;
	private double rounds = 0;
	private double wins = 0;
	private double winChance = 0.0;
	private double brokenBeds = 0;
	
	public Stats() {
		
	}
	
	public Stats(double kills, double deaths, double rounds, double wins, double brokenBeds) {
		
		this.setKills(kills);
		this.setDeaths(deaths);
		this.setWins(wins);
		this.setBrokenBeds(brokenBeds);
		this.calcKd();
		this.calcWinChance();
		
	}
	
	public Stats get() {
		return this;
	}
	
	public void set(Stats stats) {
		this.setKills(stats.getKills());
		this.setDeaths(stats.getDeaths());
		this.setRounds(stats.getRounds());
		this.setWins(stats.getWins());
		this.setBrokenBeds(stats.getBrokenBeds());
	}
	
	public void reset() {
		this.setKills(0);
		this.setDeaths(0);
		this.setRounds(0);
		this.setWins(0);
		this.setBrokenBeds(0);
	}

	public double getKills() {
		return Math.floor(this.kills);
	}

	public void setKills(double kills) {
		this.kills = kills;
	}
	
	public void addKill() {
		this.kills += 1;
	}

	public double getDeaths() {
		return Math.floor(this.deaths);
	}

	public void setDeaths(double deaths) {
		this.deaths = deaths;
	}
	
	public void addDeath() {
		this.deaths += 1;
	}
	
	private void calcKd() {
		double kd = this.kills;
		if (this.deaths > 0) {
			kd = this.kills / this.deaths;
		}
		kd = Math.round(kd * 100);
		this.kd = kd / 100;
	}
	
	public double getKd() {
		this.calcKd();
		return this.kd;
	}

	public double getRounds() {
		return Math.floor(this.rounds);
	}

	public void setRounds(double rounds) {
		this.rounds = rounds;
	}
	
	public void addRound() {
		this.rounds += 1;
	}

	public double getWins() {
		return Math.floor(this.wins);
	}

	public void setWins(double wins) {
		this.wins = wins;
	}
	
	public void addWin() {
		this.wins += 1;
	}
	
	private void calcWinChance() {
		double winChance = this.wins;
		if (this.rounds > 0) {
			winChance = this.wins / this.rounds;
		}
		winChance *= 100;
		winChance = Math.round(winChance);
		this.winChance = winChance / 100;
	}
	
	public double getWinChance() {
		this.calcWinChance();
		return this.winChance;
	}

	public double getBrokenBeds() {
		return this.brokenBeds;
	}

	public void setBrokenBeds(double brokenBeds) {
		this.brokenBeds = brokenBeds;
	}
	
	public void addBrokenBed() {
		this.brokenBeds += 1;
	}
	
	public void print(ServerPlayerEntity serverPlayer) {
		List<ITextComponent> components = new ArrayList<ITextComponent>();
		components.add(new StringTextComponent("Stats von " + serverPlayer.getName().getString() + ":").mergeStyle(TextFormatting.GRAY));
		components.add(this.creatIntComponent("Kills", this.getKills()));
		components.add(this.creatIntComponent("Deaths", this.getDeaths()));
		components.add(this.creatDoubleComponent("KD", this.getKd()));
		components.add(this.creatIntComponent("Rounds", this.getRounds()));
		components.add(this.creatIntComponent("Wins", this.getWins()));
		components.add(this.creatDoubleComponent("Win chance", this.getWinChance()));
		components.add(this.creatIntComponent("Broken beds", this.getBrokenBeds()));
		components.forEach(component -> {
			serverPlayer.sendMessage(component, serverPlayer.getUniqueID());
		});
	}
	
	protected ITextComponent creatIntComponent(String name, double value) {
		ITextComponent namePart = new StringTextComponent(name).appendString(" : ").mergeStyle(TextFormatting.GRAY);
		ITextComponent valuePart = new StringTextComponent("" + (int) value).mergeStyle(TextFormatting.RESET);
		return new StringTextComponent("").append(namePart).append(valuePart);
	}
	
	protected ITextComponent creatDoubleComponent(String name, double value) {
		ITextComponent namePart = new StringTextComponent(name).appendString(" : ").mergeStyle(TextFormatting.GRAY);
		ITextComponent valuePart = new StringTextComponent("" + value).mergeStyle(TextFormatting.RESET);
		return new StringTextComponent("").append(namePart).append(valuePart);
	}

	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putDouble("kills", this.getKills());
		nbt.putDouble("deaths", this.getDeaths());
		nbt.putDouble("kd", this.getKd());
		nbt.putDouble("rounds", this.getRounds());
		nbt.putDouble("wins", this.getWins());
		nbt.putDouble("winChance", this.getWinChance());
		nbt.putDouble("brokenBeds", this.getBrokenBeds());
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.setKills(nbt.getDouble("kills"));
		this.setDeaths(nbt.getDouble("deaths"));
		this.setRounds(nbt.getDouble("rounds"));
		this.setWins(nbt.getDouble("wins"));
		this.setBrokenBeds(nbt.getDouble("brokenBeds"));
		this.calcKd();
		this.calcWinChance();
	}

}
