package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;


/**
 * 
 * @author Tim Kuehn
 *
 */
class WildlifeTest
{
	/**
	 * 
	 * @throws FileNotFoundException Requires threeByThree.txt Requires funcional
	 *                               .toString() method
	 */
	@Test
	void testUpdatePlain() throws FileNotFoundException
	{
		Plain pOld = new Plain("threeByThree.txt");
		Plain pNew = new Plain(pOld.getWidth());

		String solution = "R1 R1 B1 \n" + "G  G  G  \n" + "G  G  G  \n";

		Wildlife.updatePlain(pOld, pNew);
		assertEquals(solution, pNew.toString());
	}

}
