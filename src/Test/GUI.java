package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class GUI extends Application {


        Button antwort1;
        Button antwort2;
        Button antwort3;
        Button antwort4;
        Label uberschrift;
        Text frage;
        Button submitButton;
        TextField textField;
        Random random;
        FlowPane pane;
        VBox root;


        public void start(Stage primaryStage) {

            final BorderPane borderPane = new BorderPane();

            pane = new FlowPane();

            borderPane.setPadding(new Insets(7,7,7,7));
            borderPane.setTop(obereLeiste());
            borderPane.setRight(frageLeiste());
            borderPane.setBottom(antwortLeiste());
            borderPane.setLeft(circle());

            // rootTop.setTop(menuBar);
            Scene scene = new Scene(borderPane, 700, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Uhrenspiel");
            primaryStage.show();
        }

        private Pane frageLeiste() {
            final HBox hBox = new HBox(2);
            hBox.setPadding(new Insets(50, 250, 10, 25));
            frage = new Text("Wie spät is es?");
            frage.setFont(Font.font(25));
            Label label = new Label("Frage: ");
            label.setFont(Font.font(25));
            // frage.setPadding(new Insets());
            hBox.getChildren().add( label  );
            hBox.getChildren().add(frage);
            return hBox;
        }

        private Pane obereLeiste() {
            final VBox vBox = new VBox();
            vBox.setStyle("-fx-border-width:  1; -fx-border-color: black");
            Font font = new Font( "BOLD", 25);
            uberschrift = new Label("Uhrenspiel");
            uberschrift.setFont(font);
            uberschrift.setPadding(new Insets(7,7,7,250));

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

            vBox.getChildren().add(menuBar);
            vBox.getChildren().add(uberschrift);

            return vBox;
        }

        private Pane circle(){
            VBox vBox= new VBox(5);
            Circle circle = new Circle(100);
            vBox.setStyle("-fx-border-width:  1; -fx-border-color: blue");
            vBox.setPadding(new Insets(7,7,7,7));
            vBox.getChildren().addAll(new Text("Uhrenbsp"),
                    circle
            );
            return vBox;
        }


         public Pane antwortLeiste() {
            final HBox hBox = new HBox(10);
            hBox.setPadding(new Insets(15, 10, 10, 100));

            antwort1 = new Button("Antwort A");
            antwort2 = new Button("Antwort B");
            antwort3 = new Button("Antwort C");
            antwort4 = new Button("Antwort D");

            hBox.getChildren().addAll(
                    new Text("Antwort"), antwort1,antwort2,antwort3, antwort4);
            return hBox;
        }

        public static void main(String[] args) {
            launch(args);
        }


    }


