/**
 * Die Klasse "QuestionsAnswer" erstellt für jedes Uhrenspiel-Level eine Map mit dem String der jeweils angezeigten
 * Uhrzeit und dem String der dazugehörigen korrekten Antwort. Aufgrund dieser Maps weiss das Spiel, welche Antwort
 * zu welcher Frage und Uhrzeit korrekt ist. Die Antworten-Map Level 1 enthält die Frage/Antwort Schlüssel für die
 * volle Stunde, Level 2 für die halbe Stunde und Level 3 für viertel nach und viertel vor.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */
package uhrenspiel.domain;


import java.util.*;


public class QuestionsAnswer {

    // Instanzvariable
    public HashMap<String, String> antwortenMap;

    /**
     * Der Konstruktor der Klasse "QuestionsAnswer" Initialisiert die Variable "antwortenMap" vom Typ HashMap. In der
     * Variablen werden die korrekten Frage/Antwort Schlüssel pro Level abgespeichert.
     */
    public QuestionsAnswer() {
        antwortenMap = new HashMap<>();
    }

    /**
     * Die Mehtode "antwortenMapLevel1" befüllt die "antwortenMap" vom Typ HashMap mit den korrekten Frage/Antwort
     * Schlüssel für Level 1 (volle Stunde).
     */
    public void antwortenMapLevel1() {
        antwortenMap.put("01:00", "1:00");
        antwortenMap.put("02:00", "2:00");
        antwortenMap.put("03:00", "3:00");
        antwortenMap.put("04:00", "4:00");
        antwortenMap.put("05:00", "5:00");
        antwortenMap.put("06:00", "6:00");
        antwortenMap.put("07:00", "7:00");
        antwortenMap.put("08:00", "8:00");
        antwortenMap.put("09:00", "9:00");
        antwortenMap.put("10:00", "10:00");
        antwortenMap.put("11:00", "11:00");
        antwortenMap.put("12:00", "12:00");
    }


    /**
     * Die Mehtode "antwortenMapLevel2" befüllt die "antwortenMap" vom Typ HashMap mit den korrekten Frage/Antwort
     * Schlüssel für Level 2 (halbe Stunde).
     */
    public void antwortenMapLevel2() {
        antwortenMap.put("01:30", "1:30");
        antwortenMap.put("02:30", "2:30");
        antwortenMap.put("03:30", "3:30");
        antwortenMap.put("04:30", "4:30");
        antwortenMap.put("05:30", "5:30");
        antwortenMap.put("06:30", "6:30");
        antwortenMap.put("07:30", "7:30");
        antwortenMap.put("08:30", "8:30");
        antwortenMap.put("09:30", "9:30");
        antwortenMap.put("10:30", "10:30");
        antwortenMap.put("11:30", "11:30");
        antwortenMap.put("12:30", "12:30");
    }

    /**
     * Die Mehtode "antwortenMapLevel3" befüllt die "antwortenMap" vom Typ HashMap mit den korrekten Frage/Antwort
     * Schlüssel für Level 3 (viertel nach und viertel vor).
     */
    public void antwortenMapLevel3() {
        antwortenMap.put("01:15", "1:15");
        antwortenMap.put("02:15", "2:15");
        antwortenMap.put("03:15", "3:15");
        antwortenMap.put("04:15", "4:15");
        antwortenMap.put("05:15", "5:15");
        antwortenMap.put("06:15", "6:15");
        antwortenMap.put("07:15", "7:15");
        antwortenMap.put("08:15", "8:15");
        antwortenMap.put("09:15", "9:15");
        antwortenMap.put("10:15", "10:15");
        antwortenMap.put("11:15", "11:15");
        antwortenMap.put("12:15", "12:15");
        antwortenMap.put("01:45", "1:45");
        antwortenMap.put("02:45", "2:45");
        antwortenMap.put("03:45", "3:45");
        antwortenMap.put("04:45", "4:45");
        antwortenMap.put("05:45", "5:45");
        antwortenMap.put("06:45", "6:45");
        antwortenMap.put("07:45", "7:45");
        antwortenMap.put("08:45", "8:45");
        antwortenMap.put("09:45", "9:45");
        antwortenMap.put("10:45", "10:45");
        antwortenMap.put("11:45", "11:45");
        antwortenMap.put("12:45", "12:45");
    }


} // Ende Klasse QuestionsAnswer
