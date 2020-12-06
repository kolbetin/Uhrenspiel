package Test.Presentation;

import Test.Test;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class GamesChoiceScreen extends GUI {

     private Label willkommensText;
     public Button level1;
     public Button level2;
     public Button level3;
     public Button leadedGame;
     private Text text1;
     private Text text2;
     private Text text3;
     private Text text4;
     public Button backButton;


    @Override
    public BorderPane middleArea(){


        willkommensText = new Label();
        willkommensText.setText("Was möchtest du lernen?");

        level1 = new Button("Starte Level 1");
        level2 = new Button("Starte Level 2");
        level3 = new Button("Starte Level 3");
        leadedGame = new Button("Geführtes Spiel");
        backButton = new Button("zurück");
        text1 = new Text("Volle Stunde, zum Beispiel 01:00Uhr?");
        text2 = new Text("Halbe Stunde lernen, zum Beispiel 01:30Uhr?");
        text3 = new Text("Viertel Stunde lernen, zum Beispiel 01:15Uhr?");
        text4 = new Text("Alles");

        VBox middle = new VBox(30);
        VBox right = new VBox(20);
        VBox bottom = new VBox(10);

        middle.setId("choiceMiddleArea");

        middle.getChildren().addAll( text4, text1, text2,text3);
        right.getChildren().addAll(leadedGame,level1, level2, level3);
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
                (Test.class.getResource("clock.css").toExternalForm());
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
