package net.luis.bedwars.events.block;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.base.util.BedPos;
import net.luis.bedwars.base.util.ColorText;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnBlockInteractEvent {

	@SubscribeEvent
	public static void BlockInteract(PlayerInteractEvent.RightClickBlock event) {
		
		PlayerEntity player = event.getPlayer();
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		BlockState state = world.getBlockState(pos);
		Block block = world.getBlockState(pos).getBlock();

		if (block instanceof BedBlock && player instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			ColorText color = ColorText.getColor((BedBlock) block);
			BedPos bedPos = BedPos.getBedPos(player, pos, state);

			serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

				if (bedwarsHandler.getTeamColor() == null) {
					
					if (color != null) {
						
						bedwarsHandler.setBedHeadPos(bedPos.getPosHead());
						bedwarsHandler.setBedFootPos(bedPos.getPosFoot());
						bedwarsHandler.setTeamColor(color.getColor());
						
						ITextComponent textComponent = new StringTextComponent("Your now in team: ")
								.append((new StringTextComponent(color.getTeamName())).mergeStyle(color.getFormatting()));
						serverPlayer.sendMessage(textComponent, serverPlayer.getUniqueID());
						serverPlayer.sendMessage(new StringTextComponent("Please set your respawn position"), serverPlayer.getUniqueID());
						
					} else {
						
						player.sendMessage(new StringTextComponent("The color of this bed can used as a team color"), serverPlayer.getUniqueID());
						
					}

				} else {
					
					serverPlayer.sendMessage(new StringTextComponent("You are already in a team"), serverPlayer.getUniqueID());
					
				}

			});
			
			event.setCanceled(true);

		} else if (block instanceof CarpetBlock && player instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			CarpetBlock carpetBlock = (CarpetBlock) block;
			DyeColor color = carpetBlock.getColor();
			
			serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

				if (bedwarsHandler.getTeamColor() == color) {
					
					bedwarsHandler.setRespawnPos(pos);

					serverPlayer.sendMessage(new StringTextComponent("Respawn position set"), serverPlayer.getUniqueID());

				} else {

					serverPlayer.sendMessage(new StringTextComponent("You can set your respawn position only on a block with your team color"),
							serverPlayer.getUniqueID());

				}

			});

		}

	}

}
