package net.luis.bedwars.common.item;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.block.AirBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class GunpowderItem extends Item {

	public GunpowderItem() {
		
		super(new Item.Properties().group(Bedwars.BEDWARS));
		
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		
		if (entity instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entity;
			
			serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
				
				if (bedwarsHandler.canTeleport()) {
					
					if (bedwarsHandler.getGunpowderTeleportCooldown() == 0) {
						
						bedwarsHandler.setGunpowderCooldown(40);
						serverPlayer.setPositionAndUpdate(bedwarsHandler.getRespawnPosX() + 0.5,
								bedwarsHandler.getRespawnPosY(), bedwarsHandler.getRespawnPosZ() + 0.5);
						
						bedwarsHandler.setCanTeleport(false);
						
						if (!serverPlayer.abilities.isCreativeMode) {
							
							List<ItemStack> stacks = this.getAllItems(serverPlayer, this);
							ItemStack itemStack = stacks.get(0);
							itemStack.shrink(1);
							
						}
						
					}
					
				}
				
			});
			
		}
		
	}
	
	public List<ItemStack> getAllItems(ServerPlayerEntity player, Item item) {
		
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(
				() -> new NullPointerException());
		List<ItemStack> itemsToBuy = new ArrayList<ItemStack>();
		
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			
			ItemStack stack = itemHandler.getStackInSlot(i);
			
			if (stack.getItem() == item) {
				
				itemsToBuy.add(stack);
				
			}
			
		}
		
		return itemsToBuy;
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		
		if (player instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			BlockPos pos = new BlockPos(serverPlayer.getPosX(), serverPlayer.getPosY() - 1, serverPlayer.getPosZ());
			
			if (!(world.getBlockState(pos).getBlock() instanceof AirBlock)) {
				
				serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					if (bedwarsHandler.getGunpowderCooldown() == 0) {
						
						bedwarsHandler.setGunpowderTeleportCooldown(6);
						bedwarsHandler.setCanTeleport(true);
						serverPlayer.setExperienceLevel(6);
						
					} else {
						
						serverPlayer.sendMessage(new StringTextComponent("You can use this item in "
								+ bedwarsHandler.getGunpowderCooldown() + " seconds"), player.getUniqueID());
						
					}
					
				});
				
			}
			
		}
		
		return super.onItemRightClick(world, player, hand);
		
	}
	
}
