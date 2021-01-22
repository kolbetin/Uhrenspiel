/**
 * Die Klasse "Lernmodus" steuert den Ablauf und die jeweiligen Erklärungen jedes Lernmodus-Levels für volle Stunde,
 * halbe Stunde sowie viertel nach und viertel vor. Der Lernmodus geht dazu in den verschiedenen Levels mittels einer
 * Schleife durch die verschiedenen Uhrzeiten von 1 bis 12 Uhr und zeigt das entsprechende Uhrenbild für eine Weile
 * mit der dazugehörenden Erklärung der Uhrzeit an. Die Klasse Lernmodus enthält ausschliesslich die Logik für den Ablauf,
 * die Lernmodus Benutzeroberfläche wird in der Klasse "LernmodusGUI" erzeugt.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */

package uhrenspiel.Presentation;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Lernmodus {

    // Instanzvariablen
    private Label text = new Label();
    private int anzuzeigendeZiffer = 1;
    private String anzuzeigendeZeit = "01:00";
    private Label uberschrift = new Label();
    private Thread thread;
    private Uhrenspiel uhrenspiel;
    private LernmodusGUI guiLM;
    private int lmLevel = 0;

    /**
     * Der Konstruktor der Klasse "Lernmodus" Initialisiert die Variable "guiLM" mit einem "LernmodusGUI" Objekt, um
     * darüber auf die Elemente zur Erstellung der Benutzeroberfläche für den Lernmodus zuzugreifen.
     */
    public Lernmodus() {
        guiLM = new LernmodusGUI();

    }

    /**
     * Die Methode "startLernmodus" started den Lernmodus im Auswahlbildschirm für die verschiedenen Lernmodus-Levels
     * für volle Stunde, halbe Stunde sowie viertel nach und viertel vor.
     *
     * @param stage1 Parameter zur Erstellung der Stage für den Lernmodus
     * @param level  Parameter zur Ansteuerung des entsprechenden Lernmudus-Levels
     **/
    public void startLernmodus(Stage stage1, int level) {

        lmLevel = level;
        setStartTime(lmLevel);
        guiLM.setUhrzeit(anzuzeigendeZeit, anzuzeigendeZiffer);

        guiLM.start(stage1);
        guiLM.header.setText("Lernmodus");
        guiLM.text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");
        guiLM.levelLM.setText(setText(lmLevel));
        guiLM.explanation.setText(setExplanation(lmLevel));
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
                        guiLM.header.setText("Lernmodus");
                        guiLM.levelLM.setText(setText(lmLevel));
                        guiLM.explanation.setText(setExplanation(lmLevel));

                        guiLM.endButton.setOnAction(event -> {
                            uhrenspiel = new Uhrenspiel();
                            thread.stop();
                            stage1.close();
                            uhrenspiel.start(stage1);
                            System.out.println("Lernmodus beendet");

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
                                guiLM.explanation.setText(setExplanation(lmLevel));
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
                                guiLM.explanation.setText(setExplanation(lmLevel));
                                startLernmodus(stage1, lmLevel);
                                System.out.println(lmLevel);
                            });
                        } else {
                            guiLM.goOnLevel.setDisable(true);
                        }

                    }
                };

                for (int i = 0; i < 11; i++) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }
        });

        thread.start();

    }

    /**
     * Die Methode "setText" steuert den Text für die jeweilige Lernmodus-Level Überschrift.
     *
     * @param level Parameter zur Ansteuerung des entsprechenden Überschriften Text für den jeweiligen Lernmodus-Level.
     * @return Gibt den Text der entsprechenden Lernmodus-Level Überschrift zurück.
     **/
    private String setText(int level) {
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

    /**
     * Die Methode "setExplanation" steuert den Text für die jeweilige Erklärung der Uhrzeit in den verschiedenen
     * Lernmodus-Levels.
     *
     * @param level Parameter zur Ansteuerung des entsprechenden Textes für den jeweiligen Lernmodus-Level.
     * @return Gibt den Erklärungs-Text der jeweiligen Uhrzeit und pro Lernmodus-Level zurück.
     **/
    private String setExplanation(int level) {
        String labelText;
        switch (level) {
            case 1:
                labelText = "Wenn der Stundenzeiger \n"
                        + "auf der Stunde ist und der\n"
                        + "Minutenzeiger auf der 12, dann \n"
                        + "haben wir eine volle Stunde.";
                break;
            case 2:
                labelText = "Wenn der Stundenzeiger \n"
                        + "zwischen zwei Stunden ist und\n"
                        + "der Minutenzeiger auf der 6, dann \n"
                        + "haben wir es halb.";

                break;
            case 3:
                labelText = "Wenn der Stundenzeiger \n"
                        + "kurz nach der Stunde ist und \n"
                        + "der Minutenzeiger auf der 3, dann \n"
                        + "haben wir es viertel nach.";
                break;
            case 4:
                labelText = "Wenn der Stundenzeiger\n"
                        + "kurz vor der Stunde ist und der\n"
                        + "Minutenzeiger auf der 9, dann \n"
                        + "haben wir es viertel vor.";
                break;
            default:
                throw new IllegalArgumentException("Invalid level");
        }
        return labelText;

    }

    /**
     * Die Methode "setStartTime" setzt die entsprechende String Variable für die anzuzeigende Zeit beim Start des
     * jeweiligen Lernmodus-Levels.
     *
     * @param level Parameter steuert die Initialisierung der String Variablen für die erste anzuzeigende Zeit pro
     *              Lernmodus-Level.
     **/
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

    /**
     * Die Methode "setAnzuzeigendeZeitLernmodus" enthält die Logik zur korrekten Zusammensetzung der String Variablen
     * "anzuzeigendeZeit" im Lernmodus. Je nach übergebenem Lernmodus-Level setzt die Methoden den String in einer
     * Schleife für jeden Level anders zusammen und definiert so den jeweilig korrekten String Key.
     *
     * @param level Parameter steuert die Initialisierung der String Variablen (Key) für die jeweilige anzuzeigende Zeit
     *              pro Lernmodus-Level für volle Stunde mit "00", für halbe Stunde "30", für viertel nach mit "15" und
     *              für viertel vor mit "45".
     **/
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


}// Ende Klasse Lernmodus





