package net.luis.bedwars.base.inventory.container;

import net.luis.bedwars.base.villager.VillagerTradeHelper;
import net.luis.bedwars.common.inventory.container.VillagerContainer;
import net.luis.bedwars.init.ModItems;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;

public class ContainerHelper {
	
	private final VillagerContainer container;
	private final VillagerTradeHelper tradeHelper;
	
	public ContainerHelper(VillagerContainer container) {
		
		this.container = container;
		this.tradeHelper = new VillagerTradeHelper();
		
	}
	
	public void creatFirstPart() {
		
		for (int i = 0; i < 9; i++) {
			
			this.putStackInSlot(i, getFillerItem());
			
		}
		
		this.creatMenu();
		
		for (int i = 18; i < 27; i++) {
			
			this.putStackInSlot(i, getFillerItem());
			
		}
		
	}
	
	public void creatSecondPart() {
		
		for (int i = 27; i < 54; i++) {
			
			this.putStackInSlot(i, getFillerItem());
			
		}

	}
	
	public void fillSecondPart() {
		
		for (int i = 27; i < 54; i++) {
			
			Slot slot = this.container.getSlot(i);
			
			if (!slot.getHasStack()) {
				
				slot.putStack(getFillerItem());
				
			}
			
		}
		
	}
	
	public void clearSecondPart() {
		
		for (int i = 27; i < 54; i++) {
			
			this.putStackInSlot(i, getAirItem());
			
		}
		
	}
	
	public void creatDefault() {
		
		this.creatFirstPart();
		this.creatSecondPart();
		this.container.detectAndSendChanges();
		
	}
	
	private void creatMenu() {
		
		this.putStackInSlot(9, new ItemStack(Items.SANDSTONE));
		this.putStackInSlot(10, new ItemStack(Items.GOLDEN_SWORD));
		this.putStackInSlot(11, new ItemStack(Items.LEATHER_HELMET));
		this.putStackInSlot(12, new ItemStack(Items.STONE_PICKAXE));
		this.putStackInSlot(13, new ItemStack(Items.BOW));
		this.putStackInSlot(14, new ItemStack(Items.APPLE));
		this.putStackInSlot(15, Items.POTION.getDefaultInstance());
		this.putStackInSlot(16, new ItemStack(Items.ENDER_PEARL));
		this.putStackInSlot(17, (new ItemStack(Items.LIGHT_GRAY_STAINED_GLASS_PANE)).setDisplayName(new StringTextComponent("")));
		this.container.detectAndSendChanges();
		
	}
	
	public void creatBlocks() {
		
		this.clearSecondPart();
		this.putStackInSlot(37, new ItemStack(Items.CUT_SANDSTONE, 2));
		this.putStackInSlot(38, new ItemStack(Items.PACKED_ICE));
		this.putStackInSlot(39, new ItemStack(Items.GLASS));
		this.putStackInSlot(40, new ItemStack(Items.SANDSTONE_STAIRS));
		this.putStackInSlot(41, new ItemStack(Items.END_STONE));
		this.putStackInSlot(42, new ItemStack(Items.IRON_BLOCK));
		
		this.putStackInSlot(46, new ItemStack(Items.BRICK));
		this.putStackInSlot(47, new ItemStack(Items.BRICK, 4));
		this.putStackInSlot(48, new ItemStack(Items.BRICK, 2));
		this.putStackInSlot(49, new ItemStack(Items.BRICK, 2));
		this.putStackInSlot(50, new ItemStack(Items.BRICK, 8));
		this.putStackInSlot(51, new ItemStack(Items.IRON_INGOT, 4));
		this.fillSecondPart();
		this.container.detectAndSendChanges();
		
	}
	
	public void creatWeapons() {
		
		this.clearSecondPart();
		this.putStackInSlot(38, this.tradeHelper.enchantedStick());
		this.putStackInSlot(39, this.tradeHelper.enchantedGoldSword1());
		this.putStackInSlot(40, this.tradeHelper.enchantedGoldSword2());
		this.putStackInSlot(41, this.tradeHelper.enchantedIronSword1());
		this.putStackInSlot(42, this.tradeHelper.enchantedIronSword2());
		
		this.putStackInSlot(47, new ItemStack(Items.BRICK, 8));
		this.putStackInSlot(48, new ItemStack(Items.IRON_INGOT, 1));
		this.putStackInSlot(49, new ItemStack(Items.IRON_INGOT, 3));
		this.putStackInSlot(50, new ItemStack(Items.GOLD_INGOT, 5));
		this.putStackInSlot(51, new ItemStack(Items.GOLD_INGOT, 9));
		this.fillSecondPart();
		
	}
	
	public void creatArmor() {
		
		this.clearSecondPart();
		this.putStackInSlot(27, this.tradeHelper.enchantedLeatherArmor(Items.LEATHER_HELMET));
		this.putStackInSlot(36, this.tradeHelper.enchantedLeatherArmor(Items.LEATHER_LEGGINGS));
		this.putStackInSlot(45, this.tradeHelper.enchantedLeatherArmor(Items.LEATHER_BOOTS));
		this.putStackInSlot(29, this.tradeHelper.enchantedChainArmor(Items.CHAINMAIL_HELMET));
		this.putStackInSlot(38, this.tradeHelper.enchantedChainArmor(Items.CHAINMAIL_LEGGINGS));
		this.putStackInSlot(47, this.tradeHelper.enchantedGoldBoots());
		this.putStackInSlot(41, this.tradeHelper.enchantedChainChestplate1());
		this.putStackInSlot(42, this.tradeHelper.enchantedChainChestplate2());
		this.putStackInSlot(43, this.tradeHelper.enchantedChainChestplate3());
		this.putStackInSlot(44, this.tradeHelper.enchantedChainChestplate4());
		
		this.putStackInSlot(28, new ItemStack(Items.BRICK, 1));
		this.putStackInSlot(37, new ItemStack(Items.BRICK, 1));
		this.putStackInSlot(46, new ItemStack(Items.BRICK, 1));
		this.putStackInSlot(30, new ItemStack(Items.IRON_INGOT, 2));
		this.putStackInSlot(39, new ItemStack(Items.IRON_INGOT, 2));
		this.putStackInSlot(48, new ItemStack(Items.IRON_INGOT, 4));
		this.putStackInSlot(50, new ItemStack(Items.IRON_INGOT, 1));
		this.putStackInSlot(51, new ItemStack(Items.IRON_INGOT, 3));
		this.putStackInSlot(52, new ItemStack(Items.IRON_INGOT, 7));
		this.putStackInSlot(53, new ItemStack(Items.GOLD_INGOT, 4));
		this.fillSecondPart();
		
	}
	
	public void creatTools() {
		
		this.clearSecondPart();
		this.putStackInSlot(38, this.tradeHelper.enchantedWoodPickaxe());
		this.putStackInSlot(39, this.tradeHelper.enchantedStonePickaxe());
		this.putStackInSlot(40, this.tradeHelper.enchantedIronPickaxe());
		this.putStackInSlot(41, this.tradeHelper.fishingRod());
		this.putStackInSlot(42, this.tradeHelper.enchantedFlintAndSteel());
		
		this.putStackInSlot(47, new ItemStack(Items.BRICK, 4));
		this.putStackInSlot(48, new ItemStack(Items.IRON_INGOT, 2));
		this.putStackInSlot(49, new ItemStack(Items.GOLD_INGOT));
		this.putStackInSlot(50, new ItemStack(Items.IRON_INGOT, 5));
		this.putStackInSlot(51, new ItemStack(Items.IRON_INGOT, 3));
		this.fillSecondPart();
		this.container.detectAndSendChanges();
		
	}
	
	public void creatBows() {
		
		this.clearSecondPart();
		this.putStackInSlot(38, this.tradeHelper.enchantedBow1());
		this.putStackInSlot(39, this.tradeHelper.enchantedBow2());
		this.putStackInSlot(40, this.tradeHelper.enchantedBow3());
		this.putStackInSlot(42, new ItemStack(Items.ARROW));
		
		this.putStackInSlot(47, new ItemStack(Items.GOLD_INGOT, 3));
		this.putStackInSlot(48, new ItemStack(Items.GOLD_INGOT, 7));
		this.putStackInSlot(49, new ItemStack(Items.GOLD_INGOT, 13));
		this.putStackInSlot(51, new ItemStack(Items.GOLD_INGOT));
		this.fillSecondPart();
		this.container.detectAndSendChanges();
		
	}
	
	public void creatFoot() {
		
		this.clearSecondPart();
		this.putStackInSlot(39, new ItemStack(Items.APPLE));
		this.putStackInSlot(40, new ItemStack(Items.COOKED_PORKCHOP));
		this.putStackInSlot(41, new ItemStack(Items.GOLDEN_APPLE));
		
		this.putStackInSlot(48, new ItemStack(Items.BRICK));
		this.putStackInSlot(49, new ItemStack(Items.BRICK, 2));
		this.putStackInSlot(50, new ItemStack(Items.GOLD_INGOT, 2));
		this.fillSecondPart();
		this.container.detectAndSendChanges();
		
	}
	
	public void creatPotions() {
		
		this.clearSecondPart();
		this.putStackInSlot(37, this.tradeHelper.potionHealing1());
		this.putStackInSlot(38, this.tradeHelper.potionHealing2());
		this.putStackInSlot(39, this.tradeHelper.potionLeaping());
		this.putStackInSlot(40, this.tradeHelper.potionSwiftness());
		this.putStackInSlot(42, this.tradeHelper.potionStrength());
		this.putStackInSlot(43, this.tradeHelper.potionSlowFalling());
		
		this.putStackInSlot(46, new ItemStack(Items.IRON_INGOT, 3));
		this.putStackInSlot(47, new ItemStack(Items.IRON_INGOT, 5));
		this.putStackInSlot(48, new ItemStack(Items.IRON_INGOT, 7));
		this.putStackInSlot(49, new ItemStack(Items.IRON_INGOT, 7));
		this.putStackInSlot(51, new ItemStack(Items.GOLD_INGOT, 7));
		this.putStackInSlot(52, new ItemStack(Items.GOLD_INGOT, 4));
		this.fillSecondPart();
		this.container.detectAndSendChanges();
		
	}
	
	public void creatMisc() {
		
		this.clearSecondPart();
		this.putStackInSlot(36, new ItemStack(Items.LADDER));
		this.putStackInSlot(37, new ItemStack(Items.COBWEB));
		this.putStackInSlot(38, new ItemStack(ModItems.GUNPOWDER.get()));
		this.putStackInSlot(39, new ItemStack(ModItems.BLAZE_ROD.get()));
		this.putStackInSlot(40, new ItemStack(Items.TNT));
		this.putStackInSlot(41, new ItemStack(Items.ENDER_PEARL));
		this.putStackInSlot(43, new ItemStack(Items.CHEST));
		this.putStackInSlot(44, new ItemStack(Items.ENDER_CHEST));
		
		this.putStackInSlot(45, new ItemStack(Items.BRICK, 2));
		this.putStackInSlot(46, new ItemStack(Items.BRICK, 8));
		this.putStackInSlot(47, new ItemStack(Items.IRON_INGOT, 3));
		this.putStackInSlot(48, new ItemStack(Items.GOLD_INGOT, 3));
		this.putStackInSlot(49, new ItemStack(Items.GOLD_INGOT, 2));
		this.putStackInSlot(50, new ItemStack(Items.GOLD_INGOT, 11));
		this.putStackInSlot(52, new ItemStack(Items.IRON_INGOT, 1));
		this.putStackInSlot(53, new ItemStack(Items.GOLD_INGOT, 1));
		this.fillSecondPart();
		this.container.detectAndSendChanges();
		
	}
	
	protected void putStackInSlot(int slot, ItemStack stack) {
		
		this.container.putStackInSlot(slot, stack);
		
	}
	
	protected ItemStack getFillerItem() {
		
		ItemStack stack = new ItemStack(Items.GRAY_STAINED_GLASS_PANE);
		stack.setDisplayName(new StringTextComponent(""));
		return stack;
		
	}
	
	protected ItemStack getAirItem() {
		
		return ItemStack.EMPTY;
		
	}
	
}
