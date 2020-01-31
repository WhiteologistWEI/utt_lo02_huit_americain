package code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerManager {
	
	private List<Player> playerList;
	private CardSet packCard;
	private int nowPlayerIndex;
	private Card reference;
	
	public PlayerManager() {
		playerList = new ArrayList<Player>();
	}
	
	public Player createHumanPlayer(String playerName) {
		return new Human(playerName);
	}
	
	public Player createSimpleRobot(String playerName) {
		return new Robot(playerName, new Simple());
	}
	
	public Player createNormalRobot(String playerName) {
		return new Robot(playerName, new Normal());
	}
	
	public Player createDifficultRobot(String playerName) {
		return new Robot(playerName, new Difficult());
	}
	
	public void addPlayers(Player newPlayer) {
		playerList.add(newPlayer);
	}
	
	public Player getPlayer(int playerNum) {
		return playerList.get(playerNum);
	}
	
	public int getPlayerAmount() {
		return playerList.size();
	}
	public boolean checkCard(Card playedCard) {
		if (playedCard == null) {//û�ƿɳ�
			Player nowPlayer = playerList.get(nowPlayerIndex);
			Card newCard = packCard.deal();//�����Ƶ�һ����
			nowPlayer.draw(newCard);//��һ������
			packCard.remove(newCard);//���������Ƴ�����ȡ����
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
	
	/*debug*/
	public void printAllPlayers() {
		Iterator<Player> itPlayer = playerList.iterator();
		while (itPlayer.hasNext()) {
			Player player = (Player) itPlayer.next();
			System.out.println(player);
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
