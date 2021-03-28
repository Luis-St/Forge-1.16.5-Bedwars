package net.luis.bedwars.common.inventory.container;

import net.luis.bedwars.common.inventory.ContainerHelper;
import net.luis.bedwars.common.inventory.slot.VillagerSlot;
import net.luis.bedwars.core.PacketHandler;
import net.luis.bedwars.core.message.SyncVillagerContainerMessage;
import net.luis.bedwars.init.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class VillagerContainer extends Container {
	
	private final ContainerHelper containerHelper;

	public VillagerContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		this(id, playerInventory, new Inventory(6 * 9));
		
	}

	public VillagerContainer(int id, PlayerInventory playerInventory, IInventory inventory) {
		
		super(ModContainerType.VILLAGER.get(), id);
		this.containerHelper = new ContainerHelper(this);
		int i = (6 - 4) * 18;
		
		for (int j = 0; j < 6; ++j) {

			for (int k = 0; k < 9; ++k) {

				this.addSlot(new VillagerSlot(inventory, k + j * 9, 8 + k * 18, (j * 18) + 18));

			}

		}
		
		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
			
		}
		
		this.onContainerOpened(playerInventory.player);

	}
	
	@Override
	public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, PlayerEntity player) {
		
		switch (slot) {
		case 9: this.sendSyncMessage(0); break;
		case 10: this.sendSyncMessage(1); break;
		case 11: this.sendSyncMessage(2); break;
		case 12: this.sendSyncMessage(3); break;
		case 13: this.sendSyncMessage(4); break;
		case 14: this.sendSyncMessage(5); break;
		case 15: this.sendSyncMessage(6); break;
		case 16: this.sendSyncMessage(7); break;
		default: this.sendSyncMessage(8); break;
		}
		
		return super.slotClick(slot, dragType, clickTypeIn, player);
		
	}
	
	public void syncSecondById(int id) {
		
		switch (id) {
		case 0: this.containerHelper.creatBlocks(); break;
		case 1: this.containerHelper.creatSwords(); break;
		case 2: this.containerHelper.creatArmor(); break;
		case 3: this.containerHelper.creatTools(); break;
		case 4: this.containerHelper.creatBows(); break;
		case 5: this.containerHelper.creatFoot(); break;
		case 6: this.containerHelper.creatPotions(); break;
		case 7: this.containerHelper.creatMisc(); break;
		default: this.containerHelper.creatDefault(); break;
		}
		
	}
	
	public void sendSyncMessage(int id) {
		
		PacketHandler.simpleChannel.sendToServer(new SyncVillagerContainerMessage(this, id));
		
	}
	
	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		
	}
	
	public void onContainerOpened(PlayerEntity player) {
		
		this.containerHelper.creatDefault();
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity player) {
		
		return true;
		
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		
		return ItemStack.EMPTY;
		
	}

}
