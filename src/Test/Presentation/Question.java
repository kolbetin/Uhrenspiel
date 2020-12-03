package Test.Presentation;

import Test.Presentation.ClockSkin;
import Test.Domain.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Question extends GUI {
    private Game game;
    public Button goOn;

  //  public void start(Stage primarystage){ }

    public Question(){
        game = new Game();
       // game.nextQuestion();
       // System.out.println(game.answers);
       // System.out.println(game.taskkey());
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
     public Pane clockArea(){
     BorderPane borderPane= new BorderPane();
      borderPane.setId("clockArea");

      ClockSkin clock = new ClockSkin();

        //  borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(7,370,7,250));

        borderPane.setCenter(clock.createClockSkin());

        return borderPane;
    }


     @Override
    public Pane answerArea () {
        final HBox hBox = new HBox(35);
        hBox.setId("answerArea");

        hBox.setPadding(new Insets(15, 10, 10, 50));

       // antwort1 = new Button("");
        antwort1 = new Button(String.valueOf(game.answers.get(0)));
        antwort2 = new Button(String.valueOf(game.answers.get(1)));
        antwort3 = new Button(String.valueOf(game.answers.get(2)));
        antwort4 = new Button(String.valueOf(game.answers.get(3)));

        goOn = new Button ("weiter");




        Text antwort = new Text("Antwort");
        hBox.getChildren().addAll(antwort, antwort1, antwort2, antwort3, antwort4);
        hBox.getChildren().add(goOn);

        return hBox;
    }
}
