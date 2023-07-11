package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Tim Kuehn
 *
 */
class EmptyTest
{
	/**
	 * Tests the construction of a plain from the Empty constructor method
	 */
	@Test
	void plainEmptyConstructorTest()
	{
		Plain p = new Plain(5);
		Empty a = new Empty(p, 1, 1);
		assertEquals(p, a.plain);
	}

	/**
	 * Tests the row of a Empty constructed using the Etmpty construction method
	 */
	@Test
	void rowEmptyConstructorTest()
	{
		Plain p = new Plain(5);
		Empty a = new Empty(p, 1, 2);
		assertEquals(1, a.row);
	}

	/**
	 * Tests the column of a Empty constructed using the Empty construction method
	 */
	@Test
	void columnEmptyConstructorTest()
	{
		Plain p = new Plain(5);
		Empty a = new Empty(p, 1, 2);
		assertEquals(2, a.column);
	}

	/**
	 * Tests the .who() method of a Empty constructed using the Empty construction
	 * method
	 */
	@Test
	void whoEmptyMethodTest()
	{
		Plain p = new Plain(5);
		Empty a = new Empty(p, 4, 4);
		assertEquals(State.EMPTY, a.who());
	}

	/**
	 * Tests the next() method of a Empty constructed using the Empty construction
	 * method Requires nextAnimalTestCase.txt Requires functional .toString() method
	 */
	@Test
	void nextEmptyMethod() throws FileNotFoundException
	{
		Plain p = new Plain("nextAnimalTestCase.txt");
		p.grid[0][4] = p.grid[0][4].next(p);
		assertEquals("F5 E  E  F0 R0 E  \n" + "B3 F1 B0 R0 G  R0 \n" + "R0 E  R2 B0 B2 G  \n" + "B0 E  E  R1 F0 E  \n"
				+ "B1 E  E  G  E  R0 \n" + "G  G  E  B0 R2 E  \n", p.toString());
	}

}
