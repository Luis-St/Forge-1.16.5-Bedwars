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
			
			ColorText color = ColorText.getColor((BedBlock) block);
			BedPos bedPos = BedPos.getBedPos(player, pos, state);

			player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

				if (bedwarsHandler.getTeamColor() == null) {
					
					if (color != null) {
						
						bedwarsHandler.setBedHeadPos(bedPos.getPosHead());
						bedwarsHandler.setBedFootPos(bedPos.getPosFoot());
						bedwarsHandler.setTeamColor(color.getColor());
						
						ITextComponent textComponent = new StringTextComponent("Du bist nun im Team: ")
								.append((new StringTextComponent(color.getTeamName())).mergeStyle(color.getFormatting()));
						player.sendMessage(textComponent, player.getUniqueID());
						player.sendMessage(new StringTextComponent("Bitte Setzte nun noch dein Respawn Position"), player.getUniqueID());
						
					} else {
						
						player.sendMessage(new StringTextComponent("Die Farbe des Betts kann nicht als Team Farbe verwendet werden"), player.getUniqueID());
						
					}
					
					event.setCanceled(true);

				} else {
					
					player.sendMessage(new StringTextComponent("Du bist bereits in einem Team"), player.getUniqueID());
					
				}

			});

		} else if (block instanceof CarpetBlock && player instanceof ServerPlayerEntity) {

			CarpetBlock carpetBlock = (CarpetBlock) block;
			DyeColor color = carpetBlock.getColor();

			player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

				if (bedwarsHandler.getTeamColor() == color) {

					bedwarsHandler.setRespawnPos(pos);

					player.sendMessage(new StringTextComponent("Respawn Position gesetzt"), player.getUniqueID());

				} else {

					player.sendMessage(new StringTextComponent("Du kannst dein Respawn Position nur auf einen Block mit gleicher Teamfarbe setzten"),
							player.getUniqueID());

				}

			});

		}

	}

}
