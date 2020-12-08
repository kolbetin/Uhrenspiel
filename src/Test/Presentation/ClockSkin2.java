package Test.Presentation;

import Test.Presentation.image.ClockElements;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ClockSkin2 {

    // Variable für alle Grafikelemente der Uhr
    private ClockElements clockElements;

    // Variablen für Stunden- & Minutenzeiger
    Line stunde;
    Line minute;

    // Konstruktor nimmt Parameter anzuzeigende Zeit entgegen zur kompletten Erstellung der Uhr
    public ClockSkin2(String anzuzeigendeZeit) {
        clock(anzuzeigendeZeit);
    }

    // Konstruktor nimmt Parameter anzuzeigende Zeit sowie ziffernblatt entgegen für einzelnen Aufbau der Ziffern
    public ClockSkin2(String anzuzeigendeZeit, int zifferblatt) {
        clockElements = new ClockElements();
        clockLerningMode(anzuzeigendeZeit, zifferblatt);
    }

    public Node clock(String anzuzeigendeZeit) {

        clockElements.createMinutenMap();
        clockElements.createStundenMap();

        this.stunde = parserStunde(anzuzeigendeZeit);
        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));

        // Zeiger Formatierung - transfer in CSS File
        stunde.setStrokeWidth(5);
        minute.setStroke(Color.RED);
        minute.setStrokeWidth(5);

        return createClock();
    }


    public Node clockLerningMode (String anzuzeigendeZeit, int ziffernblatt){

        return createClock(); // ersetzen mit LearningMode Clock Skin
    }

    public Node createClock() {

        // Kreiert Hauptgruppe und fügt dieser der Node clockSkin hinzu
        Group root = new Group (clockElements.createGrundgeruest(), clockElements.ziffern, stunde, minute);
        // Group root = new Group(circleGroup, nummerGroup, uhrZeiger);
        Node clockSkin = root;
        //Displaying the contents of the stage
        return clockSkin;
    }

    public Line parserMinuten(String minuten) {
        return clockElements.minutenMap.get(minuten);
    }

    public Line parserStunde(String stunde) {
        return clockElements.stundenMap.get(stunde);
    }

}  // Ende Klasse