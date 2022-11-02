package com.ryanantkowiak.jUlamSpiral;


import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * Main class
 * 
 * @author Ryan Antkowiak 
 *
 */
public class Main
{	
	// The width and height of the internal scrollable area
	private static final int DATA_WIDTH = 2000;
	private static final int DATA_HEIGHT = 2000;
	
	// The width and height of the gui window
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 500;
	
	/**
	 * Main static method, create the logic and display components
	 * @param args
	 */
	public static void main(String [] args)
	{

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
