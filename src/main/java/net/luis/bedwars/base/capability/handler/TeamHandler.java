package net.luis.bedwars.base.capability.handler;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.base.capability.interfaces.ITeam;
import net.luis.bedwars.base.util.TeamColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.items.ItemStackHandler;

public class TeamHandler implements ITeam {
	
	private final ItemStackHandler black = new ItemStackHandler(27);
	private final ItemStackHandler blue = new ItemStackHandler(27);
	private final ItemStackHandler cyan = new ItemStackHandler(27);
	private final ItemStackHandler gray = new ItemStackHandler(27);
	private final ItemStackHandler green = new ItemStackHandler(27);
	private final ItemStackHandler lightBlue = new ItemStackHandler(27);
	private final ItemStackHandler lightGray = new ItemStackHandler(27);
	private final ItemStackHandler lime = new ItemStackHandler(27);
	private final ItemStackHandler orange = new ItemStackHandler(27);
	private final ItemStackHandler pink = new ItemStackHandler(27);
	private final ItemStackHandler purple = new ItemStackHandler(27);
	private final ItemStackHandler red = new ItemStackHandler(27);
	private final ItemStackHandler white = new ItemStackHandler(27);
	private final ItemStackHandler yellow = new ItemStackHandler(27);
	

	@Override
	public ItemStackHandler getInventoryBlack() {
		return this.black;
	}

	@Override
	public ItemStackHandler getInventoryBlue() {
		return this.blue;
	}

	@Override
	public ItemStackHandler getInventoryCyan() {
		return this.cyan;
	}

	@Override
	public ItemStackHandler getInventoryGray() {
		return this.gray;
	}

	@Override
	public ItemStackHandler getInventoryGreen() {
		return this.green;
	}

	@Override
	public ItemStackHandler getInventoryLightBlue() {
		return this.lightBlue;
	}

	@Override
	public ItemStackHandler getInventoryLightGray() {
		return this.lightGray;
	}

	@Override
	public ItemStackHandler getInventoryLime() {
		return this.lime;
	}

	@Override
	public ItemStackHandler getInventoryOrange() {
		return this.orange;
	}

	@Override
	public ItemStackHandler getInventoryPink() {
		return this.pink;
	}

	@Override
	public ItemStackHandler getInventoryPurple() {
		return this.purple;
	}

	@Override
	public ItemStackHandler getInventoryRed() {
		return this.red;
	}

	@Override
	public ItemStackHandler getInventoryWhite() {
		return this.white;
	}

	@Override
	public ItemStackHandler getInventoryYellow() {
		return this.yellow;
	}

	@Override
	public List<ItemStackHandler> getAllInventories() {
		List<ItemStackHandler> handlers = new ArrayList<ItemStackHandler>();
		handlers.add(this.getInventoryBlack());
		handlers.add(this.getInventoryBlue());
		handlers.add(this.getInventoryCyan());
		handlers.add(this.getInventoryGray());
		handlers.add(this.getInventoryLightBlue());
		handlers.add(this.getInventoryLightGray());
		handlers.add(this.getInventoryLime());
		handlers.add(this.getInventoryOrange());
		handlers.add(this.getInventoryPink());
		handlers.add(this.getInventoryPurple());
		handlers.add(this.getInventoryRed());
		handlers.add(this.getInventoryWhite());
		handlers.add(this.getInventoryYellow());
		return handlers;
	}

	@Override
	public ItemStackHandler getInventoryByColor(TeamColor teamColor) {
		switch (teamColor) {
		case BLACK: return this.getInventoryBlack();
		case BLUE: return this.getInventoryBlue();
		case CYAN: return this.getInventoryCyan();
		case GRAY: return this.getInventoryGray();
		case GREEN: return this.getInventoryGreen();
		case LIGHT_BLUE: return this.getInventoryLightBlue();
		case LIGHT_GRAY: return this.getInventoryLightGray();
		case LIME: return this.getInventoryLime();
		case ORANGE: return this.getInventoryOrange();
		case PINK: return this.getInventoryPink();
		case PURPLE: return this.getInventoryPurple();
		case RED: return this.getInventoryRed();
		case WHITE: return this.getInventoryWhite();
		case YELLOW: return this.getInventoryYellow();
		}
		return null;
	}

	@Override
	public void clearAll() {
		this.getAllInventories().forEach(handler -> {
			this.clear(handler);
		});
	}
	
	private void clear(ItemStackHandler handler) {
		for (int i = 0; i < handler.getSlots(); i++) {
			handler.setStackInSlot(i, ItemStack.EMPTY);
		}
	}

	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.put("black", this.black.serializeNBT());
		nbt.put("blue", this.blue.serializeNBT());
		nbt.put("cyan", this.cyan.serializeNBT());
		nbt.put("gray", this.gray.serializeNBT());
		nbt.put("green", this.green.serializeNBT());
		nbt.put("lightBlue", this.lightBlue.serializeNBT());
		nbt.put("lightGray", this.lightGray.serializeNBT());
		nbt.put("lime", this.lime.serializeNBT());
		nbt.put("orange", this.orange.serializeNBT());
		nbt.put("pink", this.pink.serializeNBT());
		nbt.put("purple", this.purple.serializeNBT());
		nbt.put("red", this.red.serializeNBT());
		nbt.put("white", this.white.serializeNBT());
		nbt.put("yellow", this.yellow.serializeNBT());
		return nbt;
		
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.black.deserializeNBT(nbt.getCompound("black"));
		this.blue.deserializeNBT(nbt.getCompound("blue"));
		this.cyan.deserializeNBT(nbt.getCompound("cyan"));
		this.gray.deserializeNBT(nbt.getCompound("gray"));
		this.green.deserializeNBT(nbt.getCompound("green"));
		this.lightBlue.deserializeNBT(nbt.getCompound("lightBlue"));
		this.lightGray.deserializeNBT(nbt.getCompound("lightGray"));
		this.lime.deserializeNBT(nbt.getCompound("lime"));
		this.orange.deserializeNBT(nbt.getCompound("orange"));
		this.pink.deserializeNBT(nbt.getCompound("pink"));
		this.purple.deserializeNBT(nbt.getCompound("purple"));
		this.red.deserializeNBT(nbt.getCompound("red"));
		this.white.deserializeNBT(nbt.getCompound("white"));
		this.yellow.deserializeNBT(nbt.getCompound("yellow"));
	}

}
