package net.luis.bedwars.base.capability.interfaces;

import java.util.List;

import net.luis.bedwars.base.util.TeamColor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.items.ItemStackHandler;

public interface ITeam {
	
	ItemStackHandler getInventoryBlack();
	
	ItemStackHandler getInventoryBlue();
	
	ItemStackHandler getInventoryCyan();
	
	ItemStackHandler getInventoryGray();
	
	ItemStackHandler getInventoryGreen();
	
	ItemStackHandler getInventoryLightBlue();
	
	ItemStackHandler getInventoryLightGray();
	
	ItemStackHandler getInventoryLime();
	
	ItemStackHandler getInventoryOrange();
	
	ItemStackHandler getInventoryPink();
	
	ItemStackHandler getInventoryPurple();
	
	ItemStackHandler getInventoryRed();
	
	ItemStackHandler getInventoryWhite();

	ItemStackHandler getInventoryYellow();
	
	List<ItemStackHandler> getAllInventories();
	ItemStackHandler getInventoryByColor(TeamColor teamColor);
	void clearAll();
	
	CompoundNBT serializeNBT();
	void deserializeNBT(CompoundNBT nbt);
	
}
