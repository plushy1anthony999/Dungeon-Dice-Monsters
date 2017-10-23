package Dungeon;

// A single square tile that'll be placed in the dungeon
public final class DungeonSpace {
	private boolean isOccupied;
	private final int[] coordinate; // It's position in the Dungeon's Grid
									// Must match the index its located at in the grid
	
	public DungeonSpace() {
		isOccupied = false;
		coordinate = null;
	}
	
	public int[] getCoordinate() {
		return coordinate;
	}
}
