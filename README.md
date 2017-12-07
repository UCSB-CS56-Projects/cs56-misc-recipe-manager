# CS56 Recipe Manager #

A GUI application to manage a list of recipes. Recipe Manager allows you to easily create, edit, and save recipes for future use. The user can then read through recipes in a convenient window, and never worry about misplacing recipes in the future.

# Testing Note #

The test classes in this program use the Java Robot class, and rely on using the clipboard to paste text into fields. Since the keyboard shortcut is different on PC and Mac (Control+V or Command+V), our test classes need to take this into account before they are run. Simply update the boolean named 'mac' inside the RecipeAdderTest.java and RecipePanelTest.java classes to reflect your OS.

# F17 Final Remarks #

## Code Structure ##
* Interface.java: Main method. Sets up JFrame and launches GUI.

* IngredientsList.java, Recipe.java, RecipeList.java: Core classes. Each represents an element of the recipe manager. Self-explanatory.

* RecipeAdder.java, RecipePanel.java: GUI classes. RecipeAdder is the window that pops up when user clicks File -> Add New Recipe. RecipePanel is the main window of the RecipeManager. These two classes encompass the entirety of the GUI.

* IngredientsListTest.java, RecipeListTest.java, RecipeAdderTest.java, RecipePanelTest.java. Self-explanatory test classes.

## Current program functionality ##

The code as is launches a GUI window with two sample recipes. The user can add and remove recipes, which adds to and removes from RecipeList.java. The shortcuts for these are [DELETE] and [N](to add new recipe). A recipe consists of a name, a description, directions, ingredients, and an image. When a user saves a recipe list, it is serialized and saved as a .txt file. The user can save and load various recipe lists, and additionally can select a saved recipe list to load on program startup (rather than the samples).

## Bugs ##
1. Image tests in RecipePanelTest.java (currently commented out) are generating exceptions despite passing
2. Behavior of the searching functions is limited
3. Keyboard shortcuts may bug out after playing with it a bit
4. Newlines are interpreted using HTML's <br/> instead of '\n'
5. Test coverage is somewhat limited

With some bug fixes and new features (see issues on main repo), this could be a flawless recipe manager.
