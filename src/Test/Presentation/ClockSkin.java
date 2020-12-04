package Test.Presentation;

import Test.Test;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Random;

public class ClockSkin {


    // set up Hashmap mit String Key, Line Value für Minuten
    private HashMap<String, Line> minutenMap = new HashMap<>();
    private HashMap<String, Line> stundenMap = new HashMap<>();


    // Lineien Variablen für Stunde & Minuten zur Übergabe an createClockSkin() Methode
    Line stunde;
    Line minuten;

    public ClockSkin(String anzuzeigendeZeit) {
        clock(anzuzeigendeZeit);
    }

    public Node clock(String anzuzeigendeZeit) {

        createMinuteMap();
        createStundenMap();

        String substringMinuten = anzuzeigendeZeit.substring(3);

        this.stunde = parserStunde(anzuzeigendeZeit);
        this.minuten = parserMinuten(substringMinuten);

        System.out.println(anzuzeigendeZeit);
        System.out.println(substringMinuten);
        System.out.println(stunde);
        System.out.println(minuten);

        return createClock();
    }


    public Node createClock() {

        EventHandler<MouseEvent> eventHandler = getEventHandler();

        // Layout to transfer in CSS File
        Font nummerFont = new Font("Comic Sans MS", 30);
        Circle outerCircle = new Circle(300, 300, 160, Color.LIGHTGRAY);
        outerCircle.toBack();
        Circle innerCircle = new Circle(300, 300, 5, Color.BLACK);
        innerCircle.toFront();

        // Drawing a Circle1 and registering the event handler
        Circle circle1 = new Circle(366, 182, 25, Color.GREEN);
        Text nummer1 = new Text(358, 192, "1");
        nummer1.setFont(nummerFont);
        circle1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle2 and registering the event handler
        Circle circle2 = new Circle(418, 234, 25, Color.GREEN);
        Text nummer2 = new Text(410, 244, "2");
        nummer2.setFont(nummerFont);
        circle2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle3 and registering the event handler
        Circle circle3 = new Circle(435, 300, 25, Color.RED);
        Text nummer3 = new Text(427, 310, "3");
        nummer3.setFont(nummerFont);
        circle3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle4 and registering the event handler
        Circle circle4 = new Circle(418, 366, 25, Color.GREEN);
        Text nummer4 = new Text(410, 376, "4");
        nummer4.setFont(nummerFont);
        circle4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle5 and registering the event handler
        Circle circle5 = new Circle(366, 418, 25, Color.GREEN);
        Text nummer5 = new Text(358, 428, "5");
        nummer5.setFont(nummerFont);
        circle5.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle6 and registering the event handler
        Circle circle6 = new Circle(300, 435, 25, Color.RED);
        Text nummer6 = new Text(292, 445, "6");
        nummer6.setFont(nummerFont);
        circle6.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle7 and registering the event handler
        Circle circle7 = new Circle(234, 418, 25, Color.GREEN);
        Text nummer7 = new Text(226, 428, "7");
        nummer7.setFont(nummerFont);
        circle7.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle8 and registering the event handler
        Circle circle8 = new Circle(182, 366, 25, Color.GREEN);
        Text nummer8 = new Text(174, 376, "8");
        nummer8.setFont(nummerFont);
        circle8.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle9 and registering the event handler
        Circle circle9 = new Circle(165, 300, 25, Color.RED);
        Text nummer9 = new Text(157, 310, "9");
        nummer9.setFont(nummerFont);
        circle9.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle10 and registering the event handler
        Circle circle10 = new Circle(182, 234, 25, Color.GREEN);
        Text nummer10 = new Text(167, 244, "10");
        nummer10.setFont(nummerFont);
        circle10.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle11 and registering the event handler
        Circle circle11 = new Circle(234, 182, 25, Color.GREEN);
        Text nummer11 = new Text(219, 192, "11");
        nummer11.setFont(nummerFont);
        circle11.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        // Drawing a Circle12 and registering the event handler
        Circle circle12 = new Circle(300, 165, 25, Color.RED);
        Text nummer12 = new Text(285, 175, "12");
        nummer12.setFont(nummerFont);
        circle12.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        // Setting Stroke Formats
        stunde.setStrokeWidth(5);
        minuten.setStroke(Color.RED);
        minuten.setStrokeWidth(5);

        // Kreiert Uhr Grafik Gruppierungen
        Group circleGroup = new Group(outerCircle, circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10, circle11, circle12, innerCircle);
        Group nummerGroup = new Group(nummer1, nummer2, nummer3, nummer4, nummer5, nummer6, nummer7, nummer8, nummer9, nummer10, nummer11, nummer12);
        Group uhrZeiger = new Group(stunde, minuten, innerCircle);

        // Kreiert Hauptgruppe und fügt dieser der Node clockSkin hinzu
        Group root = new Group(circleGroup, nummerGroup, uhrZeiger);
        Node clockSkin = root;

        //Displaying the contents of the stage
        return clockSkin;
    }

    EventHandler<MouseEvent> getEventHandler() {
        //Creating the mouse event handler
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Random rand = new Random();
                double r = rand.nextDouble();
                double g = rand.nextDouble();
                double b = rand.nextDouble();
                Color randomColor = new Color(r, g, b, 1);
                System.out.println("The color is: " +
                        randomColor.toString());
                if (event.getSource() instanceof Circle) {
                    Circle c = (Circle) event.getSource();
                    c.setFill(randomColor);
                }
            }
        };
    }

    public Line parserMinuten(String minuten) {
        return minutenMap.get(minuten);
    }
    public Line parserStunde(String stunde) {
        return stundenMap.get(stunde);
    }

    public void createMinuteMap() {

        // Koordinaten für Minutenzeiger
        Line minuten_volleStunde = new Line(300, 300, 300, 200);
        Line minuten_viertelNach = new Line(300, 300, 400, 300);
        Line minuten_viertelVor = new Line(300, 300, 200, 300);
        Line minuten_halbeStunde = new Line(300, 300, 300, 400);

        // Initialisierung Key, Value Werte in minutenMap
        minutenMap.put("00", minuten_volleStunde);
        minutenMap.put("15", minuten_viertelNach);
        minutenMap.put("30", minuten_halbeStunde);
        minutenMap.put("45", minuten_viertelVor);
    }

    public void createStundenMap() {

        // Linien Koordinaten für Stunde 1 Uhr
        Line stunde_12_45 = new Line(300, 300, 335, 215);
        Line stunde_12_30 = new Line(300, 300, 325, 210);
        Line stunde_01_00 = new Line(300, 300, 345, 220);
        Line stunde_01_15 = new Line(300, 300, 355, 225);
        //  HashMap Erstellung für Stunde 1 Uhr
        stundenMap.put("12:30", stunde_12_30);
        stundenMap.put("12:45", stunde_12_45);
        stundenMap.put("01:00", stunde_01_00);
        stundenMap.put("01:15", stunde_01_15);

        // Koordinaten Stunde 2 Uhr
        private Line stunde_01_30 = new Line(300, 300, 365, 235);
        private Line stunde_01_45 = new Line(300, 300, 375, 245);
        private Line stunde_02_00 = new Line(300, 300, 380, 255);
        private Line stunde_02_15 = new Line(300, 300, 385, 265);
        //  HashMap Erstellung für Stunde 2 Uhr
        stundenMap.put("01:30", stunde_01_30);
        stundenMap.put("01:45", stunde_01_45);
        stundenMap.put("02:00", stunde_02_00);
        stundenMap.put("02:15", stunde_02_15);


        // Koordinaten Stunde 3 Uhr
        private Line stunde_3 = new Line(300, 300, 390, 300);
        private Line stunde_viertelVor_3 = new Line(300, 300, 390, 285);
        private Line stunde_viertelNach_3 = new Line(300, 300, 390, 315);
        private Line stunde_halb_3 = new Line(300, 300, 395, 275);

        // Koordinaten Stunde 4 Uhr
        private Line stunde_4 = new Line(300, 300, 380, 345);
        private Line stunde_viertelVor_4 = new Line(300, 300, 385, 335);
        private Line stunde_viertelNach_4 = new Line(300, 300, 375, 355);
        private Line stunde_halb_4 = new Line(300, 300, 395, 325);

        // Koordinaten Stunde 5 Uhr
        private Line stunde_5 = new Line(300, 300, 345, 380);
        private Line stunde_viertelVor_5 = new Line(300, 300, 355, 375);
        private Line stunde_viertelNach_5 = new Line(300, 300, 335, 385);
        private Line stunde_halb_5 = new Line(300, 300, 365, 365);

        // Koordinaten Stunde 6 Uhr
        private Line stunde_6 = new Line(300, 300, 300, 390);
        private Line stunde_viertelVor_6 = new Line(300, 300, 315, 390);
        private Line stunde_viertelNach_6 = new Line(300, 300, 285, 390);
        private Line stunde_halb_6 = new Line(300, 300, 325, 400);

        // Koordinaten Stunde 7 Uhr
        private Line stunde_7 = new Line(300, 300, 255, 380);
        private Line stunde_viertelVor_7 = new Line(300, 300, 265, 385);
        private Line stunde_viertelNach_7 = new Line(300, 300, 245, 375);
        private Line stunde_halb_7 = new Line(300, 300, 275, 400);

        // Koordinaten Stunde 8 Uhr
        private Line stunde_8 = new Line(300, 300, 220, 345);
        private Line stunde_viertelVor_8 = new Line(300, 300, 225, 355);
        private Line stunde_viertelNach_8 = new Line(300, 300, 215, 335);
        private Line stunde_halb_8 = new Line(300, 300, 235, 365);

        // Koordinaten Stunde 9 Uhr
        private Line stunde_9 = new Line(300, 300, 210, 300);
        private Line stunde_viertelVor_9 = new Line(300, 300, 390, 315);
        private Line stunde_viertelNach_9 = new Line(300, 300, 390, 285);
        private Line stunde_halb_9 = new Line(300, 300, 205, 325);

        // Koordinaten Stunde 10 Uhr
        private Line stunde_10 = new Line(300, 300, 220, 255);
        private Line stunde_viertelVor_10 = new Line(300, 300, 215, 265);
        private Line stunde_viertelNach_10 = new Line(300, 300, 225, 245);
        private Line stunde_halb_10 = new Line(300, 300, 205, 275);

        // Koordinaten Stunde 11 Uhr
        private Line stunde_11 = new Line(300, 300, 255, 220);
        private Line stunde_viertelVor_11 = new Line(300, 300, 245, 225);
        private Line stunde_viertelNach_11 = new Line(300, 300, 265, 215);
        private Line stunde_halb_11 = new Line(300, 300, 235, 235);

        // Koordinaten Stunde 12 Uhr
        private Line stunde_12 = new Line(300, 300, 300, 210);
        private Line stunde_viertelVor_12 = new Line(300, 300, 285, 210);
        private Line stunde_viertelNach_12 = new Line(300, 300, 315, 200);
        private Line stunde_halb_12 = new Line(300, 300, 275, 200);


    }

}
