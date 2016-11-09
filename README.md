#CS56 Recipe Manager

A GUI application to manage a list of recipes. Recipe Manager allows you to easily create, edit, and save recipes for future use. The user can then read through recipes in a convenient window, and never worry about misplacing recipes in the future.

* Everything below this line was written by a previous student

# MODERATOR NOTE
The problem that I see with this project is that the package structure is in the old Mantis format 
of organizing code. Thus, everything is of the package `edu.ucsb.cs56.S12.m_a_p.cp3;`. When I tried to 
convert this to the new github project structure `edu.cs56.projects.misc.recipe_manager` I came 
across an error because of the way the current code is written. The problem occurs at **line 265 of
RecipePanel.java**

`recipes = (RecipeList) is.readObject();`

What this line does is read in some previously saved recipes in the file **list.ser** .
The problem is that this is a serialized object that was created with the __*old*__ package structure, yet we want to load it into the same
class under the __*new*__ package structure. This issue has been discussed on stackoverflow:

http://stackoverflow.com/questions/5305473/how-to-deal-with-a-java-serialized-object-whose-package-changed

Now, the best solution would be to just create a new list.ser file with the new package structure... but when I try to temporarily comment out the loading of the old serialized list, or when I try to locally create a list to pass into the "recipe list", I get other Java exceptions. What I want to do is just be able to run the GUI with the new package structure, create some simple recipes, and save a new list.ser file, to use in the future. Or the code could be refactored to simply read in the recipes in JSON, XML, or txt format.

## Moderator TODO
Two options

* fix bug when trying to run GUI under new package structure, then save new list.ser file
* OR, (harder) refactor the code to load in previously saved recipes with another format, i.e. JSON, XML, etc.

Maybe the second one could be given to some students as a refactoring project, but I think it would be pretty tough. 





