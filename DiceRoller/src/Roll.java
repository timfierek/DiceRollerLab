import java.util.Random;
import java.util.Scanner;

public class Roll {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		boolean loop = true;
		int roll1 = -1;
		int roll2 = -1;
		int numSides = -1;
		int rollCount = 1;
		
		System.out.println("Welcome to the Grand Circus Casino!\n");
		
		while(loop) {
			numSides = collectInput(in);
			roll1 = generateRandomDieRoll(numSides, rand);
			roll2 = generateRandomDieRoll(numSides, rand);
			
			System.out.println("\nRoll " + rollCount + ": ");
			System.out.println(roll1);
			System.out.println(roll2);

			rollCount++;
			loop = askRollAgain(in);
		}
		
	}
	
	public static int generateRandomDieRoll(int numSides, Random rand) {
		return(rand.nextInt(numSides) + 1);
	}
	
	public static int collectInput(Scanner in) {
		System.out.print("How many sides should eat die have?: ");
		return(in.nextInt());
	}
	
	public static boolean askRollAgain(Scanner in) {
		System.out.print("\nRoll again? (y/n): ");
		return (in.next().equalsIgnoreCase("y"));
	}
}
