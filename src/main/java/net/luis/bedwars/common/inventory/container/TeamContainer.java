package net.luis.bedwars.common.inventory.container;

import net.luis.bedwars.base.capability.interfaces.ITeam;
import net.luis.bedwars.init.ModContainerType;
import net.luis.bedwars.init.ModTeamCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;

public class TeamContainer extends Container {
	
	public TeamContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		this(id, playerInventory);
		
	}

	public TeamContainer(int id, PlayerInventory playerInventory) {
		
		super(ModContainerType.TEAM.get(), id);
		PlayerEntity player = playerInventory.player;
		World world = player.getEntityWorld();
		@SuppressWarnings("unused")
		ITeam team = world.getCapability(ModTeamCapability.TEAM, null).orElseThrow(() -> new NullPointerException());
		int i = (6 - 3) * 18;
		
		for (int j = 0; j < 3; ++j) {

			for (int k = 0; k < 9; ++k) {

				this.addSlot(new Slot(null, k + j * 9, 8 + k * 18, (j * 18) + 18));

			}

		}
		
		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
			
		}
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return false;
		
	}

}
