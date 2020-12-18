package Test.Presentation;

import Test.Test;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;




public class MainScreen extends GUI {

     private Label willkommensText;
     public Button newGameButton;
     public Button loadGameButton;
     public Button endGameButton;
     public Button lernmodusButton;
     public Button spielanleitungButton;


    @Override
    public BorderPane middleArea(){

        willkommensText = new Label();
        willkommensText.setText("Willkommen zum Uhrenspiel");

        newGameButton = new Button("Neues Spiel");
        loadGameButton = new Button("Laden des letzten Spiels");
        endGameButton = new Button("Beenden");
        lernmodusButton = new Button("Lernmodus");
        spielanleitungButton = new Button("Spielanleitung");

        final VBox middle = new VBox(10);
        middle.getChildren().addAll(newGameButton,loadGameButton,lernmodusButton,spielanleitungButton,endGameButton);
        middle.setPadding(new Insets(70,500,7,70));

        final BorderPane root = new BorderPane();
        root.setTop(willkommensText);
        root.setPadding(new Insets(150,100,7,70));
        root.setLeft(middle);
      //  root.getChildren().add(label);
        root.getStylesheets().add
                (GUI.class.getResource("clock.css").toExternalForm());
        return  root;

    }

    @Override
    public Pane leftArea() {
        final VBox vBox = new VBox(5);

      //  vBox.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        vBox.setPadding(new Insets(7, 150, 7, 70));
        //vBox.getChildren().addAll(new Text("Fortschrittsleiste"));


        return vBox;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
