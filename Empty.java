package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tim Kuehn
 *
 */

/**
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living
{
	public Empty(Plain p, int r, int c)
	{
		plain = p;
		row = r;
		column = c;
	}

	/**
	 * Returns State
	 */
	public State who()
	{
		return State.EMPTY;
	}

	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or
	 * Grass, or remain empty.
	 * 
	 * @param pNew plain of the next life cycle.
	 * @return Living life form in the next cycle.
	 */
	public Living next(Plain pNew)
	{
		int[] pop = new int[5];

		this.plain.grid[row][column].census(pop); // Calls census on current plain grid location

		if (pop[RABBIT] > 1) // If more than 1 rabbit in neighborhood
		{
			return new Rabbit(pNew, row, column, 0);
		}
		else if (pop[FOX] > 1) // If more than 1 fox in neighborhood
		{
			return new Fox(pNew, row, column, 0);
		}
		else if (pop[BADGER] > 1) // If more than one badger in neighborhood
		{
			return new Badger(pNew, row, column, 0);
		}
		else if (pop[GRASS] >= 1) // If at least one grass in neighborhood
		{
			return new Grass(pNew, row, column);
		}
		else
		{
			return new Empty(pNew, row, column);
		}

	}
}
