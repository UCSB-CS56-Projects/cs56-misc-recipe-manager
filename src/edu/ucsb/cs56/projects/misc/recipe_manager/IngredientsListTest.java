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
}
