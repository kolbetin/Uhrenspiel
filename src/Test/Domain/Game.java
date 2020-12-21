package Test.Domain;

import Test.Persistenz.QuestionsAnswer;
import Test.Presentation.AlertHelper;
import Test.Presentation.MainGUI;
import Test.Presentation.QuestionFreeAnswer;
import Test.Presentation.Uhrenspiel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.*;


public class Game extends Application {

    private QuestionsAnswer questionsAnswermap;
    public List playedGames = null;
    public ArrayList<String> liste;
    public List answers;
    public String key;
    public int aufgabennummer;
    public int richtigeAntwort =0;
    public int falscheAntwort = 0;
    public int level = 1;
    public double sum = 0 ;


    public Game() {
        questionsAnswermap = new QuestionsAnswer();

        answers = new ArrayList<String>();
        liste = new ArrayList<String>();
        playedGames = new ArrayList<String>();
    //    getLevel(1);
    //    nextQuestion();


    }

    public void nextQuestion() {

        liste.clear();
       answers.clear();
        getTaskkey();
        randomAnswer();
        answerSet();
        aufgabennummer++;
        System.out.println(key);
    }

    public void setLevel(int level) {
        questionsAnswermap.antwortenMap.clear();
        if (level == 1) {
            questionsAnswermap.antwortenMapLevel1();
        }
        if (level == 2) {
            questionsAnswermap.antwortenMapLevel2();
        }
        if  (level == 3) {
            questionsAnswermap.antwortenMapLevel3();
        }
        if (level == 4) {
            questionsAnswermap.antwortenMapLevel1();
            questionsAnswermap.antwortenMapLevel2();
            questionsAnswermap.antwortenMapLevel3();
        }
        System.out.println(questionsAnswermap.antwortenMap.keySet());
        System.out.println(level);
    }


    public Object getTaskkey() {
        boolean played = false;

        while ( !played ){
            Object[] objects = questionsAnswermap.antwortenMap.keySet().toArray();
            Object randomkey = objects[new Random().nextInt(objects.length)];
            if (!playedGames.contains(randomkey)) {
                liste.add((String) randomkey);
                key = (String) randomkey;
                played = true;
               // playedGames.add(randomkey);
            }

        }

        return key;
    }


    public List randomAnswer() {

        Object[] objects = questionsAnswermap.antwortenMap.keySet().toArray();

        for (int i = 0; liste.size() < 4; i++) {
            Object keys = objects[new Random().nextInt(objects.length)];
            if (!liste.contains(keys) & keys != key  ) {
                liste.add((String) keys);
            }
        }
        Collections.shuffle(liste);
        return liste;
    }

    public void answerSet() {
        for (int i = 0; i < 4; i++) {
            String value = questionsAnswermap.antwortenMap.get(liste.get(i));
            answers.add(value);
            Collections.shuffle(answers);
        }
    }

    public String getAnswerFA(String keys) {
        String value = questionsAnswermap.antwortenMap.get(keys);
        return value;
    }

    public void start(Stage primaryStage) {}
      public static void main(String[] args) {
        launch(args);
    }
}
