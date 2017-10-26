package DungeonTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Dungeon.*;

class DungeonTest {
	Dungeon dungeon;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testDungeon() {
		dungeon = new Dungeon();
		for(int i = 0; i < Dungeon.MAX_ROWS; i++) {
			for(int j = 0; j < Dungeon.MAX_COLS; j++) {
				assertNull(dungeon.getGrid()[i][j]);
			}
		}
	}
	
}
