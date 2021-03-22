package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModCapability;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.state.properties.BedPart;
import net.minecraft.tileentity.BedTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
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

		if (block instanceof BedBlock && !world.isRemote) {

			TileEntity tileEntity = world.getTileEntity(pos);

			if (tileEntity instanceof BedTileEntity) {

				BedTileEntity bedTileEntity = (BedTileEntity) tileEntity;
				DyeColor color = bedTileEntity.getColor();

				BedPos bedPos = getBedPos(player, pos, state);

				player.getCapability(ModCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

					if (bedwarsHandler.getTeamColor() == null) {

						bedwarsHandler.setBedHeadPos(bedPos.getPosHead());
						bedwarsHandler.setBedFootPos(bedPos.getPosFoot());
						bedwarsHandler.setTeamColor(color);

						int x = bedPos.getPosHead().getX();
						int y = bedPos.getPosHead().getY();
						int z = bedPos.getPosHead().getZ();

						player.sendMessage(new StringTextComponent("Du bist nun im Team: " + color.getTranslationKey()),
								player.getUniqueID());
						player.sendMessage(new StringTextComponent(
								"Dein Bett hat folgende Position [x]: " + x + " [y]: " + y + " [y]: " + z),
								player.getUniqueID());
						player.sendMessage(new StringTextComponent("Bitte Setzte nun noch dein Respawn Position"),
								player.getUniqueID());

					}

				});

			}

		} else if (block instanceof CarpetBlock && !world.isRemote) {

			CarpetBlock carpetBlock = (CarpetBlock) block;
			DyeColor color = carpetBlock.getColor();

			player.getCapability(ModCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

				if (bedwarsHandler.getTeamColor() == color) {

					bedwarsHandler.setRespawnPos(pos);

					player.sendMessage(new StringTextComponent("Respawn Position gesetzt"), player.getUniqueID());

				} else {

					player.sendMessage(new StringTextComponent(
							"Du kannst dein Respawn Position nur auch einen Block mit gleicher Teamfarbe setzten"),
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

}
