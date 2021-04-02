package net.luis.bedwars.base.util;

import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.BedPart;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class BedPos {
	
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

}
