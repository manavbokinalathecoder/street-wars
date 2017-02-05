package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	public GameWindow(GameCanvas g){
		this.add(g);
		
		this.setTitle("Street Wars");
		this.setSize(800, 600);
		this.setPreferredSize(new Dimension(800, 600));
		this.setMinimumSize(new Dimension(800, 600));
		this.setMaximumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
}
