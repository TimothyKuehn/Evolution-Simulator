package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Tim Kuehn
 *
 */
class RabbitTest
{
	/**
	 * Tests the construction of a plain from the Rabbit constructor method
	 */
	@Test
	void plainRabbitConstructorTest()
	{
		Plain p = new Plain(5);
		Rabbit a = new Rabbit(p, 1, 1, 2);
		assertEquals(p, a.plain);
	}
	/**
	 * Tests the age of a Rabbit from the Rabbit construction method
	 */
	@Test
	void ageRabbitConstructorTest()
	{
		Plain p = new Plain(5);
		Rabbit a = new Rabbit(p, 1, 1, 2);
		assertEquals(2, a.age);
	}
	/**
	 * Tests the row of a Rabbit constructed using the Rabbit construction method
	 */
	@Test
	void rowRabbitConstructorTest()
	{
		Plain p = new Plain(5);
		Rabbit a = new Rabbit(p, 1, 2, 2);
		assertEquals(1, a.row);
	}
	/**
	 * Tests the column of a Rabbit constructed using the Rabbit construction method
	 */
	@Test
	void columnRabbitConstructorTest()
	{
		Plain p = new Plain(5);
		Rabbit a = new Rabbit(p, 1, 2, 2);
		assertEquals(2, a.column);
	}
	/**
	 * Tests the .who() method of a Rabbit constructed using the Rabbit construction
	 * method
	 */
	@Test
	void whoRabbitMethodTest()
	{
		Plain p = new Plain(5);
		Rabbit a = new Rabbit(p, 4, 4, 2);
		assertEquals(State.RABBIT, a.who());
	}
	/**
	 * Tests the next() method of a Rabbit constructed using the Rabbit construction
	 * method Requires nextAnimalTestCase.txt Requires funcional .toString() method
	 */
	@Test
	void nextRabbitMethod() throws FileNotFoundException
	{
		Plain p = new Plain("nextAnimalTestCase.txt");
		p.grid[2][2] = p.grid[2][2].next(p);
		assertEquals("F5 E  E  F0 E  E  \n" + "B3 F1 B0 R0 G  R0 \n" + "R0 E  E  B0 B2 G  \n"
				+ "B0 E  E  R1 F0 E  \n" + "B1 E  E  G  E  R0 \n" + "G  G  E  B0 R2 E  \n", p.toString());
	}

}
