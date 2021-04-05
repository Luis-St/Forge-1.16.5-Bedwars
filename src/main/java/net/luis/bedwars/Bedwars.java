package net.luis.bedwars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.base.capability.interfaces.IGame;
import net.luis.bedwars.base.capability.interfaces.ITeam;
import net.luis.bedwars.common.command.args.ChatRankArgument;
import net.luis.bedwars.common.inventory.screen.VillagerScreen;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModBlockItems;
import net.luis.bedwars.init.ModBlocks;
import net.luis.bedwars.init.ModContainerType;
import net.luis.bedwars.init.ModGameCapability;
import net.luis.bedwars.init.ModItems;
import net.luis.bedwars.init.ModTeamCapability;
import net.luis.bedwars.init.ModTileEntityType;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.command.arguments.ArgumentSerializer;
import net.minecraft.command.arguments.ArgumentTypes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Bedwars.MOD_ID)
public class Bedwars {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "bedwars";
	public static final String MINECRAFT_ID = "minecraft";
	
	public Bedwars() {
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlocks.BLOCKS.register(eventBus);
		ModBlocks.VANILLA_BLOCKS.register(eventBus);
		
		ModBlockItems.ITEMS.register(eventBus);
		ModBlockItems.VANILLA_ITEMS.register(eventBus);
		
		ModItems.ITEMS.register(eventBus);
		ModItems.VANILLA_ITEMS.register(eventBus);
		
		ModTileEntityType.TILE_ENTITIES.register(eventBus);
		
		ModContainerType.CONTAINERS.register(eventBus);
		
	}
	
	private void setup(FMLCommonSetupEvent event) {
		
		CapabilityManager.INSTANCE.register(IBedwars.class, new ModBedwarsCapability.BedwarsStorage(), new ModBedwarsCapability.BedwarsFactory());
		CapabilityManager.INSTANCE.register(IGame.class, new ModGameCapability.GameStorage(), new ModGameCapability.GameFactory());
		CapabilityManager.INSTANCE.register(ITeam.class, new ModTeamCapability.TeamStorage(), new ModTeamCapability.TeamFactory());
		ArgumentTypes.register("rank", ChatRankArgument.class, new ArgumentSerializer<>(ChatRankArgument::chatRank));
		
	}
	
	private void doClientStuff(FMLClientSetupEvent event) {
	
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.VILLAGER.get(), VillagerScreen::new));
		
	}
	
	public static final ItemGroup BEDWARS = new ItemGroup(MOD_ID) {
		
		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.RED_BED);
			
		}
		
	};

}
