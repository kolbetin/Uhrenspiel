package Test.Presentation;

import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Lernmodus extends GUI {

    private Lernmodus lernmodus;
    private ClockSkin clock;

    @Override
    public BorderPane middleArea() {

        BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        antwortzähler = new Label("Antwort 1 von 10");
        level = new Label ("Level");
        //Image image1 = new Image( System.getProperty("user.home"));


        // VBox vBox2= new VBox(2);
        // vBox2.getChildren().addAll(level);
        VBox vBox= new VBox(2);
      //  vBox.getChildren().addAll(antwortzähler, level);
        vBox.setPadding(new Insets(7,7,7,7));
        // vBox2.setPadding(new Insets(7,170,370,7));
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(questionArea());
        borderPane.setBottom(answerArea());
        //borderPane.setRight(vBox2);
        middleArea.setTop(vBox);
        middleArea.setBottom(borderPane);
        middleArea.setLeft(clockArea());

        return middleArea;

    }

    @Override
    public Pane clockArea(){
        BorderPane borderPane= new BorderPane();
        borderPane.setId("clockArea");

        int anzuzeigendeZiffer = 0;
        String anzuzeigendeZeit = null;

        // Schleife welche die ClockSkin mit 12 Stunden Uhrzeiten einzeln aufbaut

        for (int i = 0; i < 12; i++) {

            anzuzeigendeZiffer += 1;

            if (anzuzeigendeZiffer<10) {
                anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":00";
            }
            else {
                anzuzeigendeZeit = anzuzeigendeZiffer + ":00";
            }

            System.out.println(anzuzeigendeZeit);
            System.out.println(anzuzeigendeZiffer);

            borderPane.setTop(clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer));

            // Pause zwischen den einzelnen angezeigten Uhrzeiten
            PauseTransition wait = new PauseTransition(Duration.seconds(5));
            wait.setOnFinished(event -> clockArea());
            wait.play();

        }

        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(70,170,7,250));

        return borderPane;

      //  borderPane.setTop(node);
        // borderPane.setCenter(circle);
        //return borderPane;
    }
}
