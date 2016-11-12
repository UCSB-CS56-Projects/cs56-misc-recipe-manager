package edu.ucsb.cs56.projects.misc.recipe_manager;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;


public class RecipeAdderTest {

    RecipeList list;
    private Robot robot;
    int mask = InputEvent.BUTTON1_DOWN_MASK;
    private RecipeAdder adder;

    //If testing on a mac, set this true. For PC, set false.
    boolean mac = true;

    @Before
    public void init() {
        list = new RecipeList();
        DefaultListModel listModel = new DefaultListModel();
        JList jlist = new JList();
        adder = new RecipeAdder(list,listModel,jlist);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMoreIngredientsButton(){
        Dimension orig = new Dimension(515,411);
        Dimension after = new Dimension(515,439);

        //Click "More Ingredients"
        assertEquals(adder.getSize(), orig);
        robot.mouseMove(300,400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);

        //Confirm that the window increased in size
        assertEquals(adder.getSize(), after);
    }

    @Test
    public void testMoreIngredientsButtonTwice(){
        Dimension orig = new Dimension(515,411);
        Dimension second = new Dimension(515,439);
        Dimension third = new Dimension(515, 467);

        //Click "More Ingredients"
        assertEquals(adder.getSize(), orig);
        robot.mouseMove(300,400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);

        //Confirm that the window increased in size
        assertEquals(adder.getSize(), second);

        //Click "More Ingredients" again
        robot.mouseMove(300,428);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(50);

        //Confirm a second click increases the window further
        assertEquals(adder.getSize(), third);
    }

    @Test
    public void testAddingRecipeNameOnly() {
        robotType("apples");

        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);

        //Confirm "apples" is the first element in the list
        robot.delay(50);
        assertEquals(list.get(0).toString(), "apples");
    }



    @Test
    public void testAddingRecipeNameAndDescription() {
        //Type "apples"
        robotType("apples");

        //Move to "description"
        robotTab();

        //Type "yum"
        robotType("yum");

        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);

        //Confirm "apples" is the first element in the list
        robot.delay(50);
        assertEquals(list.get(0).toString(), "apples");

        //Confirm the description of this element is "yum"
        assertEquals(list.get(0).getDescription(), "yum");
    }

    @Test
    public void testAddingRecipeNameDescriptionAndDirections() {
        //Type "apples"
        robotType("apples");

        //Move to "description"
        robotTab();

        //Type "yum"
        robotType("yum");

        //Move to "directions"
        robotTab();

        //Type "eat"
        robotType("eat");

        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(50);

        //Confirm "apples" is the first element in the list
        assertEquals(list.get(0).toString(), "apples");

        //Confirm the description of this recipe is "yum"
        assertEquals(list.get(0).getDescription(), "yum");

        //Confirm the directions of this recipe is "eat"
        assertEquals(list.get(0).getDirections(), "eat");
    }

    @Test
    public void testAddingRecipeNameDescriptionAndDirectionsAnd2Ingredients() {
        //Type "apples"
        robotType("CinnamonApples");

        //Move to "description"
        robotTab();

        //Type "yum"
        robotType("yum");

        //Move to "directions"
        robotTab();

        //Type "eat"
        robotType("eat");

        //Move to "ingredients", add "apples" and "cinnamon"
        robotTab();
        robotType("apples");
        robotTab();
        robotType("cinnamon");

        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(50);

        //Confirm "apples" is the first element in the list
        assertEquals(list.get(0).toString(), "CinnamonApples");
        //Confirm the description of this recipe is "yum"
        assertEquals(list.get(0).getDescription(), "yum");
        //Confirm the directions of this recipe is "eat"
        assertEquals(list.get(0).getDirections(), "eat");
        //Confirm the IngredientsList contains "apples" and "cinnamon"
        assertEquals(list.get(0).getList().get(0), "apples");
        assertEquals(list.get(0).getList().get(1), "cinnamon");
    }

    //TODO:: Fix this test?
    /*@Test
    public void testAddingRecipeNameDescriptionAndDirectionsAnd7Ingredients() {

        //Type "Cobbler"
        robotType("Cobbler");

        //Move to "description"
        robotTab();

        //Type "tasty"
        robotType("tasty");

        //Move to "directions"
        robotTab();

        //Type directions
        robotType("Mix the ingredients. Bake at 350.");

        //Move to "ingredients", add "apples", "cinnamon", "peaches", "sugar", "butter", "batter"
        robotTab();
        robotType("apples");

        robotTab();
        robotType("cinnamon");

        robotTab();
        robotType("peaches");

        robotTab();
        robotType("sugar");

        robotTab();
        robotType("butter");

        robotTab();
        robotType("batter");


        //Click "More Ingredients"
        robot.mouseMove(300,400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
        robotType("eggs");

        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);

        //Confirm "Cobbler" is the name of the recipe
        assertEquals(list.get(0).toString(), "Cobbler");
        //Confirm the description of this recipe is "yum"
        assertEquals(list.get(0).getDescription(), "yum");
        //Confirm the directions of this recipe is "eat"
        assertEquals(list.get(0).getDirections(), "eat");
        //Confirm the IngredientsList contains "apples", "cinnamon", "peaches", "sugar", "butter", "batter", "eggs", size 7
        assertEquals(list.get(0).getList().size(), 7);
        assertEquals(list.get(0).getList().get(0), "apples");
        assertEquals(list.get(0).getList().get(1), "cinnamon");
        assertEquals(list.get(0).getList().get(2), "peaches");
        assertEquals(list.get(0).getList().get(3), "sugar");
        assertEquals(list.get(0).getList().get(4), "butter");
        assertEquals(list.get(0).getList().get(5), "batter");
        assertEquals(list.get(0).getList().get(6), "eggs");

    }*/

    //Helper function to type with robot
    private void robotType(String word) {
        StringSelection stringSelection = new StringSelection(word);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        if (mac) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
        }
        else {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
        robot.delay(50);
    }

    private void robotTab(){
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(50);
    }
}
