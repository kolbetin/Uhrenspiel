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
        createClock(anzuzeigendeZeit);
    }

    // Konstruktor nimmt Parameter anzuzeigende Zeit sowie ziffernblatt entgegen für einzelnen Aufbau der Ziffern
    public ClockSkin2(String anzuzeigendeZeit, int zifferblatt) {
        clockElements = new ClockElements();
        clockLerningMode(anzuzeigendeZeit, zifferblatt);
    }

    public Node createClock(String anzuzeigendeZeit) {

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        stunde.setStrokeWidth(5); // move to CSS File

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        minute.setStroke(Color.RED); // move to CSS File
        minute.setStrokeWidth(5); // move to CSS File

        // Kreiert Hauptgruppe und fügt dieser der Node clockSkin hinzu
        Group root = new Group (clockElements.uhrKreise, clockElements.ziffern, stunde, minute);
        Node clockSkin = root;
        //Displaying the contents of the stage
        return clockSkin;

        //return createClock();
    }

    public Node clockLerningMode (String anzuzeigendeZeit, int anzuzeigendeZiffer){

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        stunde.setStrokeWidth(5);

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        minute.setStroke(Color.RED); // move to CSS File
        minute.setStrokeWidth(5); // move to CSS File

        Group ziffer = parserZiffern(anzuzeigendeZiffer);

        // Kreiert Hauptgruppe und fügt diese der Node learningClock hinzu
        Group root = new Group (clockElements.uhrKreise,clockElements.ziffer12, stunde, minute, ziffer);
        Node learningClock = root;

        return learningClock;
    }

    /*public Node createClock() {

        // Kreiert Hauptgruppe und fügt dieser der Node clockSkin hinzu
        Group root = new Group (clockElements.grundgeruest, clockElements.ziffern, stunde, minute);
        // Group root = new Group(circleGroup, nummerGroup, uhrZeiger);
        Node clockSkin = root;
        //Displaying the contents of the stage
        return clockSkin;
    }*/

    public Line parserMinuten(String minuten) {
        return clockElements.minutenMap.get(minuten);
    }

    public Line parserStunde(String stunde) {
        return clockElements.stundenMap.get(stunde);
    }

    public Group parserZiffern(int ziffer){
        return clockElements.ziffernMap.get(ziffer);
    }

}  // Ende Klasse