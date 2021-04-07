package net.luis.bedwars.base.util;

import net.minecraft.block.BedBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.DyeColor;
import net.minecraft.util.text.TextFormatting;

public enum TeamColor {
	
	BLACK((BedBlock) Blocks.BLACK_BED, DyeColor.BLACK, TextFormatting.BLACK, "Black", 0),
	BLUE((BedBlock) Blocks.BLUE_BED, DyeColor.BLUE, TextFormatting.DARK_BLUE, "Blue", 1),
	CYAN((BedBlock) Blocks.CYAN_BED, DyeColor.CYAN, TextFormatting.DARK_AQUA, "Cyan", 2),
	GRAY((BedBlock) Blocks.GRAY_BED, DyeColor.GRAY, TextFormatting.DARK_GRAY, "Gray", 3),
	GREEN((BedBlock) Blocks.GREEN_BED, DyeColor.GREEN, TextFormatting.GREEN, "Green", 4),
	LIGHT_BLUE((BedBlock) Blocks.LIGHT_BLUE_BED, DyeColor.LIGHT_BLUE, TextFormatting.AQUA, "Light Blue", 5),
	LIGHT_GRAY((BedBlock) Blocks.LIGHT_GRAY_BED, DyeColor.LIGHT_GRAY, TextFormatting.GRAY, "Light Gray", 6),
	LIME((BedBlock) Blocks.LIME_BED, DyeColor.LIME, TextFormatting.GREEN, "Lime", 7),
	ORANGE((BedBlock) Blocks.ORANGE_BED, DyeColor.ORANGE, TextFormatting.GOLD, "Orange", 8),
	PINK((BedBlock) Blocks.PINK_BED, DyeColor.PINK, TextFormatting.LIGHT_PURPLE, "Pink", 9),
	PURPLE((BedBlock) Blocks.PURPLE_BED, DyeColor.PURPLE, TextFormatting.DARK_PURPLE, "Purple", 10),
	RED((BedBlock) Blocks.RED_BED, DyeColor.RED, TextFormatting.RED, "Red", 11),
	WHITE((BedBlock) Blocks.WHITE_BED, DyeColor.WHITE, TextFormatting.WHITE, "White", 12),
	YELLOW((BedBlock) Blocks.YELLOW_BED, DyeColor.YELLOW, TextFormatting.YELLOW, "Yellow", 13);
	
	
	private final BedBlock bedBlock;
	private final DyeColor dyeColor;
	private final TextFormatting textFormatting;
	private final String name;
	private final int id;

	private TeamColor(BedBlock bedBlock, DyeColor dyeColor, TextFormatting textFormatting, String name, int id) {
		
		this.bedBlock = bedBlock;
		this.dyeColor = dyeColor;
		this.textFormatting = textFormatting;
		this.name = name;
		this.id = id;
		
	}
	
	public BedBlock getBedBlock() {
		
		return bedBlock;
		
	}

	public DyeColor getDyeColor() {
		
		return dyeColor;
		
	}

	public TextFormatting getTextFormatting() {
		
		return textFormatting;
		
	}

	public String getName() {
		
		return name;
		
	}

	public int getId() {
		
		return id;
		
	}
	
	public static TeamColor getByBedBlock(BedBlock bedBlock) {
		
		TeamColor[] teams = TeamColor.values();
		TeamColor returnTeam = null;
		
		for (TeamColor teamColor : teams) {
			
			if (teamColor.getBedBlock() == bedBlock) {
				
				returnTeam = teamColor;
				
			}
			
		}
		
		return returnTeam;
		
	}
	
	public static TeamColor getByDyeColor(DyeColor dyeColor) {
		
		TeamColor[] teams = TeamColor.values();
		TeamColor returnTeam = null;
		
		for (TeamColor teamColor : teams) {
			
			if (teamColor.getDyeColor() == dyeColor) {
				
				returnTeam = teamColor;
				
			}
			
		}
		
		return returnTeam;
		
	}
	
	public static TeamColor getByTextFormatting(TextFormatting textFormatting) {
		
		TeamColor[] teams = TeamColor.values();
		TeamColor returnTeam = null;
		
		for (TeamColor teamColor : teams) {
			
			if (teamColor.getTextFormatting() == textFormatting) {
				
				returnTeam = teamColor;
				
			}
			
		}
		
		return returnTeam;
		
	}
	
	public static TeamColor getByName(String name) {
		
		TeamColor[] teams = TeamColor.values();
		TeamColor returnTeam = null;
		
		for (TeamColor teamColor : teams) {
			
			if (teamColor.getName().equals(name)) {
				
				returnTeam = teamColor;
				
			}
			
		}
		
		return returnTeam;
		
	}
	
	public static TeamColor getById(int id) {
		
		TeamColor[] teams = TeamColor.values();
		TeamColor returnTeam = null;
		
		for (TeamColor teamColor : teams) {
			
			if (teamColor.getId() == id) {
				
				returnTeam = teamColor;
				
			}
			
		}
		
		return returnTeam;
		
	}

}
