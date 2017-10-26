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
	
	// "coordinatesForGridTile" refers to a tile in "grid" that the player will choose
	// for placing the DungeonPiece
	public void addDungeonPiece(DungeonPiece dungeonPiece, int[] coordinatesForGridTile) {
		DungeonSpace[][] piece = dungeonPiece.getDungeonPiece();
		int[] centerIndex = dungeonPiece.getCenterIndex();
		
		for(int i = 0; i < piece.length; i++) { // goes through each row in DungeonPiece
			for(int j = 0; j < piece[i].length; j++) { // goes through each col in DungeonPiece
				if(piece[i][j] != null) {
					int[] currentSpaceIndex = {i, j};
				}
			}
		}
	}
	
	public DungeonSpace[][] getGrid() {
		return grid;
	}
}
