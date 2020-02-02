package code;

import java.util.Scanner;

public class Human implements Player {
	
	private int number;
	private String name;
	private CardSet cardSet;
	Scanner cardScanner;
	
	public Human(String playerName) {	
		cardScanner = new Scanner(System.in);
		cardSet = new CardSet();
		name = playerName;
	}

	@Override
	public void setNumber(int num) {
		number = num;
	}

	@Override
	public int getNumber() {
		return number;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Card play(Card ref) {//出牌
		
		/*
		if (ref != null) {
			System.out.println("Last played card is:" + ref);
		} else {
			System.out.println("Play any card.");
		}
		*/

		this.printCard();
		System.out.println("Choose a card");
		int choice = cardScanner.nextInt() - 1;//可加抛出异常完善
		
		if (choice >= cardSet.getCardAmount()) {
			return null;
		} else {
			Card chosenCard = cardSet.getCard(choice);
			cardSet.remove(chosenCard);
			return chosenCard;			
		}
	}

	@Override
	public void draw(Card card) {//抽牌
		cardSet.getCardList().add(card);
	}

	@Override
	public void printCard() {
		System.out.println("Your cards:");
		cardSet.printAllCards();
		System.out.println("====End====");
	}

	@Override
	public void addCard(Card card, int place) {
		cardSet.getCardList().add(place, card);
	}

	@Override
	public int getCardAmount() {
		return cardSet.getCardAmount();
	}
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append("==========Player information===========\n");
    	sb.append("Player name: " + name + "\n" + "Player number: " + number + "\n");
    	sb.append("Card Amount: " + cardSet.getCardAmount() + "\n");
    	return sb.toString();
    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	@Override
	public CardSet getAllCards() {
		return cardSet;
	}

}
