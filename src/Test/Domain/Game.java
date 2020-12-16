package Test.Domain;

import Test.Persistenz.QuestionsAnswer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.*;


public class Game extends Application {

    private QuestionsAnswer questionsAnswermap;
    public List playedGames;
    public ArrayList<String> liste;
    public List answers;
    public String key;
    public int aufgabennummer;
    public int level = 1;
    public boolean strictGame = false;


    public Game() {
        questionsAnswermap = new QuestionsAnswer();
        answers = new ArrayList<String>();
        liste = new ArrayList<String>();
        playedGames = new ArrayList<String>();
    //    getLevel(1);
    //    nextQuestion();
        System.out.println(playedGames);
        System.out.println(liste);
    }

    public void nextQuestion() {
        liste.clear();
       // answers.clear();
        getTaskkey();
        randomAnswer();
       // answerSet();
        aufgabennummer++;
    }

    public void getLevel(int level) {
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
                playedGames.add(randomkey);
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

  /*  public void answerSet() {
        for (int i = 0; i < 4; i++) {
            String value = questionsAnswermap.antwortenMap.get(liste.get(i));
            answers.add(value);
            Collections.shuffle(answers);
        }
    }*/

    public String getAnswerFA(String keys) {
        String value = questionsAnswermap.antwortenMap.get(keys);
        return value;
    }

    public void start(Stage primaryStage) {}
      public static void main(String[] args) {
        launch(args);
    }
}
