package edu.iastate.cs228.hw1;

/**
 *  
 * @author Tim Kuehn
 *
 */

/**
 * A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal
{
	/**
	 * Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Badger(Plain p, int r, int c, int a)
	{

		age = a;
		row = r;
		column = c;
		plain = p;

	}

	/**
	 * A badger occupies the square.
	 */
	public State who()
	{
		return State.BADGER;
	}

	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group
	 * of foxes.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */

	public Living next(Plain pNew)
	{
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);

		if (this.age == 4) //If Badger Max Age
		{
			return new Empty(pNew, this.row, this.column);
		}
		else if (pop[BADGER] == 1 && pop[FOX] > 1) //If 1 badger and more than 1 fox
		{
			return new Fox(pNew, this.row, this.column, 0);
		}
		else if (pop[BADGER] + pop[FOX] > pop[RABBIT]) //If more badgers and foxes combined than rabbits
		{
			return new Empty(pNew, this.row, this.column);
		}
		else
		{
			return new Badger(pNew, this.row, this.column, (age += 1)); //Ages Badger
		}

	}
}
