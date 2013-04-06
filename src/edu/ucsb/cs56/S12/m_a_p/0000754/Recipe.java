package edu.ucsb.cs56.S12.m_a_p.cp3;

import java.io.Serializable;


/** 
Recipe represents all the information in a recipe
 */
public class Recipe implements Comparable<Recipe>, Serializable {


	private static final long serialVersionUID = 1L;

	private String name;
	private IngredientsList ingredientlist = new IngredientsList();
	private String description;
	private String directions;
	
	
	/** 
	a constructor that takes the names description and directions as prerameters and adds them to the Recipe
	 */
	public Recipe(String name, String Description, String Directions){
		this.name = name;
		this.description = Description;
		this.directions = Directions;

	}

	/** 
	one arg constructor that just adds the name
	 */
	public Recipe(String name){
		this.name = name;
	}

	public int compareTo(Recipe r) {
		return name.compareTo(r.getName());
	}

	public String getName() {
		return name;
	}   

	public void setName(String name) {
		this.name = name;
	} 

	public String getDescription() {
		return description;
	}   

	public void setDescription(String Description) {
		this.description = Description;
	} 

	public String getDirections() {
		return directions;
	} 

	public void setDirections(String Directions) {
		this.directions = Directions;
	} 

	public IngredientsList getList(){
		return ingredientlist;
	}

	public void setIngredient(String ingredient){
		ingredientlist.add(ingredient);
	}

	public String toString() {
		return name;
	}

	private String printIngredients(){
		String ret = "";

		for(String s : ingredientlist)
			ret+= s + "<br>";

			return ret;     
	}

	public String printRecipe(){

		return "<html>" +
				this.getName() + 
				"<br>" + this.getDescription() +
				"<br><br> Ingredients: <br>" +
				this.printIngredients() +
				"<br><br><b> Directions:</b><br>" +
				this.getDirections() +
				"</html>";

	}
}
