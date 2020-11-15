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


public class GUIMultipleChoice extends GUI {

    Button antwort1;
    Button antwort2;
    Button antwort3;
    Button antwort4;
    Button submitButton;


    public GUIMultipleChoice() {
        super();
    }


    @Override
    public Pane antwortLeiste() {
        final HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(15, 10, 10, 100));

        antwort1 = new Button("Antwort A");
        antwort2 = new Button("Antwort B");
        antwort3 = new Button("Antwort C");
        antwort4 = new Button("Antwort D");

        hBox.getChildren().addAll(
                new Text("Antwort"), antwort1, antwort2, antwort3, antwort4);
        return hBox;
    }


}
