package code;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Function;

public class BasicVariation implements Variation {
	
	private Map<Integer, CardFunction> functMap;
	private GameManager gm;
	
	public BasicVariation(GameManager gManager) {
		gm = gManager;
		functMap = new Hashtable<>();
		functMap.put(7, new ChangeColor(gm));
	}

	@Override
	public void runFunction(Card card) {
		int cardNum = card.getValeur();
		
		if (functMap.containsKey(cardNum)) {
			CardFunction cardFunct = functMap.get(cardNum);			
			cardFunct.runFunction();
		}

	}

}
