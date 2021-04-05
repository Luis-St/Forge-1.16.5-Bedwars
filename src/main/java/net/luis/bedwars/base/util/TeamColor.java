package net.luis.bedwars.base.util;

import net.minecraft.item.DyeColor;

public enum TeamColor {
	
	BLACK(DyeColor.BLACK),
	BLUE(DyeColor.BLUE),
	CYAN(DyeColor.CYAN),
	GRAY(DyeColor.GRAY),
	GREEN(DyeColor.GREEN),
	LIGHT_BLUE(DyeColor.LIGHT_BLUE),
	LIGHT_GRAY(DyeColor.LIGHT_GRAY),
	LIME(DyeColor.LIME),
	ORANGE(DyeColor.ORANGE),
	PINK(DyeColor.PINK),
	PURPLE(DyeColor.PURPLE),
	RED(DyeColor.RED),
	WHITE(DyeColor.WHITE),
	YELLOW(DyeColor.YELLOW);
	
	private final DyeColor color;
	
	private TeamColor(DyeColor color) {
		
		this.color = color;
		
	}

	public DyeColor getColor() {
		
		return color;
		
	}
	
	public static TeamColor getByDyeColor(DyeColor color) {
		
		TeamColor[] teams = TeamColor.values();
		TeamColor teamColor = null;
		
		for (TeamColor team : teams) {
			
			if (team.getColor() == color) {
				
				teamColor = team;
				
			}
			
		}
		
		return teamColor;
		
	}

}
