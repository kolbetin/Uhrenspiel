package Test.Presentation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Spielanleitung {

    public MainGUI guiMC;
    public QuestionFreeAnswer guiFA;
    public Uhrenspiel uhrenspiel;
    private Timeline startFC;
    private Timeline abschicken;
    private Timeline ende;
    private Timeline submit;
    private Timeline green;
    private Timeline timeline;
    private Timeline answer;
    private Timeline goOn;


    public Spielanleitung(){
        guiMC = new MainGUI();
        guiFA = new QuestionFreeAnswer();
    }

    public void startSpielanleitung(Stage stage1) {

        guiMC.time = "04:00";
        guiMC.start(stage1);
        guiMC.antwortzähler.setVisible(false);
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
            startFC.stop();
            abschicken.stop();
            submit.stop();
            ende.stop();
        });


        green = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt ->
                    guiMC.level.setText("Wir zeigen dir jetzt die beiden Antwortmöglichkeiten.")
                ),
                new KeyFrame(Duration.seconds(5.0), evt ->
                    guiMC.level.setText("Die erste Antwortmöglichkeit ist die Auswahl mit Knopfdruck.")
                ),
                new KeyFrame(Duration.seconds(9.0), evt -> guiMC.antwort1.setStyle("-fx-background-color: green")));

            green.play();


         timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> guiMC.antwort1.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiMC.antwort1.setVisible(true)));

            timeline.setCycleCount(2);
            timeline.setDelay(Duration.seconds(10));
            timeline.play();


         answer = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt ->
                {
                    guiMC.antwort1.setId("buttonOkay");
                    guiMC.antwort1.setText("");
                    guiMC.antwort1.setDisable(true);
                    guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: 04:00 Uhr.");
                }),
                new KeyFrame(Duration.seconds(4.0), evt -> guiMC.goOn.setVisible(true)));

            answer.setDelay(Duration.seconds(11));
            answer.play();


         goOn = new Timeline(new KeyFrame(Duration.seconds(0.6), evt -> guiMC.goOn.setVisible(false)),
                        new KeyFrame(Duration.seconds(1.2), evt -> guiMC.goOn.setVisible(true)));

            goOn.setCycleCount(2);
            goOn.setDelay(Duration.seconds(14));
            goOn.play();



        startFC = new Timeline(
                       new KeyFrame(Duration.seconds(0.1), evt ->{
                                      //  stage1.close();
                                        guiFA.time = "07:15";
                                        guiFA.start(stage1);
                                        guiFA.antwortzähler.setVisible(false);
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
                                           startFC.stop();
                                       });


                            }),
                      new KeyFrame(Duration.seconds(0.2), evt ->   guiFA.level.setText("Bei der zweiten Antwortmöglichkeit, musst du die Antwort eintippen.")),
                      new KeyFrame(Duration.seconds(5.0), evt ->{
                              guiFA.givenHour.setText("07");
                              guiFA.givenMinutes.setText("15");


                      }),
                      new KeyFrame(Duration.seconds(8.0), evt ->  guiFA.givenHour.setText(" 7")));

            startFC.setDelay(Duration.seconds(19));
            startFC.play();


          abschicken = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt -> {
                    guiFA.submitButton.setId("buttonOkay");
                    guiFA.submitButton.setText("");
                    guiFA.submitButton.setDisable(true);

                }),
                new KeyFrame(Duration.seconds(0.6), evt -> guiFA.submitButton.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.submitButton.setVisible(true)));




            abschicken.setCycleCount(2);
            abschicken.setDelay(Duration.seconds(29));
            abschicken.play();



        submit = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> guiFA.goOn.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.goOn.setVisible(true)));

            submit.setCycleCount(2);
            submit.setDelay(Duration.seconds(31));
            submit.play();


        ende = new Timeline( new KeyFrame(Duration.seconds(0.1), evt ->{
            guiFA.goOn.setText("Tutorial Wiederholen");
            guiFA.goOn.setOnAction(event ->
               startSpielanleitung(stage1)
                );
        }));

            ende.setDelay(Duration.seconds(34));
            ende.play();



    }


}
