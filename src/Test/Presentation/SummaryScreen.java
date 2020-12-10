package Test.Presentation;

import Test.Domain.ProgressData;
import Test.Test;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;


public class SummaryScreen extends GUI {

    public Label willkommensText;
    public Label labelLevel;
    public Label labelRA;
    public Label labelFA;
    public Button backButton;
    public Button nextGame;
    public Button repeatLevel;


    @Override
    public BorderPane middleArea() {

        willkommensText = new Label();
        willkommensText.setText("Level wurde abgeschlossen");
        labelRA = new Label("Test");
        labelFA = new Label("Test");


        nextGame = new Button("Nächstes Level");
        repeatLevel = new Button("Nochmal");
        backButton = new Button("zurück");
        labelLevel = new Label("Level: ");



        VBox middle = new VBox(50);
        HBox bottom = new HBox(10);

        bottom.getChildren().addAll(backButton, nextGame, repeatLevel);
        bottom.setPadding(new Insets(100, 7, 200, 270));

        middle.getChildren().addAll(willkommensText,labelRA, labelFA);
        middle.setPadding(new Insets(70,270,7,270));

        BorderPane root = new BorderPane();

        root.setBottom(bottom);
        root.setPadding(new Insets(150,370,7,20));
        root.setCenter(middle);

        root.getStylesheets().add
                (Test.class.getResource("clock.css").toExternalForm());
        return root;

    }


    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

        vBox.setPadding(new Insets(7, 150, 7, 70));

        return vBox;
    }





}
