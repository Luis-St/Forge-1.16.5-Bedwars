package net.luis.bedwars.init;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.block.BronzeSpawnerBlock;
import net.luis.bedwars.common.block.GoldSpawnerBlock;
import net.luis.bedwars.common.block.IronSpawnerBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bedwars.MOD_ID);
	public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Bedwars.MINECRAFT_ID);
	
	
	public static final RegistryObject<Block> BRONZE_SPAWNER = VANILLA_BLOCKS.register("terracotta", BronzeSpawnerBlock::new);
	public static final RegistryObject<Block> IRON_SPAWNER = VANILLA_BLOCKS.register("iron_block", IronSpawnerBlock::new);
	public static final RegistryObject<Block> GOLD_SPAWNER = VANILLA_BLOCKS.register("gold_block", GoldSpawnerBlock::new);
	public static final RegistryObject<Block> BLOCK_OF_IRON = BLOCKS.register("block_of_iron", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool()
					.hardnessAndResistance(7.0F, 10.0F).sound(SoundType.METAL)));

}
