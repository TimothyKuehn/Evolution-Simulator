package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
/**
 * 
 * @author Tim Kuehn
 *
 */
class BadgerTest
{

	/**
	 * Tests the construction of a plain from the Badger constructor method
	 */
	@Test
	void plainBadgerConstructorTest()
	{
		Plain p = new Plain(5);
		Badger a = new Badger(p, 1, 1, 2);
		assertEquals(p, a.plain); // Plain that object a is in should be equal to plain p
	}

	/**
	 * Tests the age of a Badger from the Badger construction method
	 */
	@Test
	void ageBadgerConstructorTest()
	{
		Plain p = new Plain(5);
		Badger a = new Badger(p, 1, 1, 2);
		assertEquals(2, a.age); // Expected value of 2
	}

	/**
	 * Tests the row of a Badger constructed using the Badger construction method
	 */
	@Test
	void rowBadgerConstructorTest()
	{
		Plain p = new Plain(5);
		Badger a = new Badger(p, 1, 2, 2);
		assertEquals(1, a.row); // Expected that a.row == 1
	}

	/**
	 * Tests the column of a Badger constructed using the Badger construction method
	 */
	@Test
	void columnBadgerConstructorTest()
	{
		Plain p = new Plain(5);
		Badger a = new Badger(p, 1, 2, 2);
		assertEquals(2, a.column); // Expected that a.column == 2
	}

	/**
	 * Tests the .who() method of a Badger constructed using the Badger construction
	 * method
	 */
	@Test
	void whoBadgerMethodTest()
	{
		Plain p = new Plain(5);
		Badger a = new Badger(p, 4, 4, 2);
		assertEquals(State.BADGER, a.who()); // Expected that a.who() returns State.BADGER
	}

	/**
	 * Tests the next() method of a Badger constructed using the Badger construction
	 * method Requires nextAnimalTestCase.txt Requires funcional .toString() method
	 */
	@Test
	void nextBadgerMethod() throws FileNotFoundException
	{
		Plain p = new Plain("nextAnimalTestCase.txt");
		p.grid[2][4].next(p);
		assertEquals("F5 E  E  F0 E  E  \n" + "B3 F1 B0 R0 G  R0 \n" + "R0 E  R2 B0 B3 G  \n" + "B0 E  E  R1 F0 E  \n"
				+ "B1 E  E  G  E  R0 \n" + "G  G  E  B0 R2 E  \n", p.toString()); // The Strings should be equivilent if
																					// .next() works properly
	}

}
