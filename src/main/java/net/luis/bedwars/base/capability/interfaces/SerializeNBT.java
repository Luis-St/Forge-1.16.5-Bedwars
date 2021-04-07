package net.luis.bedwars.base.capability.interfaces;

import net.minecraft.nbt.CompoundNBT;

public interface SerializeNBT {
	
	CompoundNBT serializeNBT();
	
	void deserializeNBT(CompoundNBT nbt);

}
