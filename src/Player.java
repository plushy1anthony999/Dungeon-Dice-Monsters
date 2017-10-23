import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public final class Player {
	private CrestPool crestPool; // Used for tracking the number of Crests a player has
								 // The more Crests a player has, the more actions they can perform
	
	private ArrayList<Monster> summonedMonsters;
	
	Player() {
		crestPool = new CrestPool();
		summonedMonsters = new ArrayList<Monster>();
	}
	
	// Each turn, the player rolls 3 dice, adding 3 random Crests to the CrestPool
	public void rollDice() { 
		Random random = new Random();
		final int NUMBER_OF_CREST_TYPES = 5;
		
		Crest[] crestsToAdd = new Crest[3];
		for(int i = 0; i < 3; i++) {
			int crestTypeNumber = random.nextInt(NUMBER_OF_CREST_TYPES);
			
			switch(crestTypeNumber) {
			case 0:
				crestsToAdd[i] = Crest.ATTACK;
				break;
			case 1:
				crestsToAdd[i] = Crest.DEFENSE;
				break;
			case 2:
				crestsToAdd[i] = Crest.MAGIC;
				break;
			case 3:
				crestsToAdd[i] = Crest.MOVE;
				break;
			case 4:
				crestsToAdd[i] = Crest.SUMMON;
				break;				
			}			
		}
		
		for(Crest crest : crestsToAdd) {
			crestPool.addCrests(crest, 1);
		}
	}
	
	
	public int getNumberOfCrests(Crest crest) {
		return crestPool.getNumberOfCrests(crest);
	}
	public int getNumberOfSummonedMonster() {
		return summonedMonsters.size();
	}
	
	private final class CrestPool {
		private HashMap<Crest, Integer> crestPool;
		
		public CrestPool() {
			crestPool = new HashMap<Crest, Integer>();
			crestPool.put(Crest.ATTACK, 0);
			crestPool.put(Crest.DEFENSE, 0);
			crestPool.put(Crest.MOVE, 0);
			crestPool.put(Crest.MAGIC, 0);
			crestPool.put(Crest.SUMMON, 0);
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
	
	static enum Action {
		SUMMON_MONSTER,
		ATTACK,
		DEFEND,
		MOVE_MONSTER,
		USE_ABILITY // For monster abilities that aren't passive
	}
}
