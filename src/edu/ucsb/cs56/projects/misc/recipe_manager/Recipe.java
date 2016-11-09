package edu.ucsb.cs56.projects.misc.recipe_manager;

import java.io.Serializable;
import javax.swing.ImageIcon;


/**
 * Recipe represents all the information in a recipe object
 */
public class Recipe implements Comparable<Recipe>, Serializable {


	private static final long serialVersionUID = 1L;

	private String name;
	private IngredientsList ingredientlist = new IngredientsList();
	private String description;
	private String directions;
	private String imageName;
	//private ImageIcon recipeIcon;

	/**
	 * A constructor that takes the name, description, and
	 * directions as prerameters and adds them to the Recipe
	 * @param Name String of the name of the recipe
	 * @param Description String of the description of the recipe
	 * @param Directions String of the directions of the recipe
	 */

	public Recipe(String Name, String Description, String Directions){
		this.name = Name;
		this.description = Description;
		this.directions = Directions;
	}

	public String getImageName(){
	    return imageName;
	}
	public void setImageName(String imageName){
	    this.imageName=imageName;
	}
	//ublic void setRecipeIcon(ImageIcon image){this.recipeIcon = image;}
	//public ImageIcon getRecipeIcon(){return recipeIcon;}

	/**
	 * One argument constructor that takes in the
	 * name of the recipe
	 * @param name String of the name of the recipe
	 */

	public Recipe(String name){
		this.name = name;
	}

	/**
	 * Method to compare if two recipes are equal
	 * @param r recipe to be compared to
	 * @return return 0 if equal, a positive if not
	 */

	public int compareTo(Recipe r) {
		return name.compareTo(r.getName());
	}

	/**
	 * Getter method for the recipe name
	 * @return String of the recipe name
	 */

	public String getName() {
		return name;
	}

	/**
	 * Setter method for the recipe name
	 * @param name String of the new recipe name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for the recipe description
	 * @return String of the recipe description
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * Setter method for the recipe description
	 * @param Description String of the new recipe description
	 */

	public void setDescription(String Description) {
		this.description = Description;
	}

	/**
	 * Getter method for the recipe directions
	 * @return String of the recipe directions
	 */

	public String getDirections() {
		return directions;
	}

	/**
	 * Setter method for the recipe directions
	 * @param Directions String of the new recipe directions
	 */

	public void setDirections(String Directions) {
		this.directions = Directions;
	}

	/**
	 * Getter method for an IngredientList
	 * @return the IngredientList object
	 */

	public IngredientsList getList(){
		return ingredientlist;
	}

	/**
	 * Setter method to add an Ingredient
	 * @param ingredient String of the ingredient to be added
	 */

	public void setIngredient(String ingredient){
		ingredientlist.add(ingredient);
	}

	/**
	 * toString method for the Recipe class
	 * @return String of the name of the recipe
	 */

	public String toString() {
		return name;
	}

	/**
	 * Private helper method for printRecipe
	 * @return String of an ingredient
	 */
	private String printIngredients(){
		String ret = "";

		for(String s : ingredientlist)
			ret+= s + "<br>";

			return ret;     
	}

	/**
	 * Method to print the recipe
	 * @return String of the recipe
	 */

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
