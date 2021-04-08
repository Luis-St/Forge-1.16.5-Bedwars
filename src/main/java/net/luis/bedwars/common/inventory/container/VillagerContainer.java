package net.luis.bedwars.common.inventory.container;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.base.inventory.BuyHelper;
import net.luis.bedwars.base.inventory.BuyingItem;
import net.luis.bedwars.base.inventory.container.ContainerHelper;
import net.luis.bedwars.common.inventory.slot.VillagerSlot;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.IDyeableArmorItem;
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
	public ItemStack slotClick(int slot, int dragType, ClickType clickType, PlayerEntity player) {
		
		switch (slot) {
		case 9: this.containerHelper.creatBlocks(); this.page = Page.BLOCKS; break;
		case 10: this.containerHelper.creatWeapons(); this.page = Page.WEAPONS; break;
		case 11: this.containerHelper.creatArmor(); this.page = Page.ARMOR; break;
		case 12: this.containerHelper.creatTools(); this.page = Page.TOOLS; break;
		case 13: this.containerHelper.creatBows(); this.page = Page.BOWS; break;
		case 14: this.containerHelper.creatFoot(); this.page = Page.FOOT; break;
		case 15: this.containerHelper.creatPotions(); this.page = Page.POTIONS; break;
		case 16: this.containerHelper.creatMisc(); this.page = Page.MISC; break;
		case 17: this.containerHelper.creatMisc(); this.page = Page.MISC; break;
		default: break;
		}
		
		this.buyItem(slot, player, this.page, clickType);
		this.detectAndSendChanges();
		return super.slotClick(slot, dragType, clickType, player);
		
	}
	
	public void buyItem(int slot, PlayerEntity player, Page page, ClickType clickType) {
		
		BuyHelper buyHelper = new BuyHelper(player, page);
		BuyingItem buyingItem = buyHelper.getBuyingItem(slot);
		
		if (buyingItem != null) {
			
			if (clickType == ClickType.PICKUP || clickType == ClickType.PICKUP_ALL) {
				
				this.buyItem(buyHelper, buyingItem, player);
				
			} else if (clickType == ClickType.QUICK_MOVE) {
				
				if (!buyHelper.canBuyPerShift(buyingItem.getItemStack().getItem())) {
					
					this.buyItem(buyHelper, buyingItem, player);
					
				} else {
					
					this.buyAllItems(buyHelper, buyingItem, player);
					
				}
				
			}
			
		}
		
	}

	private void buyItem(BuyHelper buyHelper, BuyingItem buyingItem, PlayerEntity player) {
		
		ItemStack itemStack = this.colorArmorItem(buyHelper, buyingItem.getItemStack(), player);
		ItemStack buyingStack = buyingItem.getBuyingStack();
		
		if (buyHelper.hasItemToBuy(buyingStack.getItem(), buyingStack.getCount()) || player.abilities.isCreativeMode) {
		
			this.removeItems(player, buyingStack, buyingStack.getCount());
			ItemHandlerHelper.giveItemToPlayer(player, itemStack);
			
		}
		
	}
	
	protected void buyAllItems(BuyHelper buyHelper, BuyingItem buyingItem, PlayerEntity player) {
		
		int givenItem = 0;
		ItemStack itemStack = buyingItem.getItemStack();
		ItemStack buyingStack = buyingItem.getBuyingStack();
		
		while (givenItem < 64 && (buyHelper.hasItemToBuy(buyingStack.getItem(), buyingStack.getCount()) || player.abilities.isCreativeMode)) {
			
			if (buyHelper.hasItemToBuy(buyingStack.getItem(), buyingStack.getCount()) || player.abilities.isCreativeMode) {
				
				this.removeItems(player, buyingStack, buyingStack.getCount());
				ItemHandlerHelper.giveItemToPlayer(player, itemStack);
				givenItem += itemStack.getCount();
				
			}
			
		}
		
	}
	
	protected void removeItems(PlayerEntity player, ItemStack itemToBuy, int cost) {
		
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(
				() -> new NullPointerException());
		
		if (!player.abilities.isCreativeMode) {
			
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
		
	}
	
	protected ItemStack colorArmorItem(BuyHelper buyHelper, ItemStack itemStack, PlayerEntity player) {
		
		List<DyeItem> dyeItems = new ArrayList<DyeItem>();
		
		if (player instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player; 
			
			if (itemStack.getItem() instanceof IDyeableArmorItem) {
				
				DyeColor color = this.getColor(serverPlayer);
				
				if (color != null) {
					
					dyeItems.add(buyHelper.getItemFromColor(color));
					itemStack = IDyeableArmorItem.dyeItem(itemStack, dyeItems);
					
				}
				
			}
			
		}
		
		return itemStack;
		
	}
	
	protected DyeColor getColor(ServerPlayerEntity serverPlayer) {
		
		IBedwars bedwarsHandler = serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).orElseThrow(() -> new NullPointerException());
		return bedwarsHandler.getTeamColor().getDyeColor();
		
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
		MISC,
		KITS;
		
	}
	
	public static enum SubPageKit {
		
		RUSHER,
		BASIC,
		OP_RUSHER,
		OP,
		SPAMMER;
		
	}

}
