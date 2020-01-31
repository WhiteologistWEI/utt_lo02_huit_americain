package code;

import java.util.concurrent.locks.Condition;

public class Simple implements Intelligence {
	
	private CardSet cardSet;

	@Override
	public Card playCard(Card ref) {
		int cardAmount = cardSet.getCardAmount();
		
		if (ref == null) {
			Card playedCard = cardSet.getCard(0);
			cardSet.remove(playedCard);
			return playedCard;
		} else {
			for (int i = 0; i < cardAmount; i++) {
				Card itCard = cardSet.getCard(i);
				boolean condition1 = (itCard.getCouleur() == ref.getCouleur() || itCard.getValeur() == ref.getValeur());
				boolean condition2 = (itCard.getValeur() == 7);

				if (condition1 || condition2) {
					cardSet.remove(itCard);
					return itCard;
				}
			}
			
			System.out.println("Robot has no propre card");
			return null;
		}
				
	}

	@Override
	public void setCardSet(CardSet cSet) {
		cardSet = cSet;
	}
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("Robot level: Simple\n");
    	return sb.toString();
    }

}
