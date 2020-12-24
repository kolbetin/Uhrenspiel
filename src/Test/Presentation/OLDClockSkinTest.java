package Test.Presentation;
import javafx.scene.shape.Line;
import org.junit.*;

public class OLDClockSkinTest {

    private ClockSkin clock = new ClockSkin();
    private ClockElements clockElements = new ClockElements();
    private String anzuzeigendeZeit = "10:30";

       /*@BeforeClass        // Executed once, before testing starts
        public static void beforeClass (){

        }

        @Before     // Executed before each test
        public void before (){


        }*/

        @Test       // Stunden-Parser Method Test
        public void stundenParserTest (){

            clock.createClock(anzuzeigendeZeit);
            Line expectedStunde = clockElements.stundenMap.get("10");
            Line actualStunde = clock.parserStunde(anzuzeigendeZeit);
            boolean sameLine = false;

            if (expectedStunde == actualStunde) {
                sameLine = true;
            }
            else{
                sameLine = false;
            }

            Assert.assertTrue(sameLine);
        }

    // set-up FX Test
        @Test       // Minuten-Parser Method Test
        public void minutenParserTest (){
            clock.createClock("10:30");
            Line expectedMinute = clockElements.minutenMap.get("30");
            Line actualMinute = clock.parserMinuten(anzuzeigendeZeit);

            Assert.assertEquals(expectedMinute.getStartX(),actualMinute.getStartX(),0.01);

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
