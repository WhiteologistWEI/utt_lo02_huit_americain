package code;

import java.util.Scanner;
import java.util.logging.Logger;

public class GameManager {
	
	private PlayerManager pManager;
	private CardSet cardSet;
	private Scanner sc;
	
	public GameManager() {
		pManager = new PlayerManager();
		cardSet = new CardSet();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		GameManager gManager = new GameManager();

	

	}

}
