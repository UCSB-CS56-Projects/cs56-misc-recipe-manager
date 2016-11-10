package edu.ucsb.cs56.projects.misc.recipe_manager;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class RecipeAdderTest {

    RecipeList list;
    private Robot robot;
    int mask = InputEvent.BUTTON1_DOWN_MASK;
    private RecipeAdder adder;

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
        robot.delay(100);
        robot.mousePress(mask);
        robot.delay(200);
        robot.mouseRelease(mask);
        robot.delay(100);
        //Confirm that the window increased in size
        assertEquals(adder.getSize(), after);
    }

    @Test
    public void testMoreIngredientsButtonNumber2(){
        Dimension orig = new Dimension(515,411);
        Dimension second = new Dimension(515,439);
        Dimension third = new Dimension(515, 467);

        //Click "More Ingredients"
        assertEquals(adder.getSize(), orig);
        robot.mouseMove(300,400);
        robot.delay(100);
        robot.mousePress(mask);
        robot.delay(200);
        robot.mouseRelease(mask);
        robot.delay(100);
        //Confirm that the window increased in size
        assertEquals(adder.getSize(), second);

        robot.mouseMove(300,428);
        robot.delay(100);
        robot.mousePress(mask);
        robot.delay(200);
        robot.mouseRelease(mask);
        robot.delay(100);
        //Confirm a second click increases the window further
        assertEquals(adder.getSize(), third);
    }

    @Test
    public void testAddingRecipeNameOnly() {
        //Type "apples"
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_P);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_P);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_L);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_S);
        robot.delay(25);

        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.delay(25);
        robot.mouseRelease(mask);
        robot.delay(100);

        //Confirm "apples" is the first element in the list
        assertEquals(list.get(0).toString(), "apples");
    }



    @Test
    public void testAddingRecipeNameAndDescription() {
        //Type "apples"
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_P);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_P);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_L);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_S);
        robot.delay(25);

        //Move to "description"
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Type "yum"
        robot.keyPress(KeyEvent.VK_Y);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_Y);
        robot.keyPress(KeyEvent.VK_U);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_M);


        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.delay(25);
        robot.mouseRelease(mask);
        robot.delay(100);

        //Confirm "apples" is the first element in the list
        assertEquals(list.get(0).toString(), "apples");

        //Confirm the description of this element is "yum"
        assertEquals(list.get(0).getDescription(), "yum");
    }

    @Test
    public void testAddingRecipeNameDescriptionAndDirections() {
        //Type "apples"
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_P);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_P);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_L);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_S);
        robot.delay(25);

        //Move to "description"
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Type "yum"
        robot.keyPress(KeyEvent.VK_Y);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_Y);
        robot.keyPress(KeyEvent.VK_U);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_M);

        //Move to "directions"
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Type "eat"
        robot.keyPress(KeyEvent.VK_E);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_T);
        robot.delay(25);
        robot.keyRelease(KeyEvent.VK_T);

        //Click "Add to list"
        robot.mouseMove(200, 400);
        robot.mousePress(mask);
        robot.delay(25);
        robot.mouseRelease(mask);
        robot.delay(100);

        //Confirm "apples" is the first element in the list
        assertEquals(list.get(0).toString(), "apples");

        //Confirm the description of this recipe is "yum"
        assertEquals(list.get(0).getDescription(), "yum");

        //Confirm the directions of this recipe is "eat"
        assertEquals(list.get(0).getDirections(), "eat");
    }

}
