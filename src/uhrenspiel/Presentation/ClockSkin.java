/**
 * Die Klasse "ClockSkin" ist für die Erstellung aller Uhrenbilder im Uhrenspiel zuständig. Sie nimmt Angaben
 * zur anzuzeigenden Zeit als String entgegen und erstellt das gewünschte Uhrenbild für alle Spielmodi.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */

package uhrenspiel.Presentation;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ClockSkin {

    // Instanzvariablen
    private ClockElements clockElements; // Grafikelemente die für das Uhrenbild (ClockSkin) benötigt werden
    Line stunde; // Variable für den Stundenzeiger
    Line minute; // Variable für den Minutenzeiger
    MainGUI mainGui = new MainGUI(); // Variable für den Zugriff auf MainGui und das StyleSheet "clock.css"


    /**
     * Konstruktor der Klasse ClockSkin. Der Konstruktor nimmt keine Parameter entgegen, da die verschiedenen
     * Uhren-Skins direkt über die Methoden "createClock" und "createLearningClock" mit dem String Parameter
     * für die Uhrzeit erstellt werden.
     */
    public ClockSkin() {

    }

    /**
     * Die Methode "createClock" erstellt die Uhrenbilder für alle Spielmodi im Uhrenspiel mit Ausnahme des Lernmodus. Die dazu
     * benötigten grafischen Elemente werden aus der Klasse "ClockElements" geholt und zusammen mit der Information
     * der anzuzeigenden Zeit für den Stunden- und Minutenzeiger zum entsprechenden Uhrenbild zusammengestellt.
     *
     * @param anzuzeigendeZeit Übergibt einen Parameter als String mit der anzuzeigenden Uhrzeit (Beispiel: "12:30")
     * @return Gibt das zusammengesetzte Uhrenbild als Typ Node zurück.
     */
    public Node createClock(String anzuzeigendeZeit) {

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        //stunde.setStrokeWidth(5); // move to CSS File

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        //minute.setStroke(Color.RED); // move to CSS File
        //minute.setStrokeWidth(4); // move to CSS File
        mainGui.scene.getStylesheets().add(ClockSkin.class.getResource("clock.css").toExternalForm());
        minute.setId("minute");
        stunde.setId("stunde");

        // Kreiert Hauptgruppe und fügt dieser der Node clockSkin hinzu
        Group clock = new Group(clockElements.outerCircle, clockElements.ziffern, stunde, minute, clockElements.innerCircle);
        clockElements.outerCircle.toBack();
        clockElements.innerCircle.toFront();
        stunde.toFront();
        Node clockSkin = clock;
        return clockSkin;
    }

    /**
     * Die Methode "createLearningClock" erstellt die Uhrenbilder für den Spielmodus "Lernmodus". Die dazu benötigten grafischen Elemente
     * werden aus der Klasse "ClockElements" geholt und zusammen mit der Information der anzuzeigenden Zeit für den
     * Stunden- und Minutenzeiger zum entsprechenden Uhrenbild zusammengestellt. Der Parameter anzuzeigende Ziffer vom
     * Typ Integer steuert welche jeweiligen Ziffer(n) im Lernmodus Uhrenbild angezeigt werden sollen.
     *
     * @param anzuzeigendeZeit   Übergibt einen Parameter als String mit der anzuzeigenden Uhrzeit (Beispiel: "12:30")
     * @param anzuzeigendeZiffer Übergibt einen Parameter als Integer mit der Zahl der jeweils anzuzeigenden Ziffer(n)
     *                           in der Lernuhr.
     * @return Gibt das zusammengesetzte Lern-Uhrenbild als Typ Node zurück
     */
    public Node createLerningClock(String anzuzeigendeZeit, int anzuzeigendeZiffer) {

        clockElements = new ClockElements();

        this.stunde = parserStunde(anzuzeigendeZeit);
        //stunde.setStrokeWidth(5); // move to CSS File

        this.minute = parserMinuten(anzuzeigendeZeit.substring(3));
        //minute.setStroke(Color.RED); // move to CSS File
        //minute.setStrokeWidth(4); // move to CSS File
        mainGui.scene.getStylesheets().add(ClockSkin.class.getResource("clock.css").toExternalForm());
        minute.setId("minute");
        stunde.setId("stunde");

        Group ziffer = parserZiffern(anzuzeigendeZiffer);
        Group ziffer2 = parserZiffern(anzuzeigendeZiffer + 1);

        Group basicClockElements = new Group(clockElements.outerCircle, stunde, minute, clockElements.innerCircle);
        Node learningClock = null;

        if (anzuzeigendeZeit.substring(3, 5).contains("00")) {

            if (anzuzeigendeZiffer != 12) {
                Group clock = new Group(basicClockElements, clockElements.ziffer_12, ziffer);
                learningClock = clock;
            } else {
                Group clock = new Group(basicClockElements, ziffer);
                learningClock = clock;
            }
        }

        if (anzuzeigendeZeit.substring(3, 5).contains("15")) {

            if (anzuzeigendeZiffer != 3) {
                Group clock = new Group(basicClockElements, clockElements.ziffer_3, ziffer);
                learningClock = clock;
            } else {
                Group clock = new Group(basicClockElements, ziffer);
                learningClock = clock;
            }
        }

        if (anzuzeigendeZeit.substring(3, 5).contains("30")) {

            if (anzuzeigendeZiffer != 5 && anzuzeigendeZiffer != 6) {
                Group clock = new Group(basicClockElements, clockElements.ziffer_6, ziffer, ziffer2);
                learningClock = clock;
            } else {
                Group clock = new Group(basicClockElements, ziffer, ziffer2);
                learningClock = clock;
            }
        }

        if (anzuzeigendeZeit.substring(3, 5).contains("45")) {

            if (anzuzeigendeZiffer != 8) {
                Group clock = new Group(basicClockElements, clockElements.ziffer_9, ziffer2);
                learningClock = clock;
            } else {
                Group clock = new Group(basicClockElements, ziffer2);
                learningClock = clock;
            }
        }
        finalFormatSettings();
        return learningClock;
    } // Ende Methode clockLearningClock


    /**
     * Die Methode "parserMinuten" nimmt einen Substring der anzuzeigenden Zeit für die Minuten entgegen
     * (Beispiel: "30") und holt mit diesem Key die entsprechende Linie für den Minutenzeiger aus der Minuten-Map
     * in der Klasse "clockElements".
     * Linie für den Minutenzeiger.
     *
     * @param minuten Nimmt als Parameter einen String mit der anzuzeigenden Minute entgegen (Beispiel: "30")
     * @return Gibt aus der Klasse "clockElements" die Linie für den Minutenzeiger zurück.
     */
    public Line parserMinuten(String minuten) {
        return clockElements.minutenMap.get(minuten);
    }

    /**
     * Die Methode "parserStunde" nimmt einen String der anzuzeigenden Zeit für die Minuten entgegen
     * (Beispiel: "12:30") und holt mit diesem Key die entsprechende Linie für den Stundenzeiger aus der Stunden-Map
     * in der Klasse "clockElements".
     *
     * @param stunde- Nimmt als Parameter einen String mit der anzuzeigenden Minute entgegen (Beispiel: "30")
     * @return Gibt aus der Klasse "clockElements" die Linie für den Stundenzeiger zurück.
     */
    public Line parserStunde(String stunde) {
        return clockElements.stundenMap.get(stunde);
    }

    /**
     * Die Methode "parserZiffern" nimmt einen Integer der anzuzeigenden Ziffer(n) im Uhrenbild des Lernmodus
     * entgegen (Beispiel: "12") und holt mit diesem Key die entsprechende(n) Ziffer(n) aus der Ziffern-Map
     * in der Klasse "clockElements".
     *
     * @param ziffer Nimmt als Parameter einen Integer mit der anzuzeigenden Ziffer entgegen (Beispiel: "12")
     * @return Gibt aus der Klasse "clockElements" die anzuzeigenden Ziffer(n) für den Lernmodus zurück.
     */
    public Group parserZiffern(int ziffer) {
        return clockElements.ziffernMap.get(ziffer);
    }

    /**
     * Die Methode "finalFormatSetting" stellt die korrekte Reihenfolge des grossen äusseren und des kleinen
     * inneren Kreises sowie des Stundenzeigers im Uhrenbild sicher.
     */
    public void finalFormatSettings() {
        clockElements.outerCircle.toBack();
        clockElements.innerCircle.toFront();
        stunde.toFront();
    }

}  // Ende Klasse ClockSkin