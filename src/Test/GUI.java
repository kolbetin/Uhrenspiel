package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class GUI extends Application {

        public Button endButton;
        public Button antwort1;
        public Button antwort2;
        public Button antwort3;
        public Button antwort4;
        public Button saveButton;
        private ClockTest clock;


        public void start(Stage primaryStage) {

            final BorderPane borderPane = new BorderPane();

            borderPane.setPadding(new Insets(7,7,7,7));
            borderPane.setTop(upperArea());
            borderPane.setRight(middleArea());
            borderPane.setLeft(leftArea());


            // rootTop.setTop(menuBar);
            Scene scene = new Scene(borderPane, 1300, 900);
            scene.getStylesheets().add
                    (Test.class.getResource("clock.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Uhrenspiel");
            primaryStage.show();
        }

    public BorderPane middleArea() {

        final BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        Label antwortzähler = new Label("Antwort 1 von 10");

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(questionArea());
        borderPane.setBottom(answerArea());


        middleArea.setTop(antwortzähler);
        middleArea.setBottom(borderPane);
        middleArea.setLeft(clockArea());



        return middleArea;

    }

        public Pane questionArea() {
            final BorderPane borderPane = new BorderPane();
            borderPane.setId("questionArea");
            borderPane.setPadding(new Insets(7, 750, 10, 50));

           // Text frage = new Text("Wie spät is es?");
            Text frageLabel = new Text("Frage: " + "Es ist __:00 Uhr?" );
            Text antwortzähler = new Text("Antwort 1 von 10");

            //borderPane.setTop(antwortzähler);
            borderPane.setCenter(frageLabel);
           // borderPane.setBottom(answerArea());

            return borderPane;
        }

        private Pane upperArea() {
            final VBox vBox = new VBox();
            vBox.setId("upperArea");

          //  vBox.setStyle("-fx-border-width:  1; -fx-border-color: black");

            Label uberschrift = new Label("Uhrenspiel");


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

        public Pane clockArea(){
            BorderPane borderPane= new BorderPane();
            borderPane.setId("clockArea");

            Circle circle = new Circle(200);

            ClockSkin clock = new ClockSkin();


         //  borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            borderPane.setPadding(new Insets(7,370,7,250));

            borderPane.setTop(new Text("Uhrenbeispiel"));
            borderPane.setCenter(clock.createClockSkin());




            return borderPane;
        }

         public Pane leftArea() {
            BorderPane borderPane = new BorderPane();
            borderPane.setId("leftArea");

            VBox vbox = new VBox(20);

            endButton = new Button("Spiel beenden");
            saveButton = new Button ("Speichern");
            vbox.getChildren().addAll(saveButton,endButton);

           // borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            borderPane.setPadding(new Insets(7, 50, 7, 25));

            borderPane.setTop(new Text("Fortschrittsleiste"));
            borderPane.setBottom(vbox);

            return borderPane;
        }


         public  Pane answerArea() {
            final HBox hBox = new HBox(35);
            hBox.setId("answerArea");

            hBox.setPadding(new Insets(15, 10, 10, 50));

            antwort1 = new Button("Antwort A");
            antwort2 = new Button("Antwort B");
            antwort3 = new Button("Antwort C");
            antwort4 = new Button("Antwort D");

            Text antwort = new Text("Antwort");
            hBox.getChildren().addAll(antwort, antwort1,antwort2,antwort3, antwort4);

            return hBox;
         }

          public static void main(String[] args) { launch(args);
        }






    }


