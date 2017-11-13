package edu.ucsb.cs56.projects.misc.recipe_manager;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.imageio.ImageIO;
import javax.swing.*;


public class RecipePanelTest {

    //if testing this on pc (or another OS that uses CTRL+V to copy to the clipboard) set false
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
    public void testAddBlankRecipe(){
        // clickOnFile();
        // clickOnAddNewRecipe();
        int size = ContentPane.getRecipeList().size();

        // int addX = (int)ContentPane.getAddRecipeLocation().getX();
        // int addY = (int)ContentPane.getAddRecipeLocation().getY();
        // robot.mouseMove(addX, addY);
        // robot.delay(100);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        clickOnAddNewRecipeButton();
        robot.delay(100);
        for(int x = 0; x < 9; x++){
            robotTab();
        }
        if(mac){
            robotTab();
        }
	    if (mac) robotTab();
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.delay(100);

        // assertEquals(ContentPane.getRecipeList().size(), size+1);


        // assertEquals(ContentPane.getJOptionPane().isVisible(), true);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        // assertEquals(size+1, ContentPane.getRecipeList().size());
        assertEquals(size, ContentPane.getRecipeList().size());

        // clickCancelFromPopup();
        // assertEquals(ContentPane.getRecipeList().size(), size);

    }

    @Test
    public void testDeleteRecipe(){

        // clickOnFile();
        int size = ContentPane.getRecipeList().size();
        // int deleteX = (int)ContentPane.getDeleteRecipeLocation().getX();
        // int deleteY = (int)ContentPane.getDeleteRecipeLocation().getY();
        robot.delay(100);
        assertEquals(size, ContentPane.getRecipeList().size());
        // robot.mouseMove(deleteX, deleteY);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Delete Selected Recipe");
        clickOnDeleteRecipeButton();
        robot.delay(500);

        assertEquals(size-1, ContentPane.getRecipeList().size());

    }


    @Test
    public void testLoadRecipe(){
        // clickOnFile();
        // int loadX = (int)ContentPane.getLoadRecipeLocation().getX();
        // int loadY = (int)ContentPane.getLoadRecipeLocation().getY();
        // robot.mouseMove(loadX, loadY);
        // robot.delay(100);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Load Recipe List");
        clickOnLoadRecipeMenuItem();
        robot.delay(500);
        assertEquals(ContentPane.getFC().isShowing(), true);
        robot.delay(100);
        ContentPane.getFC().cancelSelection();
        assertEquals(ContentPane.getFC().isShowing(), false);
        robot.delay(100);

    }

    @Test
    public void testSaveRecipe(){
        // clickOnFile();
        // int saveX = (int)ContentPane.getSaveRecipeLocation().getX();
        // int saveY = (int)ContentPane.getSaveRecipeLocation().getY();
        // robot.mouseMove(saveX, saveY);
        // robot.delay(100);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Save Recipe List");
        clickOnSaveRecipeListMenuItem();
        robot.delay(1000);
        assertEquals(ContentPane.getFC().isShowing(), true);
        robot.delay(100);
        ContentPane.getFC().cancelSelection();
        assertEquals(ContentPane.getFC().isShowing(), false);
        robot.delay(100);

    }

    //TODO:: Figure out cause of exception for the following 2 image tests
    /*
    @Test
    public void testAddImageToRecipe(){
        clickOnFile();
        robot.delay(100);
        int addImageX = ContentPane.getAddImageLocation().x;
        int addImageY = ContentPane.getAddImageLocation().y;
        robot.mouseMove(addImageX, addImageY);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(500);

        assertEquals(ContentPane.getIc().isShowing(), true);
        assertEquals(ContentPane.getRecipeList().get(0).getRecipeIcon(), null);

        robot.delay(500);
        ContentPane.setImageChooserToImagesFolder();

        if (mac) robotDown();
        robotDown();
        robotEnter();
        robot.delay(500);

        assertFalse(ContentPane.getRecipeList().get(0).getRecipeIcon().equals(null));

    }

    @Test
    public void testAddImageToRecipeAndDelete(){

        clickOnFile();
        robot.delay(100);
        int addImageX = ContentPane.getAddImageLocation().x;
        int addImageY = ContentPane.getAddImageLocation().y;

        robot.mouseMove(addImageX, addImageY);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(500);

        assertEquals(ContentPane.getIc().isShowing(), true);
        assertEquals(ContentPane.getRecipeList().get(0).getRecipeIcon(), null);

        robot.delay(501);
        ContentPane.setImageChooserToImagesFolder();

        if (mac) robotDown();
        robotDown();
        robotEnter();
        robot.delay(500);

        assertFalse(ContentPane.getRecipeList().get(0).getRecipeIcon().equals(null));
        robot.delay(100);

        clickOnFile();
        robot.delay(100);
        int delImageX = ContentPane.getDeleteImageLocation().x;
        int delImageY = ContentPane.getDeleteImageLocation().y;

        robot.mouseMove(delImageX, delImageY);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(500);

        assertEquals(ContentPane.getRecipeList().get(0).getRecipeIcon(), null);

    }*/

    @Test
    public void testSearchIngredient(){
        // clickOnFile();
        // int addX = (int)ContentPane.getSearchIngredientLocation().getX();
        // int addY = (int)ContentPane.getSearchIngredientLocation().getY();
        // robot.mouseMove(addX, addY);
        // robot.delay(100);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Search for Ingredient");
        clickOnSearchForIngredientMenuItem();
        robot.delay(100);
        //System.out.println(JOptionPane.CANCEL_OPTION);
        assertEquals(ContentPane.getJOptionPane().isVisible(), true);
        clickCancelFromPopup();

    }

    @Test
    public void testSearchRecipeLocation(){
        // clickOnFile();
        // int addX = (int)ContentPane.getSearchRecipeLocation().getX();
        // int addY = (int)ContentPane.getSearchRecipeLocation().getY();
        // robot.mouseMove(addX, addY);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Search for Recipe");
        clickOnSearchForRecipeMenuItem();
        robot.delay(100);
        assertEquals(ContentPane.getJOptionIngredientPane().isVisible(), true);
        clickCancelFromPopup();

    }

    @Test
    public void testAddNewRecipeCinnamonApples(){
        // clickOnFile();
        // clickOnAddNewRecipe();
        int size = ContentPane.getRecipeList().size();
        // int addX = (int)ContentPane.getAddRecipeLocation().getX();
        // int addY = (int)ContentPane.getAddRecipeLocation().getY();
        assertEquals(size, ContentPane.getRecipeList().size());
        // robot.mouseMove(addX, addY);
        // robot.delay(100);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Add New Recipe");
        clickOnAddNewRecipeButton();
        robot.delay(300);

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
        // clickOnFile();
        // clickOnAddNewRecipe();
        int size = ContentPane.getRecipeList().size();
        // int addX = (int)ContentPane.getAddRecipeLocation().getX();
        // int addY = (int)ContentPane.getAddRecipeLocation().getY();
        assertEquals(size, ContentPane.getRecipeList().size());
        // robot.mouseMove(addX, addY);
        // robot.delay(100);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Add New Recipe");
        clickOnAddNewRecipeButton();
        robot.delay(300);

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

        robot.delay(100);
        // clickOnFile();
        // int deleteX = (int)ContentPane.getDeleteRecipeLocation().getX();
        // int deleteY = (int)ContentPane.getDeleteRecipeLocation().getY();
        // robot.delay(100);
        // robot.mouseMove(deleteX, deleteY);
        // robot.delay(100);
        // robot.mousePress(mask);
        // robot.mouseRelease(mask);
        // clickOnUIButton("Delete Selected Recipe");
        clickOnDeleteRecipeButton();
        robot.delay(500);
        assertEquals(size, ContentPane.getRecipeList().size());
    }


    /** TODO: Implement Search Ingredient and Search recipe test after pre loaded recipe fix. */


    public void clickOnFile(){
        robot.delay(100);
        int x = (int)ContentPane.getFileMenuLocation().getX();
        int y = (int)ContentPane.getFileMenuLocation().getY();
        robot.mouseMove(x,y);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(300);
    }

    // public void clickOnUIButton(String name) {
    //     robot.delay(100);
    //     int x = (int)ContentPane.getButtonLoc(name).getX();;
    //     int y = (int)ContentPane.getButtonLoc(name).getY();;
    //     robot.mouseMove(x, y);
    //     robot.mousePress(mask);
    //     robot.mouseRelease(mask);
    //     robot.delay(100);
    // }

    public void clickOnAddNewRecipeButton() {
        robot.delay(100);
        int x = (int)ContentPane.getAddNewRecipeButtonLocation().getX();
        int y = (int)ContentPane.getAddNewRecipeButtonLocation().getY();
        robot.mouseMove(x,y);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
    }

    public void clickOnDeleteRecipeButton() {
        robot.delay(100);
        int x = (int)ContentPane.getDeleteRecipeButtonLocation().getX();
        int y = (int)ContentPane.getDeleteRecipeButtonLocation().getY();
        robot.mouseMove(x,y);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
    }

    public void clickOnLoadRecipeMenuItem() {
        robot.delay(100);
        clickOnFile();
        int x = (int)ContentPane.getLoadRecipeListMenuItemLocation().getX();
        int y = (int)ContentPane.getLoadRecipeListMenuItemLocation().getY();
        robot.mouseMove(x,y);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100); 
    }

    public void clickOnSaveRecipeListMenuItem() {
        robot.delay(100);
        clickOnFile();
        int x = (int)ContentPane.getSaveRecipeListMenuItemLocation().getX();
        int y = (int)ContentPane.getSaveRecipeListMenuItemLocation().getY();
        robot.mouseMove(x,y);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
    }

    public void clickOnSearchForRecipeMenuItem() {
        robot.delay(100);
        clickOnFile();
        int x = (int)ContentPane.getSearchForRecipeMenuItemLocation().getX();
        int y = (int)ContentPane.getSearchForRecipeMenuItemLocation().getY();
        robot.mouseMove(x,y);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
    }

    public void clickOnSearchForIngredientMenuItem() {
        robot.delay(100);
        clickOnFile();
        int x = (int)ContentPane.getSearchForIngredientMenuItemLocation().getX();
        int y = (int)ContentPane.getSearchForIngredientMenuItemLocation().getY();
        robot.mouseMove(x,y);
        robot.delay(100);
        robot.mousePress(mask);
        robot.mouseRelease(mask);
        robot.delay(100);
    }

    public void clickCancelFromPopup(){
        robot.delay(100);
        robotTab();
        if(!mac) {
            robot.delay(100);
            robotTab();
        }
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }

    private void robotTab(){
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(100);
    }

    private void robotDown(){
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.delay(100);
    }

    private void robotEnter(){
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(100);
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
        robot.delay(100);
    }
}
