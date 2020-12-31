/**
 * Die Klasse erstellt die Spielanleitung.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */


package Test.Presentation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Spielanleitung {

    public MainGUI guiMC;
    public QuestionFreeAnswer guiFA;
    public Uhrenspiel uhrenspiel;
    private Timeline startMC;
    private Timeline pressButton;
    private Timeline correctAnswerMC;
    private Timeline goOn;
    private Timeline startFA;
    private Timeline correctAnswerFA;
    private Timeline submitAnswer;
    private Timeline end;

    /**
     * Der Konstruktor der Klasse.
     */

    public Spielanleitung(){
        guiMC = new MainGUI();
        guiFA = new QuestionFreeAnswer();
    }

    /**
     * Die Methode erstellt die GUI für die Spielanleitung.
     *
     * Zudem wird in einer Timeline die unterschiedlichen Phasen des Spiels
     * vorgestellt.
     * @param stage1 nimmt die Stage entgegen, zum Aufbau der GUI.
     */
    public void startSpielanleitung(Stage stage1) {

        guiMC.time = "04:00";
        guiMC.start(stage1);
        guiMC.answerCount.setVisible(false);
        guiMC.level.setText("Wir zeigen dir jetzt die beiden Antwortmöglichkeiten.");
        guiMC.goOn.setVisible(false);
        guiMC.richtigeAntwort.setVisible(false);
        guiMC.falscheAntwort.setVisible(false);
        guiMC.allAnswers.setVisible(false);
        guiMC.levelexplain.setVisible(false);
        guiMC.saveButton.setVisible(false);
        guiMC.endButton.setText("Tutorial Beenden");
        guiMC.endButton.setOnAction(event -> {
            uhrenspiel = new Uhrenspiel();
            stage1.close();
            uhrenspiel.start(stage1);
            startFA.stop();
            correctAnswerFA.stop();
            submitAnswer.stop();
            end.stop();
            System.out.println("Tutorial beendet");
        });


        startMC = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt ->
                    guiMC.level.setText("Wir zeigen dir jetzt die beiden Antwortmöglichkeiten.")
                ),
                new KeyFrame(Duration.seconds(5.0), evt ->
                    guiMC.level.setText("Die erste Antwortmöglichkeit ist die Auswahl mit Knopfdruck.")
                ),
                new KeyFrame(Duration.seconds(9.0), evt -> guiMC.answer1.setStyle("-fx-background-color: green")));

            startMC.play();


         pressButton = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> guiMC.answer1.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiMC.answer1.setVisible(true)));

            pressButton.setCycleCount(2);
            pressButton.setDelay(Duration.seconds(10));
            pressButton.play();


         correctAnswerMC = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt ->
                {
                    guiMC.answer1.setId("buttonOkay");
                    guiMC.answer1.setText("");
                    guiMC.answer1.setDisable(true);
                    guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: 04:00 Uhr.");
                }),
                new KeyFrame(Duration.seconds(4.0), evt -> guiMC.goOn.setVisible(true)));

            correctAnswerMC.setDelay(Duration.seconds(11));
            correctAnswerMC.play();


         goOn = new Timeline(new KeyFrame(Duration.seconds(0.6), evt -> guiMC.goOn.setVisible(false)),
                        new KeyFrame(Duration.seconds(1.2), evt -> guiMC.goOn.setVisible(true)));

            goOn.setCycleCount(2);
            goOn.setDelay(Duration.seconds(14));
            goOn.play();



        startFA = new Timeline(
                       new KeyFrame(Duration.seconds(0.1), evt ->{
                                      //  stage1.close();
                                        guiFA.time = "07:15";
                                        guiFA.start(stage1);
                                        guiFA.answerCount.setVisible(false);
                                        guiFA.richtigeAntwort.setVisible(false);
                                        guiFA.falscheAntwort.setVisible(false);
                                        guiFA.allAnswers.setVisible(false);
                                        guiFA.levelexplain.setVisible(false);
                                        guiFA.saveButton.setVisible(false);
                                        guiFA.givenHour.setDisable(true);
                                        guiFA.givenMinutes.setDisable(true);
                                        guiFA.endButton.setText("Tutorial Beenden");
                                        guiFA.goOn.setVisible(false);

                                       guiFA.endButton.setOnAction(event -> {
                                           uhrenspiel = new Uhrenspiel();
                                           stage1.close();
                                          uhrenspiel.start(stage1);
                                           startFA.stop();
                                           System.out.println("Tutorial beendet");
                                       });


                            }),
                      new KeyFrame(Duration.seconds(0.2), evt ->   guiFA.level.setText("Bei der zweiten Antwortmöglichkeit, musst du die Antwort eintippen.")),
                      new KeyFrame(Duration.seconds(5.0), evt ->{
                              guiFA.givenHour.setText("07");
                              guiFA.givenMinutes.setText("15");


                      }),
                      new KeyFrame(Duration.seconds(8.0), evt ->  guiFA.givenHour.setText(" 7")));

            startFA.setDelay(Duration.seconds(19));
            startFA.play();


          correctAnswerFA = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt -> {
                    guiFA.submitButton.setId("buttonOkay");
                    guiFA.submitButton.setText("");
                    guiFA.submitButton.setDisable(true);

                }),
                new KeyFrame(Duration.seconds(0.6), evt -> guiFA.submitButton.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.submitButton.setVisible(true)));




            correctAnswerFA.setCycleCount(2);
            correctAnswerFA.setDelay(Duration.seconds(29));
            correctAnswerFA.play();



        submitAnswer =new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> guiFA.goOn.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.goOn.setVisible(true)));

            submitAnswer.setCycleCount(2);
            submitAnswer.setDelay(Duration.seconds(31));
            submitAnswer.play();


        end = new Timeline( new KeyFrame(Duration.seconds(0.1), evt ->{
            guiFA.goOn.setText("Tutorial Wiederholen");
            guiFA.goOn.setOnAction(event ->
               startSpielanleitung(stage1)
                );
        }));

            end.setDelay(Duration.seconds(34));
            end.play();



    }


}
