package net.luis.bedwars.common.base.block;

import net.minecraft.item.Item;

public interface ISpawnerBlock {
	
	Item getSpawnItem();
	
	int getSpawnTime();

}
