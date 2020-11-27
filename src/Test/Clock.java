package Test;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Clock extends GUI {

    Line stunde;
    Line minuten;


    public Group root () {
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
         return root;


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
