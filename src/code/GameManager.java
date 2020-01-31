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
		
	public void initializeGame() {
		/*创建玩家*/
		System.out.println("Entry your name:");
		String playerName = sc.nextLine();
		
		if (playerName.isEmpty())
			playerName = "Default palyer";
		
		Player hPlayer = pManager.createHumanPlayer(playerName);
		hPlayer.setNumber(0);
		pManager.addPlayers(hPlayer);
		
		/*创建机器人*/
		System.out.println("Entry robot amount(between 1 and 3):");
		int robAmount = sc.nextInt();//抛出异常 throws exception
		for (int i = 1; i < robAmount + 1; i++) {
			String robName = "Player" + i + "";
			System.out.println("Entry robot level: ");
			System.out.println("1.Simple \n2.Normal \n3.Difficult");
			int robLevel = sc.nextInt();//抛出异常 throws exception
			
			switch (robLevel) {//选择难度
			case 1:
				Player sRobot = pManager.createSimpleRobot(robName);
				sRobot.setNumber(i);
				pManager.addPlayers(sRobot);
				break;
				
			case 2:
				Player nRobot = pManager.createNormalRobot(robName);
				nRobot.setNumber(i);
				pManager.addPlayers(nRobot);				
				break;
				
			case 3:
				Player dRobot = pManager.createDifficultRobot(robName);
				dRobot.setNumber(i);
				pManager.addPlayers(dRobot);
				
			default:
				break;
			}			
		}
		
		pManager.printAllPlayers();
	}
	
	public void startGame() {
		
	}
	
	public static void main(String[] args) {
		GameManager gManager = new GameManager();
		gManager.initializeGame();
	

	}

}
