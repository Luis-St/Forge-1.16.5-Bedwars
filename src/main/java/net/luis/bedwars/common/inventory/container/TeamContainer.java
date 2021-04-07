package net.luis.bedwars.common.inventory.container;

import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.base.capability.interfaces.ITeam;
import net.luis.bedwars.base.util.TeamColor;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.luis.bedwars.init.ModContainerType;
import net.luis.bedwars.init.ModTeamCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class TeamContainer extends Container {
	
	public TeamContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		this(id, playerInventory);
		
	}

	public TeamContainer(int id, PlayerInventory playerInventory) {
		
		super(ModContainerType.TEAM.get(), id);
		PlayerEntity player = playerInventory.player;
		World world = player.getEntityWorld();
		ITeam teamHandler = world.getCapability(ModTeamCapability.TEAM, null).orElseThrow(() -> new NullPointerException());
		IBedwars bedwarsHandler = player.getCapability(ModBedwarsCapability.BEDWARS, null).orElseThrow(() -> new NullPointerException());
		TeamColor teamColor = bedwarsHandler.getTeamColor();
		
		if (teamColor == null) return;
		
		ItemStackHandler stackHandler = teamHandler.getInventoryByTeamColor(teamColor);
		
		for (int j = 0; j < 3; ++j) {

			for (int k = 0; k < 9; ++k) {

				this.addSlot(new SlotItemHandler(stackHandler, k + j * 9, 8 + k * 18, (j * 18) + 18));

			}

		}
		
		for (int i1 = 0; i1 < 3; ++i1) {
			
			for (int k1 = 0; k1 < 9; ++k1) {
				
				this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 85 + i1 * 18));
				
			}
			
		}

		for (int j1 = 0; j1 < 9; ++j1) {

			this.addSlot(new Slot(playerInventory, j1, 8 + j1 * 18, 143));

		}
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
