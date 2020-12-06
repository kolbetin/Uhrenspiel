package Test.Presentation;

import Test.Domain.Game;
import Test.Test;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.util.Collection;


public class GUI extends Application {

        public Button endButton;
        public Button antwort1;
        public Button antwort2;
        public Button antwort3;
        public Button antwort4;
        public Button saveButton;
        public Label antwortzähler;
        public Button goOn;
        public ClockSkin clock;
        public Label questionLabel;
        public Label uberschrift;
        public String zeit = "01:00";
        public Node node;
        public Label level;



        public void start(Stage primaryStage) {

            final BorderPane borderPane = new BorderPane();

            borderPane.setPadding(new Insets(7,7,7,7));
            borderPane.setTop(upperArea());
            borderPane.setRight(middleArea());
            borderPane.setLeft(leftArea());


            // rootTop.setTop(menuBar);
            Scene scene = new Scene(borderPane, 1400, 800);
            scene.getStylesheets().add
                    (Test.class.getResource("clock.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Uhrenspiel");
            primaryStage.show();
        }

    public BorderPane middleArea() {

        BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        antwortzähler = new Label("Antwort 1 von 10");
        level = new Label ("Level");
        //Image image1 = new Image( System.getProperty("user.home"));


       // VBox vBox2= new VBox(2);
       // vBox2.getChildren().addAll(level);
        VBox vBox= new VBox(2);
        vBox.getChildren().addAll(antwortzähler, level);
        vBox.setPadding(new Insets(7,7,7,7));
       // vBox2.setPadding(new Insets(7,170,370,7));
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(questionArea());
        borderPane.setBottom(answerArea());
        //borderPane.setRight(vBox2);
        middleArea.setTop(vBox);
        middleArea.setBottom(borderPane);
        middleArea.setLeft(clockArea(zeit ));

        return middleArea;

    }

        public Pane questionArea() {
            final BorderPane borderPane = new BorderPane();
            borderPane.setId("questionArea");
            borderPane.setPadding(new Insets(7, 750, 10, 50));

           // Text frage = new Text("Wie spät is es?");
            questionLabel = new Label("Frage: " + "Es ist __:00 Uhr?" );

            borderPane.setTop(questionLabel);


            return borderPane;
        }

        private Pane upperArea() {
            final VBox vBox = new VBox();
            vBox.setId("upperArea");

          //  vBox.setStyle("-fx-border-width:  1; -fx-border-color: black");

            uberschrift = new Label("Uhrenspiel");


            // Create MenuBar
            MenuBar menuBar = new MenuBar();

            // Create menus
            javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("Datei");

            // Create MenuItems
            MenuItem loadItem = new MenuItem("Laden");
            loadItem.setOnAction(event -> {
            });

            MenuItem saveItem = new MenuItem("Speichern");
            saveItem.setOnAction(event -> {
            });

            fileMenu.getItems().addAll(loadItem, saveItem);

            // Add Menus to the MenuBar
            menuBar.getMenus().addAll(fileMenu);

           // vBox.getChildren().add(menuBar);
            vBox.getChildren().add(uberschrift);

            return vBox;
        }

        public Pane clockArea(String zit){
            BorderPane borderPane= new BorderPane();
            borderPane.setId("clockArea");



           // Circle circle = new Circle(200);
            clock = new ClockSkin(zit);
            node = clock.createClock();

           //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            borderPane.setPadding(new Insets(70,170,7,250));



            borderPane.setTop(node);
           // borderPane.setCenter(circle);

            return borderPane;
        }

         public Pane leftArea() {
            BorderPane borderPane = new BorderPane();
            borderPane.setId("leftArea");

            VBox vbox = new VBox(20);

            endButton = new Button("Spiel beenden");
            saveButton = new Button ("Speichern");
            vbox.getChildren().addAll(saveButton,endButton);


         //    final ProgressBar pbs = new ProgressBar();
          //   final ProgressIndicator pins = new ProgressIndicator();
          //   final HBox hbs  = new HBox ();


            Text text = new Text("Richtige Antworten:");
            Text text2 = new Text("Falsche Antworten:");

             final VBox vb = new VBox();
             vb.setSpacing(5);
             vb.getChildren().addAll( text,text2);

           // borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            borderPane.setPadding(new Insets(7, 50, 7, 25));

            borderPane.setTop(new Text("Fortschrittsleiste"));
            borderPane.setCenter(vb);
            borderPane.setBottom(vbox);

            return borderPane;
        }



         public  Pane answerArea() {
            final HBox hBox = new HBox(25);
            hBox.setId("answerArea");

            hBox.setPadding(new Insets(15, 10, 10, 50));

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


