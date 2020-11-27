package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static javafx.application.Application.launch;

public class QuestionsAnswer extends GUI {

    public HashMap<Integer, String> antwortenMap;
    private ProgressData progressData;
    private IOInterface ioInterface;

    /*public void start(Stage primarystage){

    }*/

    public QuestionsAnswer() {

        antwortenMap = new HashMap<>();
        antwortenMapVolleStunde();
        //System.out.println(antwortenMap.get(3));
        //System.out.println(getKey());
        //System.out.println(getValue());
        System.out.println(antwortenMap);

        //progressData.add(antwortenMap);
       // System.out.println(antwortenMap.size());
       // generateRandom(1,12);
    }

    private void antwortenMapVolleStunde() {
        antwortenMap.put(1, "1");
        antwortenMap.put(2, "2");
        antwortenMap.put(3, "drei");
        antwortenMap.put(4, "4");
     /*   antwortenMap.put(5,5);
        antwortenMap.put(6,6);
        antwortenMap.put(7,7);
        antwortenMap.put(8,8);
        antwortenMap.put(9,9);
        antwortenMap.put(10,10);
        antwortenMap.put(11,11);
        antwortenMap.put(12,12);*/
    }



    public HashMap<Integer,String> getKey(){
        for (Integer i : antwortenMap.keySet()){
            System.out.println(i);
        }
       return null;
    }
    public String getValue(){
    for (String i : antwortenMap.values()) {
       return(i);
    }
    return null;
    }

    public void add(Integer key, String answer){
        antwortenMap.put(key,answer);
    }


    @Override
    public Pane answerArea() {
        final HBox hBox = new HBox(35);
        hBox.setId("answerArea");

        hBox.setPadding(new Insets(15, 10, 10, 50));

        antwort1 = new Button("Antwort A");
        antwort2 = new Button("Antwort B");
        antwort3 = new Button("Antwort C");
        antwort4 = new Button("Antwort D");

        antwort1.setMinSize(120,40);



            Text antwort = new Text("Antwort");
            hBox.getChildren().addAll(antwort, antwort1, antwort2, antwort3, antwort4);

            return hBox;

    }

  /*  private void antwortenMapVSfalsch(){
        antwortenMap.put(1,2+4+8);
        antwortenMap.put(2,1+3+10);
        antwortenMap.put(3,2+7+4);
        antwortenMap.put(4,5+2+12);
    }*/



   /*public int generateRandom(int start, int end ) {
        Random rand = new Random();


       int  exclude = getKey();

        int range = end - start +1 ;
        int random = rand.nextInt(range) + 1;

        for(int i = 0; i < exclude; i++) {
            if(exclude > random) {
                return random;
            }
            random++;
        }

        return random;
    }
*/




    public static void main(String[] args) {
        launch(args);
    }
}
