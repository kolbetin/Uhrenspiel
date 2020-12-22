package Test.Domain;

import Test.Presentation.LernmodusGUI;
import Test.Presentation.Uhrenspiel;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Lernmodus {

    private Label text = new Label();
    private int anzuzeigendeZiffer = 1;
    private String anzuzeigendeZeit = "01:00";
    private Label uberschrift = new Label();
    private Thread thread;
    private Uhrenspiel uhrenspiel;
    private LernmodusGUI guiLM;


    public void startLernmodus(Stage stage1, int level) {
        setStartTime(level);
        guiLM.setUhrzeit(anzuzeigendeZeit, anzuzeigendeZiffer);

        guiLM.start(stage1);
        guiLM.text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");

        // longrunning operation runs on different thread
        thread = new Thread(new Runnable() {

            int n;

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        setAnzuzeigendeZeitLernmodus(level);

                        guiLM.start(stage1);

                        guiLM.endButton.setOnAction(event -> {
                            uhrenspiel = new Uhrenspiel();
                            thread.stop();
                            stage1.close();
                            uhrenspiel.start(stage1);
                        });
                        guiLM.repeatButton.setOnAction(event -> {
                            startLernmodus(stage1, level);
                        });


                    }

                };
                boolean ende = false;
                while (!ende) {
                    if (anzuzeigendeZiffer < 11) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    } else {
                        ende = true;
                    }
                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }
        });

        thread.start();

    }

    public void setStartTime(int level) {
        anzuzeigendeZiffer = 1;
        if (level == 1) {
            anzuzeigendeZeit = "01:00";

        }
        if (level == 2) {
            anzuzeigendeZeit = "01:15";

        }
        if (level == 3) {
            anzuzeigendeZeit = "01:45";

        }
        if (level == 4) {
            anzuzeigendeZeit = "01:30";

        }
    }

    public void setAnzuzeigendeZeitLernmodus(int level) {

        if (anzuzeigendeZiffer < 12) {
            anzuzeigendeZiffer += 1;


            if (anzuzeigendeZiffer < 10) {

                if (level == 1) {
                    anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":00";

                }
                if (level == 2) {
                    anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":15";

                }
                if (level == 3) {
                    anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":45";

                }
                if (level == 4) {
                    anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":30";

                }
            } else {
                if (level == 1) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":00";

                }
                if (level == 2) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":15";

                }
                if (level == 3) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":45";

                }
                if (level == 4) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":30";

                }
            }

            guiLM.setUhrzeit(anzuzeigendeZeit, anzuzeigendeZiffer);
            guiLM.text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");
            //System.out.println(anzuzeigendeZeit + " Zeit");
            //System.out.println(anzuzeigendeZiffer + " Ziffer");


        }

    }

    public Lernmodus() {
        guiLM = new LernmodusGUI();

    }
}





