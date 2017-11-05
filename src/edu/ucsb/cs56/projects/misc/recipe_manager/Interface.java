package edu.ucsb.cs56.projects.misc.recipe_manager;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * Interface is just the jframe that holds everything and main function
 */
public class Interface{

	private static final long serialVersionUID = 1L;

	/**
	 * main method
	 */
	public static void main(String[] args){
		 JFrame frame = new JFrame();
	     frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE) ;
         
	     // Interface inter = new Interface(); // what does this do?
         JComponent ContentPane = new RecipePanel();
         ContentPane.setBackground(Color.WHITE);
         ContentPane.setOpaque(true); //make pane opaque
       
         frame.setContentPane(ContentPane);
         frame.setSize(1200,900); //width 1200, height 900
	     frame. setVisible(true) ;
	}
	
}
