package net.luis.bedwars.events.player;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.common.inventory.container.VillagerContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerData;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityInteractSpecificEvent {
	
	private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.villager");
	
	@SubscribeEvent
	public static void EntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
		
		PlayerEntity player = event.getPlayer();
		Entity target = event.getTarget();
		
		if (target instanceof VillagerEntity && player instanceof ServerPlayerEntity) {
			
			VillagerEntity villager = (VillagerEntity) target;
			VillagerData data = villager.getVillagerData();
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			
			if (data.getProfession() == VillagerProfession.FARMER) {
				
				NetworkHooks.openGui(serverPlayer, new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
					
					return new VillagerContainer(id, inventory, new Inventory(6 * 9));
					
				}, CONTAINER_NAME));
				
			}
			
		}
	}

}

