package Test.Presentation;

import Test.Test;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Verabschiedungsbildschirm extends GUI {

     private Label label;
     private Button close;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Uhrenspiel");
        label = new Label();
        label.setText("Danke das du unser Spiel gespielt hast!!");


        close = new Button("Beenden");
        close.setOnAction(event -> {
            primaryStage.close();
        });
        VBox root = new VBox();

        root.getChildren().add(label);
        root.getChildren().add(close);
        String path = "src/Test";
        root.getStylesheets().add
                (Test.class.getResource("clock.css").toExternalForm());
        primaryStage.setScene(new Scene(root, 1100, 800));
        primaryStage.show();
    }
  /*  public static void main(String[] args) {
        launch(args);
    }*/
}
