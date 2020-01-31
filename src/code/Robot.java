package code;

import java.util.Iterator;
import java.util.Random;

public class Robot implements Player {
	
	private int number;
	private String name;
	private CardSet cardSet;
	private Intelligence level;
	
	public Robot(String playerName, Intelligence level) {
		name = playerName;
		this.level = level;
		cardSet = new CardSet();
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
		return null;
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
    	sb.append(level);
    	sb.append("Card Amount: " + cardSet.getCardAmount() + "\n");
    	return sb.toString();
    }

}
