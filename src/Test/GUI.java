package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class GUI extends Application {



        public void start(Stage primaryStage) {

            final BorderPane borderPane = new BorderPane();

            borderPane.setPadding(new Insets(7,7,7,7));
            borderPane.setTop(upperArea());
            borderPane.setRight(middleArea());
            borderPane.setLeft(leftArea());

            // rootTop.setTop(menuBar);
            Scene scene = new Scene(borderPane, 1200, 700);
            scene.getStylesheets().add
                    (Test.class.getResource("clock.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Uhrenspiel");
            primaryStage.show();
        }

    public BorderPane middleArea() {

        final BorderPane middleArea = new BorderPane();

        middleArea.setRight(questionArea());
        middleArea.setBottom(antwortLeiste());
        middleArea.setLeft(clockArea());

        return middleArea;

    }

        private Pane questionArea() {
            final HBox hBox = new HBox(2);
            hBox.setPadding(new Insets(50, 250, 10, 25));

            Text frage = new Text("Wie spät is es?");
            Text frageLabel = new Text("Frage: ");

            hBox.getChildren().addAll( frageLabel,frage  );
            return hBox;
        }

        private Pane upperArea() {
            final VBox vBox = new VBox();
            vBox.setStyle("-fx-border-width:  1; -fx-border-color: black");

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

        private Pane clockArea(){
            VBox vBox= new VBox(5);
            Circle circle = new Circle(100);
            vBox.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            vBox.setPadding(new Insets(7,7,7,7));
            vBox.getChildren().addAll(new Text("Uhrenbsp"),
                    circle
            );
            return vBox;
        }

         private Pane leftArea() {
            VBox vBox = new VBox(5);

            vBox.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            vBox.setPadding(new Insets(7, 7, 7, 7));
            vBox.getChildren().addAll(new Text("Fortschrittsleiste")

            );
            return vBox;
        }


         public Pane antwortLeiste() {
            final HBox hBox = new HBox(10);
            hBox.setPadding(new Insets(15, 10, 10, 100));

            Button antwort1 = new Button("Antwort A");
            Button antwort2 = new Button("Antwort B");
            Button antwort3 = new Button("Antwort C");
            Button antwort4 = new Button("Antwort D");

            Text antwort = new Text("Antwort");
            hBox.getChildren().addAll(
                    antwort, antwort1,antwort2,antwort3, antwort4);
            return hBox;
        }

          public static void main(String[] args) { launch(args);
        }






    }


