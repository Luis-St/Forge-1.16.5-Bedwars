package net.luis.bedwars.base.capability.interfaces;

import java.util.List;

import net.luis.bedwars.base.util.TeamColor;
import net.minecraftforge.items.ItemStackHandler;

public interface ITeam extends SerializeNBT {
	
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
	ItemStackHandler getInventoryByTeamColor(TeamColor teamColor);
	void clearAll();
	
}
