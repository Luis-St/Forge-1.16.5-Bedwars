package net.luis.bedwars.init;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.tileentities.SpawnBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityType {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Bedwars.MOD_ID);
	
	
	public static final RegistryObject<TileEntityType<SpawnBlockTileEntity>> SPAWNER = TILE_ENTITIES.register("spawner", 
			() -> TileEntityType.Builder.create(SpawnBlockTileEntity::new, 
			new Block[] {ModBlocks.BRONZE_SPAWNER.get(), ModBlocks.BLOCK_OF_IRON.get(), ModBlocks.GOLD_SPAWNER.get()}).build(null));

}
