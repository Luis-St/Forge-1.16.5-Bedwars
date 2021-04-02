package net.luis.bedwars.base.block;

import net.minecraft.item.Item;

public interface ISpawnerBlock {
	
	Item getSpawnItem();
	
	int getSpawnTime();

}
