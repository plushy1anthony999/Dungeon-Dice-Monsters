import java.util.ArrayList;
import java.util.HashMap;

public final class Player {
	private HashMap<Crest, Integer> crestPool; // Used for tracking the number of Crests a player has
									   		   // The more Crests a player has, the more actions they can perform
	
	private ArrayList<Monster> summonedMonsters;
	
	Player() {
		crestPool.put(Crest.ATTACK, 0);
		crestPool.put(Crest.DEFENSE, 0);
		crestPool.put(Crest.MOVE, 0);
		crestPool.put(Crest.MAGIC, 0);
		crestPool.put(Crest.SUMMON, 0);
	}
	
	public void rollDice() { // Each turn, the player rolls 3 dice of random types
		
	}
	
	public void addCrests(Crest crest, int numOfCrestsToAdd) {
		int currentNumOfCrests = crestPool.get(crest);
		
		crestPool.put(crest, currentNumOfCrests + numOfCrestsToAdd);
	}
	public boolean removeCrests(Crest crest, int numOfCrestsToRemove) {
		int currentNumOfCrests = crestPool.get(crest);

		if(currentNumOfCrests > 0 && currentNumOfCrests >= numOfCrestsToRemove) {
			crestPool.put(crest, currentNumOfCrests - numOfCrestsToRemove);
			return true;
		} else {
			System.out.println("Failed to remove crest from crestPool");
			return false;
		}			
	}
	
	public int getNumberOfCrests(Crest crest) {
		return crestPool.get(crest);
	}
}
