package edu.ucsb.cs56.projects.misc.recipe_manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

/**
 *  RecipeAdder is a frame with text areas to enter
 *  information about a new recipe
 */
public class RecipeAdder extends JFrame {
	Recipe newRecipe = new Recipe("");

	JTextField nameField, descriptionField, directionsField;
	ArrayList<JTextField> ingredientFields  = new ArrayList<>();

	JButton button;
	JButton button2;

	RecipeList list; 
	DefaultListModel listModel;
	JList listNames;
	Form form;

	/**
	 * three-arg constructor that takes in the current
	 * list data and sets up the JFrame and components
	 * @param listA RecipeList for the frame
	 * @param listModelA DefaultListModel for the frame
	 * @param listNamesA JList for the frame
	 */

	public RecipeAdder(RecipeList listA, DefaultListModel listModelA, JList listNamesA){
		super("Add Recipe");


		list = listA;
		listModel = listModelA;
		listNames = listNamesA;	

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;

		for(int i=0; i<6; i++)
			ingredientFields.add(new JTextField(30));

		form = new Form();

		JPanel content = new JPanel();
		setContentPane(content);

		Border titled2 = new TitledBorder("Enter Information:");
		content.setBorder(titled2);

		ActionListener saveListener = new bottonListener();
		ActionListener moreIngredientsListener = new moreIngredientsListener();

		button = new JButton("Add to list");
		button.addActionListener(saveListener);

		button2 = new JButton("More Ingredients");
		button2.addActionListener(moreIngredientsListener);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		panel.add(button);
		panel.add(button2);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		add(form);
		add(panel);
		pack();
		setVisible(true);
	}//end constructor 


	/**
	 * Inner class form sets up all the text fields
	 * so the user can enter the recipe info
	 */
	
	@SuppressWarnings("serial")
	public class Form extends JPanel {
		JLabel[] labels;
		JComponent[] fields;
		int fieldNum = 0;

		/**
		 * Constructor for the Form object
		 */

		public Form(){
			String[] labelStrings = {
					"Name: ",
					"Description: ",
					"Directions: ",
					"Ingredients: "
			};

			labels = new JLabel[labelStrings.length];
			fields = new JComponent[labelStrings.length];


			for(int i=0; i<4; i++)
				labels[i] = new JLabel(labelStrings[i],
						JLabel.TRAILING);

			nameField = new JTextField(30);

			fields[fieldNum++] = nameField;

			descriptionField = new JTextField(30);
			fields[fieldNum++] = descriptionField;

			directionsField = new JTextField(30);
			fields[fieldNum++] = directionsField;

			fields[fieldNum++] = ingredientFields.get(0);

			setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));  
			setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

			addComponents();

		}

		/**
		 * Helper function that add all text fields to the form
		 */

		public void addComponents(){

			for(int i=0; i < fieldNum ; i++){       
				add(labels[i]);
				if(i==3){
					add(fields[i]);
					for(int k=1;k<ingredientFields.size();k++)
						add(ingredientFields.get(k));
				}
				else 
					add(fields[i]);
			}

		}


	}//end form class

	/**
	 * Second inner class that listens for
	 * the user to push the "add recipe" button
	 */

	public class bottonListener implements ActionListener {

		/**
		 * Listens for the "add recipe" button to be clicked and
		 * then performs the corresponding action
		 * @param arg0 ActionEvent of the "add recipe"
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean hasIngredients = false;
			for(JTextField f : ingredientFields){
				if(!f.getText().equals("")){
					hasIngredients = true;
					break;
				}
			}
			if (nameField.getText().equals("") || descriptionField.getText().equals("") || directionsField.getText().equals("") || !hasIngredients) {
				JOptionPane.showMessageDialog(null, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
				dispose();
				return;
			}
			Recipe recipe = new Recipe(nameField.getText(), descriptionField.getText(), directionsField.getText()); 

			for(int i=0; i<ingredientFields.size(); i++)
				recipe.setIngredient(ingredientFields.get(i).getText());

			list.add(recipe);		 
			listModel.addElement(nameField.getText());

			listNames.setModel(listModel);
			listNames.setSelectedIndex(list.size()-1);

			//saveList(list);

			dispose();			
		}

	}


	/**
	 * Third inner class listener that waits for the "more ingredients"
	 * button to be pressed and adds more textfields
	 */

	public class moreIngredientsListener implements ActionListener {

		/**
		 * Listens for the "more ingredients" button to be clicked and
		 * then performs the corresponding action
		 * @param arg0 ActionEvent of the "more ingredients"
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ingredientFields.add(new JTextField());
			form.add(ingredientFields.get(ingredientFields.size()-1));

			form.revalidate();
			form.repaint();
			pack();
		}

	}

	/**
	 * for debugging purposes - gets onscreen location of the JButton "Add to List"
	 */
	public Point getAddToListButtonLoc(){
		return button.getLocationOnScreen();
	}

	/**
	 * for debugging purposes - gets onscreen location of the JButton "More Ingredients"
	 */
	public Point getMoreIngredientsButtonLoc(){
		return button2.getLocationOnScreen();
	}

	/**
	 * for debugging purposes - gets onscreen location of the JTextField "name"
	 */
	public Point getNameFieldLoc() {
		return nameField.getLocationOnScreen();
	}

}
