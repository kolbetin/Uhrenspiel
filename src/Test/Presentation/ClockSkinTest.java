package Test.Presentation;
import javafx.scene.shape.Line;
import org.junit.*;

public class ClockSkinTest {

    ClockSkin clock = new ClockSkin();
    ClockElements clockElements = new ClockElements();
    String anzuzeigendeZeit = "10:30";

        /*@BeforeClass        // Executed once, before testing starts
        public static void beforeClass (){
            System.out.println("I'm before Class method");

        }

        @Before     // Executed before each test
        public void before (){
            System.out.println("I'm before each Test method");
        }*/

        @Test       // Stunden-Parser Method Test
        public void stundenParserTest (){
        clock.createClock(anzuzeigendeZeit);
        boolean sameLine = false;

            if (clock.stunde == clock.parserStunde("10:30")) {
                sameLine = true;
            }
            else{
                sameLine = false;
            }
        Assert.assertTrue(sameLine);
        }

        @Test       // Minuten-Parser Method Test
        public void minutenParserTest (){

            clock.createClock(anzuzeigendeZeit);
            Assert.assertEquals(clock.minute, clock.parserMinuten("30"));
        }



        /*@After      // Executed after each test
        public void after(){
            System.out.println("I'm before each Test method");
        }

        @AfterClass     // Executed once, at the end of testing
        public static void afterClass(){
            System.out.println("I'm after Class method");
        }*/

} // Ende Test Klasse
