package edu.ucsb.cs56.projects.misc.recipe_manager;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * Interface is just the jframe that holds everything and main function
 */
public class Interface extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	Robot robot; 
	RecipePanel ContentPane;
	/**
	 * main method
	 */
	public static void main(String[] args){
		new Interface();
	}

	public Interface(){
		// JFrame frame = new JFrame("Recipe Manager");
	     setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE) ;
        
         ContentPane = new RecipePanel();
         ContentPane.setBackground(Color.WHITE);
         ContentPane.setOpaque(true); //make pane opaque
       
         setContentPane(ContentPane);
         addKeyListener(this);
         setFocusable(true);
         setSize(1200,900); //width 1200, height 900
	     setVisible(true) ;

	        
	}

	   	public void keyPressed(KeyEvent e) {
	   		try {
	            robot = new Robot();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	   		
	      int key = e.getKeyCode();
	        if(key == KeyEvent.VK_DELETE || key == KeyEvent.VK_BACK_SPACE){

	        	ContentPane.index = ContentPane.listNames.getSelectedIndex();
				ContentPane.list.get(ContentPane.index).setRecipeIcon(null);
				ContentPane.recipeInfo.setIcon(null);
				ContentPane.list.remove(ContentPane.index);
				ContentPane.listModel.remove(ContentPane.index);

				ContentPane.listNames.setModel(ContentPane.listModel);
				ContentPane.listNames.setSelectedIndex(0);
	        }else if (key == KeyEvent.VK_N){
	        	ContentPane.adder = new RecipeAdder(ContentPane.list, ContentPane.listModel, ContentPane.listNames);
	        }
	      
	   	}
	   	public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	
	
}
