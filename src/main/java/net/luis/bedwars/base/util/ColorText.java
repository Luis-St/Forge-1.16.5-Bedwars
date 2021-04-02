package net.luis.bedwars.base.util;

import net.minecraft.block.BedBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.DyeColor;
import net.minecraft.util.text.TextFormatting;

public class ColorText {
	
	private final DyeColor color;
	private final String teamName;
	private final TextFormatting[] formatting;
	
	public ColorText(DyeColor color, String teamName, TextFormatting... formatting) {
		
		this.color = color;
		this.teamName = teamName;
		this.formatting = formatting;
		
	}

	public DyeColor getColor() {
		
		return color;
		
	}

	public String getTeamName() {
		
		return teamName;
		
	}

	public TextFormatting[] getFormatting() {
		
		return formatting;
		
	}
	
	public static ColorText getColor(BedBlock block) {
		
		if (block == Blocks.BLACK_BED) {
			
			return new ColorText(DyeColor.BLACK, "Black", TextFormatting.BLACK);
			
		} else if (block == Blocks.BLUE_BED) {
			
			return new ColorText(DyeColor.BLUE, "Blue", TextFormatting.DARK_BLUE);
			
		} else if (block == Blocks.BROWN_BED) {
			
			return null; 
			
		} else if (block == Blocks.CYAN_BED) {
			
			return new ColorText(DyeColor.CYAN, "Cyan", TextFormatting.DARK_AQUA); 
			
		} else if (block == Blocks.GRAY_BED) {
			
			return new ColorText(DyeColor.GRAY, "Gray", TextFormatting.DARK_GRAY);
			
		} else if (block == Blocks.GREEN_BED) {
			
			return new ColorText(DyeColor.GREEN, "Green", TextFormatting.DARK_GREEN);
			
		} else if (block == Blocks.LIGHT_BLUE_BED) {
			
			return new ColorText(DyeColor.LIGHT_BLUE, "Light Blue", TextFormatting.AQUA); 
			
		} else if (block == Blocks.LIGHT_GRAY_BED) {
			
			return new ColorText(DyeColor.LIGHT_GRAY, "Light Gray", TextFormatting.GRAY);
			
		} else if (block == Blocks.LIME_BED) {
			
			return new ColorText(DyeColor.LIME, "Lime", TextFormatting.GREEN);
			
		} else if (block == Blocks.MAGENTA_BED) {
			
			return null; 
			
		} else if (block == Blocks.ORANGE_BED) {
			
			return new ColorText(DyeColor.ORANGE, "Orange", TextFormatting.GOLD); 
			
		} else if (block == Blocks.PINK_BED) {
			
			return new ColorText(DyeColor.PINK, "Pink", TextFormatting.LIGHT_PURPLE);
			
		} else if (block == Blocks.PURPLE_BED) {
			
			return new ColorText(DyeColor.PURPLE, "Purple", TextFormatting.DARK_PURPLE);
			
		} else if (block == Blocks.RED_BED) {
			
			return new ColorText(DyeColor.RED, "Red", TextFormatting.DARK_RED);
			
		} else if (block == Blocks.WHITE_BED) {
			
			return new ColorText(DyeColor.WHITE, "White", TextFormatting.WHITE);
			
		} else if (block == Blocks.YELLOW_BED) {
			
			return new ColorText(DyeColor.YELLOW, "Yellow", TextFormatting.YELLOW);
			
		}
		
		return null;
		
	}

}
