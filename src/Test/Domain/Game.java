package Test.Domain;

import Test.Persistenz.IOSerialisierung;

import Test.Presentation.GUI;
import Test.ClockSkin;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import Test.Presentation.AlertHelper;

import java.util.*;


public class Game extends GUI {

        private QuestionsAnswer questionsAnswermap;
        private ProgressData progressData;
        private AlertHelper alertHelper;
        private Random random;
        public List playedGames;
        private IOSerialisierung ioSerialisierung;
        public ArrayList<Integer> liste;
        public List answers;
        private int key;



        public Game(){
            progressData = new ProgressData();
            questionsAnswermap = new QuestionsAnswer();
            random = new Random();
            liste =  new ArrayList<Integer>();
            System.out.println(questionsAnswermap.antwortenMap.size());
            taskkey();
            randomkey();
            answerSet();
            System.out.println(answers);
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

                antwort1 = new Button(String.valueOf(answers.get(0)));
                antwort2 = new Button(String.valueOf(answers.get(1)));
                antwort3 = new Button(String.valueOf(answers.get(2)));
                antwort4 = new Button(String.valueOf(answers.get(3)));


                Text antwort = new Text("Antwort");
                hBox.getChildren().addAll(antwort, antwort1, antwort2, antwort3, antwort4);

                return hBox;
            }

    public int taskkey() {

        for( int i = 0; liste.size() <2; i++){
            int zufall = random.nextInt(questionsAnswermap.antwortenMap.size());
            if (zufall != 0) {
                key = zufall;
                liste.add(key);
            }
        }

        return key;
    }

    private Integer getkey()
    {
        for (Integer key : questionsAnswermap.antwortenMap.keySet()){
            return key;
        }
        return null;
    }

    public List randomkey() {
        int zufall;

        for (int i = 0; liste.size() <4; i++) {
            zufall = random.nextInt(questionsAnswermap.antwortenMap.size());
            if (!liste.contains(zufall) & zufall!= 0 & zufall!= key) {
                liste.add(zufall);
            }
        }

        return null;

    }

    public void answerSet() {
        answers = new ArrayList<String>();

        for (int i = 0; i < 4; i++) {
            String value =questionsAnswermap.antwortenMap.get(liste.get(i));
            answers.add(value);
            Collections.shuffle(answers);
        }
    }



    public static void main(String[] args) {
        launch(args);
    }

}
