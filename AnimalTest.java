package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Tim Kuehn
 *
 */
class AnimalTest
{

	Plain p = new Plain(5);

	/**
	 * Tests the age of Fox using a Fox constructor
	 */
	@Test
	void testFoxAge()
	{
		Animal a = new Fox(p, 2, 2, 4);
		assertEquals(4, a.myAge()); //Expected Value 4

	}
	/**
	 * Tests the age of Badger using a Badger constructor
	 */
	@Test
	void testBadgerAge()
	{

		Animal b = new Badger(p, 2, 3, 3);
		assertEquals(3, b.myAge()); //Expected Value 3
	}
	/**
	 * Tests the age of Rabbit using a Rabbit constructor
	 */
	@Test
	void testRabbitAge()
	{
		Animal c = new Rabbit(p, 2, 1, 1);
		assertEquals(1, c.myAge()); //Expected Value 1
	}

}
