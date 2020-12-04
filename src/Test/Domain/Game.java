package Test.Domain;

import Test.Persistenz.IOSerialisierung;

import Test.Presentation.Question;
import javafx.application.Application;
import Test.Presentation.AlertHelper;
import javafx.stage.Stage;
import Test.Presentation.GUI;

import java.util.*;


public class Game  {

        private QuestionsAnswer questionsAnswermap;
        private ProgressData progressData;
        private AlertHelper alertHelper;
        private Random random;
        public List playedGames;
        private IOSerialisierung ioSerialisierung;
        public ArrayList<String> liste;
        public List answers;
        public String key;
        public int aufgabennummer;
        private  ArrayList<QuestionsAnswer> frageListe;
        private QuestionsAnswer aktuelleFrage;
        private Question question;
        private GUI gui;
        private Stage stage1;




        public Game(){
          //  progressData = new ProgressData();
            questionsAnswermap = new QuestionsAnswer();
            answers = new ArrayList<String>();
            random = new Random();
            liste =  new ArrayList<String>();
           nextQuestion();
         /*   getTaskkey();
            System.out.println(liste);
            randomAnswer();
            answerSet();
            System.out.println(liste);*/
            //playGame();
           // getkey();
         //   System.out.println(key);
          //  System.out.println(questionsAnswermap.antwortenMap.get(getTaskkey()));
         //   System.out.println(randomAnswer());
          //  System.out.println(answers);


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

    public Object getTaskkey() {
        Object[] objects = questionsAnswermap.antwortenMap.keySet().toArray();
        Object randomkey = objects[new Random().nextInt(objects.length)];
        liste.add((String) randomkey);
        key = (String) randomkey;
        return key;
       //  for( int i = 0; liste.size() <; i++){
          //   String zufall = random.nextInt(questionsAnswermap.antwortenMap.size());
          //   //   String value  = questionsAnswermap.antwortenMap.get(zufall);
                //key = value;
              //  liste.add(value);
       // }
     //   return  zufall;
    }


    public void key() {
     /*   for (String key : questionsAnswermap.antwortenMap.keySet()){
            return key;
        }
        return null;*/
    }

    public List randomAnswer() {

        Object[] objects = questionsAnswermap.antwortenMap.keySet().toArray();

        for (int i = 0; liste.size() <4; i++) {
            Object keys = objects[new Random().nextInt(objects.length)];
            if (!liste.contains(keys) & keys != key) {
                liste.add((String) keys);
            }
        }


/*        int zufall;
        for (int i = 0; liste.size() <4; i++) {
            zufall = random.nextInt(questionsAnswermap.antwortenMap.size());
            if (!liste.contains(zufall) /*& value != key) {
                liste.add(zufall);
            }
        } */
        return liste;
    }

    public void answerSet() {

        for (int i = 0; i < 4; i++) {
            String value =questionsAnswermap.antwortenMap.get(liste.get(i));
            answers.add(value);
            Collections.shuffle(answers);
        }

    }



  /*  public static void main(String[] args) {
        launch(args);
    }*/

}
