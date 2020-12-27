/**
 * Die Klasse nimmt die Eingabe der beiden Textfelder für die freie Antwort entgegen
 *  und prüft die Eingabe auf Vollständigkeit und prüft ob nur Zahlen eingegeben wurden.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */


package Test.Domain;

import Test.Presentation.AlertHelper;

public class checkEntryFA {
    // Instanzvariablen
    private int stunde = 0;
    private int minuten = 0;
    private String givenHour = null;
    private String givenMinutes = null;
    private AlertHelper alertHelper;
    public boolean correctEntry = false;
    public boolean clearMinute= false;
    public boolean clearHour= false;

    /**
     * Konstruktor der Klasse.
     *
     * Die Klasse AlertHelper wird initialisiert.
     */

    public checkEntryFA() {
        alertHelper = new AlertHelper();
    }

    /**
     * Die Methode nimmt die eingegeben Parameter entgegen und startet den Check der Eingabe auf Vollständigkeit
     * und nach korrekten Muster
     *
     * @param  stunde  Übergibt einen String mit der Stunde im Format "12"
     * @param  minuten Übergibt einen String mit der Minuten im Format "45"
     */

    public void setValues(String stunde, String minuten) {
        this.givenHour = stunde;
        this.givenMinutes = minuten;
        clearMinute= false;
        clearHour= false;
        correctEntry = false;
        checkHour();
        checkMinutes();
        if(checkMinutes() & checkHour()){
            correctEntry = true;
        }
    }

    /**
     * Die Methode prüft ob die Eingabe nicht Null, Buchstaben, Negativzahlen oder Sonderzeichen ist und
     * dass nur Zahlen zwischen 1 und 12 eingegeben worden sind
     *

     * @return  Gibt den Boolean zurück ob die Stunde korrekt eingegeben wurde,
     *          so dass die Antwort auf Richtigkeit geprüften werden kann.
     */

    private boolean checkHour() {
        if (!givenHour.trim().isEmpty()
                & givenHour != null
                & givenHour.matches("[0-9]*")) {

            stunde = Integer.valueOf(givenHour);

            if (stunde > 0 & stunde < 13) {

                return true;
            }
            else

                return false;
        }
        return false;
    }

    /**
     * Die Methode prüft ob die Eingabe nicht Null, Buchstaben, Negativzahlen oder Sonderzeichen ist und
     * dass nur die Zahlen 00, 15, 30 oder 45 eingegeben worden sind
     *

     * @return  Gibt den Boolean zurück ob die Minuten korrekt eingegeben wurden,
     *          so dass die Antwort auf Richtigkeit geprüften werden kann.
     */


    private boolean checkMinutes() {
        if (!givenMinutes.trim().isEmpty()
                & givenMinutes != null
                & givenMinutes.matches("[0-9]*")
        ) {
            minuten = Integer.valueOf(givenMinutes);

            if (minuten == 00
                    | minuten == 15
                    | minuten == 30
                    | minuten == 45
            ) {
                     return true;
            }
            else

                return false;

        } else
            return false;
    }

    /**
     * Die Methode wirft einen Alert, falls die Checks in checkMinutes() und checkHour()
     * ein False zurückgegeben haben
     *
     */

    public void sendAlert() {

        if (!checkHour() & !checkMinutes()) {
            alertHelper.errorAlert("Fehler", "Bitte eine gültige Uhrzeit eingeben, z.B. 3:30.");
            clearHour = true;
            clearMinute = true;
        } else {
            if (!checkHour()) {
                alertHelper.errorAlert("Fehler", "Bitte die Stunde eingeben, z.B. 8 oder 12.");
                clearHour = true;
            }
            if (!checkMinutes()) {
                alertHelper.errorAlert("Fehler", "Bitte die Minuten eingeben, z.B. 15, 30 oder 45.");
                clearMinute = true;

            } else System.out.println("Eingabe okay");
        }
    }

        /**
         * Getter Methode
         *

         * @return  Gibt Boolean von checkMinutes() zurück.
         */


        public boolean getCheckMinutes(){
                return checkMinutes();
        }

    /**
     * Getter Methode
     *

     * @return  Gibt Boolean von checkHour() zurück.
     */

        public boolean getCheckHour(){
            return checkHour();
        }

}



