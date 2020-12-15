package Test.Presentation;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Lernmodus extends GUI {


    private ClockSkin clock;
    public Label text = new Label();
    public int anzuzeigendeZiffer = 1;
    public String anzuzeigendeZeit = "01:00";
    private Label uberschrift = new Label();
    public Button endGameButton;

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
    public BorderPane middleArea(){


        uberschrift.setText("Lernmodus - Wo stehen die Ziffern auf der Uhr?");

        endGameButton = new Button("Beenden");

        Button spielanleitungButton = new Button("Spielanleitung");

        VBox middle = new VBox(10);
        middle.getChildren().addAll(clockArea());
        middle.setPadding(new Insets(70,500,7,70));
        BorderPane root = new BorderPane();
        root.setTop(uberschrift);
        root.setPadding(new Insets(7,100,7,70));
        root.setCenter(middle);
        root.setBottom(text);
        //  root.getChildren().add(label);
        root.getStylesheets().add
                (GUI.class.getResource("clock.css").toExternalForm());
        return  root;

    }
    public Pane clockArea(){
        BorderPane borderPane= new BorderPane();
        borderPane.setId("clockArea");

        clock = new ClockSkin();
        node =clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer);


        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(70,170,7,250));



        borderPane.setCenter(node);

        return borderPane;
    }

    @Override
  public Pane leftArea() {
            BorderPane borderPane = new BorderPane();
            borderPane.setId("leftArea");

            VBox vbox = new VBox(20);

            endButton = new Button("Spiel beenden");
            vbox.getChildren().addAll(endButton);


            borderPane.setPadding(new Insets(7, 50, 7, 25));

            vbox.setPadding(new Insets(70, 7, 7, 7));

            borderPane.setBottom(vbox);

            return borderPane;
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
