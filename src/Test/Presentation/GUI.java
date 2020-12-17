package Test.Presentation;

import Test.Test;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class GUI extends Application {

        public Button endButton;
        public Button antwort1;
        public Button antwort2;
        public Button antwort3;
        public Button antwort4;
        public Button saveButton;
        public Label antwortzähler;
        public Button goOn;
        private ClockSkin clock;
        public Label questionLabel;
        public Label uberschrift;
        public String zeit = "12:00";
        public Node node;
        public Label level;
        public Label richtigeAntwort;
        public Label falscheAntwort;
        public Label textlevel;
        public Label allAnswers;



    public void start(Stage primaryStage) {

            final BorderPane borderPane = new BorderPane();

            borderPane.setPadding(new Insets(7,7,7,7));
            borderPane.setTop(upperArea());
            borderPane.setRight(middleArea());
            borderPane.setLeft(leftArea());
          //  borderPane.setStyle("-fx-border-image-width: 1; -fx-border-color: black");


            // rootTop.setTop(menuBar);
            Scene scene = new Scene(borderPane, 1400, 700);
            scene.getStylesheets().add
                    (GUI.class.getResource("clock.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Uhrenspiel");
            primaryStage.show();
        }

    public BorderPane middleArea() {

        final BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        antwortzähler = new Label("Antwort 1 von 10");
        level = new Label ("Level");
       // textlevel = new Label("Erklärung");
        //Image image1 = new Image( System.getProperty("user.home"));


        final BorderPane hBox= new BorderPane();
        hBox.setLeft(level);
        hBox.setCenter(textlevel);

        final VBox upper = new VBox(20);
        upper.getChildren().addAll(antwortzähler,hBox);

        final BorderPane borderPane = new BorderPane();
        borderPane.setTop(questionArea());
        borderPane.setBottom(answerArea());
        //borderPane.setRight(vBox2);
        middleArea.setTop(upper);
        middleArea.setBottom(borderPane);
        middleArea.setCenter(clockArea());
        //middleArea.setStyle("-fx-border-image-width: 1; -fx-border-color: blue");

        return middleArea;

    }

        public Pane questionArea() {
            final BorderPane borderPane = new BorderPane();
            borderPane.setId("questionArea");
           // borderPane.setPadding(new Insets(7, 7, 10, 7));

           // Text frage = new Text("Wie spät is es?");
            questionLabel = new Label("Frage: " + "Wie spät ist es?" );

            borderPane.setTop(questionLabel);


            return borderPane;
        }

        private Pane upperArea() {
            final VBox vBox = new VBox();
            vBox.setId("upperArea");

          //  vBox.setStyle("-fx-border-width:  1; -fx-border-color: black");

            uberschrift = new Label("Uhrenspiel");

            vBox.getChildren().add(uberschrift);

            return vBox;
        }

        public Pane clockArea(){
            final  BorderPane borderPane= new BorderPane();
            borderPane.setId("clockArea");


            clock = new ClockSkin();
            node = clock.createClock(zeit);
            //node = clock.clockLerningClock(zeit, 2);

           //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            borderPane.setPadding(new Insets(70,170,7,250));



            borderPane.setTop(node);
           // borderPane.setCenter(circle);

            return borderPane;
        }

         public Pane leftArea() {
            final BorderPane borderPane = new BorderPane();
            borderPane.setId("leftArea");

            final VBox vbox = new VBox(20);

            allAnswers = new Label("Anzahl aller Antworten");
            endButton = new Button("Spiel beenden");
            saveButton = new Button ("Speichern");
            vbox.getChildren().addAll(saveButton,endButton);


         //    final ProgressBar pbs = new ProgressBar();
          //   final ProgressIndicator pins = new ProgressIndicator();



            richtigeAntwort = new Label("Richtige Antworten:");
            falscheAntwort = new Label("Falsche Antworten:");

             final VBox vb = new VBox(20);
             vb.setSpacing(50);
             vb.getChildren().addAll( new Label("In diesem Level: "),richtigeAntwort,falscheAntwort);

            //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            borderPane.setPadding(new Insets(120, 7, 7, 7));
            vb.setPadding(new Insets(50, 7, 7, 7));
            vbox.setPadding(new Insets(7, 7, 7, 7));

            borderPane.setTop(allAnswers);
            borderPane.setCenter(vb);
            borderPane.setBottom(vbox);

            return borderPane;
        }



         public  Pane answerArea() {
            final HBox hBox = new HBox(25);
            hBox.setId("answerArea");

            hBox.setPadding(new Insets(15, 7, 10, 7));

            antwort1 = new Button("Antwort A");
            antwort2 = new Button("Antwort B");
            antwort3 = new Button("Antwort C");
            antwort4 = new Button("Antwort D");

             goOn = new Button ("weiter");


            Label antwort = new Label("Antwort");
            hBox.getChildren().addAll(antwort, antwort1, antwort2, antwort3, antwort4);
            hBox.getChildren().add(goOn);


            return hBox;
         }

          public static void main(String[] args) { launch(args);
        }






    }


