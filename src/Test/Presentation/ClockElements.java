/**
 * Die Klasse "ClockElements" enthält alle grafischen Elemente die zur Erstellung aller Uhrenbilder im Uhrenspiel
 * nötig sind. Dies sind im Wesentlichen der äussere und innere Kreis, welche das Ziffernblatt bilden. Die Kreise
 * sowie Nummern 1 bis 12 welche die einzelnen Ziffern ergeben. Die Linien für den Minuten- sowie Stundenzeiger mit
 * den Koordinaten für die anzuzeigende Uhrzeit welche in der Muniten- und Stunden-Map mit dem jeweiligen Uhrzeit-Key
 * als String verknüpft sind.
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */
package Test.Presentation;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.HashMap;
import java.util.Random;

public class ClockElements {

    // Instanzvariablen
    public final HashMap<Integer, Group> ziffernMap = new HashMap<>();
    public final HashMap<String, Line> minutenMap = new HashMap<>();
    public final HashMap<String, Line> stundenMap = new HashMap<>();
    public Circle outerCircle;
    public Circle innerCircle;

    // Kreise und Nummern 1 bis 12 für die Zifferblätter im Uhrenbild
    Circle circle1 = new Circle(366, 182, 25, Color.GREEN);
    Text nummer1 = new Text(358, 192, "1");
    Circle circle2 = new Circle(418, 234, 25, Color.GREEN);
    Text nummer2 = new Text(410, 244, "2");
    Circle circle3 = new Circle(435, 300, 25, Color.RED);
    Text nummer3 = new Text(427, 310, "3");
    Circle circle4 = new Circle(418, 366, 25, Color.GREEN);
    Text nummer4 = new Text(410, 376, "4");
    Circle circle5 = new Circle(366, 418, 25, Color.GREEN);
    Text nummer5 = new Text(358, 428, "5");
    Circle circle6 = new Circle(300, 435, 25, Color.RED);
    Text nummer6 = new Text(292, 445, "6");
    Circle circle7 = new Circle(234, 418, 25, Color.GREEN);
    Text nummer7 = new Text(226, 428, "7");
    Circle circle8 = new Circle(182, 366, 25, Color.GREEN);
    Text nummer8 = new Text(174, 376, "8");
    Circle circle9 = new Circle(165, 300, 25, Color.RED);
    Text nummer9 = new Text(157, 310, "9");
    Circle circle10 = new Circle(182, 234, 25, Color.GREEN);
    Text nummer10 = new Text(167, 244, "10");
    Circle circle11 = new Circle(234, 182, 25, Color.GREEN);
    Text nummer11 = new Text(219, 192, "11");
    Circle circle12 = new Circle(300, 165, 25, Color.RED);
    Text nummer12 = new Text(285, 175, "12");

    // Gruppieren von Kreisen und Nummern zur jeweiligen Ziffer 1 bis 12
    Group ziffer_1 = new Group(circle1, nummer1);
    Group ziffer_2 = new Group (circle2, nummer2);
    Group ziffer_3 = new Group (circle3, nummer3);
    Group ziffer_4 = new Group (circle4, nummer4);
    Group ziffer_5 = new Group (circle5, nummer5);
    Group ziffer_6 = new Group (circle6, nummer6);
    Group ziffer_7 = new Group (circle7, nummer7);
    Group ziffer_8 = new Group (circle8, nummer8);
    Group ziffer_9 = new Group (circle9, nummer9);
    Group ziffer_10 = new Group (circle10, nummer10);
    Group ziffer_11 = new Group (circle11, nummer11);
    Group ziffer_12 = new Group (circle12, nummer12);

    // Gruppieren von allen Ziffern für die erstellung des Uhrenbildes
    public Group ziffern = new Group (ziffer_1,ziffer_2,ziffer_3,ziffer_4,ziffer_5,ziffer_6,ziffer_7,ziffer_8,ziffer_9,ziffer_10,ziffer_11,ziffer_12);


    /*public void createUhrKreise(){
        // Hauptkreise Uhr
        outerCircle = new Circle(300, 300, 160, Color.LIGHTGRAY);
        outerCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        innerCircle = new Circle(300, 300, 6, Color.BLACK);
    }*/

    EventHandler<MouseEvent> eventHandler = getEventHandler();

    EventHandler<MouseEvent> getEventHandler() {
        //Creating the mouse event handler
        return event -> {
            Random rand = new Random();
            double r = rand.nextDouble();
            double g = rand.nextDouble();
            double b = rand.nextDouble();
            Color randomColor = new Color(r, g, b, 1);
            //System.out.println("The color is: " +
            //        randomColor.toString());
            if (event.getSource() instanceof Circle) {
                Circle c = (Circle) event.getSource();
                c.setFill(randomColor);
            }
        };
    }

    /**
     * Der Konstruktor der Klasse ClockElements führt verschiedene Methoden der eigenen Klasse aus um die grafischen
     * Elemente so bereitzustellen damit sie von der Klasse ClockSkin nur noch für den jeweiligen Spielmodus korrekt
     * zusammengebaut werden müssen. Als zentrales Element erstellt er auch die verschiedenen Maps für die Ziffern sowie
     * die Minuten- und Stunden-Linien.
     */
    public ClockElements (){
        //createUhrKreise();
        setupClockElements();
        createZiffernMap();
        createMinutenMap();
        createStundenMap();
    }

    public void setupClockElements(){
        Font nummerFont = new Font("Comic Sans MS", 30);

        nummer1.setFont(nummerFont);
        circle1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer2.setFont(nummerFont);
        circle2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer3.setFont(nummerFont);
        circle3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer4.setFont(nummerFont);
        circle4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer5.setFont(nummerFont);
        circle5.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer6.setFont(nummerFont);
        circle6.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer7.setFont(nummerFont);
        circle7.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer8.setFont(nummerFont);
        circle8.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer9.setFont(nummerFont);
        circle9.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer10.setFont(nummerFont);
        circle10.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer11.setFont(nummerFont);
        circle11.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        nummer12.setFont(nummerFont);
        circle12.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        outerCircle = new Circle(300, 300, 160, Color.LIGHTGRAY);
        outerCircle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        innerCircle = new Circle(300, 300, 6, Color.BLACK);
    }


    public void createZiffernMap() {

        // Kreiert ZiffernMap für mit Ziffernblätter
        ziffernMap.put(1, ziffer_1);
        ziffernMap.put(2, ziffer_2);
        ziffernMap.put(3, ziffer_3);
        ziffernMap.put(4, ziffer_4);
        ziffernMap.put(5, ziffer_5);
        ziffernMap.put(6, ziffer_6);
        ziffernMap.put(7, ziffer_7);
        ziffernMap.put(8, ziffer_8);
        ziffernMap.put(9, ziffer_9);
        ziffernMap.put(10, ziffer_10);
        ziffernMap.put(11, ziffer_11);
        ziffernMap.put(12, ziffer_12);
        // Ziffer key 13 mit Ziffer 1 wird speziell für die Lernmodi mit 30min und 45min benötigt
        ziffernMap.put(13,ziffer_1);
    }


    public void createMinutenMap() {

        // Koordinaten für Minutenzeiger
        Line minuten_30 = new Line(300, 300, 300, 390);
        Line minuten_45 = new Line(300, 300, 210, 300);
        Line minuten_00 = new Line(300, 300, 300, 210);
        Line minuten_15 = new Line(300, 300, 390, 300);
        // HashMap Erstellung für Minuten
        minutenMap.put("30", minuten_30);
        minutenMap.put("45", minuten_45);
        minutenMap.put("00", minuten_00);
        minutenMap.put("15", minuten_15);
    }

    public void createStundenMap() {

        // Linien 12 Uhr
        Line stunde_11_30 = new Line(300, 300, 285, 245);
        Line stunde_11_45 = new Line(300, 300, 290, 240);
        Line stunde_12_00 = new Line(300, 300, 300, 235);
        Line stunde_12_15 = new Line(300, 300, 310, 240);

        // Linien 1 Uhr
        Line stunde_12_30 = new Line(300, 300, 315, 245);
        Line stunde_12_45 = new Line(300, 300, 325, 240);
        Line stunde_01_00 = new Line(300, 300, 330, 245);
        Line stunde_01_15 = new Line(300, 300, 335, 255);

        // Linien 2 Uhr
        Line stunde_01_30 = new Line(300, 300, 340, 260);
        Line stunde_01_45 = new Line(300, 300, 345, 265);
        Line stunde_02_00 = new Line(300, 300, 350, 270);
        Line stunde_02_15 = new Line(300, 300, 355, 280);

        // Linien 3 Uhr
        Line stunde_02_30 = new Line(300, 300, 360, 285);
        Line stunde_02_45 = new Line(300, 300, 360, 290);
        Line stunde_03_00 = new Line(300, 300, 365, 300);
        Line stunde_03_15 = new Line(300, 300, 360, 310);

        // Linien 4 Uhr
        Line stunde_03_30 = new Line(300, 300, 360, 315);
        Line stunde_03_45 = new Line(300, 300, 355, 320);
        Line stunde_04_00 = new Line(300, 300, 350, 330);
        Line stunde_04_15 = new Line(300, 300, 345, 335);

        // Linien 5 Uhr
        Line stunde_04_30 = new Line(300, 300, 340, 340);
        Line stunde_04_45 = new Line(300, 300, 335, 345);
        Line stunde_05_00 = new Line(300, 300, 330, 355);
        Line stunde_05_15 = new Line(300, 300, 325, 360);

        // Linien 6 Uhr
        Line stunde_05_30 = new Line(300, 300, 315, 355);
        Line stunde_05_45 = new Line(300, 300, 310, 360);
        Line stunde_06_00 = new Line(300, 300, 300, 365);
        Line stunde_06_15 = new Line(300, 300, 290, 360);

        // Linien 7 Uhr
        Line stunde_06_30 = new Line(300, 300, 285, 355);
        Line stunde_06_45 = new Line(300, 300, 275, 360);
        Line stunde_07_00 = new Line(300, 300, 270, 355);
        Line stunde_07_15 = new Line(300, 300, 265, 345);

        // Linien 8 Uhr
        Line stunde_07_30 = new Line(300, 300, 260, 340);
        Line stunde_07_45 = new Line(300, 300, 255, 335);
        Line stunde_08_00 = new Line(300, 300, 250, 330);
        Line stunde_08_15 = new Line(300, 300, 245, 320);

        // Linien 9 Uhr
        Line stunde_08_30 = new Line(300, 300, 240, 315);
        Line stunde_08_45 = new Line(300, 300, 240, 310);
        Line stunde_09_00 = new Line(300, 300, 235, 300);
        Line stunde_09_15 = new Line(300, 300, 240, 290);

        // Linien 10 Uhr
        Line stunde_09_30 = new Line(300, 300, 240, 285);
        Line stunde_09_45 = new Line(300, 300, 245, 280);
        Line stunde_10_00 = new Line(300, 300, 250, 270);
        Line stunde_10_15 = new Line(300, 300, 255, 265);

        // Linien 11 Uhr
        Line stunde_10_30 = new Line(300, 300, 260, 260);
        Line stunde_10_45 = new Line(300, 300, 265, 255);
        Line stunde_11_00 = new Line(300, 300, 270, 245);
        Line stunde_11_15 = new Line(300, 300, 275, 240);


        // HashMap Erstellung für Stunde
        stundenMap.put("12:30", stunde_12_30);
        stundenMap.put("12:45", stunde_12_45);
        stundenMap.put("01:00", stunde_01_00);
        stundenMap.put("01:15", stunde_01_15);
        stundenMap.put("01:30", stunde_01_30);
        stundenMap.put("01:45", stunde_01_45);
        stundenMap.put("02:00", stunde_02_00);
        stundenMap.put("02:15", stunde_02_15);
        stundenMap.put("02:30", stunde_02_30);
        stundenMap.put("02:45", stunde_02_45);
        stundenMap.put("03:00", stunde_03_00);
        stundenMap.put("03:15", stunde_03_15);
        stundenMap.put("03:30", stunde_03_30);
        stundenMap.put("03:45", stunde_03_45);
        stundenMap.put("04:00", stunde_04_00);
        stundenMap.put("04:15", stunde_04_15);
        stundenMap.put("04:30", stunde_04_30);
        stundenMap.put("04:45", stunde_04_45);
        stundenMap.put("05:00", stunde_05_00);
        stundenMap.put("05:15", stunde_05_15);
        stundenMap.put("05:30", stunde_05_30);
        stundenMap.put("05:45", stunde_05_45);
        stundenMap.put("06:00", stunde_06_00);
        stundenMap.put("06:15", stunde_06_15);
        stundenMap.put("06:30", stunde_06_30);
        stundenMap.put("06:45", stunde_06_45);
        stundenMap.put("07:00", stunde_07_00);
        stundenMap.put("07:15", stunde_07_15);
        stundenMap.put("07:30", stunde_07_30);
        stundenMap.put("07:45", stunde_07_45);
        stundenMap.put("08:00", stunde_08_00);
        stundenMap.put("08:15", stunde_08_15);
        stundenMap.put("08:30", stunde_08_30);
        stundenMap.put("08:45", stunde_08_45);
        stundenMap.put("09:00", stunde_09_00);
        stundenMap.put("09:15", stunde_09_15);
        stundenMap.put("09:30", stunde_09_30);
        stundenMap.put("09:45", stunde_09_45);
        stundenMap.put("10:00", stunde_10_00);
        stundenMap.put("10:15", stunde_10_15);
        stundenMap.put("10:30", stunde_10_30);
        stundenMap.put("10:45", stunde_10_45);
        stundenMap.put("11:00", stunde_11_00);
        stundenMap.put("11:15", stunde_11_15);
        stundenMap.put("11:30", stunde_11_30);
        stundenMap.put("11:45", stunde_11_45);
        stundenMap.put("12:00", stunde_12_00);
        stundenMap.put("12:15", stunde_12_15);

    }

} // Ende Klasse
