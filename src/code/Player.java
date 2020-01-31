package code;

public interface Player {
	
	abstract void setNumber(int num);
	abstract int getNumber();
	abstract String getName();
	abstract Card play(Card reference);
	abstract void draw(Card card);
	abstract void addCard(Card card, int place);
	abstract int getCardAmount();
	abstract void printCard();
}
