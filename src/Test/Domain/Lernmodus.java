package Test.Domain;

import Test.Presentation.ClockSkin;

public class Lernmodus {

    // Klasse Lernmodus

    public void createLerningMode(String anzuzeigendeZeit, String zifferblatt){

        ClockSkin learningClock = new ClockSkin(anzuzeigendeZeit, zifferblatt);
    }
    // Schleife welche die ClockSkin mit 12 Stunden Uhrzeiten einzeln aufbaut
    // Pause zwischen den einzelnen angezeigten Uhrzeiten mit "Thread.sleep(5000);"




    // Klasse ClockSkin erweitern:
    // Zweiter Konstruktor in ClockSkin welcher die Uhrzeiten einzeln für Lernmodus aufbaut
    // Konstruktor Parameter mit "String anzuzeigendeZeit" & ein Key als String für die anzeige der Richtigen Zeit-Gruppe
    // Einfügen einer HashMap mit Key Zeit-Gruppe "1" sowie "group zeit_1"

} // Ende Klasse
