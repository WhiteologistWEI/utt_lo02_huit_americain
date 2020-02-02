package code;

import java.util.Iterator;
import java.util.Random;

public class Robot implements Player {
	
	private int number;
	private String name;
	private CardSet cardSet;
	private Intelligence robLevel;
	
	public Robot(String playerName, Intelligence level) {
		name = playerName;
		this.robLevel = level;
		cardSet = new CardSet();
		robLevel.setCardSet(cardSet);
	}
	
	@Override
	public void setNumber(int num) {
		number = num;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getNumber() {
		return number;
	}
	
	@Override
	public Card play(Card ref) {		
		printCard();
		return robLevel.playCard(ref);
	}

	@Override
	public void draw(Card card) {
		cardSet.addCard(card);
	}

	@Override
	public void printCard() {
		System.out.println("Robot cards:");
		cardSet.printAllCards();
		System.out.println("====End====");
	}
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("==========Player information===========\n");
    	sb.append("Player name: " + name + "\n" + "Player number: " + number + "\n");
    	sb.append(robLevel);
    	sb.append("Card Amount: " + cardSet.getCardAmount() + "\n");
    	return sb.toString();
    }

	@Override
	public void addCard(Card card, int place) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getCardAmount() {
		return cardSet.getCardAmount();
	}

	@Override
	public CardSet getAllCards() {
		return cardSet;
	}

}
