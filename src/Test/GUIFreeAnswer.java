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

public class GUIFreeAnswer extends GUI {


    @Override
    public Pane answerArea() {
        final HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(15, 10, 10, 50));
        Button submitButton = new Button("Submit");
        TextField textField = new TextField();
        submitButton.setOnAction(event -> {
            submitButton.setText("ich funktioniere a bit");
        });

        hBox.getChildren().addAll(
                new Text("Antwort"), textField,submitButton );
        return hBox;
    }




}
