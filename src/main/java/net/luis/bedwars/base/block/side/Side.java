package net.luis.bedwars.base.block.side;

public enum Side {
	
	UP(0.5, 1.5, 0.5, true),
	DOWN(0.5, -1.0, 0.5, true),
	NORTH(0.5, 0.5, -0.5, true),
	EAST(1.5, 0.5, 0.5, true),
	SOUTH(0.5, 0.5, 1.5, true),
	WEST(-0.5, 0.5, 0.5, true),
	NULL(0.0, 0.0, 0.0, false);
	
	private final double x;
	private final double y;
	private final double z;
	private final boolean canSpawn;
	
	Side(double x, double y, double z, boolean canSpawn) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.canSpawn = canSpawn;
		
	}
	
	public double getX() {
		
		return this.x;
		
	}
	
	public double getY() {
		
		return this.y;
		
	}
	
	public double getZ() {
		
		return this.z;
		
	}

	public boolean canSpawn() {
		
		return canSpawn;
		
	}

}
