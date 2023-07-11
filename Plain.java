package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tim Kuehn
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * The plain is represented as a square grid of size width x width.
 *
 */
public class Plain
{
	private int width; // grid size: width X width

	public Living[][] grid;

	/**
	 * Default constructor reads from a file
	 * Uses three scanners, two to get the width and 1 to read the full file
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{
		File f = new File(inputFileName);
		//Gets the first line of the file to be used to find the width
		Scanner scLine = new Scanner(f);
		//Scanner for the whole file (requires the width)
		Scanner sc = new Scanner(f);
		String firstLine = scLine.nextLine();
		//Scanner to check the width of the first line (and thus the whole grid
		Scanner scWidth = new Scanner(firstLine);
		//w is the width of the input grid
		int w = 0;

		while (scWidth.hasNext())
		{
			scWidth.next();
			w++;
		}
		
		width = w;
		//creates new grid with given width
		grid = new Living[width][width];
		//goes through all values
		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < width; col++)
			{
				//For each item, makes new string and stores first character
				String s = sc.next();
				char firstChar = s.charAt(0);
				//Second char only used when Badger Fox or Rabbit
				char secondChar;
				String age;
				//Based on the first character, picks what animal is constructed
				switch (firstChar)
				{
				case 'B':
					//secondChar is the age of the animal
					secondChar = s.charAt(1);
					age = secondChar + "";
					grid[row][col] = new Badger(this, row, col, Integer.parseInt(age));
					break;
				case 'E':
					grid[row][col] = new Empty(this, row, col);
					break;
				case 'F':
					//secondChar is the age of the animal
					secondChar = s.charAt(1);
					age = secondChar + "";
					grid[row][col] = new Fox(this, row, col, Integer.parseInt(age));
					break;
				case 'G':
					grid[row][col] = new Grass(this, row, col);
					break;
				case 'R':
					//secondChar is the age of the animal
					secondChar = s.charAt(1);
					age = secondChar + "";
					grid[row][col] = new Rabbit(this, row, col, Integer.parseInt(age));
					break;
				}
			}
		}
	}

	/**
	 * Constructor that builds a w x w grid without initializing it.
	 * 
	 * @param width the grid
	 */
	public Plain(int w)
	{
		width = w;
		this.grid = new Living[w][w];
	}

	public int getWidth()
	{
		return width;
	}

	/**
	 * Initialize the plain by randomly assigning to every square of the grid one of
	 * BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random();

		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < width; col++)
			{

				int nextCell = generator.nextInt(5);

				if (nextCell == Living.BADGER)
				{
					grid[row][col] = new Badger(this, row, col, 0);
				}
				if (nextCell == Living.FOX)
				{
					grid[row][col] = new Fox(this, row, col, 0);
				}
				if (nextCell == Living.RABBIT)
				{
					grid[row][col] = new Rabbit(this, row, col, 0);
				}
				if (nextCell == Living.GRASS)
				{
					grid[row][col] = new Grass(this, row, col);
				}
				if (nextCell == Living.EMPTY)
				{
					grid[row][col] = new Empty(this, row, col);
				}
			}
		}

	}

	/**
	 * Output the plain grid. For each square, output the first letter of the living
	 * form occupying the square. If the living form is an animal, then output the
	 * age of the animal followed by a blank space; otherwise, output two blanks.
	 */
	public String toString()
	{
		String plainString = "";
		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < width; col++)
			{
				switch (grid[row][col].who())
				{
				case BADGER:
					plainString += "B" + ((Animal) grid[row][col]).myAge() + " ";
					break;
				case RABBIT:
					plainString += "R" + ((Animal) grid[row][col]).myAge() + " ";
					break;
				case FOX:
					plainString += "F" + ((Animal) grid[row][col]).myAge() + " ";
					break;
				case EMPTY:
					plainString += "E  ";
					break;
				case GRASS:
					plainString += "G  ";
					break;
				}
			}
			plainString += "\n";
		}
		return plainString;
	}

	/**
	 * Write the plain grid to an output file. Also useful for saving a randomly
	 * generated plain for debugging purpose.
	 * 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		File f = new File(outputFileName);
		PrintWriter w = new PrintWriter(f);
		String write = this.toString();
		int i = 0;
		w.print(write);
		w.close();
	}
}
