package net.luis.bedwars.events;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.base.villager.Trade;
import net.luis.bedwars.common.base.villager.VillagerTradeHelper;
import net.luis.bedwars.init.ModItems;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnVillagerTradesEvent {
	
	@SubscribeEvent
	public static void VillagerTrade(VillagerTradesEvent event) {
		
		VillagerProfession profession = event.getType();
		VillagerTradeHelper tradeHelper = new VillagerTradeHelper();
		
		if (profession == VillagerProfession.MASON) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceBronze(1).saleItem(Items.CUT_SANDSTONE, 2).defaultValues().creat());
			trades1.add(new Trade().priceBronze(4).saleItem(Items.PACKED_ICE).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceBronze(2).saleItem(Items.GLASS).defaultValues().creat());
			trades2.add(new Trade().priceBronze(2).saleItem(Items.SANDSTONE_STAIRS).defaultValues().creat());
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			trades3.add(new Trade().priceBronze(8).saleItem(Items.END_STONE).defaultValues().creat());
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
			
		} else if (profession == VillagerProfession.WEAPONSMITH) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceBronze(8).saleItem(tradeHelper.enchantedStick()).defaultValues().creat());
			trades1.add(new Trade().priceIron(1).saleItem(tradeHelper.enchantedGoldSword1()).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceIron(3).saleItem(tradeHelper.enchantedGoldSword2()).defaultValues().creat());
			trades2.add(new Trade().priceGold(5).saleItem(tradeHelper.enchantedIronSword1()).defaultValues().creat());
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			trades3.add(new Trade().priceGold(9).saleItem(tradeHelper.enchantedIronSword2()).defaultValues().creat());
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		} else if (profession == VillagerProfession.ARMORER) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceBronze(1).saleItem(tradeHelper.enchantedLeatherArmor(Items.LEATHER_HELMET)).defaultValues().creat());
			trades1.add(new Trade().priceBronze(1).saleItem(tradeHelper.enchantedLeatherArmor(Items.LEATHER_LEGGINGS)).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceBronze(1).saleItem(tradeHelper.enchantedLeatherArmor(Items.LEATHER_BOOTS)).defaultValues().creat());
			trades2.add(new Trade().priceIron(2).saleItem(tradeHelper.enchantedChainArmor(Items.CHAINMAIL_HELMET)).defaultValues().creat());
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			trades3.add(new Trade().priceIron(2).saleItem(tradeHelper.enchantedChainArmor(Items.CHAINMAIL_LEGGINGS)).defaultValues().creat());
			trades3.add(new Trade().priceIron(4).saleItem(tradeHelper.enchantedGoldBoots()).defaultValues().creat());
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			trades4.add(new Trade().priceIron(1).saleItem(tradeHelper.enchantedChainChestplate1()).defaultValues().creat());
			trades4.add(new Trade().priceIron(3).saleItem(tradeHelper.enchantedChainChestplate2()).defaultValues().creat());
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			trades5.add(new Trade().priceIron(7).saleItem(tradeHelper.enchantedChainChestplate3()).defaultValues().creat());
			trades5.add(new Trade().priceGold(3).saleItem(tradeHelper.enchantedChainChestplate4()).defaultValues().creat());
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		} else if (profession == VillagerProfession.CLERIC) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceIron(3).saleItem(tradeHelper.potionHealing1()).defaultValues().creat());
			trades1.add(new Trade().priceIron(5).saleItem(tradeHelper.potionHealing2()).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceIron(7).saleItem(tradeHelper.potionLeaping()).defaultValues().creat());
			trades2.add(new Trade().priceIron(7).saleItem(tradeHelper.potionSwiftness()).defaultValues().creat());
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			trades3.add(new Trade().priceGold(7).saleItem(tradeHelper.potionStrength()).defaultValues().creat());
			trades3.add(new Trade().priceGold(4).saleItem(tradeHelper.potionSlowFalling()).defaultValues().creat());
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		} else if (profession == VillagerProfession.TOOLSMITH) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceBronze(4).saleItem(tradeHelper.enchantedWoodPickaxe()).defaultValues().creat());
			trades1.add(new Trade().priceIron(2).saleItem(tradeHelper.enchantedStonePickaxe()).defaultValues().creat());
			
			// TODO : add if iron block work
//			List<ITrade> trades2 = new ArrayList<ITrade>();
//			trades2.add(new Trade().priceGold(1).saleItem(tradeHelper.enchantedIronPickaxe()).defaultValues().creat());
//			trades2.add(new Trade().priceIron(5).saleItem(tradeHelper.fishingRod()).defaultValues().creat());
//			
//			List<ITrade> trades3 = new ArrayList<ITrade>();
//			trades3.add(new Trade().priceIron(3).saleItem(tradeHelper.enchantedFlintAndSteel()).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceIron(5).saleItem(tradeHelper.fishingRod()).defaultValues().creat());
			trades2.add(new Trade().priceIron(3).saleItem(tradeHelper.enchantedFlintAndSteel()).defaultValues().creat());
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		} else if (profession == VillagerProfession.FLETCHER) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceGold(3).saleItem(tradeHelper.enchantedBow1()).defaultValues().creat());
			trades1.add(new Trade().priceGold(7).saleItem(tradeHelper.enchantedBow2()).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceGold(13).saleItem(tradeHelper.enchantedBow3()).defaultValues().creat());
			trades2.add(new Trade().priceGold(1).saleItem(Items.ARROW).defaultValues().creat());
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		} else if (profession == VillagerProfession.BUTCHER) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceBronze(1).saleItem(Items.APPLE).defaultValues().creat());
			trades1.add(new Trade().priceBronze(2).saleItem(Items.COOKED_PORKCHOP).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceGold(1).saleItem(Items.GOLDEN_APPLE).defaultValues().creat());
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		} else if (profession == VillagerProfession.CARTOGRAPHER) {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			trades1.add(new Trade().priceBronze(2).saleItem(Items.LADDER).defaultValues().creat());
			trades1.add(new Trade().priceBronze(8).saleItem(Items.COBWEB).defaultValues().creat());
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			trades2.add(new Trade().priceIron(3).saleItem(ModItems.GUNPOWDER.get()).defaultValues().creat()); 
			trades2.add(new Trade().priceGold(3).saleItem(ModItems.BLAZE_ROD.get()).defaultValues().creat()); 
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			trades3.add(new Trade().priceGold(11).saleItem(Items.ENDER_PEARL).defaultValues().creat());
			trades3.add(new Trade().priceIron(1).saleItem(Items.CHEST).defaultValues().creat());
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			trades4.add(new Trade().priceGold(1).saleItem(Items.ENDER_CHEST).defaultValues().creat());
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		} else {
			
			List<ITrade> trades1 = new ArrayList<ITrade>();
			
			List<ITrade> trades2 = new ArrayList<ITrade>();
			
			List<ITrade> trades3 = new ArrayList<ITrade>();
			
			List<ITrade> trades4 = new ArrayList<ITrade>();
			
			List<ITrade> trades5 = new ArrayList<ITrade>();
			
			event.getTrades().put(1, trades1);
			event.getTrades().put(2, trades2);
			event.getTrades().put(3, trades3);
			event.getTrades().put(4, trades4);
			event.getTrades().put(5, trades5);
			
		}
		
	}
	
}
