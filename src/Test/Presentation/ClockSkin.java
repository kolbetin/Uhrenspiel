/**
 * Die Klasse ClockSkin nimmt Angaben zur anzuzeigenden Zeit als String entgegen und erstellt
 * das gewünschte Uhrenbild für alle Spielmodi im Uhrenspiel.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */

package Test.Presentation;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ClockSkin {

    // Instanzvariablen
    private ClockElements clockElements; // Beinhaltet Grafikelemente das Uhrenbild (ClockSkin)
    Line stunde; // Variable für den Stundenzeiger
    Line minute; // Variable für den Minutenzeiger

    /**
     * Konstruktor für Objekte der Klasse ClockSkin
     */
    public ClockSkin() {

    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     *
     * @param  anzuzeigendeZeit - Übergibt einen String mit der Uhrzeit im Format "12:30"
     * @return  Gibt das zusammengesetzte Uhrenbild als Typ Node "clockSkin" zurück
     */
    public Node createClock(String anzuzeigendeZeit) {

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        stunde.setStrokeWidth(5); // move to CSS File

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        minute.setStroke(Color.RED); // move to CSS File
        minute.setStrokeWidth(4); // move to CSS File

        // Kreiert Hauptgruppe und fügt dieser der Node clockSkin hinzu
        Group clock = new Group (clockElements.outerCircle, clockElements.ziffern, stunde, minute, clockElements.innerCircle);
        clockElements.outerCircle.toBack();
        clockElements.innerCircle.toFront();
        stunde.toFront();
        Node clockSkin = clock;
        return clockSkin;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     *
     * @param anzuzeigendeZeit- Übergibt einen String mit der Uhrzeit im Format "12:30"
     * @param anzuzeigendeZiffer - Übergibt einen Integer mit der Zahl der jeweil anzuzeigenden Ziffer in der Lernuhr
     * @return  Gibt das zusammengesetzte Lern-Uhrenbild als Typ Node "lerningClock" zurück
     */
    public Node clockLerningClock (String anzuzeigendeZeit, int anzuzeigendeZiffer){

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        stunde.setStrokeWidth(5); // move to CSS File

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        minute.setStroke(Color.RED); // move to CSS File
        minute.setStrokeWidth(5); // move to CSS File

        Group ziffer = parserZiffern(anzuzeigendeZiffer);
        Group ziffer2 = parserZiffern(anzuzeigendeZiffer+1);

        Group basicClockElements = new Group (clockElements.outerCircle, stunde, minute, clockElements.innerCircle);
        Node learningClock = null;

        if (anzuzeigendeZeit.substring(3,5).contains("00")) {

            if (anzuzeigendeZiffer != 12) {
                Group clock = new Group(basicClockElements, clockElements.ziffer_12, ziffer);
                learningClock = clock;
            } else {
                Group clock = new Group(basicClockElements, ziffer);
                learningClock = clock;
            }
        }

        if (anzuzeigendeZeit.substring(3,5).contains("15")) {

            if (anzuzeigendeZiffer != 3) {
                Group clock = new Group(basicClockElements, clockElements.ziffer_3, ziffer);
                learningClock = clock;
            } else {
                Group clock = new Group(basicClockElements, ziffer);
                learningClock = clock;
            }
        }

        if (anzuzeigendeZeit.substring(3,5).contains("30")) {

            if (anzuzeigendeZiffer != 5 && anzuzeigendeZiffer != 6 ) {
                Group clock = new Group(basicClockElements,clockElements.ziffer_6, ziffer, ziffer2);
                learningClock = clock;
            } else {
                Group clock = new Group(basicClockElements, ziffer, ziffer2);
                learningClock = clock;
            }
        }

        if (anzuzeigendeZeit.substring(3,5).contains("45")) {

            if (anzuzeigendeZiffer != 8) {
                Group clock = new Group(basicClockElements, clockElements.ziffer_9, ziffer2);
                learningClock = clock;
            }
            else {
                Group clock = new Group(basicClockElements, ziffer2);
                learningClock = clock;
            }
        }
        finalFormatSettings();
        return learningClock;
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