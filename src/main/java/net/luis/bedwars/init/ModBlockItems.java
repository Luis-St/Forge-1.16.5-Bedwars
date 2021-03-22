package net.luis.bedwars.init;

import net.luis.bedwars.Bedwars;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bedwars.MOD_ID);
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bedwars.MINECRAFT_ID);
	
	
	public static final RegistryObject<BlockItem> BRONZE_SPAWNER_ITEM = VANILLA_ITEMS.register("terracotta", 
			() -> new BlockItem(ModBlocks.BRONZE_SPAWNER.get(), new Item.Properties().group(Bedwars.BEDWARS)));
	
	public static final RegistryObject<BlockItem> IRON_SPAWNER_ITEM = VANILLA_ITEMS.register("iron_block", 
			() -> new BlockItem(ModBlocks.IRON_SPAWNER.get(), new Item.Properties().group(Bedwars.BEDWARS)));
	
	public static final RegistryObject<BlockItem> GOLD_SPAWNER_ITEM = VANILLA_ITEMS.register("gold_block", 
			() -> new BlockItem(ModBlocks.GOLD_SPAWNER.get(), new Item.Properties().group(Bedwars.BEDWARS)));
	
	public static final RegistryObject<BlockItem> DIAMOND_SPAWNER_ITEM = VANILLA_ITEMS.register("diamond_block", 
			() -> new BlockItem(ModBlocks.DIAMOND_SPAWNER.get(), new Item.Properties().group(Bedwars.BEDWARS)));

}
