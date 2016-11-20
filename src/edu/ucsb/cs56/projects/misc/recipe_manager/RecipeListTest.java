package edu.ucsb.cs56.projects.misc.recipe_manager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the IngredientsList class, to confirm correct behavior
 */

public class RecipeListTest {

    Recipe appleSauce;
    Recipe spaghetti;
    Recipe cereal;

    @Before
    public void init(){
        appleSauce = new Recipe("Apple Sauce", "Delicious Red Apple Sauce", "Blend the apples! enjoy.");
        spaghetti = new Recipe("Spaghetti", "Mom's Spaghetti", "Boil the noodles, add sauce.");
        cereal = new Recipe("Cereal", "Classic cereal and milk", "Pour cereal into bowl. Add milk");
    }

    @Test
    public void testEmptyRecipeList() {
        RecipeList empty = new RecipeList();
        assertEquals(empty.size(), 0);
    }

    @Test
    public void testSingleElementRecipeList() {
        RecipeList single = new RecipeList();
        single.add(appleSauce);
        assertEquals(single.size(), 1);
        assertEquals(single.get(0), appleSauce);
        assertEquals(single.get(0).getDescription(), "Delicious Red Apple Sauce");
    }

    @Test
    public void testMultiElementRecipeList() {
        RecipeList multi = new RecipeList();
        multi.add(appleSauce);
        multi.add(spaghetti);
        multi.add(cereal);
        assertEquals(multi.size(), 3);
        assertEquals(multi.get(0), appleSauce);
        assertEquals(multi.get(2), cereal);
        assertEquals(multi.get(2).getDirections(), "\u2022 Pour cereal into bowl<br>\u2022  Add milk<br>");
        assertEquals(multi.get(1).getName(), "Spaghetti");
    }

}
