package net.luis.bedwars.base.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.text.TextFormatting;

public enum ChatRank {
	
	PLAYER("Spieler", "spieler", 0, TextFormatting.GRAY),
	PREMIUM("Premium", "premium", 1, TextFormatting.GOLD),
	SUPREMIUM("Supremium", "supremium", 2, TextFormatting.AQUA),
	ADMIN("Server Admin", "server admin", 3, TextFormatting.DARK_RED);
	
	private final String rank;
	private final String argName;
	private final int id;
	private final TextFormatting style;

	private ChatRank(String rank, String argName, int id, TextFormatting style) {
		
		this.rank = rank;
		this.argName = argName;
		this.id = id;
		this.style = style;
		
	}

	public String getRankName() {
		
		return this.rank;
		
	}
	
	public String getCommandArgumentName() {
		
		return this.argName;
		
	}

	public int getId() {
		
		return this.id;
		
	}

	public TextFormatting getRankFormatting() {
		
		return this.style;
		
	}
	
	public static ChatRank byId(int id) {
		
		ChatRank[] ranks = ChatRank.values();
		ChatRank returnRank = PLAYER;
		
		for (ChatRank chatRank : ranks) {
			
			if (chatRank.getId() == id) {
				
				returnRank = chatRank;
				
			}
			
		}
		
		return returnRank;
		
	}
	
	public static ChatRank byRankName(String name) {
		
		ChatRank[] ranks = ChatRank.values();
		ChatRank returnRank = null;
		
		for (ChatRank chatRank : ranks) {
			
			if (chatRank.getRankName().equalsIgnoreCase(name)) {
				
				returnRank = chatRank;
				
			}
			
		}
		
		return returnRank;
		
	}
	
	public static List<String> rankNamesAsList() {
		
		List<String> names = new ArrayList<String>(); 
		ChatRank[] ranks = ChatRank.values();
		
		for (ChatRank chatRank : ranks) {
			
			names.add(chatRank.getCommandArgumentName());
			
		}
		
		return names;

	}

}
