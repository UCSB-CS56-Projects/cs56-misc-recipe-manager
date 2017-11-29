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

	        try {
	            robot = new Robot();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}

	   	public void keyPressed(KeyEvent e) {
	   		
	      int key = e.getKeyCode();
	        if(key == KeyEvent.VK_DELETE || key == KeyEvent.VK_BACK_SPACE){
	            robot.delay(100);
    			int mask = InputEvent.BUTTON1_DOWN_MASK;
		        int x = (int)ContentPane.getDeleteRecipeButtonLocation().getX();
		        int y = (int)ContentPane.getDeleteRecipeButtonLocation().getY();
		        robot.mouseMove(x,y);
		        robot.mousePress(mask);
		        robot.mouseRelease(mask);
	        }else if (key == KeyEvent.VK_N){
	        	robot.delay(100);
    			int mask = InputEvent.BUTTON1_DOWN_MASK;
		        int x = (int)ContentPane.getAddNewRecipeButtonLocation().getX();
		        int y = (int)ContentPane.getAddNewRecipeButtonLocation().getY();
		        robot.mouseMove(x,y);
		        robot.mousePress(mask);
		        robot.mouseRelease(mask);
	        }
	      
	   	}
	   	public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}
	
	
}
