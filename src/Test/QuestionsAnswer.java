package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.shape.Line;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static javafx.application.Application.launch;

public class QuestionsAnswer extends Application {

    public HashMap<Integer, String> antwortenMap;
    public HashMap<Line, Line>  uhrzeit;
    public HashMap<HashMap,String>  antworten;
    private ProgressData progressData;
    private IOInterface ioInterface;
    private ClockTest clock;
    public ArrayList<Integer> liste;

    public void start(Stage primarystage){

    }

    public QuestionsAnswer() {

        antwortenMap = new HashMap<>();
        antworten = new HashMap<>();
        uhrzeit = new HashMap<>();
        clock = new ClockTest();

      /*  uhrzeit.put(clock.stunde_1,clock.minuten_volleStunde);
        uhrzeit.put(clock.stunde_2,clock.minuten_volleStunde);
        add(uhrzeit,"1 Uhr");
        add(uhrzeit,"2 Uhr");*/
      //  System.out.println(antworten);
    //    System.out.println(uhrzeit.size());
        antwortenMapVolleStunde();
        //System.out.println(antwortenMap.get(3));
       // System.out.println(getKey());
       // System.out.println(getValue());
       // System.out.println(antwortenMap);
      // listebefüllen();

        System.out.println(antwortenMap.size());
        randomAnswer(3);
        System.out.println(liste.size());
        System.out.println(liste);
        //progressData.add(antwortenMap);
       // System.out.println(antwortenMap.size());
       // generateRandom(1,12);
    }

    private void antwortenMapVolleStunde() {
        antwortenMap.put(1, "eins");
        antwortenMap.put(2, "zwei");
        antwortenMap.put(3, "drei");
        antwortenMap.put(4, "vier");
        antwortenMap.put(5,"fünf");
        antwortenMap.put(6,"6");
        antwortenMap.put(7,"7");
        antwortenMap.put(8,"8");
        antwortenMap.put(9,"9");
        antwortenMap.put(10,"10");
        antwortenMap.put(11,"11");
        antwortenMap.put(12,"12");
    }



    public Integer getKey() {
        for (Integer i : antwortenMap.keySet()) {
            return (i);
        }
        return null;
    }


    public String getValue(){
    for (String i : antwortenMap.values()) {
        return(i);
    }
    return null;
    }

    public void add(HashMap Uhrenbild, String answer){
        antworten.put(Uhrenbild,answer);
    }



  /*  private void antwortenMapVSfalsch(){
        antwortenMap.put(1,2+4+8);
        antwortenMap.put(2,1+3+10);
        antwortenMap.put(3,2+7+4);
        antwortenMap.put(4,5+2+12);
    }*/



   public List randomAnswer(int key) {
        Random rand = new Random();
        liste =  new ArrayList<Integer>();
        int zufall;
        liste.add(key);
        for (int i = 0; liste.size() <4; i++) {
            zufall = rand.nextInt(antwortenMap.size());
            String value = antwortenMap.get(zufall);
            if (!liste.contains(value) || !liste.contains(key)) {
                liste.add(zufall);
            }

        }
        return null;

        }






    public static void main(String[] args) {
        launch(args);
    }
}
