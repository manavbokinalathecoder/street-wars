package gui;

import java.awt.Dimension;

public class Main {

	public static void main(String args[]){
		GameCanvas g = new GameCanvas();
		
		Dimension d = new Dimension(800, 600);
		g.setSize(d);
		g.setMinimumSize(d);
		g.setPreferredSize(d);
		g.setMaximumSize(d);
		
		new GameWindow(g);
		
		g.start();
	}
}
