package net.luis.bedwars.events.block;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.state.properties.BedPart;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
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
			
			ColorText color = getColor((BedBlock) block);
			BedPos bedPos = getBedPos(player, pos, state);

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

	public static BedPos getBedPos(PlayerEntity player, BlockPos pos, BlockState state) {

		BedPart part = state.get(BedBlock.PART);
		int x = pos.getX();
		int z = pos.getZ();
		BlockPos head = BlockPos.ZERO;
		BlockPos foot = BlockPos.ZERO;
		Direction direction = BedBlock.getFootDirection(state);

		if (part == BedPart.FOOT) {

			switch (direction) {
			case NORTH:
				--z;
				break;
			case EAST:
				++x;
				break;
			case SOUTH:
				++z;
				break;
			case WEST:
				--x;
				break;
			default:
				break;
			}

			head = new BlockPos(x, pos.getY(), z);
			foot = pos;

		} else {

			part = BedPart.HEAD;
			direction = direction.getOpposite();

			switch (direction) {
			case NORTH:
				z -= 1;
				break;
			case EAST:
				x += 1;
				break;
			case SOUTH:
				z += 1;
				break;
			case WEST:
				x -= 1;
				break;
			default:
				break;
			}

			head = pos;
			foot = new BlockPos(x, pos.getY(), z);

		}

		return new BedPos(head, foot);

	}
	
	public static ColorText getColor(BedBlock block) {
		
		if (block == Blocks.BLACK_BED) {
			
			return new ColorText(DyeColor.BLACK, "Black", TextFormatting.BLACK);
			
		} else if (block == Blocks.BLUE_BED) {
			
			return new ColorText(DyeColor.BLUE, "Blue", TextFormatting.DARK_BLUE);
			
		} else if (block == Blocks.BROWN_BED) {
			
			return null; 
			
		} else if (block == Blocks.CYAN_BED) {
			
			return new ColorText(DyeColor.CYAN, "Cyan", TextFormatting.DARK_AQUA); 
			
		} else if (block == Blocks.GRAY_BED) {
			
			return new ColorText(DyeColor.GRAY, "Gray", TextFormatting.DARK_GRAY);
			
		} else if (block == Blocks.GREEN_BED) {
			
			return new ColorText(DyeColor.GREEN, "Green", TextFormatting.DARK_GREEN);
			
		} else if (block == Blocks.LIGHT_BLUE_BED) {
			
			return new ColorText(DyeColor.LIGHT_BLUE, "Light Blue", TextFormatting.AQUA); 
			
		} else if (block == Blocks.LIGHT_GRAY_BED) {
			
			return new ColorText(DyeColor.LIGHT_GRAY, "Light Gray", TextFormatting.GRAY);
			
		} else if (block == Blocks.LIME_BED) {
			
			return new ColorText(DyeColor.LIME, "Lime", TextFormatting.GREEN);
			
		} else if (block == Blocks.MAGENTA_BED) {
			
			return null; 
			
		} else if (block == Blocks.ORANGE_BED) {
			
			return null; 
			
		} else if (block == Blocks.PINK_BED) {
			
			return new ColorText(DyeColor.PINK, "Pink", TextFormatting.LIGHT_PURPLE);
			
		} else if (block == Blocks.PURPLE_BED) {
			
			return new ColorText(DyeColor.PURPLE, "Purple", TextFormatting.DARK_PURPLE);
			
		} else if (block == Blocks.RED_BED) {
			
			return new ColorText(DyeColor.RED, "Red", TextFormatting.DARK_RED);
			
		} else if (block == Blocks.WHITE_BED) {
			
			return new ColorText(DyeColor.WHITE, "White", TextFormatting.WHITE);
			
		} else if (block == Blocks.YELLOW_BED) {
			
			return new ColorText(DyeColor.YELLOW, "Yellow", TextFormatting.YELLOW);
			
		}
		
		return null;
		
	}

	public static class BedPos {

		private final BlockPos posHead;
		private final BlockPos posFoot;

		public BedPos(BlockPos posHead, BlockPos posFoot) {

			this.posHead = posHead;
			this.posFoot = posFoot;

		}

		public BlockPos getPosHead() {

			return posHead;

		}

		public BlockPos getPosFoot() {

			return posFoot;

		}

	}
	
	public static class ColorText {
		
		private final DyeColor color;
		private final String teamName;
		private final TextFormatting[] formatting;
		
		public ColorText(DyeColor color, String teamName, TextFormatting... formatting) {
			
			this.color = color;
			this.teamName = teamName;
			this.formatting = formatting;
			
		}

		public DyeColor getColor() {
			
			return color;
			
		}

		public String getTeamName() {
			
			return teamName;
			
		}

		public TextFormatting[] getFormatting() {
			
			return formatting;
			
		}

	}

}
