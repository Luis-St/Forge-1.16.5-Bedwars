package net.luis.bedwars.common.base.capability;

import net.minecraft.item.DyeColor;
import net.minecraft.util.math.BlockPos;

public interface IBedwars {
	
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
	
	
	DyeColor getTeamColor();
	void setTeamColor(DyeColor teamColor);
	
}
