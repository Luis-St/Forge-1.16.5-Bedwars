package net.luis.bedwars.init;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.inventory.container.VillagerContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerType {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Bedwars.MOD_ID);
	
	
	public static final RegistryObject<ContainerType<VillagerContainer>> VILLAGER = CONTAINERS.register("vilager_container", 
			() -> IForgeContainerType.create(VillagerContainer::new));
	
}
