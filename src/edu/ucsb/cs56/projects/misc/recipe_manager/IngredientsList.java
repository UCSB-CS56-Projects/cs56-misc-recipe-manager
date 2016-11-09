package edu.ucsb.cs56.projects.misc.recipe_manager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * IngredientList is a list of ingredients
 */
public class IngredientsList extends ArrayList<String> implements Serializable {

	/**
	 * No argument constructor for IngredientList
	 */
	 public IngredientsList() {
		    super(1); // we want capacity at least 1
	 }

	/**
	 * One argument constructor that takes in a string
	 * @param r ingredient to add to the list
	 */

	public IngredientsList(String r) {
		super(1); // we want capacity at least 1 
		this.add(0,r);
	}
}
