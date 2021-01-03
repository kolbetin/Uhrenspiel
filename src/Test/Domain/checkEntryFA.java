/**
 * Die Klasse nimmt die Eingabe der beiden Textfelder für die freie Antwort entgegen
 * und prüft die Eingabe auf Validität.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */


package Test.Domain;

import Test.Presentation.AlertHelper;

public class checkEntryFA {
    // Instanzvariablen
    private int hour = 0;
    private int minutes = 0;
    private String givenHour = null;
    private String givenMinutes = null;
    public boolean correctEntry = false;
    public boolean clearMinute= false;
    public boolean clearHour= false;


    /**
     * Die Methode nimmt die eingegebenen Parameter entgegen und startet den Check der Eingabe auf Validität
     *
     * @param  hour  Übergibt einen String mit der Stunde im Format "12"
     * @param  minutes Übergibt einen String mit der Minuten im Format "45"
     */

    public void setValues(String hour, String minutes) {
        this.givenHour = hour;
        this.givenMinutes = minutes;
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
     * Die Methode prüft, dass die Eingabe nicht Null, Buchstaben, Negativzahlen oder Sonderzeichen ist und
     * dass nur Zahlen zwischen 1 und 12 eingegeben worden sind
     *

     * @return  Gibt den Boolean zurück, ob die Stunde valide eingegeben wurde,
     *          so dass die Antwort auf Richtigkeit geprüften werden kann.
     */

    private boolean checkHour() {
        if (!givenHour.trim().isEmpty()
                & givenHour != null
                & givenHour.matches("[0-9]*")
                & givenHour.length() <3
        ) {

            hour = Integer.valueOf(givenHour);

            if (hour > 0 & hour < 13) {

                return true;
            }
            else

                return false;
        }
        return false;
    }

    /**
     * Die Methode prüft, dass die Eingabe nicht Null, Buchstaben, Negativzahlen oder Sonderzeichen ist und
     * dass nur Zahlen zwischen 0 - 59 eingegeben worden sind
     *

     * @return  Gibt den Boolean zurück ob die Minuten korrekt eingegeben wurden,
     *          so dass die Antwort auf Richtigkeit geprüften werden kann.
     */


    private boolean checkMinutes() {
        if (!givenMinutes.trim().isEmpty()
                & givenMinutes != null
                & givenMinutes.matches("[0-9]*")
                & givenMinutes.length() <3
        ) {
            minutes = Integer.valueOf(givenMinutes);

            if (minutes >= 0
                  & minutes < 60
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
            AlertHelper.errorAlert("Fehler", "Bitte eine gültige Uhrzeit eingeben, z.B. 3:30.");
            clearHour = true;
            clearMinute = true;
        } else {
            if (!checkHour()) {
                AlertHelper.errorAlert("Fehler", "Bitte die Stunde zwischen 1 und 12 eingeben.");
                clearHour = true;
            }
            if (!checkMinutes()) {
                AlertHelper.errorAlert("Fehler", "Bitte die Minuten zwischen 0 und 59 eingeben");
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

}// Ende Klasse checkEntryFA



