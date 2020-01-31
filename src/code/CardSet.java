package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.portable.ValueBase;

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
		Card dealtCard = cardSet.get(0);
		cardSet.remove(dealtCard);
		return dealtCard;
	}
	
	public CardSet createPack() {
		for (int color = 0; color < 4; color++) {
			
			for (int value = 0; value < 13; value++) {
				this.addCard(new Card(color, value));								
			}
			
		}
		
		return this;
	}
	
	public void shuffle() {
		Collections.shuffle(cardSet);
	}
	
	public void printAllCards() {
		Iterator<Card> itCard = cardSet.iterator();
		int i = 1;
		while (itCard.hasNext()) {
			Card card = (Card) itCard.next();
			System.out.println(i + ". " + card);
			i++;
		}	
	}
	
	public static void main(String[] args) {
		CardSet generator = new CardSet();
	}

}
