package net.luis.bedwars.common.base;

import net.minecraft.item.DyeColor;

public enum TeamColor {
	
	RED("red", 0, DyeColor.RED),
	BLUE("blue", 1, DyeColor.BLUE),
	YELLOW("yellow", 2, DyeColor.YELLOW),
	GREEN("green", 3, DyeColor.GREEN),
	PINK("pink", 4, DyeColor.PINK),
	TÜRKIS("türkis", 5, DyeColor.CYAN),
	ORANGE("orange", 6, DyeColor.ORANGE),
	VIOLETT("violett", 7, DyeColor.PURPLE);
	
	private final String name;
	private final int id;
	private final DyeColor color;
	
	private TeamColor(String name, int id, DyeColor color) {
		
		this.name = name;
		this.id = id;
		this.color = color;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public DyeColor getColor() {
		return color;
	}

}
