package Test.Presentation;

import Test.Domain.ProgressData;
import Test.Test;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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


public class SummaryScreen extends GUI {

     private Label willkommensText;
     public Label labelLevel;
     public Text text1;
     public Text text2;

     public Button backButton;
     public Button nextGame;
     public Button repeatLevel;
     final Integer[] values = new Integer[] {1,2,3,4,5,6,7,8,9,10};
     final Label [] labels = new Label[values.length];
     final HBox hbs [] = new HBox [values.length];
     private ProgressData progressData;

    @Override
    public BorderPane middleArea(){

        willkommensText = new Label();
        willkommensText.setText("Level wurde abgeschlossen");
        nextGame = new Button("Nächstes Level");
        repeatLevel = new Button("Nochmal");
        backButton = new Button("zurück");
        labelLevel = new Label("Level: " );
        progressData = new ProgressData();

        VBox middle = new VBox(30);
        VBox right = new VBox(20);
        VBox bottom = new VBox(10);


        middle.getChildren().addAll(labelLevel);

        bottom.getChildren().addAll(backButton, nextGame, repeatLevel);

        BorderPane root = new BorderPane();

        root.setTop(willkommensText);
        root.setPadding(new Insets(150,370,7,20));

        for (int i = 0; i < values.length; i++) {
            final Label label = labels[i] = new Label();
            label.setText("Aufgabe: " + values[i]);

            final Label label2 = labels[i] = new Label();
            label2.setText( progressData.progress.get(values[i]));



            HBox hb = hbs[i] = new HBox();
            hb.setSpacing(25);
            hb.setAlignment(Pos.CENTER_LEFT);
            hb.getChildren().addAll(label, label2);

        }



        right.getChildren().addAll(hbs);

        middle.setPadding(new Insets(50,7,10,7));
        right.setPadding(new Insets(50,7,10,7));
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
