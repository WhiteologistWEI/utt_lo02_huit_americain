package code;

import java.util.Hashtable;
import java.util.Map;

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
		
	}

}
