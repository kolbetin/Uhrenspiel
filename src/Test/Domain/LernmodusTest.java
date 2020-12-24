package Test.Domain;

import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LernmodusTest {

    private Lernmodus lernmodus;
    private Stage stage1;
    private int level;


     /*@BeforeClass        // Executed once, before testing starts
        public static void beforeClass (){

        }*/

        @Before     // Executed before each test
        public void before (){
            lernmodus = new Lernmodus();
            level = 1;
            lernmodus.startLernmodus(stage1,level);
            stage1 = new Stage();
        }

        @Test       // Set Start Time Method Test
        public void setStartTimeTest (){


        lernmodus.setStartTime(level);
        //Assert.assertEquals("01:00", lernmodus.getAnzuzeigendeZeit());
        Assert.assertTrue(lernmodus.getAnzuzeigendeZeit().contains("01:00"));
     }

        @Test       // Set Anzuzeigende Zeit Lernmodus Method Test
        public void setAnzuzeigendeZeitLernmodusLevel1Test (){
        int level = 1;
        lernmodus.setAnzuzeigendeZeitLernmodus(level);
        Assert.assertEquals("01:00", lernmodus.getAnzuzeigendeZeit());

    }


        /*@After      // Executed after each test
        public void after(){
            System.out.println("I'm before each Test method");
        }

        @AfterClass     // Executed once, at the end of testing
        public static void afterClass(){
            System.out.println("I'm after Class method");
        }*/


}
