package Test;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Willkommensbildschirm extends GUI {

     private Label label;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Willkommen im Uhrenspiel");

        label = new Label();
        label.setText("Willkommen zum Uhrenspiel");

        StackPane root = new StackPane();
        root.getChildren().add(label);
        root.getStylesheets().add
                (Test.class.getResource("clock.css").toExternalForm());
        primaryStage.setScene(new Scene(root, 1100, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
