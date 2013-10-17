package com.ryanantkowiak.jUlamSpiral;


import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * Main class
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 *
 */
public class Main
{	
	/**
	 * Main static method, create the logic and display components
	 * @param args
	 */
	public static void main(String [] args)
	{
		// The width and height of the internal scrollable area
		final int DATA_WIDTH = 2000;
		final int DATA_HEIGHT = 2000;
		
		// The width and height of the gui window
		final int WINDOW_WIDTH = 500;
		final int WINDOW_HEIGHT = 500;
		
		// Create the logic object
		UlamSpiralLogic logic = new UlamSpiralLogic();
		logic.run(DATA_WIDTH, DATA_HEIGHT);
		
		// Create the display component
		GraphDisplayComponent gdc = new GraphDisplayComponent();
		gdc.setPreferredSize(new Dimension(DATA_WIDTH, DATA_HEIGHT));
		gdc.setPointList(logic.getPoints());
		
		JScrollPane scrollpane = new JScrollPane(gdc);
		scrollpane.getViewport().setViewPosition(new Point(
						(DATA_WIDTH - WINDOW_WIDTH)/2,
						(DATA_HEIGHT - WINDOW_HEIGHT)/2));

		JFrame frame = new JFrame("Ulam Spiral");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(scrollpane);
		frame.setVisible(true);
	}

}
