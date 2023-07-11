package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tim Kuehn
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is
 * eaten.
 *
 */
public class Grass extends Living
{
	public Grass(Plain p, int r, int c)
	{
		plain = p;
		row = r;
		column = c;
	}

	public State who()
	{
		return State.GRASS;
	}

	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast
	 * enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);

		if (pop[RABBIT] >= pop[GRASS] * 3) //If 3 times as much grass as number of rabbits
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (pop[RABBIT] >= 3) //If more than 3 rabbits
		{
			return new Rabbit(pNew, this.row, this.column, 0);
		}
		else
		{
			return new Grass(pNew, this.row, this.column);
		}
	}
}
