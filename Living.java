package edu.iastate.cs228.hw1;
/**
 *  
 * @author Tim Kuehn
 *
 */

/**
 * 
 * Living refers to the life form occupying a square in a plain grid. It is a
 * superclass of Empty, Grass, and Animal, the latter of which is in turn a
 * superclass of Badger, Fox, and Rabbit. Living has two abstract methods
 * awaiting implementation.
 *
 */
public abstract class Living
{
	protected Plain plain; // the plain in which the life form resides
	protected int row; // location of the square on which
	protected int column; // the life form resides

	// constants to be used as indices.
	protected static final int BADGER = 0;
	protected static final int EMPTY = 1;
	protected static final int FOX = 2;
	protected static final int GRASS = 3;
	protected static final int RABBIT = 4;

	public static final int NUM_LIFE_FORMS = 5;

	// life expectancies
	public static final int BADGER_MAX_AGE = 4;
	public static final int FOX_MAX_AGE = 6;
	public static final int RABBIT_MAX_AGE = 3;

	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a plain.
	 * 
	 * @param population counts of all life forms
	 */
	protected void census(int population[])
	{
		int badgers = 0;
		int empties = 0;
		int foxes = 0;
		int grasses = 0;
		int rabbits = 0;

		for (int r = row - 1; r <= row + 1; r++)
		{
			for (int c = column - 1; c <= column + 1; c++)
			{
				//Checks to see if the location r,c is within the plain and not outside
				boolean validLocation = (r >= 0 && r < plain.getWidth() && c >= 0 && c < plain.getWidth());
				if (validLocation)
				{
					State state = plain.grid[r][c].who();
					if (state == State.BADGER)
					{
						badgers++;
					}
					else if (state == State.EMPTY)
					{
						empties++;
					}
					else if (state == State.FOX)
					{
						foxes++;
					}
					else if (state == State.GRASS)
					{
						grasses++;
					}
					else if (state == State.RABBIT)
					{
						rabbits++;
					}
				}
			}
		}

		population[BADGER] = badgers;
		population[EMPTY] = empties;
		population[FOX] = foxes;
		population[GRASS] = grasses;
		population[RABBIT] = rabbits;
	}

	/**
	 * Gets the identity of the life form on the square.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the life form on the square in the next cycle.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living
	 */
	public abstract Living next(Plain pNew);


}
