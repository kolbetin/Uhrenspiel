package Test.Presentation;

public class Lernmodus {

    private ClockSkin clock;
    private ClockElements clockElements;

    public static void main(String[] args) {

        Lernmodus lernmodus = new Lernmodus();
        lernmodus.startLernmodus();


    }

    public void startLernmodus() {

        // clockElements = new ClockElements();
        // System.out.println(clockElements.stundenMap.keySet());


        int stunde = 0;
        int anzuzeigendeZiffer = 0;
        String anzuzeigendeZeit = null;


        // Schleife welche die ClockSkin mit 12 Stunden Uhrzeiten einzeln aufbaut

        for (int i = 0; i < 12; i++) {

            stunde += 1;
            anzuzeigendeZiffer += 1;

            if (stunde<10) {
                anzuzeigendeZeit = "0" + stunde + ":00";
            }
            else {
                anzuzeigendeZeit = stunde + ":00";
            }

            //clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer);



            // Pause zwischen den einzelnen angezeigten Uhrzeiten
            /*PauseTransition wait = new PauseTransition(Duration.seconds(5));
            wait.setOnFinished(event -> startLernmodus());
            wait.play();*/


            System.out.println(stunde);
            System.out.println(anzuzeigendeZeit);
            System.out.println(anzuzeigendeZiffer);

        }


    }
}
