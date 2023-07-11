package edu.iastate.cs228.hw1;

/**
 * 
 * @author Tim Kuehn
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal
{
	/**
	 * Creates a Rabbit object.
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Rabbit(Plain p, int r, int c, int a)
	{
		plain = p;
		age = a;
		row = r;
		column = c;
	}

	// Rabbit occupies the square.
	public State who()
	{
		return State.RABBIT;
	}

	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a
	 * fox.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{

		int[] pop = new int[5];
		
		this.plain.grid[this.row][this.column].census(pop);

		if (this.age == 3)
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (pop[GRASS] == 0)
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (pop[FOX] + pop[BADGER] >= pop[RABBIT] && pop[FOX] > pop[BADGER])
		{
			return new Fox(pNew, this.row, this.column, 0);
		}
		else if (pop[BADGER] > pop[RABBIT])
		{
			return new Badger(pNew, this.row, this.column, 0);
		}
		else
		{
			return new Rabbit(pNew, this.row, this.column, (this.age+=1));
		}
	}
}
