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





    public void start(Stage primarystage){

    }

    public QuestionsAnswer() {
        antwortenMap = new HashMap<>();
        antworten = new HashMap<>();
        uhrzeit = new HashMap<>();

        antwortenMapVolleStunde();
        //System.out.println(antwortenMap.get(3));
       // System.out.println(getKey());
       // System.out.println(getValue(3));
       // System.out.println(antwortenMap);
      // listebefüllen();

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

    public String getValue(Integer value){
     return antwortenMap.get(value);
    }

    public void add(HashMap Uhrenbild, String answer){
        antworten.put(Uhrenbild,answer);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
