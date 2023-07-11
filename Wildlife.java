package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  
 * @author Tim Kuehn
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with squares
 * inhabited by badgers, foxes, rabbits, grass, or none.
 *
 */
public class Wildlife
{
	/**
	 * Update the new plain from the old plain in one cycle.
	 * 
	 * @param pOld old plain
	 * @param pNew new plain
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
		for (int row = 0; row < pOld.getWidth(); row++)
		{
			for (int col = 0; col < pOld.getWidth(); col++)
			{
				pNew.grid[row][col] = pOld.grid[row][col].next(pNew);
			}
		}

	}

	/**
	 * Repeatedly generates plains either randomly or from reading files. Over each
	 * plain, carries out an input number of cycles of evolution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{

		boolean run = true;
		int trialNumber = 1;
		int numCyclesRun = 0;
		int numCyclesGoal = 0;
		Scanner sc = new Scanner(System.in);
		Plain even = null;
		Plain odd = null;

		while (run)
		{

			System.out.println("Simulation of Wildlife of the Plain");
			System.out.println("keys: 1 (random plain)  2 (file input)  3 (exit)");
			System.out.print("\nTrial " + trialNumber + ": ");
			int i = sc.nextInt();
			switch (i)
			{
			// If a 1 is inputed a random grid can be generated
			case 1:
				System.out.println("\nRandom plain");
				System.out.print("Enter grid width: ");
				even = new Plain(sc.nextInt());
				odd = new Plain(even.getWidth());
				even.randomInit();

				break;
			// If a 2 is inputed a grid can be read from a file
			case 2:
				System.out.println("\nPlain input from a file");
				System.out.print("File name: ");
				// Boolean to check whether a file is present in the location
				boolean validInput = false;
				// while there is no valid input
				while (!validInput)
				{
					// get a new input
					String fileName = sc.next();

					try
					{
						// Try to read the file at location given
						even = new Plain(fileName);
						odd = new Plain(even.getWidth());
						// If found then break out of while loop
						validInput = true;
					} 
					catch (FileNotFoundException e)
					{
						System.out.print("Invalid File, enter a new one:");
					}
				}
				break;
			// Any other input will end the program
			default:
				run = false;
				break;
			}
			// If program is not ended earlier
			if (run)
			{
				trialNumber++;
				System.out.print("\nEnter the number of cycles: ");
				// How many "generations" should be run
				numCyclesGoal = sc.nextInt();

				System.out.println("\nInitial plain:");
				// Prints starter plain
				System.out.println(even.toString());

				// Runs through the number of goal cycles (inputed by user)
				for (int numRun = 0; numRun < numCyclesGoal; numRun++)
				{
					// Makes sure the right plain is passed in to update
					if (numRun % 2 == 0)
					{
						updatePlain(even, odd);

					}
					// Makes sure the right plain is passed in to update
					if (numRun % 2 == 1)
					{
						updatePlain(odd, even);
					}
					numCyclesRun++;
				}
				// Makes sure to print out the correct plain depending if number of cycles run
				// is odd of even
				if (numCyclesRun % 2 == 0)
				{
					System.out.println("\n" + "Final plain:" + "\n");
					System.out.println(even.toString());
				}
				//If odd numbers of cycles and the end
				else if (numCyclesRun % 2 == 1)
				{
					System.out.println("\n" + "Final plain:" + "\n");
					System.out.println(odd.toString());
				}
			}
			// Resets so it can be run again
			numCyclesRun = 0;
			numCyclesGoal = 0;
		}
	}

}
