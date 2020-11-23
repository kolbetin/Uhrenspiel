package Test;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Willkommensbildschirm extends GUI {

     private Label label;

    @Override
    public BorderPane middleArea(){
      //  primaryStage.setTitle("Willkommen im Uhrenspiel");

        label = new Label();
        label.setText("Willkommen zum Uhrenspiel");

        Button newGameButton = new Button("Neues Spiel");
        Button loadGameButton = new Button("Laden des letzten Spiels");
        Button endButton = new Button("Beenden");
        Button lernmodusButton = new Button("Lernmodus");
        Button spielanleitungButton = new Button("Spielanleitung");

        VBox middle = new VBox(10);
        middle.getChildren().addAll(newGameButton,loadGameButton,lernmodusButton,spielanleitungButton,endButton);
        middle.setPadding(new Insets(70,7,7,7));
        BorderPane root = new BorderPane();
        root.setTop(label);
        root.setPadding(new Insets(150,370,7,2));
        root.setCenter(middle);
      //  root.getChildren().add(label);
        root.getStylesheets().add
                (Test.class.getResource("clock.css").toExternalForm());
        return  root;
      //  primaryStage.setScene(new Scene(root, 1100, 800));
      //  primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
