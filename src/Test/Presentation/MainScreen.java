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


    @Override
    public BorderPane middleArea(){

        willkommensText = new Label();
        willkommensText.setText("Willkommen zum Uhrenspiel");

        newGameButton = new Button("Neues Spiel");
        loadGameButton = new Button("Laden des letzten Spiels");
        endGameButton = new Button("Beenden");
        Button lernmodusButton = new Button("Lernmodus");
        Button spielanleitungButton = new Button("Spielanleitung");

        VBox middle = new VBox(10);
        middle.getChildren().addAll(newGameButton,loadGameButton,lernmodusButton,spielanleitungButton,endGameButton);
        middle.setPadding(new Insets(70,170,7,70));
        BorderPane root = new BorderPane();
        root.setTop(willkommensText);
        root.setPadding(new Insets(150,370,7,20));
        root.setCenter(middle);
      //  root.getChildren().add(label);
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





    public static void main(String[] args) {
        Application.launch(args);
    }
}