package Test.Presentation;
import javafx.scene.Node;
import org.junit.*;

public class ClockSkinTest {

    ClockSkin clock = new ClockSkin();
    String anzuzeigendeZeit = "01:15";

        @BeforeClass        // Executed once, before testing starts
        public static void beforeClass (){
            System.out.println("I'm beforeClass method");
        }

        @Before     // Executed before each test
        public void before (){
            System.out.println("I'm before method");
        }

        @Test       // Stunden-Parser Method Test
        public void stundenParserTest (){

        clock.createClock(anzuzeigendeZeit);
        Assert.assertEquals(01, clock.stunde);
        }

        @Test       // Minuten-Parser Method Test
        public void minutenParserTest (){

            clock.createClock(anzuzeigendeZeit);
            Assert.assertEquals(15, clock.minute);
        }



        @Test     // Test Case 2
        public void test2 (){
            System.out.println("I'm Test Case 2 method");
        }

        @After      // Executed after each test
        public void after(){
            System.out.println("I'm after method");
        }

        @AfterClass     // Executed once, at the end of testing
        public static void afterClass(){
            System.out.println("I'm after Class method");
        }

}
