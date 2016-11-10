package edu.ucsb.cs56.projects.misc.recipe_manager;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class RecipePanelTest {

    //robot.mouseMove(20,60); //move mouse to "File"

    private Robot robot;

    @Before
    public void init() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){

    }

}
