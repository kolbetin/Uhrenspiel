package Test.Presentation;

import Test.Domain.Game;
import Test.Presentation.GUI;
import Test.Test;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class QuestionFreeAnswer extends GUI {
    public Button goOn;
    private Game game;
    public TextField textField;
    public Button submitButton;

    public QuestionFreeAnswer(){
        game = new Game();
    }
    @Override
    public BorderPane middleArea() {

        final BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        antwortzähler = new Label("Aufgabe: " + game.aufgabennummer+ "  von 10");

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(questionArea());
        borderPane.setBottom(answerArea());


        middleArea.setTop(antwortzähler);
        middleArea.setBottom(borderPane);
        middleArea.setLeft(clockArea());



        return middleArea;

    }

    @Override
    public Pane answerArea() {
        final HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(15, 10, 10, 50));
        submitButton = new Button("Submit");
        textField = new TextField();
        submitButton.setOnAction(event -> {
            submitButton.setText("ich überlege");
        });
        goOn = new Button ("weiter");
        hBox.getChildren().addAll(
                new Text("Antwort"), textField,submitButton, goOn );
        return hBox;
    }




}
