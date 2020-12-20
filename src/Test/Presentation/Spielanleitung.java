package Test.Presentation;

import Test.Presentation.GUI;
import Test.Presentation.QuestionFreeAnswer;
import Test.Presentation.Uhrenspiel;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Spielanleitung {

    public GUI guiMC;
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
        guiMC = new GUI();
        guiFA = new QuestionFreeAnswer();
    }

    public void starteSpielanleitung(Stage stage1) {

        guiMC.zeit = "04:00";
        guiMC.start(stage1);
        guiMC.antwortzähler.setVisible(false);
        guiMC.textlevel.setVisible(false);
        guiMC.level.setText("Wir zeigen dir jetzt die beiden Antwortmöglichkeiten.");
        guiMC.antwort1.setText("04:00");
        guiMC.antwort2.setText("02:00");
        guiMC.antwort3.setText("05:00");
        guiMC.antwort4.setText("03:00");
        guiMC.goOn.setVisible(false);
        guiMC.richtigeAntwort.setVisible(false);
        guiMC.falscheAntwort.setVisible(false);
        guiMC.allAnswers.setVisible(false);
        guiMC.levelexplain.setVisible(false);
        guiMC.saveButton.setVisible(false);
        guiMC.endButton.setText("Beenden");
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
                new KeyFrame(Duration.seconds(0.1), evt -> {
                    guiMC.level.setText("Wir zeigen dir jetzt die beiden Antwortmöglichkeiten.");
                }),
                new KeyFrame(Duration.seconds(2.0), evt -> {
                    guiMC.level.setText("Die erste Antwortmöglichkeit ist die Auswahl mit Knopfdruck.");
                }),
                new KeyFrame(Duration.seconds(7.0), evt -> guiMC.antwort1.setStyle("-fx-background-color: green")));

        if(green != null){
            green.play();
        }

         timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> guiMC.antwort1.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiMC.antwort1.setVisible(true)));

        if(timeline != null){
            timeline.setCycleCount(2);
            timeline.setDelay(Duration.seconds(8));
            timeline.play();
        }

         answer = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt ->
                {
                    guiMC.antwort1.setText("Super!!");
                    guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: 04:00 Uhr.");
                }),
                new KeyFrame(Duration.seconds(4.0), evt -> guiMC.goOn.setVisible(true)));


        if(answer != null){
            answer.setDelay(Duration.seconds(10));
            answer.play();
        }


         goOn = new Timeline(new KeyFrame(Duration.seconds(0.6), evt -> guiMC.goOn.setVisible(false)),
                        new KeyFrame(Duration.seconds(1.2), evt -> guiMC.goOn.setVisible(true)));


        if(goOn != null){
            goOn.setCycleCount(2);
            goOn.setDelay(Duration.seconds(12));
            goOn.play();
        }


        startFC = new Timeline(
                       new KeyFrame(Duration.seconds(0.1), evt ->{
                                        stage1.close();
                                        guiFA.zeit = "07:15";
                                        guiFA.start(stage1);
                                        guiFA.antwortzähler.setVisible(false);
                                        guiFA.textlevel.setVisible(false);
                                        guiFA.richtigeAntwort.setVisible(false);
                                        guiFA.falscheAntwort.setVisible(false);
                                        guiFA.allAnswers.setVisible(false);
                                        guiFA.levelexplain.setVisible(false);
                                        guiFA.saveButton.setVisible(false);
                                        guiFA.endButton.setText("Beenden");

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
                      new KeyFrame(Duration.seconds(7.0), evt ->  guiFA.givenHour.setText(" 7")));

        if(startFC != null) {
            startFC.setDelay(Duration.seconds(16));
            startFC.play();
        }

          abschicken = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> {
                    guiFA.submitButton.setStyle("-fx-background-color: green");
                    guiFA.submitButton.setText("Super!!");
                }),
                new KeyFrame(Duration.seconds(0.6), evt -> guiFA.submitButton.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.submitButton.setVisible(true)));



        if(abschicken != null){
            abschicken.setCycleCount(2);
            abschicken.setDelay(Duration.seconds(24));
            abschicken.play();
        }


        submit = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> guiFA.goOn.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.goOn.setVisible(true)));
         if(submit != null){
            submit.setCycleCount(2);
            submit.setDelay(Duration.seconds(27));
            submit.play();
        }

        ende = new Timeline( new KeyFrame(Duration.seconds(0.1), evt ->{
            guiFA.goOn.setText("Tutorial Beenden");
            guiFA.goOn.setOnAction(event -> {
                uhrenspiel = new Uhrenspiel();
                stage1.close();
                uhrenspiel.start(stage1);
            });
        }));


            if(ende != null){

            ende.setDelay(Duration.seconds(30));
            ende.play();
        }


    }


}
