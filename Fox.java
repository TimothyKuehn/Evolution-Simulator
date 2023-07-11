package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tim Kuehn
 *
 */

/**
 * A fox eats rabbits and competes against a badger.
 */
public class Fox extends Animal
{
	/**
	 * Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Fox(Plain p, int r, int c, int a)
	{
		plain = p;
		row = r;
		column = c;
		age = a;

	}

	/**
	 * A fox occupies the square.
	 */
	public State who()
	{
		return State.FOX;
	}

	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior
	 * badgers.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	public Living next(Plain pNew)
	{
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);
		if (this.age == 6) //If max fox age
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (pop[BADGER] > pop[FOX]) //If more badgers than foxes
		{
			return new Badger(pNew, this.row, this.column, 0);
		}
		else if (pop[BADGER] + pop[FOX] > pop[RABBIT]) //if more badgers and foxes combined than rabbits
		{
			return new Empty(pNew, this.row, this.column);
		}
		else
		{
			return new Fox(pNew, this.row, this.column, (this.age+=1)); //Ages fox a year
		}
	}
}
