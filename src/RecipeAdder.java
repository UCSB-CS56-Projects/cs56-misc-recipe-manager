package edu.ucsb.cs56.S12.m_a_p.cp3;

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

/** RecipeAdder is a frame with text areas to enter information about a new recipe 

 */
public class RecipeAdder extends JFrame {
	Recipe newRecipe = new Recipe("");

	JTextField nameField, descriptionField, directionsField;
	ArrayList<JTextField> ingredientFields  = new ArrayList<JTextField>();

	RecipeList list; 
	DefaultListModel listModel;
	JList listNames;
	Form form;

	/** 
	three-arg constructor that takes in the current list data and sets up the JFrame and components 
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

		JButton button = new JButton("Add to list");
		button.addActionListener(saveListener);

		JButton button2 = new JButton("More Ingredients");
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
	inner class form sets up all the text fields so the usser can enter the recipe info
	 */
	
	@SuppressWarnings("serial")
	public class Form extends JPanel {
		JLabel[] labels;
		JComponent[] fields;
		int fieldNum = 0;

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

		}//end no-arg constructor
		
		
		/** 
		helper function that add all text fields to the form
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
	inner class that listens for the user to push the "add recipe" button
	 */
	public class bottonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
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
	inner class listener that waits for the more ingredients button to be pressed and adds more textfields 
	 */
	public class moreIngredientsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ingredientFields.add(new JTextField());
			form.add(ingredientFields.get(ingredientFields.size()-1));

			form.revalidate();
			form.repaint();
			pack();
		}

	}



}
