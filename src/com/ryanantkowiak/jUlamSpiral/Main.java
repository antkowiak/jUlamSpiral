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
	// Application frame
	private JFrame m_frame;
	
	/**
	 * Main static method
	 * @param args
	 */
	public static void main(String [] args)
	{
		@SuppressWarnings("unused")
		Main m = new Main();
	}

	/***
	 * Create the logic and display components
	 */
	public Main()
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

		m_frame = new JFrame("Ulam Spiral");
		m_frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_frame.getContentPane().add(scrollpane);
		m_frame.setVisible(true);
	}

}
