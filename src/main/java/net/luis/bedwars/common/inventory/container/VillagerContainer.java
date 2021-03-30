package net.luis.bedwars.common.inventory.container;

import net.luis.bedwars.common.inventory.BuyHelper;
import net.luis.bedwars.common.inventory.BuyingItem;
import net.luis.bedwars.common.inventory.ContainerHelper;
import net.luis.bedwars.common.inventory.slot.VillagerSlot;
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
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class VillagerContainer extends Container {
	
	private final ContainerHelper containerHelper;
	private Page page = Page.DEFAULT;

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
		case 9: this.containerHelper.creatBlocks(); this.page = Page.BLOCKS; break;
		case 10: this.containerHelper.creatWeapons(); this.page = Page.WEAPONS; break;
		case 11: this.containerHelper.creatArmor(); this.page = Page.ARMOR; break;
		case 12: this.containerHelper.creatTools(); this.page = Page.TOOLS; break;
		case 13: this.containerHelper.creatBows(); this.page = Page.BOWS; break;
		case 14: this.containerHelper.creatFoot(); this.page = Page.FOOT; break;
		case 15: this.containerHelper.creatPotions(); this.page = Page.POTIONS; break;
		case 16: this.containerHelper.creatMisc(); this.page = Page.MISC; break;
		default: break;
		}
		
		this.buyItem(slot, player, this.page);
		this.detectAndSendChanges();
		return super.slotClick(slot, dragType, clickTypeIn, player);
		
	}
	
	public void buyItem(int slot, PlayerEntity player, Page page) {
		
		BuyHelper buyHelper = new BuyHelper(player, page);
		BuyingItem buyingItem = buyHelper.getBuyingItem(slot);
		
		if (buyingItem != null) {
			
			ItemStack itemStack = buyingItem.getItemStack();
			ItemStack buyingStack = buyingItem.getBuyingStack();
			
			if (buyHelper.hasItemToBuy(buyingStack.getItem(), buyingStack.getCount())) {
			
				this.removeItems(player, buyingStack, buyingStack.getCount());
				ItemHandlerHelper.giveItemToPlayer(player, itemStack);
				
			}
			
		}
		
	}
	
	protected void removeItems(PlayerEntity player, ItemStack itemToBuy, int cost) {
		
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(
				() -> new NullPointerException());
		
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			
			ItemStack stack = itemHandler.getStackInSlot(i);
			
			if (cost > 0) {
				
				if (itemToBuy.getItem() == stack.getItem()) {
					
					if (stack.getCount() >= cost) {
						
						stack.shrink(cost);
						cost = 0;
						
					} else {
						
						int count = stack.getCount();
						stack.shrink(count);
						cost -= count;
						
					}
					
				}
				
			}
			
		}
		
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
	
	public static enum Page {
		
		DEFAULT,
		BLOCKS,
		WEAPONS,
		ARMOR,
		TOOLS,
		BOWS,
		FOOT,
		POTIONS,
		MISC;
		
	}

}
