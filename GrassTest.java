package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Tim Kuehn
 *
 */
class GrassTest
{
	/**
	 * Tests the construction of a plain from the Grass constructor method
	 */
	@Test
	void plainGrassConstructorTest()
	{
		Plain p = new Plain(5);
		Grass a = new Grass(p, 1, 1);
		assertEquals(p, a.plain);
	}

	/**
	 * Tests the row of a Grass constructed using the Grass construction method
	 */
	@Test
	void rowGrassConstructorTest()
	{
		Plain p = new Plain(5);
		Grass a = new Grass(p, 1, 2);
		assertEquals(1, a.row);
	}

	/**
	 * Tests the column of a Grass constructed using the Grass construction method
	 */
	@Test
	void columnGrassConstructorTest()
	{
		Plain p = new Plain(5);
		Grass a = new Grass(p, 1, 2);
		assertEquals(2, a.column);
	}

	/**
	 * Tests the .who() method of a Grass constructed using the Grass construction
	 * method
	 */
	@Test
	void whoGrassMethodTest()
	{
		Plain p = new Plain(5);
		Grass a = new Grass(p, 4, 4);
		assertEquals(State.GRASS, a.who());
	}

	/**
	 * Tests the next() method of a Grass constructed using the Grass construction
	 * Requires nextAnimalTestCase.txt Requires functional .toString() method
	 */
	@Test
	void nextGrassMethod() throws FileNotFoundException
	{
		Plain p = new Plain("nextAnimalTestCase.txt");
		p.grid[1][4] = p.grid[1][4].next(p);
		assertEquals("F5 E  E  F0 E  E  \n" + "B3 F1 B0 R0 G  R0 \n" + "R0 E  R2 B0 B2 G  \n" + "B0 E  E  R1 F0 E  \n"
				+ "B1 E  E  G  E  R0 \n" + "G  G  E  B0 R2 E  \n", p.toString());
	}

}
