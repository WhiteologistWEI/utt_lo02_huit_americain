package code;

import java.util.Scanner;

public class Controller {

	private int playerAmount;
	private GameManager gManager;
	private PlayerManager pManager;
	private CardSet cSet;
	private Scanner sc;
	
	public Controller() {
		sc = new Scanner(System.in);
	}
	
	public void addPlayers() {
		pManager = new PlayerManager();
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
			System.out.println("Entry robot " + "<" + robName + ">" + " level: ");
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
		
		playerAmount = pManager.getPlayerAmount();
		/* debug
		pManager.printAllPlayers(); */
	}
	
	public void prepareCards() {
		cSet = new CardSet();
		/* create 52 cards */
		cSet.createPack();
		cSet.shuffle();
		
		/* deal */
		for (int cardAmount = 0; cardAmount < 8; cardAmount++) {
			for (int playerIndex = 0; playerIndex < playerAmount; playerIndex++) {
				Player player = pManager.getPlayer(playerIndex);
				Card card = cSet.deal();
				player.draw(card);
			}		
		}
		/* debug: held cards
		for (int i = 0; i < playerAmount; i++) {;
			Player player = pManager.getPlayer(i);
			System.out.println("======= " + player.getName() + " =======");
			player.printCard();
		}*/
		
		/* debug: rest card amount
		int amount = cSet.getCardAmount();
		System.out.println("rest cards: " + amount);*/
	}
	
	public void startGame() {
		gManager = new GameManager(pManager, cSet);
		System.out.println("===========Game start============");
		gManager.runGame();
	}
	
	public static void main(String[] args) {
		Controller game = new Controller();
		game.addPlayers();
		game.prepareCards();
		game.startGame();

	}

}
