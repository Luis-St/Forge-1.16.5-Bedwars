package net.luis.bedwars.core.message;

import java.util.function.Supplier;

import net.luis.bedwars.common.inventory.container.VillagerContainer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class SyncVillagerContainerMessage {
	
	private static VillagerContainer container;
	private static int id;
	
	public SyncVillagerContainerMessage(VillagerContainer containerIn, int idIn) {
		
		container = containerIn;
		id = idIn;
		
	}
	
	public static void encode(SyncVillagerContainerMessage message, PacketBuffer buffer) {
		
	}

	
	public static SyncVillagerContainerMessage decode(PacketBuffer buffer) {
		
		return new SyncVillagerContainerMessage(container, id);
		
	}

	
	public static void handle(SyncVillagerContainerMessage message, Supplier<Context> networkContext) {
		
		networkContext.get().enqueueWork(() -> {
			
			VillagerContainer container = getContainer();
			int id = getId();
			
			container.syncSecondById(id);
			
		});
		
		networkContext.get().setPacketHandled(true);
		
	}

	private static VillagerContainer getContainer() {
		
		return container;
		
	}

	public static int getId() {
		
		return id;
		
	}
	
}
