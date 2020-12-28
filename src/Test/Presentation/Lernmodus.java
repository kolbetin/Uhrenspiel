package Test.Presentation;

import Test.Presentation.LernmodusGUI;
import Test.Presentation.Uhrenspiel;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Lernmodus {

    private Label text = new Label();
    private int anzuzeigendeZiffer = 1;
    private String anzuzeigendeZeit = "01:00";
    private Label uberschrift = new Label();
    private Thread thread;
    private Uhrenspiel uhrenspiel;
    private LernmodusGUI guiLM;
    private int lmLevel = 0;


    public void startLernmodus(Stage stage1, int level) {

        PauseTransition wait = new PauseTransition(Duration.seconds(5));
        wait.setDelay(Duration.seconds(5));

            lmLevel = level;
            setStartTime(lmLevel);
            guiLM.setUhrzeit(anzuzeigendeZeit, anzuzeigendeZiffer);

            guiLM.start(stage1);
            guiLM.text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");
            guiLM.levelLM.setText(setText(lmLevel));
            // longrunning operation runs on different thread
            thread = new Thread(new Runnable() {

                int n;

                @Override
                public void run() {
                    Runnable updater = new Runnable() {

                        @Override
                        public void run() {
                            setAnzuzeigendeZeitLernmodus(lmLevel);

                            guiLM.start(stage1);
                            guiLM.levelLM.setText(setText(lmLevel));

                            guiLM.endButton.setOnAction(event -> {
                                uhrenspiel = new Uhrenspiel();
                                thread.stop();
                                stage1.close();
                                uhrenspiel.start(stage1);

                            });
                            guiLM.repeatButton.setOnAction(event -> {
                                thread.stop();
                                startLernmodus(stage1, lmLevel);
                            });
                            if (lmLevel > 1) {
                                guiLM.preLevel.setOnAction(event -> {
                                    thread.stop();
                                    lmLevel = lmLevel - 1;
                                    guiLM.levelLM.setText(setText(lmLevel));
                                    startLernmodus(stage1, lmLevel);

                                });
                            } else {
                                guiLM.preLevel.setDisable(true);
                            }

                            if (lmLevel < 4) {
                                guiLM.goOnLevel.setOnAction(event -> {
                                    thread.stop();
                                    lmLevel = lmLevel + 1;
                                    guiLM.levelLM.setText(setText(lmLevel));
                                    startLernmodus(stage1, lmLevel);
                                    System.out.println(lmLevel);
                                });
                            } else {
                                guiLM.goOnLevel.setDisable(true);
                            }

                        }
                    };

                    boolean ende = false;
                    while (!ende) {
                        if (anzuzeigendeZiffer < 11) {
                            try {
                                Thread.sleep(7000);
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
    private String setText(int level){
        String labelText;
        switch (level) {
            case 1:
                labelText = "Volle Stunde";
                break;
            case 2:
                labelText = "Halbe Stunde";

                break;
            case 3:
                labelText = "Viertel nach";
                break;
            case 4:
                labelText = "Viertel vor";
                break;
            default:
                throw new IllegalArgumentException("Invalid level");
        }
        return labelText;

    }

    public void setStartTime(int level) {
        anzuzeigendeZiffer = 1;
        if (level == 1) {
            anzuzeigendeZeit = "01:00";

        }
        if (level == 2) {
            anzuzeigendeZeit = "01:30";


        }
        if (level == 3) {
            anzuzeigendeZeit = "01:15";

        }
        if (level == 4) {
            anzuzeigendeZeit = "01:45";

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
                    anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":30";

                }
                if (level == 3) {
                    anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":15";

                }
                if (level == 4) {
                    anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":45";

                }
            } else {
                if (level == 1) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":00";

                }
                if (level == 2) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":30";

                }
                if (level == 3) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":15";

                }
                if (level == 4) {
                    anzuzeigendeZeit = anzuzeigendeZiffer + ":45";

                }
            }

            guiLM.setUhrzeit(anzuzeigendeZeit, anzuzeigendeZiffer);
            guiLM.text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");

        }

    }

    public Lernmodus() {
        guiLM = new LernmodusGUI();

    }

    // Getter Methode für LernmodusTest Klasse
    public String getAnzuzeigendeZeit() {
        return anzuzeigendeZeit;
    }

}// Ende Klasse Lernmodus





