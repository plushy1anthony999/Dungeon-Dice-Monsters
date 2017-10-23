import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	Player player;
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player();
	}

	@Test
	final void testPlayer() {
		assertEquals(player.getNumberOfCrests(Crest.ATTACK), 0);
		assertEquals(player.getNumberOfCrests(Crest.DEFENSE), 0);
		assertEquals(player.getNumberOfCrests(Crest.MOVE), 0);
		assertEquals(player.getNumberOfCrests(Crest.MAGIC), 0);
		assertEquals(player.getNumberOfCrests(Crest.SUMMON), 0);
		assertEquals(player.getNumberOfSummonedMonster(), 0);
	}

	@Test
	final void testRollDice() {
		int[] initialNumOfCrests = new int[5];
		initialNumOfCrests[0] = player.getNumberOfCrests(Crest.ATTACK);
		initialNumOfCrests[1] = player.getNumberOfCrests(Crest.DEFENSE);
		initialNumOfCrests[2] = player.getNumberOfCrests(Crest.MOVE);
		initialNumOfCrests[3] = player.getNumberOfCrests(Crest.MAGIC);
		initialNumOfCrests[4] = player.getNumberOfCrests(Crest.SUMMON);
		
		player.rollDice();
		
		int[] newNumOfCrests = new int[5];
		newNumOfCrests[0] = player.getNumberOfCrests(Crest.ATTACK);
		newNumOfCrests[1] = player.getNumberOfCrests(Crest.DEFENSE);
		newNumOfCrests[2] = player.getNumberOfCrests(Crest.MOVE);
		newNumOfCrests[3] = player.getNumberOfCrests(Crest.MAGIC);
		newNumOfCrests[4] = player.getNumberOfCrests(Crest.SUMMON);
		
		int increasedNumOfCrests = 0;
		for(int i = 0; i < 5; i++) {
			increasedNumOfCrests += (newNumOfCrests[i] - initialNumOfCrests[i]);
		}
		assertEquals(increasedNumOfCrests, 3);
	}
}
