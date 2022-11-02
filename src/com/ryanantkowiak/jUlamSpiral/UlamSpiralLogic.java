package com.ryanantkowiak.jUlamSpiral;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * The UlamSpiralLogic class creates a list of points that should be shaded in
 * a "Ulam Spiral" as defined at: http://en.wikipedia.org/wiki/Ulam_spiral
 * 
 * @author Ryan Antkowiak 
 *
 */
public class UlamSpiralLogic
{
	// List of shaded points
	private List<Point> m_points;

	// Constructor
	public UlamSpiralLogic()
	{
		m_points = new ArrayList<Point>();
	}
	
	/**
	 * This method looks for prime numbers, and decides what corresponding point on
	 * a grid should be shaded for the Ulam Spiral
	 * 
	 * @param maxX - Maximum distance in the x direction for the internal display
	 * @param maxY - Maximum distance in the y direction for the internal display
	 */
	public void run(int maxX, int maxY)
	{
		// Start with a clear list of points
		m_points.clear();
		
		// This number will be incremented and tested for being prime
		int candidatePrime = 1;
		
		// This is the point that would be shaded if the canddiatePrime is a prime
		Point point = new Point(maxX/2, maxY/2);

		// Variables for calculating the location of the x-y coordinates of the
		// prime points
		boolean canRotateWithoutIncrement = true;
		int movesInDirectionRemaining = 1;
		int movesInDirectionResetValue = 0;
		int directionToggle = 0;
		
		// Loop while we haven't exceeded maxY or maxY
		while ( (Math.abs(point.x) < maxX) && (Math.abs(point.y) < maxY) )
		{
			// If we found a prime, add the point to the list of points
			if (isPrime(candidatePrime))
				m_points.add((Point) point.clone());
			
			// Calculations to figure out what the next "point" should be
			// (if the next number is a prime)
			if (movesInDirectionRemaining > 0)
			{
				-- movesInDirectionRemaining;
			}
			else
			{
				// Check to see if we can simply rotate
				if (canRotateWithoutIncrement)
				{
					canRotateWithoutIncrement = false;
					++directionToggle;
					movesInDirectionRemaining = movesInDirectionResetValue;
				}
				else
				{
					// we can't just rotate... we must rotate AND increment the reset value
					canRotateWithoutIncrement = true;
					++directionToggle;
					++movesInDirectionResetValue;
					movesInDirectionRemaining = movesInDirectionResetValue;
				}
			}
		
			int direction = directionToggle % 4;
			if (direction == 0) // Move Right
			{
				point.x++;
			}
			else if (direction == 1) // Move Up
			{
				point.y--;
			}
			else if (direction == 2) // Move Left
			{
				point.x--;
			}
			else // Move Down
			{
				point.y++;
			}
			
			++candidatePrime;
		}
	}
	
	/**
	 * Retrieve the list of Ulam Spiral points
	 * 
	 * @return list of points
	 */
	public List<Point> getPoints()
	{
		return m_points;
	}
	
	/**
	 * Check if a number is prime
	 * 
	 * @param n - the number to check
	 * @return - true if n is prime
	 */
	private boolean isPrime(int n)
	{
		// 1 and less is not prime
		if (n <= 1)
			return false;
		
		// Check for factors
		for (int i=2; (i*i) <= n ; ++i)
			if (n % i == 0)
				return false;
		
		// No factors found, so must be prime
		return true;
	}

}
