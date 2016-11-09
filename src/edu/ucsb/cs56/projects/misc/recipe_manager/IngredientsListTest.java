package edu.ucsb.cs56.projects.misc.recipe_manager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the IngredientsList class, to confirm correct behavior
 */

public class IngredientsListTest {
    
    @Test
    public void testEmptyIngredientsList() {
        IngredientsList empty = new IngredientsList();
        assertEquals(empty.size(), 0);
    }

    @Test
    public void testSingleElementIngredientsList() {
        IngredientsList single = new IngredientsList();
        single.add("Carrots");
        assertEquals(single.size(), 1);
        assertEquals(single.get(0), "Carrots");
    }

    @Test
    public void testMultiElementIngredientsList() {
        IngredientsList single = new IngredientsList();
        single.add("Carrots");
        single.add("Onions");
        single.add("Celery");
        assertEquals(single.size(), 3);
        assertEquals(single.get(0), "Carrots");
        assertEquals(single.get(1), "Onions");
        assertEquals(single.get(2), "Celery");
    }

}
