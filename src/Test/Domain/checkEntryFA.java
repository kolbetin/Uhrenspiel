package Test.Domain;

import Test.Presentation.AlertHelper;

public class checkEntryFA {
    private int stunde = 0;
    private int minuten = 0;
    private String givenHour = null;
    private String givenMinutes = null;
    private AlertHelper alertHelper;


    public checkEntryFA() {
        alertHelper = new AlertHelper();
    }

    public void setValues(String stunde, String minuten) {
        this.givenHour = stunde;
        this.givenMinutes = minuten;
        checkHour();
        System.out.println("Check Hour: " + checkHour());
        checkMinutes();
        System.out.println("Check Minutes: " + checkMinutes());
        sendAlert();
    }

    public boolean checkHour() {
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

    public boolean checkMinutes() {
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

    public void sendAlert() {

        if (!checkHour() & !checkMinutes()) {
            alertHelper.errorAlert("Fehler", "Bitte eine gültige Uhrzeit eingeben, z.B. 3:30.");
        } else {
            if (!checkHour()) {
                alertHelper.errorAlert("Fehler", "Bitte die Stunde eingeben, z.B. 8 oder 12.");
            }
            if (!checkMinutes()) {
                alertHelper.errorAlert("Fehler", "Bitte die Minuten eingeben, z.B. 15, 30 oder 45.");

            } else System.out.println("Eingabe okay");
        }

    }

}



