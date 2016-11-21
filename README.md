#CS56 Recipe Manager

A GUI application to manage a list of recipes. Recipe Manager allows you to easily create, edit, and save recipes for future use. The user can then read through recipes in a convenient window, and never worry about misplacing recipes in the future.

# Testing Note #

The test classes in this program use the Java Robot class, and rely on using the clipboard to paste text into fields. Since the keyboard shortcut is different on PC and Mac (Control+V or Command+V), our test classes need to take this into account before they are run. Simply update the boolean named 'mac' inside the RecipeAdderTest.java and RecipePanelTest.java classes to reflect your OS.




