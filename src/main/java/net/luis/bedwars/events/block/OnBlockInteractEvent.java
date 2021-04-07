package net.luis.bedwars.events.block;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.base.capability.interfaces.IBedwars;
import net.luis.bedwars.base.util.BedPos;
import net.luis.bedwars.base.util.TeamColor;
import net.luis.bedwars.common.inventory.container.TeamContainer;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.DyeColor;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.network.NetworkHooks;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnBlockInteractEvent {

	@SubscribeEvent
	public static void BlockInteract(PlayerInteractEvent.RightClickBlock event) {
		
		PlayerEntity player = event.getPlayer();
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		BlockState state = world.getBlockState(pos);
		Block block = world.getBlockState(pos).getBlock();
		
		if (block instanceof EnderChestBlock) {
			
			if (player instanceof ServerPlayerEntity) {
				
				ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
				
				if (!serverPlayer.isSneaking()) {
					
					event.setUseBlock(Result.DENY);
					
					if (!serverPlayer.getHeldItemMainhand().isEmpty()) {
						
						event.setUseItem(Result.DENY);
						
					}
					
					IBedwars bedwarsHandler = serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).orElseThrow(() -> new NullPointerException());
					TeamColor teamColor = bedwarsHandler.getTeamColor();
					
					if (teamColor != null) {
						
						String teamName = teamColor.getName();
						ITextComponent textComponent = new StringTextComponent(teamName);
						
						NetworkHooks.openGui((ServerPlayerEntity) serverPlayer, new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
							return new TeamContainer(id, inventory);
						}, textComponent), pos);
						
						double x = pos.getX() + 0.5D;
						double y = pos.getY() + 0.5D;
						double z = pos.getZ() + 0.5D;
						
						world.playSound(null, x, y, z, SoundEvents.BLOCK_ENDER_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
						
					}
					
				} else {
					
					event.setCanceled(true);
					
				}
				
			}
			
		} else if (block instanceof BedBlock) {
			
			BedBlock bedBlock = (BedBlock) block;
			
			if (player instanceof ServerPlayerEntity) {
				
				ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
				bedBlockServer(serverPlayer, pos, state, bedBlock);
				
			}
			
			/**
			 *  TODO : create class with Dist#Client
			 */
			if (player instanceof ClientPlayerEntity) {
				
				ClientPlayerEntity clientPlayer = (ClientPlayerEntity) player;
				bedBlockClient(clientPlayer, bedBlock);
				
			}
			
			event.setCanceled(true);

		} else if (block instanceof CarpetBlock && player instanceof ServerPlayerEntity) {
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			CarpetBlock carpetBlock = (CarpetBlock) block;
			DyeColor color = carpetBlock.getColor();
			
			serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

				if (bedwarsHandler.getTeamColor().getDyeColor() == color) {
					
					bedwarsHandler.setRespawnPos(pos);

					serverPlayer.sendMessage(new StringTextComponent("Respawn position set"), serverPlayer.getUniqueID());

				} else {

					serverPlayer.sendMessage(new StringTextComponent("You can set your respawn position only on a block with your team color"),
							serverPlayer.getUniqueID());

				}

			});

		}

	}
	
	private static void bedBlockServer(ServerPlayerEntity serverPlayer, BlockPos pos, BlockState state, BedBlock bedBlock) {
		
		TeamColor teamColor = TeamColor.getByBedBlock(bedBlock);
		BedPos bedPos = BedPos.getBedPos(serverPlayer, pos, state);

		serverPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {

			if (bedwarsHandler.getTeamColor() == null) {
				
				if (teamColor != null) {
					
					bedwarsHandler.setBedHeadPos(bedPos.getPosHead());
					bedwarsHandler.setBedFootPos(bedPos.getPosFoot());
					bedwarsHandler.setTeamColor(teamColor);
					
					ITextComponent textComponent = new StringTextComponent("Your now in team: ")
							.append((new StringTextComponent(teamColor.getName())).mergeStyle(teamColor.getTextFormatting()));
					serverPlayer.sendMessage(textComponent, serverPlayer.getUniqueID());
					serverPlayer.sendMessage(new StringTextComponent("Please set your respawn position"), serverPlayer.getUniqueID());
					
				} else {
					
					serverPlayer.sendMessage(new StringTextComponent("The color of this bed can used as a team color"), serverPlayer.getUniqueID());
					
				}

			} else {
				
				serverPlayer.sendMessage(new StringTextComponent("You are already in a team"), serverPlayer.getUniqueID());
				
			}

		});
		
	}
	
	private static void bedBlockClient(ClientPlayerEntity clientPlayer, BedBlock bedBlock) {
		
		TeamColor teamColor = TeamColor.getByBedBlock(bedBlock);
		
		clientPlayer.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
			
			if (bedwarsHandler.getTeamColor() == null) {
				
				if (teamColor != null) {
					
					bedwarsHandler.setTeamColor(teamColor);
					
				}

			}
			
		});
		
	}

}
