package edu.ucsb.cs56.projects.misc.recipe_manager;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by trent on 11/9/2016.
 */
public class RecipeTest {
    @Test
    public void testRecipeConstructor3Params(){
        Recipe testRecipe = new Recipe("testName", "testDescription", "testDirections");
        assertEquals(testRecipe.getName(), "testName");
        assertEquals(testRecipe.getDescription(), "testDescription");
        assertEquals(testRecipe.getDirections(), "testDirections");
    }

    @Test
    public void testRecipeConstructor1Param() {
        Recipe testRecipe = new Recipe("testName");
        assertEquals(testRecipe.getName(), "testName");
    }

    @Test
    public void testImageName(){
        Recipe testRecipe = new Recipe("testName");
        testRecipe.setImageName("testImageName");
        assertEquals(testRecipe.getImageName(), "testImageName");
    }

    @Test
    public void testCompareTo_whenEqual(){
        Recipe testRecipe1 = new Recipe("testName");
        Recipe testRecipe2 = new Recipe("testName");
        assertEquals(testRecipe1.compareTo(testRecipe2), 0);
    }

    @Test
    public void testCompareTo_whenLessThan(){
        Recipe testRecipe1 = new Recipe("AtestName");
        Recipe testRecipe2 = new Recipe("testName");
        assertEquals(testRecipe1.compareTo(testRecipe2), -51);
    }

    @Test
    public void testCompareTo_whenGreaterThan(){
        Recipe testRecipe1 = new Recipe("testName");
        Recipe testRecipe2 = new Recipe("AtestName");
        assertEquals(testRecipe1.compareTo(testRecipe2), 51);
    }

    @Test
    public void testRecipeSetName(){
        Recipe testRecipe = new Recipe("testName");
        testRecipe.setName("newRecipeName");
        assertEquals(testRecipe.getName(), "newRecipeName");
    }

    @Test
    public void testRecipeSetDescription(){
        Recipe testRecipe = new Recipe("testName");
        testRecipe.setDescription("newRecipeDescription");
        assertEquals(testRecipe.getDescription(), "newRecipeDescription");
    }

    @Test
    public void testRecipeSetDirections(){
        Recipe testRecipe = new Recipe("testName");
        testRecipe.setDirections("newRecipeDirections");
        assertEquals(testRecipe.getDirections(), "newRecipeDirections");
    }

    @Test
    public void testRecipeToString(){
        Recipe testRecipe = new Recipe("testName");
        assertEquals(testRecipe.toString(), "testName");
    }

    @Test
    public void testPrintIngredients(){
        Recipe testRecipe = new Recipe("testName");
        testRecipe.setIngredient("apple");
        testRecipe.setDirections("testDirections");
        testRecipe.setDescription("testDescription");
        assertEquals(testRecipe.printRecipe(), "<html>testName<br>testDescription<br><br> Ingredients: " +
                "<br>apple<br><br><br><b> Directions:</b><br>testDirections</html>" );
    }

}
