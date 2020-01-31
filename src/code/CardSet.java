package code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardSet {

	private List<Card> cardSet;	
	
	public CardSet() {
		cardSet = new ArrayList<>();
	} 
	
	public int getCardAmount() {
		return cardSet.size();
	}
	
	public void addCard(Card newCard) {
		cardSet.add(newCard);
	}
	
	public Card remove(Card removingCard) {
		cardSet.remove(removingCard);
		return removingCard;
	}
	
	public Card getCard(int cardIndex) {
		return cardSet.get(cardIndex - 1);
	}

	public Card deal() {
		return cardSet.get(0);
	}
	
	public void printAllCards() {
		Iterator<Card> itCard = cardSet.iterator();
		while (itCard.hasNext()) {
			Card card = itCard.next();
			System.out.println(card);			
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
