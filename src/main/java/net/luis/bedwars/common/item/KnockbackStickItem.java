package net.luis.bedwars.common.item;

import net.luis.bedwars.Bedwars;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class KnockbackStickItem extends Item {

	public KnockbackStickItem() {
		
		super(new Item.Properties().group(Bedwars.BEDWARS));
		
	}
	
	@Override
	public int getItemEnchantability() {
		
		return 1;
		
	}
	
	@Override
	public int getItemEnchantability(ItemStack stack) {
		
		return 1;
		
	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		
		return true;
		
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		
		return enchantment == Enchantments.KNOCKBACK;
		
	}

}
