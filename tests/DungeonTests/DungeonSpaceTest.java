package DungeonTests;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Executable;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertThrows;
import Dungeon.*;
import Dungeon.DungeonSpace.Color;


public class DungeonSpaceTest {
	DungeonSpace dungeonSpace;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test // public DungeonSpace(Color color)
	final void testDungeonSpace() { 
		dungeonSpace = new DungeonSpace(Color.RED);
		assertEquals(dungeonSpace.getColor(), Color.RED);
		dungeonSpace = new DungeonSpace(Color.BLUE);
		assertEquals(dungeonSpace.getColor(), Color.BLUE);
		
		assertEquals(dungeonSpace.isOccupied, false);
	}
	
	@Test //public DungeonSpace(Color color, int[] coordinate)
	final void testDungeonSpaceWithCoordinate() { 
		dungeonSpace = new DungeonSpace(Color.RED, new int[] {2, 3});

		assertEquals(dungeonSpace.isOccupied, false);
		
		dungeonSpace = new DungeonSpace(Color.RED, new int[] {1, 1});

		assertEquals(dungeonSpace.isOccupied, false);
	}
}
