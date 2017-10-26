package Dungeon;

import java.util.ArrayList;

import Dungeon.DungeonSpace.Color;

// A fixed-sized grid that's initially empty
// Is filled using DungeonSpace Objects to populate the grid
public final class Dungeon {
	public static final int MAX_ROWS = 20;
	public static final int MAX_COLS = 20;
	private DungeonSpace[][] grid;
	
	public Dungeon() {		
		grid = new DungeonSpace[MAX_ROWS][MAX_COLS];
	}
	
	// "coordinatesForGridTile" refers to a tile in "grid" that the player will choose for placing the DungeonPiece
	public boolean addDungeonPiece(DungeonPiece dungeonPiece, int[] coordinatesForGridTile) {
		DungeonSpace[][] piece = dungeonPiece.getDungeonPiece();
		Color playerColor = dungeonPiece.getColor();
		int[] centerCoordinate = dungeonPiece.getCenterCoordinates();
		
		ArrayList<int[]> coordinatesForAddingSpaces = new ArrayList<int[]>();
		
		for(int i = 0; i < piece.length; i++) { // goes through each row in DungeonPiece
			for(int j = 0; j < piece[i].length; j++) { // goes through each col in DungeonPiece
				if(piece[i][j] != null) {
					int[] currentSpaceIndex = {i, j}; // This index is the Space's position relative to 
													  // the piece's centerIndex
					
					// Calculate the DungeonSpace's position in the Grid where it'll be placed
					int[] offset = { // centerIndex - currentSpaceIndex
							centerCoordinate[0] - currentSpaceIndex[0],
							centerCoordinate[1] - currentSpaceIndex[1]
					};
					
					// coordinatesForGridTile - offset
					int spaceToAddX = coordinatesForGridTile[0] - offset[0];
					int spaceToAddY = coordinatesForGridTile[1] - offset[1];
					
					// Make sure the space in the grid is not already filled with a tile
					if(grid[spaceToAddX][spaceToAddY] == null) {
						coordinatesForAddingSpaces.add(new int[] {spaceToAddX, spaceToAddY});
					}
					else 
						return false; // The dungeon piece to be added overlapped with an existing tile
				}
			}
		}
		
		for(int[] spaceCoordinates : coordinatesForAddingSpaces) {
			int spaceToAddX = spaceCoordinates[0];
			int spaceToAddY = spaceCoordinates[1];
			grid[spaceToAddX][spaceToAddY] = new DungeonSpace(playerColor);
		}
		return true;
	}
	public boolean addMonster(Monster monster, int[] coordinates) {
		int spaceX = coordinates[0];
		int spaceY = coordinates[1];
		
		
		if(grid[spaceX][spaceY] != null && !grid[spaceX][spaceY].isOccupied) {
			
		}
		else
			return false; // The grid tile is either already occupied or the tile doesn't exist
	}
	
	public DungeonSpace[][] getGrid() { return grid; }
	public int getNumberOfTiles() { // Returns # of filled in tiles in the Grid
		int numOfTiles = 0;
		for(int i = 0; i < Dungeon.MAX_ROWS; i++) {
			for(int j = 0; j < Dungeon.MAX_COLS; j++) {
				if(getGrid()[i][j] != null) 
					numOfTiles++;
			}
		}
		return numOfTiles;
	}
}
