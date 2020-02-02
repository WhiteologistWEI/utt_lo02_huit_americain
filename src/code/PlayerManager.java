package code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerManager {
	
	private List<Player> playerList;
	
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
	
	public List<Player> getAllPlayers() {
		return playerList;
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
		// TODO 自动生成的方法存根

	}

}
