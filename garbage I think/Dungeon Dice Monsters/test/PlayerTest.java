import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		if(player == null) throw new Exception("Failed to construct Player");
	}

	@Test
	public void testPlayer() {
		assertEquals(0, player.getNumberOfCrests(Crest.ATTACK));
		assertEquals(0, player.getNumberOfCrests(Crest.DEFENSE));
		assertEquals(0, player.getNumberOfCrests(Crest.MOVE));
		assertEquals(0, player.getNumberOfCrests(Crest.MAGIC));

	}

	@Test
	public void testRollDice() {
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddCrests() {
		player.addCrests(Crest.ATTACK, 1);
		assertEquals(1, player.getNumberOfCrests(Crest.ATTACK));
	}

	@Test
	public void testRemoveCrests() {
		//fail("Not yet implemented"); // TODO
	}

}
