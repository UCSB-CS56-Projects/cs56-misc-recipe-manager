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
         
	     Interface inter = new Interface();
         JComponent ContentPane = new RecipePanel();
         //ContentPane.setBackground(Color.WHITE);
         ContentPane.setBackground(Color.WHITE);
         ContentPane.setOpaque(true); //make pane opaque
         
         frame.setContentPane(ContentPane);
         frame.setSize(800,600); //width 800, height 600                                 
	     frame. setVisible(true) ;
	}
	
	
   

}
