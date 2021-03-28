package net.luis.bedwars.common.inventory.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;

public class VillagerSlot extends Slot {

	public VillagerSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		
		super(inventoryIn, index, xPosition, yPosition);
		
	}
	
	@Override
	public boolean canTakeStack(PlayerEntity playerIn) {
		
		return false;
		
	}

}
