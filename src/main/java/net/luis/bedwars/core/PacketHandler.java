package net.luis.bedwars.core;

import java.util.Optional;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.core.message.SyncVillagerContainerMessage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {
	
	private static final String version = "1";
	private static int id = 0;
	public static SimpleChannel simpleChannel;
	
	public static void init() {
		
		simpleChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation(Bedwars.MOD_ID, "simple_chnanel"), () -> version,  version::equals, version::equals);
	
		simpleChannel.registerMessage(id++, SyncVillagerContainerMessage.class, SyncVillagerContainerMessage::encode, 
				SyncVillagerContainerMessage::decode, SyncVillagerContainerMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		
	}
	
}
