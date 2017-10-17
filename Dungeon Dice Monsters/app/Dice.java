import java.util.Random;

public abstract class Dice {
	protected Crest[] sides;
	protected final int summonLevel = 0; // Used to determine the level of monster to summon when rolling 2 or 3 summon crests
	
	Dice() {
		sides = new Crest[6];		
	}
	
	public static Dice getRandomDiceTypeObject() {
		String types = "ABCDE";
		int numOfTypes = types.length();
		
		Random rand = new Random();
		char type = types.charAt(rand.nextInt(numOfTypes));
		
		Dice result = null;
		
		switch(type) {
		case 'A':
			result =  new DiceTypeA();
//		case 'B':
//			return new DiceTypeB();
//		case 'C':
//			return new DiceTypeC();
//		case 'D':
//			return new DiceTypeD();
//		default:
//			throw new Exception("Attempted to create a nonexistant dice type");
		}
		
		return result;
	}
}
