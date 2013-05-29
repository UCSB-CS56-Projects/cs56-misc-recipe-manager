package edu.ucsb.cs56.S12.m_a_p.cp3;

import java.io.Serializable;
import java.util.ArrayList;

/** RecipeList represents a list of recipes

*/
public class RecipeList extends ArrayList<Recipe> implements Serializable {

	
	/**
    no-arg constructor makes a list with two empty slots
	 */	
	RecipeList(){
		super(2); 
	}
	
	/**
    one-recipe-arg constructor makes a list with one recipe added and one slot empty 
	 */	
	RecipeList(Recipe r){
		super(2);
		add(r);
		
	}

	/** TODO: Document and implement this method.. or not.  If not remove this. */
	public Recipe getRecipeByName(String recipeName) {
	    return null; // Eventually, search through "this" and if any recipe has this name, return it.
	}
	
}
