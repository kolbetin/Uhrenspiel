package Test.Presentation;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Lernmodus extends GUI {

   // private Lernmodus lernmodus;
    private ClockSkin clock;
    public Label text = new Label();



    public int anzuzeigendeZiffer = 0;
    public String anzuzeigendeZeit = null;

  //  public void start(Stage primaryStage) {}
    public static void main(String[] args) {
        launch(args);
    }


    public void startLernmodus(){


        // for (int i = 0; i < 12; i++) {

        //   int anzuzeigendeZiffer =0 ;
        //  String anzuzeigendeZeit = null;
        //lernmodus.start(stage1);

        anzuzeigendeZiffer += 1;

        if (anzuzeigendeZiffer < 10) {
            anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":00";
        } else {
            anzuzeigendeZeit = anzuzeigendeZiffer + ":00";
        }

        System.out.println(anzuzeigendeZeit);
        System.out.println(anzuzeigendeZiffer);

        text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");

      /*      // Pause zwischen den einzelnen angezeigten Uhrzeiten
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


        //   }

    }
    @Override
    public BorderPane middleArea() {

        BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        uberschrift = new Label("Lernmodus");
        level = new Label ("Level 1");
        //Image image1 = new Image( System.getProperty("user.home"));


        // VBox vBox2= new VBox(2);
        // vBox2.getChildren().addAll(level);
         VBox vBox= new VBox(2);
         vBox.getChildren().addAll(uberschrift, text);
      //  vBox.setPadding(new Insets(7,7,7,7));
        // vBox2.setPadding(new Insets(7,170,370,7));
     //   BorderPane borderPane = new BorderPane();
      //  borderPane.setTop(questionArea());
       // borderPane.setBottom(answerArea());
        //borderPane.setRight(vBox2);
         middleArea.setTop(vBox);
       // middleArea.setBottom(borderPane);
        middleArea.setPadding(new Insets(7,370,370,7));
        middleArea.setCenter(clockArea());

        return middleArea;

    }
    public Pane clockArea(){
        BorderPane borderPane= new BorderPane();
        borderPane.setId("clockArea");
      //  anzuzeigendeZeit = "01:00";
      //  anzuzeigendeZiffer = 1;

        clock = new ClockSkin();
        node =clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer);


        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(70,170,7,250));



        borderPane.setTop(node);
        // borderPane.setCenter(circle);

        return borderPane;
    }

    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

        //  vBox.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        vBox.setPadding(new Insets(7, 150, 7, 70));
        //vBox.getChildren().addAll(new Text("Fortschrittsleiste"));


        return vBox;
    }



    /*
    @Override
    public Pane clockArea(){
        BorderPane borderPane= new BorderPane();
        borderPane.setId("clockArea");

        int anzuzeigendeZiffer =0 ;
        String anzuzeigendeZeit = null;

        // Schleife welche die ClockSkin mit 12 Stunden Uhrzeiten einzeln aufbaut

        for (int i = 0; i < 12; i++) {

            anzuzeigendeZiffer  += 1;

            if (anzuzeigendeZiffer<10) {
                anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":00";
            }
            else {
                anzuzeigendeZeit = anzuzeigendeZiffer + ":00";
            }

            System.out.println(anzuzeigendeZeit);
            System.out.println(anzuzeigendeZiffer);



            // Pause zwischen den einzelnen angezeigten Uhrzeiten
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            BorderPane hb = hbs[i] = new BorderPane();
            hb.getChildren().add(clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer));

           // borderPane.setTop(clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer));
        }

        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(70,170,7,250));
        BorderPane frame = new BorderPane();
        frame.getChildren().addAll(hbs);
        return frame;

      //  borderPane.setTop(node);
        // borderPane.setCenter(circle);
        //return borderPane;
    }*/


}
