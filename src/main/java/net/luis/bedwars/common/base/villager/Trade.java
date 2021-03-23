package net.luis.bedwars.common.base.villager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.BasicTrade;

public class Trade {
	
	private ItemStack price;
	private ItemStack forSale;
	private int maxTrades;
	private int xp;
	private float priceMult;
	
	public Trade(ItemStack price, ItemStack forSale, int maxTrades, int xp, float priceMult) {
		this.price = price;
		this.forSale = forSale;
		this.maxTrades = maxTrades;
		this.xp = xp;
		this.priceMult = priceMult;
	}
	
	public Trade() {
		
	}
	
	public Trade priceBronze(int bronzeCount) {
		this.price = new ItemStack(Items.BRICK, bronzeCount);
		return this;
	}
	
	public Trade priceIron(int bronzeCount) {
		this.price = new ItemStack(Items.IRON_INGOT, bronzeCount);
		return this;
	}
	
	public Trade priceGold(int bronzeCount) {
		this.price = new ItemStack(Items.GOLD_INGOT, bronzeCount);
		return this;
	}
	
	public Trade saleItem(Item item) {
		this.forSale = new ItemStack(item);
		return this;
	}
	
	public Trade saleItem(Item item, int count) {
		this.forSale = new ItemStack(item, count);
		return this;
	}
	
	public Trade saleItem(ItemStack stack) {
		this.forSale = stack;
		return this;
	}
	
	public Trade defaultValues() {
		this.maxTrades = Integer.MAX_VALUE;
		this.xp = 100;
		this.priceMult = 0F;
		return this;
	}
	
	public Trade maxTrades(int maxTrade) {
		this.maxTrades = maxTrade;
		return this;
	}
	
	public Trade xp(int xp) {
		this.xp = xp;
		return this;
	}
	
	public Trade priceMultiplier(float priceMult) {
		this.priceMult = priceMult;
		return this;
	}
	
	public Trade addValues(int maxTrade, int xp, float priceMult) {
		this.maxTrades = maxTrade;
		this.xp = xp;
		this.priceMult = priceMult;
		return this;
	}
	
	public BasicTrade creat() {
		return new BasicTrade(this.price, this.forSale, this.maxTrades, this.xp, this.priceMult);
	}
	
}
