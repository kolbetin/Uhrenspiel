package Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

        public int game() {
           int total = 0;

        for (int i = 0; total < 11; i++) {

            total = total+1;
        }
        return total;
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
