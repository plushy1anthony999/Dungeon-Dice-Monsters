package Dungeon;

import java.util.ArrayList;

import com.sun.javafx.scene.traversal.Direction;

import Dungeon.DungeonSpace.Color;

// A fixed-sized grid that's initially empty
// Is filled using DungeonSpace Objects to populate the grid
public final class Dungeon {
	public static final int MAX_ROWS = 21; // Both must be Odd Values
	public static final int MAX_COLS = 21;
	public static final int[] playerBlueHeartPointsCoordinates = new int[2];; // Near Bottom of Grid
	public static final int[] playerRedHeartPointsCoordinates = new int[2];;  // Near Top of Grid
	
	private DungeonSpace[][] grid;
	private boolean playerBlueHasAddedFirstPiece = false;
	private boolean playerRedHasAddedFirstPiece = false;
	
	public Dungeon() {		
		grid = new DungeonSpace[MAX_ROWS][MAX_COLS];
		//playerBlueHeartPointsCoordinates;
		playerRedHeartPointsCoordinates = new int[2];  
	}
	
	// "coordinatesForGridTile" refers to a tile in "grid" that the player will choose for placing the DungeonPiece
	public boolean addDungeonPiece(DungeonPiece dungeonPiece, int[] coordinatesForGridTile) {
		Color playerColor = dungeonPiece.getColor();
		
		if(playerColor == Color.RED && !playerRedHasAddedFirstPiece) {
			playerRedHasAddedFirstPiece = true;
			return addFirstDungeonPiece(dungeonPiece, coordinatesForGridTile);
		}
		if(playerColor == Color.BLUE && !playerBlueHasAddedFirstPiece) {
			playerBlueHasAddedFirstPiece = true;
			return addFirstDungeonPiece(dungeonPiece, coordinatesForGridTile);			
		}
		
		DungeonSpace[][] piece = dungeonPiece.getDungeonPiece();
		int[] centerCoordinate = dungeonPiece.getCenterCoordinates();
		
		ArrayList<int[]> coordinatesForAddingSpaces = new ArrayList<int[]>();
		
		boolean isAdjacentToTileWithSameColor = false;
		
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
	private boolean addFirstDungeonPiece(DungeonPiece dungeonPiece, int[] coordinatesForGridTile) {
		DungeonSpace[][] piece = dungeonPiece.getDungeonPiece();
		int[] centerCoordinate = dungeonPiece.getCenterCoordinates();
		Color playerColor = dungeonPiece.getColor();
		
		ArrayList<int[]> coordinatesForAddingSpaces = new ArrayList<int[]>();
		
		boolean isAdjacentToTileWithSameColor = false;
		
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
//	public boolean addMonster(Monster monster, int[] coordinates) { // TODO: finish this method
//		int spaceX = coordinates[0];
//		int spaceY = coordinates[1];
//		
//		
//		if(grid[spaceX][spaceY] != null && !grid[spaceX][spaceY].isOccupied) {
//			
//		}
//		else
//			return false; // The grid tile is either already occupied or the tile doesn't exist
//	}
	
	public DungeonSpace[][] getGrid() { return grid; }
	public boolean getPlayerHasAddedFirstPiece(Color playerColor) {
		if(playerColor == Color.RED) return playerRedHasAddedFirstPiece;
		if(playerColor == Color.BLUE) return playerBlueHasAddedFirstPiece;
		throw new Error("Stub");
	}
	public DungeonSpace getGridTile(int[] coordinates) {
		int spaceX = coordinates[0];
		int spaceY = coordinates[1];
		
		if(spaceX >= 0 && spaceX < MAX_ROWS &&
		   spaceY >= 0 && spaceY < MAX_COLS &&
		   grid[spaceX][spaceY] != null
		)
			return grid[spaceX][spaceY];
		else 
			throw new Error("The coordinates passed are out-of-bounds");
	}
	
	// Used for retrieving a tile of a matching Color that's adjacent to the specified tile in the Grid 
	public DungeonSpace getMatchingAdjacentGridTile(int[] coordinatesOfTile, Direction direction) throws Error {
		int spaceX = coordinatesOfTile[0];
		int spaceY = coordinatesOfTile[1];
		
		// The coordinates passed in must be for a tile that already exists in the Grid
		if(spaceX >= 0 && spaceX < MAX_ROWS &&
		   spaceY >= 0 && spaceY < MAX_COLS &&
		   grid[spaceX][spaceY] != null
		) {
			int adjacentTileX;
			int adjacentTileY;
			
			switch(direction) {
			case UP:
				adjacentTileX = spaceX - 1;
				adjacentTileY = spaceY;
				break;
			case DOWN:
				adjacentTileX = spaceX + 1;
				adjacentTileY = spaceY;
				break;
			case RIGHT:
				adjacentTileX =spaceX;
				adjacentTileY = spaceY + 1;
				break;
			case LEFT:
				adjacentTileX =spaceX;
				adjacentTileY = spaceY - 1;
				break;
			default:
				throw new Error("Stub");
			}
			if(
				adjacentTileX >= 0 && adjacentTileX < MAX_ROWS &&
				grid[adjacentTileX][adjacentTileY] != null &&
				grid[adjacentTileX][adjacentTileY].getColor() == grid[spaceX][spaceY].getColor()
			)
				return grid[spaceX - 1][spaceY];
			else
				throw new Error("The tile above either doesn't exist or doesn't have a matching color");			
		}
		else 
			throw new Error("The coordinates passed are either out-of-bounds or refer to an empty spot in the DungeonGrid");
	}
	
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
