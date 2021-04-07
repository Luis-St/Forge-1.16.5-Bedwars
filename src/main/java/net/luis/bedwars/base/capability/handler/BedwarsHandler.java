package net.luis.bedwars.base.capability.handler;

import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.base.util.ChatRank;
import net.luis.bedwars.base.util.TeamColor;
import net.minecraft.nbt.CompoundNBT;
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
	
	private TeamColor teamColor = null;
	private ChatRank chatRank = ChatRank.ZOMBIE_FIGHTER;
	
	private int gunpowderCooldown = 0;
	private int gunpowderTeleportCooldown = 6;
	private boolean canTeleport = false;
	private int blazeRodCooldown = 0;
	
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
	public boolean hasBedAt(BlockPos pos) {
		
		if (pos.getX() == this.getBedFootPosX() && pos.getY() == this.getBedFootPosY() && pos.getZ() == this.getBedFootPosZ()) {
			
			return true;
			
		} else if (pos.getX() == this.getBedHeadPosX() && pos.getY() == this.getBedHeadPosY() && pos.getZ() == this.getBedHeadPosZ()) {
			
			return true;
			
		}
		
		return false;
		
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
		this.respawnPosY = posY;
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
	public TeamColor getTeamColor() {
		return this.teamColor;
	}

	@Override
	public void setTeamColor(TeamColor teamColor) {
		this.teamColor = teamColor;
	}
	
	@Override
	public ChatRank getChatRank() {
		return this.chatRank;
	}

	@Override
	public void setChatRank(ChatRank chatRank) {
		this.chatRank = chatRank;
	}

	@Override
	public int getGunpowderCooldown() {
		return this.gunpowderCooldown;
	}

	@Override
	public void setGunpowderCooldown(int cooldown) {
		this.gunpowderCooldown = cooldown;
	}
	
	@Override
	public int getGunpowderTeleportCooldown() {
		return this.gunpowderTeleportCooldown;
	}

	@Override
	public void setGunpowderTeleportCooldown(int cooldown) {
		this.gunpowderTeleportCooldown = cooldown;
	}
	
	@Override
	public boolean canTeleport() {
		return this.canTeleport;
	}

	@Override
	public void setCanTeleport(boolean teleport) {
		this.canTeleport = teleport;
	}
	
	@Override
	public int getBlazeRodCooldown() {
		return this.blazeRodCooldown;
	}

	@Override
	public void setBlazeRodCooldown(int cooldown) {
		this.blazeRodCooldown = cooldown;
	}
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("bedHeadPosX", this.getBedHeadPosX());
		nbt.putInt("bedHeadPosY", this.getBedHeadPosY());
		nbt.putInt("bedHeadPosZ", this.getBedHeadPosZ());
		
		nbt.putInt("bedFootPosX", this.getBedFootPosX());
		nbt.putInt("bedFootPosY", this.getBedFootPosY());
		nbt.putInt("bedFootPosZ", this.getBedFootPosZ());
		
		nbt.putBoolean("hasBed", this.hasBed());
		
		nbt.putInt("respawnPosX", this.getRespawnPosX());
		nbt.putInt("respawnPosY", this.getRespawnPosY());
		nbt.putInt("respawnPosZ", this.getRespawnPosZ());
		
		nbt.putBoolean("canRespawn", this.canRespawn());
		
		nbt.putInt("chatRank", this.getChatRank().getId());
		
		nbt.putInt("gunpowderCooldown", this.getGunpowderCooldown());
		nbt.putInt("gunpowderTeleportCooldown", this.getGunpowderTeleportCooldown());
		nbt.putBoolean("canTeleport", this.canTeleport());
		
		nbt.putInt("blazeRodCooldown", this.getBlazeRodCooldown());
		
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.setBedHeadPosX(nbt.getInt("bedHeadPosX"));
		this.setBedHeadPosY(nbt.getInt("bedHeadPosY"));
		this.setBedHeadPosZ(nbt.getInt("bedHeadPosZ"));
		
		this.setBedFootPosX(nbt.getInt("bedFootPosX"));
		this.setBedFootPosY(nbt.getInt("bedFootPosY"));
		this.setBedFootPosZ(nbt.getInt("bedFootPosZ"));
		
		this.setHasBed(nbt.getBoolean("hasBed"));
		
		this.setRespawnPosX(nbt.getInt("respawnPosX"));
		this.setRespawnPosY(nbt.getInt("respawnPosY"));
		this.setRespawnPosZ(nbt.getInt("respawnPosZ"));
		
		this.setCanRespawn(nbt.getBoolean("canRespawn"));
		
		this.setChatRank(ChatRank.byId(nbt.getInt("chatRank")));
		
		this.setGunpowderCooldown(nbt.getInt("gunpowderCooldown"));
		this.setGunpowderTeleportCooldown(nbt.getInt("gunpowderTeleportCooldown"));
		this.setCanTeleport(nbt.getBoolean("canTeleport"));
		
		this.setBlazeRodCooldown(nbt.getInt("blazeRodCooldown"));
	}

}
