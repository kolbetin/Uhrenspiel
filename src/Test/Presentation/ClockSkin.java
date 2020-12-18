package Test.Presentation;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ClockSkin {

    // Variable für alle Grafikelemente der Uhr
    private ClockElements clockElements;

    // Variablen für Stunden- & Minutenzeiger
    Line stunde;
    Line minute;

    // Konstruktor
    public ClockSkin() {

    }

    public Node createClock(String anzuzeigendeZeit) {

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        stunde.setStrokeWidth(5); // move to CSS File

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        minute.setStroke(Color.RED); // move to CSS File
        minute.setStrokeWidth(5); // move to CSS File

        // Kreiert Hauptgruppe und fügt dieser der Node clockSkin hinzu
        Group root = new Group (clockElements.outerCircle, clockElements.ziffern, stunde, minute, clockElements.innerCircle);
        clockElements.outerCircle.toBack();
        clockElements.innerCircle.toFront();
        stunde.toFront();
        Node clockSkin = root;
        return clockSkin;
    }

    public Node clockLerningClock (String anzuzeigendeZeit, int anzuzeigendeZiffer){

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        stunde.setStrokeWidth(5); // move to CSS File

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        minute.setStroke(Color.RED); // move to CSS File
        minute.setStrokeWidth(5); // move to CSS File

        Group ziffer = parserZiffern(anzuzeigendeZiffer);
        Group ziffer2 = parserZiffern(anzuzeigendeZiffer+1);

        if (anzuzeigendeZeit.substring(3,5).contains("00")) {

            if (anzuzeigendeZiffer != 12) {
                Group root = new Group(clockElements.outerCircle, clockElements.ziffer_12, stunde, minute, clockElements.innerCircle, ziffer);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            } else {
                Group root = new Group(clockElements.outerCircle, stunde, minute, clockElements.innerCircle, ziffer);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            }
        }

        if (anzuzeigendeZeit.substring(3,5).contains("15")) {

            if (anzuzeigendeZiffer != 3) {
                Group root = new Group(clockElements.outerCircle, clockElements.ziffer_3, stunde, minute, clockElements.innerCircle, ziffer);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            } else {
                Group root = new Group(clockElements.outerCircle, stunde, minute, clockElements.innerCircle, ziffer);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            }
        }

        if (anzuzeigendeZeit.substring(3,5).contains("30")) {

            if (anzuzeigendeZiffer != 5 && anzuzeigendeZiffer != 6 ) {
                Group root = new Group(clockElements.outerCircle, clockElements.ziffer_6, stunde, minute, clockElements.innerCircle, ziffer, ziffer2);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            } else {
                Group root = new Group(clockElements.outerCircle, stunde, minute, clockElements.innerCircle, ziffer, ziffer2);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            }
        }

        if (anzuzeigendeZeit.substring(3,5).contains("45")) {

            if (anzuzeigendeZiffer != 9) {
                Group root = new Group(clockElements.outerCircle, clockElements.ziffer_9, stunde, minute, clockElements.innerCircle, ziffer2);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            } else {
                Group root = new Group(clockElements.outerCircle, stunde, minute, clockElements.innerCircle, ziffer2);
                Node learningClock = root;
                finalFormatSettings();
                return learningClock;
            }
        }

        return null;
    } // Ende Methode clockLearningClock


    public Line parserMinuten(String minuten) {
        return clockElements.minutenMap.get(minuten);
    }

    public Line parserStunde(String stunde) {
        return clockElements.stundenMap.get(stunde);
    }

    public Group parserZiffern(int ziffer){
        return clockElements.ziffernMap.get(ziffer);
    }

    public void finalFormatSettings(){
        clockElements.outerCircle.toBack();
        clockElements.innerCircle.toFront();
        stunde.toFront();
    }

}  // Ende Klasse