package Test.Domain;

import Test.Persistenz.IOSerialisierung;

import Test.Presentation.Question;
import javafx.application.Application;
import Test.Presentation.AlertHelper;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Test.Presentation.GUI;

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
        private GUI gui;


    public void start(Stage primarystage){

    }


        public Game(){
          //  progressData = new ProgressData();
          //  question = new Question();
            questionsAnswermap = new QuestionsAnswer();
            answers = new ArrayList<String>();
            random = new Random();
            liste =  new ArrayList<Integer>();
           // nextQuestion();
            playGame();
            //System.out.println(playedGames);

            }

    public void nextQuestion() {
        liste. clear();
        answers.clear();
        getTaskkey();
        randomAnswer();
        answerSet();
        aufgabennummer++;

        System.out.println(getTaskkey());
        System.out.println(liste);
        System.out.println(answers);
        System.out.println(aufgabennummer);
    }



    public void playGame() {

      //  liste. clear();
      //  answers.clear();
        for (int i = 0; i < 10; i++)  {
            nextQuestion();

            System.out.println(getTaskkey());
            System.out.println(liste);
            System.out.println(answers);
            System.out.println(aufgabennummer);

        }
    }

    public int getTaskkey() {

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
            if (!liste.contains(zufall) & zufall!= 0 & zufall != key) {
                liste.add(zufall);
            }
        }
        return liste;
    }

    public void answerSet() {


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
