package Test.Domain;

import Test.Persistenz.IOSerialisierung;

import Test.Presentation.Question;
import javafx.application.Application;
import Test.Presentation.AlertHelper;
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
        public ArrayList<String> liste;
        public List answers;
        private String key;
        public int aufgabennummer;
        private  ArrayList<QuestionsAnswer> frageListe;
        private QuestionsAnswer aktuelleFrage;
        private Question question;
        private GUI gui;
        private Stage stage1;


    public void start(Stage primarystage){

    }


        public Game(){
          //  progressData = new ProgressData();
            questionsAnswermap = new QuestionsAnswer();
            answers = new ArrayList<String>();
            random = new Random();
            liste =  new ArrayList<String>();
           // nextQuestion();
            getTaskkey();
         //   randomAnswer();
         //   answerSet();
            //playGame();
           // getkey();
         //   System.out.println(key);
          //  System.out.println(questionsAnswermap.antwortenMap.get(getTaskkey()));
            System.out.println(randomAnswer());
            System.out.println(answers);


            }

    public void nextQuestion() {
        liste. clear();
        answers.clear();
        getTaskkey();
        randomAnswer();
        answerSet();
        aufgabennummer++;

      //  System.out.println(getTaskkey());
        System.out.println(key);
        System.out.println(liste);
        System.out.println(answers);
        System.out.println(aufgabennummer);
    }



    public void playGame() {

      //  liste. clear();
      //  answers.clear();
        for (int i = 0; i < 10; i++)  {
            nextQuestion();

         //   System.out.println(getTaskkey());
            System.out.println(liste);
            System.out.println(answers);
            System.out.println(aufgabennummer);

        }
    }

    public void getTaskkey() {

        Object[] test = questionsAnswermap.antwortenMap.keySet().toArray();
        Object key = test[new Random().nextInt(test.length)];
        System.out.println("************ Random Value ************ \n" + key + " :: " + questionsAnswermap.antwortenMap.get(key));

       //  for( int i = 0; liste.size() <; i++){
          //   String zufall = random.nextInt(questionsAnswermap.antwortenMap.size());
          //   String zufall = random.questionsAnswermap.antwortenMap.keySet();
          //   String value  = questionsAnswermap.antwortenMap.get(zufall);
                //key = value;
              //  liste.add(value);
       // }
     //   return  zufall;
    }



     /*   for (String key : questionsAnswermap.antwortenMap.keySet()){
            return key;
        }
        return null;*/

    public List randomAnswer() {
        int zufall;

        for (int i = 0; liste.size() <4; i++) {
            zufall = random.nextInt(questionsAnswermap.antwortenMap.size());
            String value = questionsAnswermap.antwortenMap.get(zufall);
            if (!liste.contains(value) /*& value != key*/) {
                liste.add(value);
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
