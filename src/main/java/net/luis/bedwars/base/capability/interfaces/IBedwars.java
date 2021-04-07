package net.luis.bedwars.base.capability.interfaces;

import net.luis.bedwars.base.util.ChatRank;
import net.luis.bedwars.base.util.TeamColor;
import net.minecraft.util.math.BlockPos;

public interface IBedwars extends SerializeNBT {
	
	// Head Pos
	BlockPos getBedHeadPos();
	void setBedHeadPos(BlockPos pos);
	
	int getBedHeadPosX();
	void setBedHeadPosX(int posX);
	
	int getBedHeadPosY();
	void setBedHeadPosY(int posY);
	
	int getBedHeadPosZ();
	void setBedHeadPosZ(int posZ);
	
	
	// Foot Pos
	BlockPos getBedFootPos();
	void setBedFootPos(BlockPos pos);
	
	int getBedFootPosX();
	void setBedFootPosX(int posX);
	
	int getBedFootPosY();
	void setBedFootPosY(int posY);
	
	int getBedFootPosZ();
	void setBedFootPosZ(int posZ);
	
	
	boolean hasBed();
	void setHasBed(boolean hasBed);
	
	boolean hasBedAt(BlockPos pos);
	
	
	// Respawn Pos
	BlockPos getRespawnPos();
	void setRespawnPos(BlockPos pos);
	
	int getRespawnPosX();
	void setRespawnPosX(int posX);
	
	int getRespawnPosY();
	void setRespawnPosY(int posY);
	
	int getRespawnPosZ();
	void setRespawnPosZ(int posZ);
	
	
	boolean canRespawn();
	void setCanRespawn(boolean canRespawn);
	
	
	// Chat and Team
	TeamColor getTeamColor();
	void setTeamColor(TeamColor teamColor);
	
	ChatRank getChatRank();
	void setChatRank(ChatRank chatRank);
	
	
	// Cooldowns
	int getGunpowderCooldown();
	void setGunpowderCooldown(int cooldown);
	
	int getGunpowderTeleportCooldown();
	void setGunpowderTeleportCooldown(int cooldown);
	
	boolean canTeleport();
	void setCanTeleport(boolean teleport);
	
	int getBlazeRodCooldown();
	void setBlazeRodCooldown(int cooldown);
	
}
