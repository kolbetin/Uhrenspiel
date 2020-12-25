package Test.Domain;

import Test.Presentation.AlertHelper;
import Test.Presentation.Uhrenspiel;
import javafx.scene.control.Alert;

public class checkEntryFA {
    private int stunde = 0;
    private int minuten =0;
    private String givenHour = null;
    private String givenMinutes = null;
    private AlertHelper alertHelper;
    public boolean korrekt = false;

    public checkEntryFA(){
        alertHelper = new AlertHelper();
    }

    public void setValues(String stunde, String minuten) {
        this.givenHour = stunde;
        this.givenMinutes = minuten;
        checkEmpty();
    }


    public void changeFormat() {
        this.stunde = Integer.valueOf(givenHour);
        this.minuten  = Integer.valueOf(givenMinutes);

    }

    private void checkEmpty() {
        if (!givenHour.trim().isEmpty()
                & !givenMinutes.trim().isEmpty()
                &  givenHour != null
                & givenMinutes != null
                & givenMinutes.matches("[0-9]*")
                & givenHour.matches("[0-9]*")

        ) { changeFormat();
             checkValues();
            System.out.println(stunde);
            System.out.println(minuten);

        } else {
            if ((givenMinutes.trim().isEmpty() | givenMinutes == null)
                    & (givenHour.trim().isEmpty() | givenHour == null)
                    | (!givenHour.matches("[0-9]*") | !givenMinutes.matches("[0-9]*")) ) {
                alertHelper.errorAlert("Fehler", "Bitte eine gültige Uhrzeit eingeben, z.B. 3:30.");
            } else {
                if (givenHour.trim().isEmpty()
                        | givenHour == null) {
                    alertHelper.errorAlert( "Fehler", "Bitte die Stunde eingeben, z.B. 8 oder 12.");
                } else {
                    if (givenMinutes.trim().isEmpty()
                            | givenMinutes == null) {
                        this.stunde = Integer.valueOf(givenHour);
                        if(stunde ==0 | stunde >12){
                            alertHelper.errorAlert( "Fehler", "Bitte eine Stunde eingeben zwischen 1 und 12.");
                        }
                        if((stunde > 0 & stunde <13)
                                & (!givenMinutes.trim().isEmpty()
                                & givenMinutes != null)){
                                                        changeFormat();
                                                       checkValues();
                                 }
                                    else {
                                            if( !givenMinutes.trim().isEmpty()
                                                    & givenMinutes != null){
                                                changeFormat();
                                                checkValues();
                                            }
                                            else {
                                                alertHelper.errorAlert( "Fehler", "Bitte die Minuten eingeben, z.B. 15,30 oder 45.");
                                            }
                                     }
                                 }

                     }
                 }
            }
    }

    public boolean checkValues() {
        if (stunde == 0 & stunde > 12
                 |( minuten != 00
                   & minuten != 15
                   & minuten != 30
                   & minuten != 45)
                    ) {

            if ( stunde == 0 & stunde > 12) {
                alertHelper.errorAlert( "Fehler", "Bitte eine Stunde eingeben zwischen 1 und 12.");

            } else {
                if (minuten != 00 & minuten != 15 & minuten != 30 & minuten != 45) {
                    alertHelper.errorAlert( "Fehler", "Bitte die Minuten eingeben, z.B. 15,30 oder 45.");
                }else {
                    return korrekt = true;
                }
            }
        }else {
            return korrekt = true;
        }
        return korrekt =  false;
    }
}



