package net.luis.bedwars.common.base.villager;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.text.StringTextComponent;

public class VillagerTradeHelper {
	
	public ItemStack enchantedStick() {
		
		ItemStack stack = new ItemStack(Items.STICK);
		stack.setDisplayName(new StringTextComponent("Knockback Stick"));
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.KNOCKBACK, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedGoldSword1() {
		
		ItemStack stack = new ItemStack(Items.GOLDEN_SWORD);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.SHARPNESS, 1);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedGoldSword2() {
		
		ItemStack stack = new ItemStack(Items.GOLDEN_SWORD);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.SHARPNESS, 2);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedIronSword1() {
		
		ItemStack stack = new ItemStack(Items.IRON_SWORD);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.SHARPNESS, 2);
		enchantments.put(Enchantments.UNBREAKING, 2);
		enchantments.put(Enchantments.KNOCKBACK, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedIronSword2() {
		
		ItemStack stack = new ItemStack(Items.IRON_SWORD);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.SHARPNESS, 3);
		enchantments.put(Enchantments.UNBREAKING, 2);
		enchantments.put(Enchantments.KNOCKBACK, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedLeatherArmor(Item item) {
		
		ItemStack stack = new ItemStack(item);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.PROTECTION, 1);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedChainArmor(Item item) {
		
		ItemStack stack = new ItemStack(item);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.PROTECTION, 2);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedChainChestplate1() {
		
		ItemStack stack = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.PROTECTION, 1);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedChainChestplate2() {
		
		ItemStack stack = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.PROTECTION, 2);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedChainChestplate3() {
		
		ItemStack stack = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.PROTECTION, 3);
		enchantments.put(Enchantments.UNBREAKING, 2);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedChainChestplate4() {
		
		ItemStack stack = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.PROTECTION, 3);
		enchantments.put(Enchantments.THORNS, 1);
		enchantments.put(Enchantments.UNBREAKING, 2);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
	
	}
	
	public ItemStack enchantedGoldBoots() {
		
		ItemStack stack = new ItemStack(Items.GOLDEN_BOOTS);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.FEATHER_FALLING, 3);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedWoodPickaxe() {
		
		ItemStack stack = new ItemStack(Items.WOODEN_PICKAXE);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedStonePickaxe() {
		
		ItemStack stack = new ItemStack(Items.STONE_PICKAXE);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedIronPickaxe() {
		
		ItemStack stack = new ItemStack(Items.IRON_PICKAXE);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.EFFICIENCY, 1);
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack fishingRod() {
		
		ItemStack stack = new ItemStack(Items.FISHING_ROD);
		stack.setDamage(30);
		return stack;
		
	}
	
	public ItemStack enchantedFlintAndSteel() {
		
		ItemStack stack = new ItemStack(Items.FLINT_AND_STEEL);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.UNBREAKING, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedBow1() {
		
		ItemStack stack = new ItemStack(Items.BOW);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.INFINITY, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedBow2() {
		
		ItemStack stack = new ItemStack(Items.BOW);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.INFINITY, 1);
		enchantments.put(Enchantments.POWER, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack enchantedBow3() {
		
		ItemStack stack = new ItemStack(Items.BOW);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		enchantments.put(Enchantments.INFINITY, 1);
		enchantments.put(Enchantments.POWER, 2);
		enchantments.put(Enchantments.PUNCH, 1);
		EnchantmentHelper.setEnchantments(enchantments, stack);
		return stack;
		
	}
	
	public ItemStack potionHealing1() {
		
		ItemStack stack = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(stack, Potions.HEALING);
		return stack;
		
	}
	
	public ItemStack potionHealing2() {
		
		ItemStack stack = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(stack, Potions.STRONG_HEALING);
		return stack;
		
	}
	
	public ItemStack potionLeaping() {
		
		ItemStack stack = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(stack, Potions.STRONG_LEAPING);
		return stack;
		
	}
	
	public ItemStack potionSwiftness() {
		
		ItemStack stack = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(stack, Potions.SWIFTNESS);
		return stack;
		
	}
	
	public ItemStack potionStrength() {
		
		ItemStack stack = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(stack, Potions.STRENGTH);
		return stack;
		
	}
	
	public ItemStack potionSlowFalling() {
		
		ItemStack stack = new ItemStack(Items.POTION);
		PotionUtils.addPotionToItemStack(stack, Potions.SLOW_FALLING);
		return stack;
		
	}
	
}
