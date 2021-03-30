package net.luis.bedwars.common.inventory;

import net.minecraft.item.ItemStack;

public class BuyingItem {
	
	private final ItemStack itemStack;
	private final ItemStack buyingStack;
	
	public BuyingItem(ItemStack itemStack, ItemStack buyingStack) {
		
		this.itemStack = itemStack;
		this.buyingStack = buyingStack;
		
	}

	public ItemStack getItemStack() {
		
		return itemStack;
		
	}

	public ItemStack getBuyingStack() {
		
		return buyingStack;
		
	}

}
