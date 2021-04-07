package net.luis.bedwars.base.util;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.Bedwars;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public enum ChatRank {
	
	ZOMBIE_FIGHTER("Zombie Fighter", "zombie_fighter", new ResourceLocation(Bedwars.MOD_ID, "zombie_fighter"), 0, TextFormatting.DARK_GREEN),
	SKELETON_SNIPER("Skeleton Sniper", "skeleton_sniper", new ResourceLocation(Bedwars.MOD_ID, "skeleton_sniper"), 1, TextFormatting.GRAY),
	CREEPER_DEFUSER("Creeper Defuser", "creeper_defuser", new ResourceLocation(Bedwars.MOD_ID, "creeper_defuser"), 2, TextFormatting.GREEN),
	WITHER_KILLER("Wither Killer", "wither_killer", new ResourceLocation(Bedwars.MOD_ID, "wither_killer"), 3, TextFormatting.DARK_GRAY),
	DRAGON_SLAYER("Dragon Slayer", "dragon_slayer", new ResourceLocation(Bedwars.MOD_ID, "dragon_slayer"), 4, TextFormatting.DARK_PURPLE),
	MINECRAFT_GOD("Minecraft God", "minecraft_god", new ResourceLocation(Bedwars.MOD_ID, "minecraft_god"), 5, TextFormatting.GOLD),
	SERVER_ADMIN("Server Admin", "server_admin", new ResourceLocation(Bedwars.MOD_ID, "server_admin"), 6, TextFormatting.DARK_RED);
	
	private final String rank;
	private final String argName;
	private final ResourceLocation location;
	private final int id;
	private final TextFormatting style;

	private ChatRank(String rank, String argName, ResourceLocation location, int id, TextFormatting style) {
		
		this.rank = rank;
		this.argName = argName;
		this.location = location;
		this.id = id;
		this.style = style;
		
	}

	public String getRankName() {
		
		return this.rank;
		
	}
	
	public String getCommandArgumentName() {
		
		return this.argName;
		
	}
	
	public ResourceLocation getLocation() {
		
		return location;
		
	}

	public int getId() {
		
		return this.id;
		
	}

	public TextFormatting getRankFormatting() {
		
		return this.style;
		
	}
	
	public static ChatRank byId(int id) {
		
		ChatRank[] ranks = ChatRank.values();
		ChatRank returnRank = ZOMBIE_FIGHTER;
		
		for (ChatRank chatRank : ranks) {
			
			if (chatRank.getId() == id) {
				
				returnRank = chatRank;
				
			}
			
		}
		
		return returnRank;
		
	}
	
	public static ChatRank byRankName(ResourceLocation location) {
		
		ChatRank[] ranks = ChatRank.values();
		ChatRank returnRank = null;
		
		for (ChatRank chatRank : ranks) {
			
			if (chatRank.getLocation().equals(location)) {
				
				returnRank = chatRank;
				
			}
			
		}
		
		return returnRank;
		
	}
	
	public static List<ResourceLocation> rankLocationAsList() {
		
		List<ResourceLocation> locations = new ArrayList<ResourceLocation>(); 
		ChatRank[] ranks = ChatRank.values();
		
		for (ChatRank chatRank : ranks) {
			
			locations.add(chatRank.getLocation());
			
		}
		
		return locations;

	}

}
