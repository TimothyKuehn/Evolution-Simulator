package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Tim Kuehn
 *
 */
class FoxTest
{
	/**
	 * Tests the construction of a plain from the Fox constructor method
	 */
	@Test
	void plainFoxConstructorTest()
	{
		Plain p = new Plain(5);
		Fox a = new Fox(p, 1, 1, 2);
		assertEquals(p, a.plain);
	}
	/**
	 * Tests the age of a Fox from the Fox construction method
	 */
	@Test
	void ageFoxConstructorTest()
	{
		Plain p = new Plain(5);
		Fox a = new Fox(p, 1, 1, 2);
		assertEquals(2, a.age);
	}
	/**
	 * Tests the row of a Fox constructed using the Fox construction method
	 */
	@Test
	void rowFoxConstructorTest()
	{
		Plain p = new Plain(5);
		Fox a = new Fox(p, 1, 1, 2);
		assertEquals(1, a.row);
	}
	/**
	 * Tests the column of a Fox constructed using the Fox construction method
	 */
	@Test
	void columnFoxConstructorTest()
	{
		Plain p = new Plain(5);
		Fox a = new Fox(p, 1, 1, 2);
		assertEquals(1, a.column);
	}
	/**
	 * Tests the .who() method of a Fox constructed using the Fox construction
	 * method
	 */
	@Test
	void whoFoxMethodTest()
	{
		Plain p = new Plain(5);
		Fox a = new Fox(p, 4, 4, 2);
		assertEquals(State.FOX, a.who());
	}
	/**
	 * Tests the next() method of a Fox constructed using the Fox construction
	 * method Requires nextAnimalTestCase.txt Requires funcional .toString() method
	 */
	@Test
	void nextFoxMethod() throws FileNotFoundException
	{
		Plain p = new Plain("nextAnimalTestCase.txt");
		p.grid[1][1] = p.grid[1][1].next(p);
		assertEquals("F5 E  E  F0 E  E  \n" + "B3 E  B0 R0 G  R0 \n" + "R0 E  R2 B0 B2 G  \n"
				+ "B0 E  E  R1 F0 E  \n" + "B1 E  E  G  E  R0 \n" + "G  G  E  B0 R2 E  \n", p.toString());
	}
}
