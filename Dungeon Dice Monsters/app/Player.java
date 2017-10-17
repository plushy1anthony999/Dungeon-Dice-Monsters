import java.util.ArrayList;
import java.util.HashMap;

public final class Player {
	HashMap<Crest, Integer> crestPool; // Used for tracking the number of Crests a player has
									   // The more Crests a player has, the more actions they can perform
	
	ArrayList<Monster> summonedMonsters;

	
	Player() {}
	
	public static void rollDice() { // Each turn, the player rolls 3 dice of random types
		
	}
}
