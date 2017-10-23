package Dungeon;

// A fixed-sized grid that's initially empty
// Is filled using DungeonSpace Objects to populate the grid
public final class Dungeon {
	public static final int MAX_ROWS = 20;
	public static final int MAX_COLS = 20;
	private DungeonSpace[][] grid;
	
	Dungeon() {
		//grid = new DungeonSpace
	}
	
	public void addDungeonPiece(DungeonPiece piece) {
		
	}
	
	// A single square tile that'll be placed in the dungeon
	private final class DungeonSpace {
		private boolean isOccupied;
		private int[] coordinate; // It's position in the Dungeon's Grid
										// Must match the index its located at in the grid
		
		public DungeonSpace() {
			isOccupied = false;
			coordinate = null;
		}
		
		public int[] getCoordinate() {
			return coordinate;
		}
		
		private void setCoordinate(int[] coordinate) {
			this.coordinate = coordinate;
		}
	}
	
	// A collection of DungeonSpaces that are arranged in a shape like an unfolded cube
	protected abstract class DungeonPiece {
		public static final int MAX_NUM_SPACES = 6;
		
		public DungeonPiece() {
			
		}
	}
}
