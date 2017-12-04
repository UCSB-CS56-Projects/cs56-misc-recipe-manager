package edu.ucsb.cs56.projects.misc.recipe_manager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * RecipeList represents is an ArrayList of recipes
*/

public class RecipeList extends ArrayList<Recipe> implements Serializable {


	/**
	 * No-arg constructor makes a list with two empty slots
	 */

	RecipeList(){
		// super(2); 
		super();
	}

	/**
	 * One-arg constructor that makes a list with one recipe added
	 * and one empty slot for a recipe
	 * @param r Recipe to be added to the list
	 */

	RecipeList(Recipe r){
		// super(2);
		super();
		add(r);		
	}

	/** TODO: Document and implement this method.. or not.  If not remove this. */
	/*
	public Recipe getRecipeByName(String recipeName) {
	    return null; // Eventually, search through "this" and if any recipe has this name, return it.
	}
	*/
	
}
