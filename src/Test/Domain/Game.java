package Test.Domain;

import Test.Persistenz.IOSerialisierung;

import Test.Presentation.GUI;
import Test.ClockSkin;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import Test.Presentation.AlertHelper;
import java.util.List;
import java.util.Random;


public class Game extends GUI {

        private QuestionsAnswer questionsAnswermap;
        private ProgressData progressData;
        private AlertHelper alertHelper;
        private Random random;
        public List playedGames;
        private IOSerialisierung ioSerialisierung;

        public Game(){
            progressData = new ProgressData();
            questionsAnswermap = new QuestionsAnswer();
            //game();

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

                antwort1 = new Button(String.valueOf(questionsAnswermap.answers.get(0)));
                antwort2 = new Button(String.valueOf(questionsAnswermap.answers.get(1)));
                antwort3 = new Button(String.valueOf(questionsAnswermap.answers.get(2)));
                antwort4 = new Button(String.valueOf(questionsAnswermap.answers.get(3)));


                Text antwort = new Text("Antwort");
                hBox.getChildren().addAll(antwort, antwort1, antwort2, antwort3, antwort4);

                return hBox;
            }





    public static void main(String[] args) {
        launch(args);
    }

}
