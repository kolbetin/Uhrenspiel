package Test.Presentation;

import Test.Domain.Lernmodus;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LernmodusScreen extends GUI {

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

        double stunde = 01;
        int anzuzeigendeZiffer = 1;
        String anzuzeigendeZeit = stunde + ":00";

        // Schleife welche die ClockSkin mit 12 Stunden Uhrzeiten einzeln aufbaut

        for(int i = 1; i < 13; i++){
            clock = new ClockSkin();
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
            borderPane.setTop( clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer));
        }


        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(70,170,7,250));



      //  borderPane.setTop(node);
        // borderPane.setCenter(circle);

        return borderPane;
    }
}
