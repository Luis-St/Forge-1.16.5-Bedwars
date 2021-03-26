package net.luis.bedwars.init;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.item.BlazeRodItem;
import net.luis.bedwars.common.item.GunpowderItem;
import net.luis.bedwars.common.item.KnockbackStickItem;
import net.luis.bedwars.common.item.ModBowItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bedwars.MOD_ID);
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bedwars.MINECRAFT_ID);
	
	
	public static final RegistryObject<Item> STICK = VANILLA_ITEMS.register("stick", KnockbackStickItem::new);
	public static final RegistryObject<Item> BOW = VANILLA_ITEMS.register("bow", ModBowItem::new);
	public static final RegistryObject<Item> GUNPOWDER = VANILLA_ITEMS.register("gunpowder", GunpowderItem::new);
	public static final RegistryObject<Item> BLAZE_ROD = VANILLA_ITEMS.register("blaze_rod", BlazeRodItem::new);

}
