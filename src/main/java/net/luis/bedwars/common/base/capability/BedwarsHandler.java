package net.luis.bedwars.common.base.capability;

import net.minecraft.item.DyeColor;
import net.minecraft.util.math.BlockPos;

public class BedwarsHandler implements IBedwars {
	
	private int bedHeadPosX = 0;
	private int bedHeadPosY = 0;
	private int bedHeadPosZ = 0;
	
	private int bedFootPosX = 0;
	private int bedFootPosY = 0;
	private int bedFootPosZ = 0;
	
	private int respawnPosX = 0;
	private int respawnPosY = 0;
	private int respawnPosZ = 0;
	
	private boolean hasBed = true;
	private boolean canRespawn = true;
	
	private DyeColor teamColor = null;
	
	public BedwarsHandler() {
		
	}
	
	@Override
	public BlockPos getBedHeadPos() {
		return new BlockPos(this.getBedHeadPosX(), this.getBedHeadPosY(), this.getBedHeadPosZ());
	}

	@Override
	public void setBedHeadPos(BlockPos pos) {
		this.setBedHeadPosX(pos.getX());
		this.setBedHeadPosY(pos.getY());
		this.setBedHeadPosZ(pos.getZ());
	}
	
	@Override
	public int getBedHeadPosX() {
		return this.bedHeadPosX;
	}

	@Override
	public void setBedHeadPosX(int posX) {
		this.bedHeadPosX = posX;
	}

	@Override
	public int getBedHeadPosY() {
		return this.bedHeadPosY;
	}

	@Override
	public void setBedHeadPosY(int posY) {
		this.bedHeadPosY = posY;
	}

	@Override
	public int getBedHeadPosZ() {
		return this.bedHeadPosZ;
	}

	@Override
	public void setBedHeadPosZ(int posZ) {
		this.bedHeadPosZ = posZ;
	}
	
	@Override
	public BlockPos getBedFootPos() {
		return new BlockPos(this.getBedFootPosX(), this.getBedFootPosY(), this.getBedFootPosZ());
	}

	@Override
	public void setBedFootPos(BlockPos pos) {
		this.setBedFootPosX(pos.getX());
		this.setBedFootPosY(pos.getY());
		this.setBedFootPosZ(pos.getZ());
	}
	
	@Override
	public int getBedFootPosX() {
		return this.bedFootPosX;
	}

	@Override
	public void setBedFootPosX(int posX) {
		this.bedFootPosX = posX;
	}

	@Override
	public int getBedFootPosY() {
		return this.bedFootPosY;
	}

	@Override
	public void setBedFootPosY(int posY) {
		this.bedFootPosY = posY;
	}

	@Override
	public int getBedFootPosZ() {
		return this.bedFootPosZ;
	}

	@Override
	public void setBedFootPosZ(int posZ) {
		this.bedFootPosZ = posZ;
	}

	@Override
	public boolean hasBed() {
		return this.hasBed;
	}

	@Override
	public void setHasBed(boolean hasBed) {
		this.hasBed = hasBed;
	}
	
	@Override
	public BlockPos getRespawnPos() {
		return new BlockPos(this.getRespawnPosX(), this.getRespawnPosY(), this.getRespawnPosZ());
	}

	@Override
	public void setRespawnPos(BlockPos pos) {
		this.setRespawnPosX(pos.getX());
		this.setRespawnPosY(pos.getY());
		this.setRespawnPosZ(pos.getZ());
	}
	
	@Override
	public int getRespawnPosX() {
		return this.respawnPosX;
	}

	@Override
	public void setRespawnPosX(int posX) {
		this.respawnPosX = posX;
	}

	@Override
	public int getRespawnPosY() {
		return this.respawnPosY;
	}

	@Override
	public void setRespawnPosY(int posY) {
		this.respawnPosY = respawnPosZ;
	}

	@Override
	public int getRespawnPosZ() {
		return this.respawnPosZ;
	}

	@Override
	public void setRespawnPosZ(int posZ) {
		this.respawnPosZ = posZ;
	}

	@Override
	public boolean canRespawn() {
		return this.canRespawn;
	}

	@Override
	public void setCanRespawn(boolean canRespawn) {
		this.canRespawn = canRespawn;
	}

	@Override
	public DyeColor getTeamColor() {
		return this.teamColor;
	}

	@Override
	public void setTeamColor(DyeColor teamColor) {
		this.teamColor = teamColor;
	}

}
