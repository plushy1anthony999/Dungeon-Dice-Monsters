package Dungeon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import Dungeon.DungeonSpace.Color;

// A collection of DungeonSpaces that are arranged in a shape like an unfolded cube
public abstract class DungeonPiece {
	protected DungeonSpace[][] dungeonPiece; // The piece is a non-rectangular 2D Array
	protected int monsterIndex; // The space that a monster will start on when summoning a monster
								// and placing a piece onto the Dungeon
								// Refers to an index in the dungeonPiece array 
	public static final int NUM_OF_SPACES = 6;
	private final Color COLOR; // Denotes that all DungeonSpaces in this piece are of this color
	
	public DungeonPiece(Color color) {
		COLOR = color;
	}
	
	public Color getColor() {
		return COLOR;
	}
	
	// The caller must handle checking if the indexes in the Piece are DungeonSpaces or NULL
	public DungeonSpace[][] getDungeonPiece() {
		return dungeonPiece;
	}
	
	// Returns an Array of all the DungeonSpaces inside the piece
	public DungeonSpace[] getArrayOfDungeonSpaces() {
		DungeonSpace[] result = new DungeonSpace[6];
		
		int index = 0;
		for(int i = 0; i < dungeonPiece.length; i++) { // ROWS
			for(int j = 0; j < dungeonPiece[i].length; j++) { // COLS
				if(getDungeonPiece()[i][j] != null) {
					result[index] = getDungeonPiece()[i][j];
					index++;
				}					
			}
		}
		
		return result;
	}
}
