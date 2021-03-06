package code;

import java.util.Random;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncFactoryException;

public class ChangeColor implements CardFunction {
	
	GameManager gManager;
	Scanner sc = new Scanner(System.in);
	
	public ChangeColor(GameManager gm) {
		gManager = gm;
	}

	@Override
	public void runFunction() {
		Player nowPlayer = gManager.getNowPlayer();
		
		if (nowPlayer instanceof Human) {
			System.out.println("# You can change the color of the reference card #");
			System.out.println("1.Pic\n2.Coeur\n3.Trefle\n4.Carreau");
			int newColor = sc.nextInt() - 1;//�׳��쳣 throw exception
			gManager.setColor(newColor);
		} else {
			Random random = new Random();
			int rValue = random.nextInt(4);
			gManager.setColor(rValue);
		}
		
		System.out.println("=======New reference: " + gManager.getReference() + "=========");

	}
	
	public static void main(String[] args) {
		
	}
}
