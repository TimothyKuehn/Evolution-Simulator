package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
/**
 * 
 * @author Tim Kuehn
 *
 */
class PlainTest
{

	/**
	 * Tests construction of a Plain object from the file "nextAnimalTestCase.txt"
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	void plainConstructorFromFile() throws FileNotFoundException
	{
		Plain p = new Plain("nextAnimalTestCase.txt");
		String expected = "F5 E  E  F0 E  E  \n" + "B3 F1 B0 R0 G  R0 \n" + "R0 E  R2 B0 B2 G  \n"
				+ "B0 E  E  R1 F0 E  \n" + "B1 E  E  G  E  R0 \n" + "G  G  E  B0 R2 E  \n";
		assertEquals(expected, p.toString());
	}

	/**
	 * Tests the constructor public Plain(int w) Also tests the public int
	 * getWidth()
	 */
	@Test
	void plainWidthConstructor()
	{
		// Plain should have a width 4
		Plain p = new Plain(4);
		assertEquals(4, p.getWidth());
	}

	/**
	 * Tests initialization/filling of a Plain object using randomInit() method Does
	 * not check values of output, just checks that every space in the plain.grid is
	 * filled and not null
	 * 
	 */
	@Test
	void randomInitTest()
	{
		Plain p = new Plain(5);
		p.randomInit();
		for (int i = 0; i < p.getWidth(); i++)
		{
			for (int j = 0; j < p.getWidth(); j++)
			{
				// iterates through rows and columns and makes sure that each location has a
				// valid object in that position
				assertNotEquals(p.grid[i][j], null);

			}
		}

	}

	/**
	 * Tests the plainToString method Please note: This method is used in other
	 * JUnit Test Cases so if it is wrong it will cause a plethora of errors
	 * Requires censusTestCase.txt file
	 * @throws FileNotFoundException
	 */
	@Test
	void plainToStringTest() throws FileNotFoundException
	{
		Plain p = new Plain("censusTestCase.txt");
		String expected = "F5 E  E  F0 E  E  \n" + "B3 F1 B0 R0 G  R0 \n" + "R0 E  R2 B0 B2 G  \n"
				+ "B0 E  E  R1 F0 E  \n" + "B1 E  E  G  E  R0 \n" + "G  G  E  B0 R2 E  \n";
		assertEquals(expected, p.toString());

	}

	/**
	 * Tests the write method in Plain class. Outputs to file
	 * writeOutputTestCase.txt Requires censusTestCase.txt
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	void plainWriteTest() throws FileNotFoundException
	{
		//Creates plain from file
		Plain p = new Plain("censusTestCase.txt");
		//Creates text file from plain
		p.write("writeOutputTestCase.txt");
		//Creates new plain from new file
		Plain p2 = new Plain("writeOutputTestCase.txt");
		//Checks that original plain is the same as new one
		assertEquals(p2.toString(), p.toString());
	}

}
