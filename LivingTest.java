package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
/**
 * 
 * @author Tim Kuehn
 *
 */
class LivingTest
{
	/**
	 * Test case to check .census() looks at middle of a grid (at least one square each side)
	 * Requires censusTestCase.txt
	 * @throws FileNotFoundException
	 */
	@Test
	void testCensus() throws FileNotFoundException
	{
		
		Plain p = new Plain("censusTestCase.txt");
		int[] pop = new int[5];
		p.grid[1][1].census(pop);
		assertEquals(2, pop[0]);
		assertEquals(3,pop[1]);
		assertEquals(2, pop[2]);
		assertEquals(0, pop[3]);
		assertEquals(2, pop[4]);
		
	}
	/**
	 * Test case to make sure .census() works in the corner of a grid
	 * Requires censusTestCase.txt
	 * @throws FileNotFoundException
	 */
	@Test
	void testCornerCensus() throws FileNotFoundException
	{
		Plain p = new Plain("censusTestCase.txt");
		int[] pop = new int[5];
		p.grid[0][0].census(pop);
		assertEquals(1, pop[0]);
		assertEquals(1,pop[1]);
		assertEquals(2, pop[2]);
		assertEquals(0, pop[3]);
		assertEquals(0, pop[4]);
		
	}

}
