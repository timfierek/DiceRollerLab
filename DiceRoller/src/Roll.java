import java.util.Random;
import java.util.Scanner;

/**
 * Roll.java contains all functionality for a random die rolling simulator
 * in which the user decides the number of sides on 2 dies and rolls to their
 * hearts content.
 * 
 * @author Tim Fierek
 *
 */
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
		numSides = collectInput(in);	// Get input from user
		
		while(loop) {
			roll1 = generateRandomDieRoll(numSides, rand);
			roll2 = generateRandomDieRoll(numSides, rand);
			
			// Generate output and check for snake eyes and boxcars
			System.out.println("\nRoll " + rollCount + ": ");
			System.out.println(roll1);
			System.out.println(roll2);
			if(roll1 == 1 && roll2 == 1) {
				System.out.println("You rolled Snake Eyes!");
			}
			else if(roll1 == 6 && roll2 == 6) {
				System.out.println("You rolled Box Cars!");
			}
			
			rollCount++;
			loop = askRollAgain(in);
		}
		
	}
	
	/**
	 * generateRandomDieRoll returns a number between 1 and the highest
	 * number as entered by the user as the number of sides (inclusive).
	 * 
	 * @param numSides	the top range (inclusive) that can be rolled
	 * @param rand	    rand object for generating non-seeded random nums
	 * @return			return the randomly generated number
	 */
	public static int generateRandomDieRoll(int numSides, Random rand) {
		return(rand.nextInt(numSides) + 1);
	}
	
	/**
	 * collectInput prompts and returns the number of sides on the dice
	 * that the user would like
	 * 
	 * @param in Scanner object used for user input
	 * @return   return the number of sides of the dice as entered by user
	 */
	public static int collectInput(Scanner in) {
		System.out.print("How many sides should eat die have?: ");
		return(in.nextInt());
	}
	
	/**
	 * askRollAgain simply requests if the user would like another roll and
	 * returns the result.
	 * 
	 * @param in Scanner object used for user input
	 * @return   true if user enters 'y', false otherwise
	 */
	public static boolean askRollAgain(Scanner in) {
		System.out.print("\nRoll again? (y/n): ");
		return (in.next().equalsIgnoreCase("y"));
	}
}
