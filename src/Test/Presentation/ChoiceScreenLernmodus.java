package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class ChoiceScreenLernmodus extends MainGUI {

     public Label willkommensText;
     public Button level1;
     public Button level2;
     public Button level3;
     public Button level4;
     public Text text1;
     public Text text2;
     public Text text3;
     public Text text4;
     public Button backButton;


    @Override
    public BorderPane middleArea(){


        willkommensText = new Label();
        willkommensText.setText("Welchen Lernmodus möchtest du starten?");

        level1 = new Button("Start");
        level2 = new Button("Start");
        level3 = new Button("Start");
        level4 = new Button("Start");
        backButton = new Button("Zurück");
        text1 = new Text("Volle Stunde, zum Beispiel 01:00 Uhr?");
        text2 = new Text("Viertel nach lernen, zum Beispiel 3:15 Uhr?");
        text3 = new Text("Viertel vor lernen, zum Beispiel 3:45 Uhr?");
        text4 = new Text("Halbe Stunde lernen, zum Beispiel 2:30 Uhr?");


        final VBox middle = new VBox(30);
        final VBox right = new VBox(20);
        final VBox bottom = new VBox(10);

        middle.setId("choiceMiddleArea");

        middle.getChildren().addAll(  text1, text2,text3, text4);
        right.getChildren().addAll(level1, level2, level3, level4);
        bottom.getChildren().add(backButton);

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
                (MainGUI.class.getResource("clock.css").toExternalForm());
        return  root;

    }

    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

      //  vBox.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        vBox.setPadding(new Insets(7, 150, 7, 70));
        //vBox.getChildren().addAll(new Text("Fortschrittsleiste"));


        return vBox;
    }





}
