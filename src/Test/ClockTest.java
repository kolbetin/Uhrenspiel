package Test;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class ClockTest extends Application {


    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        EventHandler<MouseEvent> eventHandler = getEventHandler();
// Drawing a Circle and registering the event handler
        Circle circle12 = new Circle(300, 165, 25, Color.RED);
        circle12.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle2 and registering the event handler
        Circle circle1 = new Circle(345, 210, 25, Color.GREEN);
        circle1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle2 and registering the event handler
        Circle circle2 = new Circle(390, 255, 25, Color.GREEN);
        circle2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle3 and registering the event handler
        Circle circle3 = new Circle(435, 300, 25,Color.RED);
        circle3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle4 and registering the event handler
        Circle circle4 = new Circle(390, 335, 25,Color.GREEN);
        circle4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle5 and registering the event handler
        Circle circle5 = new Circle(345, 390, 25,Color.GREEN);
        circle5.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle6 and registering the event handler
        Circle circle6 = new Circle(300, 435, 25,Color.RED);
        circle6.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle7 and registering the event handler
        Circle circle7 = new Circle(255, 390, 25,Color.GREEN);
        circle7.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle8 and registering the event handler
        Circle circle8 = new Circle(210, 345, 25,Color.GREEN);
        circle8.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle9 and registering the event handler
        Circle circle9 = new Circle(165, 300, 25,Color.RED);
        circle9.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle10 and registering the event handler
        Circle circle10 = new Circle(210, 255, 25,Color.GREEN);
        circle10.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a Circle11 and registering the event handler
        Circle circle11 = new Circle(255, 210, 25,Color.GREEN);
        circle11.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
// Drawing a HelpCircle and registering the event handler
       // Circle circleMiddle = new Circle(300, 300, 10,Color.RED);
        //circleMiddle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

// Setting the text with coordinates
        Text text = new Text(150, 50, "Test Uhr");
// Setting the font of the text and setting the color of the text
        text.setFont(Font.font(null, FontWeight.BOLD, 15));
        text.setFill(Color.CRIMSON);
// Creating a Group object and a scene object
        Group root = new Group(circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10, circle11, circle12, text);
        Scene scene = new Scene(root, 600, 600);
// Setting the fill color to the scene and the title
        scene.setFill(Color.LAVENDER);
        stage.setTitle("Event Filters Example");
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

