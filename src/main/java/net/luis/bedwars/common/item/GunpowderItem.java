package net.luis.bedwars.common.item;

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
						
						if (!serverPlayer.abilities.isCreativeMode) {
							
							serverPlayer.getHeldItemMainhand().shrink(1);
							
						}
						
						bedwarsHandler.setCanTeleport(false);
						
					}
					
				}
				
			});
			
		}
		
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
						
						serverPlayer.sendMessage(new StringTextComponent("Du kannst das Item erst wieder in "
								+ bedwarsHandler.getGunpowderCooldown() + " Sekunden nutzten"), null);
						
					}
					
				});
				
			}
			
		}
		
		return super.onItemRightClick(world, player, hand);
		
	}
	
}
