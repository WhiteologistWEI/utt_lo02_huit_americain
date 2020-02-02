package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {

	private boolean gameEnd = false;
	private int nowPlayerIndex = 0;
	private int turn = 1;
	private int playerAmount;
	private Card reference;
	private Player winner;
	private PlayerManager playerList;
	private CardSet packCard;
	private Variation gameVar;
	private Scanner sc;
	
	public GameManager(PlayerManager pm, CardSet cs) {
		playerList = pm;
		playerAmount = playerList.getPlayerAmount();
		packCard = cs;
		sc = new Scanner(System.in);
	}
	
	public void setColor(int newColor) {
		reference.setCouleur(newColor);
	}
	
	public void toNext() {
		nowPlayerIndex = (nowPlayerIndex + turn) % playerAmount;
	}
	
	public Player getNowPlayer() {
		return playerList.getPlayer(nowPlayerIndex);
	}
	
	public Card getReference() {
		return reference;
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public boolean checkCard(Card playedCard, int playerNum) {
		if (playedCard == null) {//抽牌
			Player nowPlayer = playerList.getPlayer(playerNum);
			Card newCard = packCard.deal();//公共牌第一张牌
			nowPlayer.draw(newCard);//拿一张新牌
			System.out.println("-----Player " + nowPlayer.getName() + " draw a new card.-----");
			packCard.remove(newCard);//公共牌中移除被拿取的牌
			return true;
		} else {//出牌
			if (reference == null) {
				return true;
			} else {					
				boolean condition1 = (playedCard.getCouleur() == reference.getCouleur());
				boolean condition2 = (playedCard.getValeur() == reference.getValeur());
				boolean condition3 = (playedCard.getValeur() == 7);

				if (condition1 || condition2 || condition3) {
					return true;
				} else {
					return false;
				}
			}
		}		
	}
	
	public void runGame(Variation var) {
		gameVar = var;
		//Player winner = new Human("exemple");
		
		do {
			Player nowPlayer = playerList.getPlayer(nowPlayerIndex);
			String name = nowPlayer.getName();
			int num = nowPlayer.getNumber();
			System.out.println("========= Player <" + name + ">'s turn=========");
			
			if (reference == null) {
				System.out.println("Please play any card.");
			} else {
				System.out.println("Last played card is:" + reference);
			}
			
			Card playedCard = nowPlayer.play(reference);
			Boolean result = this.checkCard(playedCard, num);
			
			if (result) {
				packCard.addCard(playedCard);
				int restCardAmount = nowPlayer.getCardAmount();
				
				if (restCardAmount == 0) {
					winner = nowPlayer;
					break;
				}
				
				if (playedCard != null) {
					int color = playedCard.getCouleur();
					int value = playedCard.getValeur();
					
					if (reference == null) {
						reference = new Card(color, value);
					} else {
						reference.setCouleur(color);
						reference.setValeur(value);
					}
				}
				
				if (playedCard != null)
					gameVar.runFunction(playedCard);
				
				toNext();		
			} else {
				nowPlayer.addCard(playedCard, 0);
			}
			
		} while (gameEnd == false);
				
		//System.out.println("Winner is: \n" + winner);
	}
		
	public static void main(String[] args) {
		
	}

}
