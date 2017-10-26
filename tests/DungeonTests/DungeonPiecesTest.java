package DungeonTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Dungeon.*;
import Dungeon.DungeonSpace.Color;

class DungeonPiecesTest {
	DungeonPiece dungeonPiece;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testDungeonPiece() {
		assertEquals(DungeonPiece.NUM_OF_SPACES, 6);
		
		dungeonPiece = new DungeonPieceA(Color.RED);
		assertEquals(dungeonPiece.getColor(), Color.RED);
	}
	
	@Test
	final void testEveryDungeonPieceType() {
		DungeonPiece[] dungeonPieces = {
				new DungeonPieceA(Color.RED),
				new DungeonPieceB(Color.RED),
				new DungeonPieceC(Color.RED),
				new DungeonPieceD(Color.RED),
				new DungeonPieceE(Color.RED),
				new DungeonPieceF(Color.RED),
				new DungeonPieceG(Color.RED),
				new DungeonPieceH(Color.RED),
				new DungeonPieceI(Color.RED),
				new DungeonPieceJ(Color.RED),
				new DungeonPieceK(Color.RED)
		};
		
		for(DungeonPiece dungeonPiece : dungeonPieces) {
			int numOfSpaces = 0;
			for(int i = 0; i < dungeonPiece.getDungeonPiece().length; i++) { // ROWS
				for(int j = 0; j < dungeonPiece.getDungeonPiece()[i].length; j++) { // COLS
					if(dungeonPiece.getDungeonPiece()[i][j] != null) {
						numOfSpaces++;
						assertEquals(dungeonPiece.getDungeonPiece()[i][j].getColor(), Color.RED);
					}					
				}
			}
			assertEquals(numOfSpaces, 6);
			assertEquals(dungeonPiece.getColor(), Color.RED);
		}
	}
	
	// TODO: Maybe get rid of this method?
	@Test
	final void testGetArrayOfDungeonSpaces() {
		dungeonPiece = new DungeonPieceA(Color.RED);
		
		for(DungeonSpace space : dungeonPiece.getArrayOfDungeonSpaces()) {
			assertEquals(space.getColor(), Color.RED);
		}
	}
}
