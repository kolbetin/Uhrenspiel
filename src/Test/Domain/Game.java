package Test.Domain;

import Test.Persistenz.IOSerialisierung;

import Test.Presentation.Question;
import javafx.application.Application;
import Test.Presentation.AlertHelper;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.*;


public class Game extends Application {

        private QuestionsAnswer questionsAnswermap;
        private ProgressData progressData;
        private AlertHelper alertHelper;
        private Random random;
        public List playedGames;
        private IOSerialisierung ioSerialisierung;
        public ArrayList<Integer> liste;
        public List answers;
        private int key;
        public int aufgabennummer;
        private  ArrayList<QuestionsAnswer> frageListe;
        private QuestionsAnswer aktuelleFrage;
        private Question question;


    public void start(Stage primarystage){

    }


        public Game(){
            progressData = new ProgressData();
          //  question = new Question();
            questionsAnswermap = new QuestionsAnswer();
            random = new Random();
            liste =  new ArrayList<Integer>();
            nextQuestion();
           // playGame();
            //System.out.println(playedGames);

            }

    public void nextQuestion() {

        taskkey();
        randomAnswer();
        answerSet();
        aufgabennummer++;

        System.out.println(taskkey());
        System.out.println(liste);
        System.out.println(answers);
        System.out.println(aufgabennummer);
    }



    public void playGame() {
        int i = 0;

        while (i < 11 ) {
            nextQuestion();
            System.out.println(taskkey());
            System.out.println(liste);
            System.out.println(answers);
            i++;
        }
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

    public List randomAnswer() {
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
