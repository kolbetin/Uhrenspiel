package Test.Domain;

import Test.Domain.ProgressData;
import Test.Test;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.shape.Line;

import java.util.*;

import static javafx.application.Application.launch;

public class QuestionsAnswer extends Application {

    public HashMap<String, String> antwortenMap;
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
      ///System.out.println(antwortenMap.get(getValue()));
        System.out.println(antwortenMap.keySet());

       // System.out.println(getValue("01:00"));
       // System.out.println(antwortenMap);
      // listebefüllen();

    }

    private void antwortenMapVolleStunde() {
        antwortenMap.put("01:00", "1");
        antwortenMap.put("02:00", "2");
        antwortenMap.put("03:00", "3");
        antwortenMap.put("04:00", "4");
        antwortenMap.put("05:00","5");
        antwortenMap.put("06:00","6");
        antwortenMap.put("07:00","7");
        antwortenMap.put("08:00","8");
        antwortenMap.put("09:00","9");
        antwortenMap.put("10:00","10");
        antwortenMap.put("11:00","11");
        antwortenMap.put("12:00","12");
    }

    public String getValue(String value){
     return antwortenMap.get(value);
    }


    public void add(HashMap Uhrenbild, String answer){
        antworten.put(Uhrenbild,answer);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
