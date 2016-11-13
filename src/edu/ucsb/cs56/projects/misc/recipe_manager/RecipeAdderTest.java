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
    private int heightDiff;

    int moreIngredientsButtonX;
    int moreIngredientsButtonY;
    int addToListButtonX;
    int addToListButtonY;
    int nameFieldX;
    int nameFieldY;


    //If testing on a mac, set this true. For PC, set false.
    boolean mac = false;

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
        Dimension orig = adder.getSize();

        refreshWidgetLocations();

        robot.mouseMove(moreIngredientsButtonX, moreIngredientsButtonY);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(50);

        Dimension second = adder.getSize();
        heightDiff = second.height - orig.height;
        robot.delay(100);
    }


    @Test
    public void testMoreIngredientsButton(){

        refreshWidgetLocations();
        Dimension orig = new Dimension(adder.getSize());
        Dimension after = new Dimension(adder.getWidth(), adder.getHeight() + heightDiff);

        //Click "More Ingredients"
        clickMoreIngredients();

        //Confirm that the window increased in size
        assertEquals(adder.getSize(), after);
    }


    @Test
    public void testMoreIngredientsButtonTwice(){
        refreshWidgetLocations();

        Dimension orig = new Dimension(adder.getSize());
        Dimension second = new Dimension(adder.getWidth(), adder.getHeight() + heightDiff);
        Dimension third = new Dimension(adder.getWidth(), adder.getHeight() + 2*heightDiff);

        clickMoreIngredients(); refreshWidgetLocations();

        //Confirm that the window increased in size
        assertEquals(adder.getSize(), second);

        //Click "More Ingredients" again
        clickMoreIngredients();
        refreshWidgetLocations();

        //Confirm a second click increases the window further
        assertEquals(adder.getSize(), third);
    }


    @Test
    public void testMoreIngredientsButtonLots(){
        refreshWidgetLocations();
        Dimension orig = new Dimension(adder.getSize());
        Dimension second = new Dimension(adder.getWidth(), adder.getHeight() + heightDiff);
        Dimension third = new Dimension(adder.getWidth(), adder.getHeight() + 2*heightDiff);
        Dimension sixth = new Dimension(adder.getWidth(), adder.getHeight() + 5*heightDiff);

        clickMoreIngredients(); refreshWidgetLocations();

        //Confirm that the window increased in size
        assertEquals(adder.getSize(), second);

        //Click "More Ingredients" again
        clickMoreIngredients(); refreshWidgetLocations();

        //Confirm a second click increases the window further
        assertEquals(adder.getSize(), third);

        //Click "More Ingredients" three more times
        clickMoreIngredients(); refreshWidgetLocations();
        clickMoreIngredients(); refreshWidgetLocations();
        clickMoreIngredients(); refreshWidgetLocations();

        //Confirm five clicks increases the window properly
        assertEquals(adder.getSize(), sixth);
    }

    @Test
    public void testAddingRecipeNameOnly() {
        //Get current widget locations, type "apples" into name field
        refreshWidgetLocations();
        clickInsideNameField();
        robotType("apples");

        clickAddToList();
        robot.delay(50);
        //Confirm "apples" is the first element in the list
        assertEquals(list.get(0).toString(), "apples");
    }


    @Test
    public void testAddingRecipeNameAndDescription() {
        refreshWidgetLocations();
        clickInsideNameField();

        //Type "apples"
        robotType("apples");

        //Type description : "yum"
        robotTab();
        robotType("yum");

        clickAddToList();

        //Confirm "apples" is the first element in the list
        robot.delay(50);
        assertEquals(list.get(0).toString(), "apples");

        //Confirm the description of this element is "yum"
        assertEquals(list.get(0).getDescription(), "yum");
    }


    @Test
    public void testAddingRecipeNameDescriptionAndDirections() {
        refreshWidgetLocations();
        clickInsideNameField();

        //Type "apples"
        robotType("apples");

        //Type description : "yum"
        robotTab();
        robotType("yum");

        //Type directions : "eat"
        robotTab();
        robotType("eat");

        clickAddToList();

        //Confirm "apples" is the first element in the list
        assertEquals(list.get(0).toString(), "apples");

        //Confirm the description of this recipe is "yum"
        assertEquals(list.get(0).getDescription(), "yum");

        //Confirm the directions of this recipe is "eat"
        assertEquals(list.get(0).getDirections(), "eat");
    }

    @Test
    public void testAddingRecipeNameDescriptionAndDirectionsAnd2Ingredients() {
        refreshWidgetLocations();
        clickInsideNameField();

        //Type "CinnamonApples"
        robotType("CinnamonApples");

        //Type description : "yum"
        robotTab();
        robotType("yum");

        //Type directions : "eat"
        robotTab();
        robotType("eat");

        //Move to "ingredients", add "apples" and "cinnamon"
        robotTab();
        robotType("apples");
        robotTab();
        robotType("cinnamon");

        clickAddToList();

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
    /*
    //TODO:: Fix this test?
    @Test
    public void testAddingRecipeNameDescriptionAndDirectionsAnd7Ingredients() {

        refreshWidgetLocations();
        clickInsideNameField();

        //Type "Cobbler"
        robotType("Cobbler");

        //Type description "tasty"
        robotTab();
        robotType("tasty");

        //Type directions
        robotTab();
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


        //Add extra ingredient, eggs
        clickMoreIngredients();
        robotType("eggs");

        clickAddToList();

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

    private void clickMoreIngredients() {
        robot.mouseMove(moreIngredientsButtonX, moreIngredientsButtonY);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(300);
    }

    private void clickAddToList() {
        robot.mouseMove(addToListButtonX, addToListButtonY);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(50);
    }

    private void clickInsideNameField(){
        robot.mouseMove(nameFieldX, nameFieldY);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(50);
    }

    private void refreshWidgetLocations() {
        moreIngredientsButtonX = adder.getMoreIngredientsButtonLoc().x + 5;
        moreIngredientsButtonY = adder.getMoreIngredientsButtonLoc().y + 5;
        addToListButtonX = adder.getAddToListButtonLoc().x + 5;
        addToListButtonY = adder.getAddToListButtonLoc().y + 5;
        nameFieldX = adder.getNameFieldLoc().x + 5;
        nameFieldY = adder.getNameFieldLoc().y + 5;
    }
}
