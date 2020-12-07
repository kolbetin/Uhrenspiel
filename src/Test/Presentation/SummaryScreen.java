package Test.Presentation;

import Test.Domain.ProgressData;
import Test.Test;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class SummaryScreen extends GUI {

     private Label willkommensText;


     public Label labelLevel;
     public Text text1;
     public Text text2;
     private Text text3;
     private Text text4;
     public Button backButton;
     public Button nextGame;
     public Button repeatLevel;



    @Override
    public BorderPane middleArea(){


        willkommensText = new Label();
        willkommensText.setText("Level wurde abgeschlossen");


        nextGame = new Button("Nächstes Level");
        repeatLevel = new Button("Nochmal");
        backButton = new Button("zurück");
        labelLevel = new Label("Level: " );
        text1 = new Text("Aufgabe");
        text2 = new Text("Ergebnis");

        VBox middle = new VBox(30);
        VBox right = new VBox(20);
        VBox bottom = new VBox(10);


        middle.getChildren().addAll(labelLevel,text1);
        right.getChildren().addAll(text2);
        bottom.getChildren().addAll(backButton, nextGame, repeatLevel);

        BorderPane root = new BorderPane();

        root.setTop(willkommensText);
        root.setPadding(new Insets(150,370,7,20));

        middle.setPadding(new Insets(50,7,10,7));
        right.setPadding(new Insets(50,7,10,70));
        bottom.setPadding(new Insets(0,7,200,7));
        root.setLeft(middle);
        root.setRight(right);
        root.setBottom(bottom);

        root.getStylesheets().add
                (Test.class.getResource("clock.css").toExternalForm());
        return  root;

    }

    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

        vBox.setPadding(new Insets(7, 150, 7, 70));

        return vBox;
    }





}
