package Test.Domain;

import java.util.*;

import static javafx.application.Application.launch;

public class QuestionsAnswer {

    public HashMap<String, String> antwortenMap;
    private ProgressData progressData;


  /*  public void start(Stage primarystage){   }*/

    public QuestionsAnswer() {
        antwortenMap = new HashMap<>();
     //   antwortenMapLevel1();
      //  antwortenMapLevel2();
      //  antwortenMapLevel3();
        System.out.println(antwortenMap.size());

    }

    public void antwortenMapLevel1() {
        antwortenMap.put("01:00","1");
        antwortenMap.put("02:00","2");
        antwortenMap.put("03:00","3");
        antwortenMap.put("04:00","4");
        antwortenMap.put("05:00","5");
        antwortenMap.put("06:00","6");
        antwortenMap.put("07:00","7");
        antwortenMap.put("08:00","8");
        antwortenMap.put("09:00","9");
        antwortenMap.put("10:00","10");
        antwortenMap.put("11:00","11");
        antwortenMap.put("12:00","12");
    }

    public void antwortenMapLevel2() {
        antwortenMap.put("01:30","1:30");
        antwortenMap.put("02:30","2:30");
        antwortenMap.put("03:30","3:30");
        antwortenMap.put("04:30","4:30");
        antwortenMap.put("05:30","5:30");
        antwortenMap.put("06:30","6:30");
        antwortenMap.put("07:30","7:30");
        antwortenMap.put("08:30","8:30");
        antwortenMap.put("09:30","9:30");
        antwortenMap.put("10:30","10:30");
        antwortenMap.put("11:30","11:30");
        antwortenMap.put("12:30","12:30");
    }
    public void antwortenMapLevel3() {
        antwortenMap.put("01:15","1:15");
        antwortenMap.put("02:15","2:15");
        antwortenMap.put("03:15","3:15");
        antwortenMap.put("04:15","4:15");
        antwortenMap.put("05:15","5:15");
        antwortenMap.put("06:15","6:15");
        antwortenMap.put("07:15","7:15");
        antwortenMap.put("08:15","8:15");
        antwortenMap.put("09:15","9:15");
        antwortenMap.put("10:15","10:15");
        antwortenMap.put("11:15","11:15");
        antwortenMap.put("12:15","12:15");
        antwortenMap.put("01:45","1:45");
        antwortenMap.put("02:45","2:45");
        antwortenMap.put("03:45","3:45");
        antwortenMap.put("04:45","4:45");
        antwortenMap.put("05:45","5:45");
        antwortenMap.put("06:45","6:45");
        antwortenMap.put("07:45","7:45");
        antwortenMap.put("08:45","8:45");
        antwortenMap.put("09:45","9:45");
        antwortenMap.put("10:45","10:45");
        antwortenMap.put("11:45","11:45");
        antwortenMap.put("12:45","12:45");
    }

    public String getValue(String value){
     return antwortenMap.get(value);
    }



  /*  public static void main(String[] args) {
        launch(args);
    }*/
}
