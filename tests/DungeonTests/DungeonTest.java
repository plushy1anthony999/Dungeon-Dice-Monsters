package DungeonTests;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.javafx.scene.traversal.Direction;

import Dungeon.*;
import Dungeon.DungeonSpace.Color;

class DungeonTest {
	Dungeon dungeon;

	@BeforeEach
	void setUp() throws Exception {
		dungeon = new Dungeon();
	}

	@Test
	final void testDungeon() {
		for(int i = 0; i < Dungeon.MAX_ROWS; i++) {
			for(int j = 0; j < Dungeon.MAX_COLS; j++) {
				assertNull(dungeon.getGrid()[i][j]);
			}
		}
		
		assertEquals(dungeon.getNumberOfTiles(), 0);
	}
	
	@Test
	final void testAddDungeonPiece() {
		// TODO: Rework to handle positioning near heartPoints
		assertTrue(dungeon.addDungeonPiece(new DungeonPieceE(Color.RED), new int[] {1, 1}));
		// If adding a piece was successful, the # of spaces in the DungeonGrid should have increased by 6
		assertEquals(dungeon.getNumberOfTiles(), 6);
		
		assertFalse(dungeon.addDungeonPiece(new DungeonPieceE(Color.RED), new int[] {1, 1}));
		assertFalse(dungeon.addDungeonPiece(new DungeonPieceE(Color.RED), new int[] {1, 2}));

		// If addDungeonPiece fails, then the Dungeon should be the same as it was before
		// addDungeonPiece was called i.e. either all spaces in the piece were added, or none were
		assertEquals(dungeon.getNumberOfTiles(), 6);
		
		assertFalse(dungeon.addDungeonPiece(new DungeonPieceE(Color.RED), new int[] {1, 3}));
		assertTrue(dungeon.addDungeonPiece(new DungeonPieceE(Color.RED), new int[] {1, 4}));
		assertEquals(dungeon.getNumberOfTiles(), 12);

		// Check that spaces are in the correct spots on the grid
		DungeonSpace[][] spaces = dungeon.getGrid();
		assertNotNull(spaces[0][1]);
		assertNotNull(spaces[0][4]);
		assertNotNull(spaces[1][0]);
		assertNotNull(spaces[1][1]);
		assertNotNull(spaces[1][2]);
		assertNotNull(spaces[1][3]);
		assertNotNull(spaces[1][4]);
		assertNotNull(spaces[1][5]);
		assertNotNull(spaces[2][1]);
		assertNotNull(spaces[2][4]);
		assertNotNull(spaces[3][1]);
		assertNotNull(spaces[3][4]);
		assertFalse(dungeon.addDungeonPiece(new DungeonPieceA(Color.RED), new int[] {4, 1}));
		assertEquals(dungeon.getNumberOfTiles(), 12);
		
		// Makes sure that adding a piece only succeeds when the piece being added 
		// is adjacent to an existing DungeonSpace of the same color
		
		// TODO: Rework to handle positioning near heartPoints
		assertTrue(dungeon.addDungeonPiece(new DungeonPieceE(Color.BLUE), new int[] {4, 2})); // Is first BLUE in Dungeon so checking
		assertEquals(dungeon.getNumberOfTiles(), 18);										  // for adjacency doesn't apply
		
		
		assertTrue(dungeon.addDungeonPiece(new DungeonPieceE(Color.RED), new int[] {4, 2}));
		assertEquals(dungeon.getNumberOfTiles(), 24);
	}
	
	@Test
	final void testGetGridTile() {
		dungeon.addDungeonPiece(new DungeonPieceA(Color.RED), new int[] {1, 1});
		assertThrows(Error.class, () -> {dungeon.getGridTile(new int[] {1, -1}); } );
		assertThrows(Error.class, () -> {dungeon.getGridTile(new int[] {Dungeon.MAX_ROWS, Dungeon.MAX_COLS}); } );
		assertThrows(Error.class, () -> {dungeon.getGridTile(new int[] {1, 0}); } );
		assertThrows(Error.class, () -> {dungeon.getGridTile(new int[] {1, 2}); } );

	}
	@Test
	final void getMatchingAdjacentGridTile() {
		dungeon.addDungeonPiece(new DungeonPieceE(Color.RED), new int[] {1, 1});
		
		// Test that these don't throw
		assertNotNull(dungeon.getMatchingAdjacentGridTile(new int[] {1, 1}, Direction.UP)); 
		assertNotNull(dungeon.getMatchingAdjacentGridTile(new int[] {1, 1}, Direction.DOWN));
		assertThrows(Error.class, () -> {
			dungeon.getMatchingAdjacentGridTile(new int[] {0, 1}, Direction.UP); // Off-grid
		});
		assertThrows(Error.class, () -> {
			dungeon.getMatchingAdjacentGridTile(new int[] {1, 0}, Direction.UP); // Looks at empty space
		});
		
		dungeon.addDungeonPiece(new DungeonPieceE(Color.BLUE), new int[] {4, 2});

	}
	
	
	@AfterEach
	final void testDungeonHasValidNumOfTiles() {
		// The DungeonGrid should always have a number of tiles in it that's a multiple of 6
		// NOTE: this is no longer true if a monster ability can alter the number of tiles in the Dungeon
		// though this isn't applicable here as monsters abilities aren't used in this test class
		if(dungeon != null) {
			assertEquals(0, dungeon.getNumberOfTiles() % 6);
		}
	}
}
