package Dungeon;

// A fixed-sized grid that's initially empty
// Is filled using DungeonSpace Objects to populate the grid
public final class Dungeon {
	public static final int MAX_ROWS = 20;
	public static final int MAX_COLS = 20;
	private DungeonSpace[][] grid;
	
	public Dungeon() {		
		grid = new DungeonSpace[MAX_ROWS][MAX_COLS];
	}
	
//	public void addDungeonPiece(DungeonPiece piece, int[] coordinates) {
//		for(int i = 0; i < piece.getDungeonPiece())
//	}
	
	public DungeonSpace[][] getGrid() {
		return grid;
	}
}
