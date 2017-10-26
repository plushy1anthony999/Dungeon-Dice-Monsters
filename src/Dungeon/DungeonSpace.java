package Dungeon;

// A single square tile that'll be placed in the dungeon
public final class DungeonSpace {
	public boolean isOccupied;
	private int[] coordinate;   // It's position in the Dungeon's Grid
							    // Must match the index its located at in the grid
	
	private final Color COLOR;	// Used to denote which player this this space belongs to 
								// BLUE is player1 (Human), RED is player2 (AI)
	public DungeonSpace(Color color) {
		isOccupied = false;
		coordinate = null;
		this.COLOR = color;
	}
	public DungeonSpace(Color color, int[] coordinate) {
		isOccupied = false;
		//setCoordinate(coordinate); // TODO: Maybe remove?
		
		this.COLOR = color;
	}
	
	// TODO: Maybe remove?
//	public int[] getCoordinate() {
//		return coordinate;
//	}
	public Color getColor() {
		return COLOR;
	}	
	
	// TODO: Maybe remove?
//	public void setCoordinate(int[] coordinate) {
//		 // Make sure coordinate is actually inside the Dungeon Grid
//		if(coordinate[0] > 0 && coordinate[0] < Dungeon.MAX_ROWS &&
//		   coordinate[1] > 0 && coordinate[1] < Dungeon.MAX_COLS
//		)
//			this.coordinate = coordinate;
//		else
//			throw new Error("Coordinates passed in are out-of-bounds");
//	}
//	public boolean getIsOccupied() {
//		return isOccupied;
//	}
//	public void setIsOccupied(boolean isOccupied) {
//		this.isOccupied = isOccupied;
//	}

	public enum Color { BLUE, RED }
}
