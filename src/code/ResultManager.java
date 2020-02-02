package code;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ResultManager {
	private PlayerManager pManager;
	private List<Player> pList;
	
	public ResultManager(PlayerManager pm) {
		pManager = pm;
		pList = pManager.getAllPlayers();
	}
	
	public int getFinalPoint(Player p) {
		int point = 0;
		
		Iterator<Card> itCard = p.getAllCards().getCardList().iterator();
		
		while (itCard.hasNext()) {
			Card card = (Card) itCard.next();
			point += (card.getValeur() + 1);
		}
				
		return point;
	}
	
	public void printRank() {
		int rank = 1;
		Map<Integer, String> rankMap = new TreeMap<>();
		Set<Integer> playerPoint;
		
		Iterator<Player> itPlayer = pList.iterator();
		
		while (itPlayer.hasNext()) {
			Player player = (Player) itPlayer.next();
			rankMap.put(getFinalPoint(player), player.getName());
		}
		
		playerPoint = rankMap.keySet();
		
		Iterator<Integer> itPoint = playerPoint.iterator();
		
		while (itPoint.hasNext()) {
			Integer integer = (Integer) itPoint.next();
			System.out.println(rank + "|" + rankMap.get(integer) + "|" + integer);
			rank++;
		}
		
	}

	public static void main(String[] args) {
		Map<Integer, Integer> rank = new TreeMap<>();
		rank.put(5, 1);
		rank.put(3, 3);
		rank.put(4, 2);
		
		Set<Integer> keySet = rank.keySet();
		Iterator<Integer> it = keySet.iterator();
		while (it.hasNext()) {
			Integer val = (Integer) it.next();
			System.out.println("key: " + val + "value: " + rank.get(val));
		}
		
	}

}
