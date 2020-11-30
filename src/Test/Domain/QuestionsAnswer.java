package Test.Domain;

import Test.Domain.ProgressData;
import Test.Test;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.shape.Line;

import java.util.*;

import static javafx.application.Application.launch;

public class QuestionsAnswer extends Application {

    public HashMap<Integer, String> antwortenMap;
    public HashMap<Line, Line>  uhrzeit;
    public HashMap<HashMap,String>  antworten;
    private ProgressData progressData;
    public ArrayList<Integer> liste;
    public List answers;
    private int key;

    private Random random;

    public void start(Stage primarystage){

    }

    public QuestionsAnswer() {
        random = new Random();
        liste =  new ArrayList<Integer>();
        antwortenMap = new HashMap<>();
        antworten = new HashMap<>();
        uhrzeit = new HashMap<>();


      // uhrzeit.put(clock.stunde_1,clock.minuten_volleStunde);
        //uhrzeit.put(clock.stunde_2,clock.minuten_volleStunde);
       // add(uhrzeit,"1 Uhr");
       // add(uhrzeit,"2 Uhr");
      //  System.out.println(antworten);
    //    System.out.println(uhrzeit.size());
        antwortenMapVolleStunde();
        //System.out.println(antwortenMap.get(3));
       // System.out.println(getKey());
       // System.out.println(getValue(3));
       // System.out.println(antwortenMap);
      // listebefüllen();

      //  System.out.println(antwortenMap.size());
       taskkey();
    //    System.out.println(taskkey());
        randomkey();
      //  System.out.println(liste);
        answerSet();
        //gameset();

        System.out.println(key);
        System.out.println(liste);
        System.out.println(answers);



        //progressData.add(antwortenMap);
       // System.out.println(antwortenMap.size());
       // generateRandom(1,12);
    }

    private void antwortenMapVolleStunde() {
        antwortenMap.put(1, "eins");
      //  antwortenMap.put("03:15", "eins");
        antwortenMap.put(2, "zwei");
        antwortenMap.put(3, "drei");
        antwortenMap.put(4, "vier");
        antwortenMap.put(5,"fünf");
        antwortenMap.put(6,"6");
        antwortenMap.put(7,"7");
        antwortenMap.put(8,"8");
        antwortenMap.put(9,"9");
        antwortenMap.put(10,"zehn");
        antwortenMap.put(11,"11");
        antwortenMap.put(12,"12");
    }




  /*  public void gameSet() {
        List count = new ArrayList<Integer>();
        for (int i = 0; playedGames.size() < 11; i++) {
            for (Integer key : antwortenMap.keySet()) {
                if (!playedGames.contains(key) & key != 0) {
                    playedGames.add(key);
                }
                count.add(i);
            }
        }
    }*/

    private Integer getkey()
    {
        for (Integer key : antwortenMap.keySet()){
            return key;
        }
        return null;
    }


    public String getValue(Integer value){
     return antwortenMap.get(value);
    }

    public void add(HashMap Uhrenbild, String answer){
        antworten.put(Uhrenbild,answer);
    }

  /*  public void gameset(){
        taskkey();
      randomkey(taskkey());
       answerSet();

    }*/


    public int taskkey() {

        for( int i = 0; liste.size() <2; i++){
            int zufall = random.nextInt(antwortenMap.size());
            if (zufall != 0) {
                key = zufall;
                liste.add(key);
            }
        }

        return key;
    }



   public List randomkey() {
       int zufall;

        for (int i = 0; liste.size() <4; i++) {
            zufall = random.nextInt(antwortenMap.size());
            if (!liste.contains(zufall) & zufall!= 0 & zufall!= key) {
                liste.add(zufall);
            }
        }

        return null;

        }

    public void answerSet() {
        answers = new ArrayList<String>();

        for (int i = 0; i < 4; i++) {
            String value =antwortenMap.get(liste.get(i));
            answers.add(value);
            Collections.shuffle(answers);
        }


    }




    public static void main(String[] args) {
        launch(args);
    }
}
