package edu.ucsb.cs56.projects.misc.recipe_manager;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;


import javax.swing.JFrame;


public class RecipePanelTest {

    boolean mac = false;


    JFrame frame;
    int mask = InputEvent.BUTTON1_DOWN_MASK;
    RecipePanel ContentPane;
    private Robot robot;

    @Before
    public void init() {
        frame = new JFrame();
        ContentPane = new RecipePanel();

        frame.setContentPane(ContentPane);
        frame.setSize(800,600); //width 800, height 600
        frame.setVisible(true);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddNewRecipe(){
        // robot.mouseMove();
        // System.out.println(ContentPane.get);
        clickOnFile();
        int addX = (int)ContentPane.getAddRecipeLocation().getX();
        int addY = (int)ContentPane.getAddRecipeLocation().getY();
        robot.mouseMove(addX, addY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
        assertEquals(ContentPane.getAdderWindow().isActive(), true);
    }

    @Test
    public void testDeleteRecipe(){
        clickOnFile();
        int size = ContentPane.getRecipeList().size();
        int deleteX = (int)ContentPane.getDeleteRecipeLocation().getX();
        int deleteY = (int)ContentPane.getDeleteRecipeLocation().getY();
        assertEquals(size, ContentPane.getRecipeList().size());
        robot.mouseMove(deleteX, deleteY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
        assertEquals(size-1, ContentPane.getRecipeList().size());
    }

    @Test
    public void testLoadRecipe(){
        clickOnFile();
        int loadX = (int)ContentPane.getLoadRecipeLocation().getX();
        int loadY = (int)ContentPane.getLoadRecipeLocation().getY();
        robot.mouseMove(loadX, loadY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(1000);
        assertEquals(ContentPane.getFC().isShowing(), true);
        robot.delay(100);
        ContentPane.getFC().cancelSelection();
        assertEquals(ContentPane.getFC().isShowing(), false);
        robot.delay(100);
    }

    @Test
    public void testSaveRecipe(){
        clickOnFile();
        int saveX = (int)ContentPane.getSaveRecipeLocation().getX();
        int saveY = (int)ContentPane.getSaveRecipeLocation().getY();
        robot.mouseMove(saveX, saveY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(1000);
        assertEquals(ContentPane.getFC().isShowing(), true);
        robot.delay(100);
        ContentPane.getFC().cancelSelection();
        assertEquals(ContentPane.getFC().isShowing(), false);
        robot.delay(100);
    }

    @Test
    public void testSearchIngredient(){
        clickOnFile();
        int addX = (int)ContentPane.getSearchIngredientLocation().getX();
        int addY = (int)ContentPane.getSearchIngredientLocation().getY();
        robot.mouseMove(addX, addY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
       // System.out.println(JOptionPane.CANCEL_OPTION);
        assertEquals(ContentPane.getJOptionPane().isVisible(), true);
        clickBoxCancel();
    }

    @Test
    public void testSearchRecipeLocation(){
        clickOnFile();
        int addX = (int)ContentPane.getSearchRecipeLocation().getX();
        int addY = (int)ContentPane.getSearchRecipeLocation().getY();
        robot.mouseMove(addX, addY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
        assertEquals(ContentPane.getJOptionIngredientPane().isVisible(), true);
        clickBoxCancel();
    }

    @Test
    public void testAddNewRecipeCinnamonApples(){
        clickOnFile();
        int size = ContentPane.getRecipeList().size();
        int addX = (int)ContentPane.getAddRecipeLocation().getX();
        int addY = (int)ContentPane.getAddRecipeLocation().getY();
        assertEquals(size, ContentPane.getRecipeList().size());
        robot.mouseMove(addX, addY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);

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

        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(100);
        assertEquals(size+1, ContentPane.getRecipeList().size());

    }

    @Test
    public void testAddAndDeleteRecipe(){
        clickOnFile();
        int size = ContentPane.getRecipeList().size();
        int addX = (int)ContentPane.getAddRecipeLocation().getX();
        int addY = (int)ContentPane.getAddRecipeLocation().getY();
        assertEquals(size, ContentPane.getRecipeList().size());
        robot.mouseMove(addX, addY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);

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

        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robotTab();
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(100);
        assertEquals(size+1, ContentPane.getRecipeList().size());

        robot.delay(100);
        clickOnFile();
        int deleteX = (int)ContentPane.getDeleteRecipeLocation().getX();
        int deleteY = (int)ContentPane.getDeleteRecipeLocation().getY();
        robot.delay(100);
        robot.mouseMove(deleteX, deleteY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.delay(100);
        robot.mouseRelease(mask);
        robot.delay(100);
        assertEquals(size, ContentPane.getRecipeList().size());
    }

    @Test
    public void testAddNewRecipeAndSearch(){

    }


    /** TODO: Implement Search Ingredient and Search recipe test after pre loaded recipe fix. */
    /*re

     */

    public void clickOnFile(){
        robot.delay(100);
        int fileX = (int)ContentPane.getFileButtonLoc().getX();
        int fileY = (int)ContentPane.getFileButtonLoc().getY();
        robot.mouseMove(fileX, fileY);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
    }

    public void clickBoxCancel(){
        robot.delay(100);
        robotTab();
        if(!mac) {
            robot.delay(100);
            robotTab();
        }
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_SPACE);
}

    private void robotTab(){
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(50);
    }

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

}
