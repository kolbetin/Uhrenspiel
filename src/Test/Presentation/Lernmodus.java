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
    public Button repeatButton;

    //  public void start(Stage primaryStage) {}
    public static void main(String[] args) {
        launch(args);
    }


    public void startLernmodusVolleStunde() {

        if( anzuzeigendeZiffer < 12) {
            anzuzeigendeZiffer += 1;

            if (anzuzeigendeZiffer < 10) {
                anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":00";
            } else {
                anzuzeigendeZeit = anzuzeigendeZiffer + ":00";
            }
            text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");
        }
        else {
            System.out.println("Bin fertig!");
        }
    }

    public void startLernmodusViertelNach() {

        if( anzuzeigendeZiffer < 12) {
            anzuzeigendeZiffer += 1;

            if (anzuzeigendeZiffer < 10) {
                anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":15";
            } else {
                anzuzeigendeZeit = anzuzeigendeZiffer + ":15";
            }
            text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");
        }
        else {
            System.out.println("Bin fertig!");
        }
    }

    public void startLernmodusHalbeStunde() {

        if( anzuzeigendeZiffer < 12) {
            anzuzeigendeZiffer += 1;

            if (anzuzeigendeZiffer < 10) {
                anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":30";
            } else {
                anzuzeigendeZeit = anzuzeigendeZiffer + ":30";
            }
            text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");
        }
        else {
            System.out.println("Bin fertig!");
        }
    }

    public void startLernmodusViertelVor() {

        if( anzuzeigendeZiffer < 12) {
            anzuzeigendeZiffer += 1;

            if (anzuzeigendeZiffer < 10) {
                anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":45";
            } else {
                anzuzeigendeZeit = anzuzeigendeZiffer + ":45";
            }
            text.setText("Es ist jetzt: " + anzuzeigendeZeit + " Uhr");
        }
        else {
            System.out.println("Bin fertig!");
        }
    }


    @Override
    public BorderPane middleArea() {

        uberschrift.setText("Lernmodus - Wo stehen die Ziffern auf der Uhr?");

        final VBox right = new VBox(20);
        right.getChildren().add(text);
        right.setPadding(new Insets(200, 550, 7, 7));

        final VBox middle = new VBox(10);
        middle.getChildren().addAll(clockArea());
        //   middle.setPadding(new Insets(70,100,7,70));
        //  middle.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        final BorderPane root = new BorderPane();
        root.setTop(uberschrift);
        root.setPadding(new Insets(7, 450, 7, 70));
        // root.setStyle("-fx-border-width:  1; -fx-border-color: green");
        root.setLeft(middle);
        root.setRight(right);

        root.getStylesheets().add
                (GUI.class.getResource("clock.css").toExternalForm());
        return root;

    }

    public Pane clockArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("clockArea");

        clock = new ClockSkin();
        node = clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer);

        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(70, 170, 7, 250));

        borderPane.setCenter(node);

        return borderPane;
    }

    @Override
    public Pane leftArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("leftArea");

        final VBox vbox = new VBox(20);

        endButton = new Button("Lernmodus beenden");
        repeatButton = new Button("Nochmal");
        vbox.getChildren().addAll(repeatButton, endButton);

        borderPane.setPadding(new Insets(7, 50, 7, 25));

        vbox.setPadding(new Insets(70, 7, 7, 7));

        borderPane.setBottom(vbox);

        return borderPane;
    }

}
