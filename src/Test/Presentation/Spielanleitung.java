package Test.Presentation;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Spielanleitung {

    public   GUI guiMC;
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
        guiMC.level.setVisible(false);
        guiMC.antwortzähler.setVisible(false);
        guiMC.textlevel.setText("Wir zeigen dir jetzt die beiden Antwortmöglichkeiten.");
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

            });


        green = new Timeline(
                new KeyFrame(Duration.seconds(0.1), evt -> {
                    guiMC.textlevel.setText("Wir zeigen dir jetzt die beiden Antwortmöglichkeiten.");
                }),
                new KeyFrame(Duration.seconds(2.0), evt -> {
                    guiMC.textlevel.setText("Die erste Antwortmöglichkeit ist die Auswahl mit Knopfdruck.");
                }),
                new KeyFrame(Duration.seconds(7.0), evt -> guiMC.antwort1.setStyle("-fx-background-color: green")));

        if(green != null){
            green.play();
        }


         timeline = new Timeline(
                //     new KeyFrame(Duration.seconds(0.6), evt ->  guiMC.antwort1.setStyle("-fx-background-color: green")),
                new KeyFrame(Duration.seconds(0.6), evt -> guiMC.antwort1.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiMC.antwort1.setVisible(true)));



        if(timeline != null){
            timeline.setCycleCount(3);
            timeline.setDelay(Duration.seconds(8));
            timeline.play();
        }

         answer = new Timeline(
                new KeyFrame(Duration.seconds(0.5), evt ->
                {
                    guiMC.antwort1.setText("Super!!");
                    guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: 04:00 Uhr.");
                }),
                new KeyFrame(Duration.seconds(4.0), evt -> guiMC.goOn.setVisible(true)));


        if(answer != null){
            answer.setDelay(Duration.seconds(12));
            answer.play();
        }


         goOn = new Timeline(new KeyFrame(Duration.seconds(0.6), evt -> guiMC.goOn.setVisible(false)),
                        new KeyFrame(Duration.seconds(1.2), evt -> guiMC.goOn.setVisible(true)));



        if(goOn != null){
            goOn.setCycleCount(3);
            goOn.setDelay(Duration.seconds(17));
            goOn.play();
        }


        startFC = new Timeline(
                       new KeyFrame(Duration.seconds(0.1), evt ->{
                                        stage1.close();
                                        guiFA.zeit = "07:15";
                                        guiFA.start(stage1);
                                        guiFA.level.setVisible(false);
                                        guiFA.antwortzähler.setVisible(false);
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

                                        });


                            }),
                      new KeyFrame(Duration.seconds(0.2), evt ->   guiFA.textlevel.setText("Bei der zweiten Antwortmöglichkeit, musst du die Antwort eintippen.")),
                      new KeyFrame(Duration.seconds(7.0), evt ->{
                              guiFA.givenHour.setText("07");
                              guiFA.givenMinutes.setText("15");

                      }),
                      new KeyFrame(Duration.seconds(9.0), evt ->  guiFA.givenHour.setText(" 7")));

        if(startFC != null) {
            startFC.setDelay(Duration.seconds(21));
            startFC.play();
        }

          abschicken = new Timeline(
                new KeyFrame(Duration.seconds(0.6), evt -> {
                    guiFA.submitButton.setStyle("-fx-background-color: green");
                    guiFA.submitButton.setText("Super!!");
                }),
                new KeyFrame(Duration.seconds(0.6), evt -> guiFA.submitButton.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.submitButton.setVisible(true)),
                new KeyFrame(Duration.seconds(4.0), evt -> guiFA.goOn.setVisible(true)));


        if(abschicken != null){
            abschicken.setCycleCount(3);
            abschicken.setDelay(Duration.seconds(35));
            abschicken.play();
        }


        submit = new Timeline(new KeyFrame(Duration.seconds(0.6), evt -> guiFA.goOn.setVisible(false)),
                new KeyFrame(Duration.seconds(1.2), evt -> guiFA.goOn.setVisible(true)));
         if(submit != null){
            submit.setCycleCount(3);
            submit.setDelay(Duration.seconds(42));
            submit.play();
        }

        ende = new Timeline( new KeyFrame(Duration.seconds(5), evt ->{
            guiFA.goOn.setText("Tutorial Beenden");
            guiFA.goOn.setOnAction(event -> {
                uhrenspiel = new Uhrenspiel();
                stage1.close();
                uhrenspiel.start(stage1);
            });
        }));


            if(ende != null){

            ende.setDelay(Duration.seconds(43));
            ende.play();
        }


    }


}
