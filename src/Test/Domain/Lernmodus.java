package Test.Domain;
import Test.Presentation.ClockElements;
import Test.Presentation.ClockSkin;

public class Lernmodus {

    private ClockSkin clock;

    public static void main(String[]args){

     Lernmodus lernmodus = new Lernmodus();
     lernmodus.startLernmodus();

    }

    public void startLernmodus(){

        //clockElements = new ClockElements();
        //clock = new ClockSkin();

        double stunde = 01;
        int anzuzeigendeZiffer = 1;
        String anzuzeigendeZeit = stunde + ":00";

        // Schleife welche die ClockSkin mit 12 Stunden Uhrzeiten einzeln aufbaut

        for(int i = 1; i < 13; i++){

            clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer);

            stunde+=01;
            anzuzeigendeZiffer+=1;

            // Pause zwischen den einzelnen angezeigten Uhrzeiten
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            System.out.println(stunde);
            System.out.println(anzuzeigendeZeit);
            System.out.println(anzuzeigendeZiffer);

        }

    }

} // Ende Klasse
