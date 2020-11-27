package Test;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;

public class ClockTest extends Application {

    Line stunde;
    Line minuten;

    // Koordinaten für Minutenzeiger
    Line minuten_volleStunde = new Line (300,300,300,200);
    Line minuten_viertelNach = new Line (300,300,400,300);
    Line minuten_viertelVor = new Line (300,300, 200, 300);
    Line minuten_halbeStunde = new Line (300,300, 300, 400);

    // Koordinaten Stunde 1 Uhr
    Line stunde_1 = new Line (300,300,345,220);
    Line stunde_viertelVor_1 = new Line (300,300,335,215);
    Line stunde_viertelNach_1 = new Line (300,300,355,225);
    Line stunde_halb_1 = new Line (300,300,325,210);

    // Koordinaten Stunde 2 Uhr
    Line stunde_2 = new Line (300,300,380,255);
    Line stunde_viertelVor_2 = new Line (300,300,375,245);
    Line stunde_viertelNach_2 = new Line (300,300,385,265);
    Line stunde_halb_2 = new Line (300,300,365,235);

    // Koordinaten Stunde 3 Uhr
    Line stunde_3 = new Line (300,300,390,300);
    Line stunde_viertelVor_3 = new Line (300,300,390,285);
    Line stunde_viertelNach_3 = new Line(300,300,390,315);
    Line stunde_halb_3 = new Line (300,300,395,275);

    // Koordinaten Stunde 4 Uhr
    Line stunde_4 = new Line (300,300,380,345);
    Line stunde_viertelVor_4 = new Line (300,300,385,335);
    Line stunde_viertelNach_4 = new Line (300,300,375,355);
    Line stunde_halb_4 = new Line (300,300,395,325);

    // Koordinaten Stunde 5 Uhr
    Line stunde_5 = new Line (300,300,345,380);
    Line stunde_viertelVor_5 = new Line (300,300,355,375);
    Line stunde_viertelNach_5 = new Line(300,300,335,385);
    Line stunde_halb_5 = new Line (300,300,365,365);

    // Koordinaten Stunde 6 Uhr
    Line stunde_6 = new Line (300,300,300,390);
    Line stunde_viertelVor_6 = new Line (300,300,315,390);
    Line stunde_viertelNach_6 = new Line(300,300,285,390);
    Line stunde_halb_6 = new Line (300,300,325,400);

    // Koordinaten Stunde 7 Uhr
    Line stunde_7 = new Line (300,300,255,380);
    Line stunde_viertelVor_7 = new Line (300,300,265,385);
    Line stunde_viertelNach_7 = new Line(300,300,245,375);
    Line stunde_halb_7 = new Line (300,300,275,400);

    // Koordinaten Stunde 8 Uhr
    Line stunde_8 = new Line (300,300,220,345);
    Line stunde_viertelVor_8 = new Line (300,300,225,355);
    Line stunde_viertelNach_8 = new Line (300,300,215,335);
    Line stunde_halb_8 = new Line (300,300,235,365);

    // Koordinaten Stunde 9 Uhr
    Line stunde_9 = new Line (300,300,210,300);
    Line stunde_viertelVor_9 = new Line (300,300,390,315);
    Line stunde_viertelNach_9 = new Line(300,300,390,285);
    Line stunde_halb_9 = new Line (300,300,205,325);

    // Koordinaten Stunde 10 Uhr
    Line stunde_10 = new Line (300,300,220,255);
    Line stunde_viertelVor_10 = new Line (300,300,215,265);
    Line stunde_viertelNach_10 = new Line (300,300,225,245);
    Line stunde_halb_10 = new Line (300,300,205,275);

    // Koordinaten Stunde 11 Uhr
    Line stunde_11 = new Line (300,300,255,220);
    Line stunde_viertelVor_11 = new Line (300,300,245,225);
    Line stunde_viertelNach_11 = new Line(300,300,265,215);
    Line stunde_halb_11 = new Line (300,300,235,235);

    // Koordinaten Stunde 12 Uhr
    Line stunde_12 = new Line (300,300,300,210);
    Line stunde_viertelVor_12 = new Line (300,300,285,210);
    Line stunde_viertelNach_12 = new Line(300,300,315,200);
    Line stunde_halb_12 = new Line (300,300,275,200);


    public ClockTest (){

        //this.stunde = stunde;
        // this.minuten = minuten;

        this.stunde = stunde_1;
        this.minuten = minuten_volleStunde;

    }

    @Override
    public void start(Stage stage) {
        EventHandler<MouseEvent> eventHandler = getEventHandler();

        // Layout to transfer in CSS File
        Font nummerFont = new Font("Comic Sans MS", 30);
        Circle outerCircle = new Circle(300, 300,160, Color.LIGHTGRAY);
        outerCircle.toBack();
        Circle innerCircle = new Circle(300,300,5, Color.BLACK);
        innerCircle.toFront();
        // Drawing a Circle12 and registering the event handler
        Circle circle12 = new Circle(300, 165, 25, Color.RED);
        Text nummer12 = new Text(285,175,"12");
        nummer12.setFont(nummerFont);
        circle12.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle1 and registering the event handler
        Circle circle1 = new Circle(366, 182, 25, Color.GREEN);
        Text nummer1 = new Text(358,192,"1");
        nummer1.setFont(nummerFont);
        circle1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle2 and registering the event handler
        Circle circle2 = new Circle(418, 234, 25, Color.GREEN);
        Text nummer2 = new Text(410,244,"2");
        nummer2.setFont(nummerFont);
        circle2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle3 and registering the event handler
        Circle circle3 = new Circle(435, 300, 25,Color.RED);
        Text nummer3 = new Text(427,310,"3");
        nummer3.setFont(nummerFont);
        circle3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle4 and registering the event handler
        Circle circle4 = new Circle(418, 366, 25,Color.GREEN);
        Text nummer4 = new Text(410,376,"4");
        nummer4.setFont(nummerFont);
        circle4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle5 and registering the event handler
        Circle circle5 = new Circle(366, 418, 25,Color.GREEN);
        Text nummer5 = new Text(358,428,"5");
        nummer5.setFont(nummerFont);
        circle5.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle6 and registering the event handler
        Circle circle6 = new Circle(300, 435, 25,Color.RED);
        Text nummer6 = new Text(292,445,"6");
        nummer6.setFont(nummerFont);
        circle6.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle7 and registering the event handler
        Circle circle7 = new Circle(234, 418, 25,Color.GREEN);
        Text nummer7 = new Text(226,428,"7");
        nummer7.setFont(nummerFont);
        circle7.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle8 and registering the event handler
        Circle circle8 = new Circle(182, 366, 25,Color.GREEN);
        Text nummer8 = new Text(174,376,"8");
        nummer8.setFont(nummerFont);
        circle8.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle9 and registering the event handler
        Circle circle9 = new Circle(165, 300, 25,Color.RED);
        Text nummer9 = new Text(157,310,"9");
        nummer9.setFont(nummerFont);
        circle9.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle10 and registering the event handler
        Circle circle10 = new Circle(182, 234, 25,Color.GREEN);
        Text nummer10 = new Text(167,244,"10");
        nummer10.setFont(nummerFont);
        circle10.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle11 and registering the event handler
        Circle circle11 = new Circle(234, 182, 25,Color.GREEN);
        Text nummer11 = new Text(219,192,"11");
        nummer11.setFont(nummerFont);
        circle11.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        // Setting Stroke Formats
        stunde.setStrokeWidth(5);
        minuten.setStroke(Color.RED);
        minuten.setStrokeWidth(5);

        // Setting titel text
        //Text text = new Text(300, 150, "Uhr");
        // Setting the font of the text and setting the color of the text
        //text.setFont(Font.font(null, FontWeight.BOLD, 15));
        //text.setFill(Color.CRIMSON);

        // Kreiert Uhr Grafik Gruppierungen
        Group circleGroup = new Group(outerCircle, circle1,circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10, circle11, circle12, innerCircle);
        Group nummerGroup = new Group (nummer1, nummer2, nummer3, nummer4, nummer5, nummer6, nummer7, nummer8, nummer9,nummer10, nummer11, nummer12);
        Group uhrZeiger = new Group (stunde, minuten, innerCircle);

        // Kreiert Hauptgruppe & Scene
        Group root = new Group (circleGroup, nummerGroup,uhrZeiger);
        Scene scene = new Scene(root,600,600);

        // Setting the fill color to the scene and the title
        scene.setFill(Color.LAVENDER);
        stage.setTitle("Event Filters Example");
        //scene.getStylesheets().add  (Test.class.getResource("clock.css").toExternalForm());
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    EventHandler<MouseEvent> getEventHandler () {
        //Creating the mouse event handler
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Random rand = new Random();
                double r = rand.nextDouble();
                double g = rand.nextDouble();
                double b = rand.nextDouble();
                Color randomColor = new Color(r, g, b,1);
                System.out.println("The color is: " +
                        randomColor.toString());
                if (event.getSource() instanceof Circle) {
                    Circle c = (Circle) event.getSource();
                    c.setFill(randomColor);
                }
            }
        };
    }
}