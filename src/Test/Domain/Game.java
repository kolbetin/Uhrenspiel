package Test.Domain;

import Test.Persistenz.QuestionsAnswer;
import Test.Presentation.AlertHelper;
import Test.Presentation.GUI;
import Test.Presentation.QuestionFreeAnswer;
import Test.Presentation.Uhrenspiel;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.*;


public class Game extends Application {

    private QuestionsAnswer questionsAnswermap;
    public List playedGames = null;
    public ArrayList<String> liste;
    public List answers;
    public String key;
    public int aufgabennummer;
    public GUI guiMC;
    public QuestionFreeAnswer guiFA;
    public Uhrenspiel uhrenspiel;
    public int richtigeAntwort =0;
    public int falscheAntwort = 0;
    public int level = 1;
    public double sum = 0 ;
    private AlertHelper alertHelper;

    public Game() {
        questionsAnswermap = new QuestionsAnswer();
        guiMC = new GUI();
        guiFA = new QuestionFreeAnswer();

      //  answers = new ArrayList<String>();
        liste = new ArrayList<String>();
        playedGames = new ArrayList<String>();
    //    getLevel(1);
    //    nextQuestion();


    }

    public void nextQuestion() {

        liste.clear();

       // answers.clear();
        getTaskkey();
        randomAnswer();
       // answerSet();
        aufgabennummer++;
        System.out.println(key);
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

/*
    public void setgoOnButton(Stage stage1){
        uhrenspiel = new Uhrenspiel();
        if( aufgabennummer<3) {
            if (level < 4) {
                if (aufgabennummer < 4) {
                    newGameMultipleChoice(stage1);
                } else {
                    newGameFreeAnswer(stage1);
                }
            } else {
                if (uhrenspiel.getGUI() == guiFA) {
                    newGameFreeAnswer(stage1);
                } else {
                    newGameMultipleChoice(stage1);
                }
            }
        }
        else {
            //stage1.close();
            uhrenspiel.summaryGame();
        }
    }


    public void newGameMultipleChoice(Stage stage1) {
        uhrenspiel = new Uhrenspiel();
        nextQuestion();
        guiMC.zeit = key ;
        guiMC.start(stage1);
        Collections.shuffle(liste);
        guiMC.antwort1.setText((String) liste.get(0));
        guiMC.antwort2.setText((String) liste.get(1));
        guiMC.antwort3.setText((String) liste.get(2));
        guiMC.antwort4.setText((String) liste.get(3));

        guiMC.antwortzähler.setText("Aufgabe: " + aufgabennummer + "  von 10");
        guiMC.level.setText("Level: " + level );
        guiMC.allAnswers.setText("Insgesamt beantwortete "+ "\n"+"Fragen: "+ (int)sum );
        guiMC.richtigeAntwort.setText("Richtige Antworten: " + richtigeAntwort);
        guiMC.falscheAntwort.setText("Falsche Antworten: " + falscheAntwort );
        guiMC.goOn.setOnAction(event -> setgoOnButton(stage1));
        guiMC.endButton.setOnAction(event -> {
            stage1.close();
            uhrenspiel.endGame();
        });
        guiMC.saveButton.setOnAction(event -> {  uhrenspiel.saveProgress();   });

        correctAnswerMC();
        System.out.println(key);
        System.out.println(liste);
        System.out.println(aufgabennummer);
        System.out.println("Richtige Antwort: " + richtigeAntwort);
        System.out.println("Falsche Antwort: " + falscheAntwort);
        System.out.println(playedGames);
    }
    public void correctAnswerMC() {
        EventHandler<MouseEvent> eventHandler = getEventHandler();
        guiMC.antwort1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        guiMC.antwort2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        guiMC.antwort3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        guiMC.antwort4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        guiMC.goOn.setVisible(false);
    }

    private void disableButtons(){
        guiMC.antwort1.setDisable(true);
        guiMC.antwort2.setDisable(true);
        guiMC.antwort3.setDisable(true);
        guiMC.antwort4.setDisable(true);
    }


    EventHandler<MouseEvent> getEventHandler() {
        //Creating the mouse event handler
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (event.getSource() instanceof Button) {
                    Button button = (Button) event.getSource();

                    if (button.getText().contains(getAnswerFA(key)) ) {
                        button.setStyle("-fx-background-color: green");
                        button.setText("Super!!");
                        guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + key + " Uhr.");
                        richtigeAntwort++;
                        sum++;
                        disableButtons();
                        guiMC.goOn.setVisible(true);


                    } else {
                        button.setStyle("-fx-background-color: red");
                        button.setText("Leider falsch!");
                        guiMC.questionLabel.setText("Das war leider nicht richtig! Die korrekte Antwort ist: " + key + " Uhr.");
                        falscheAntwort++;
                        sum++;
                        disableButtons();
                        guiMC.goOn.setVisible(true);

                    }

                }
            }

        };
    }
    public void newGameFreeAnswer(Stage stage1){
        uhrenspiel = new Uhrenspiel();
        nextQuestion();
        guiFA.zeit = key;
        guiFA.start(stage1);
        guiFA.antwortzähler.setText("Aufgabe: " + aufgabennummer + "  von 10");
        guiFA.level.setText("Level: " + level);
        guiFA.givenMinutes.setText("00");
        guiFA.allAnswers.setText("Insgesamt beantwortete "+ "\n"+"Fragen: "+ (int)sum  );
        guiFA.richtigeAntwort.setText("Richtige Antworten: " + richtigeAntwort );
        guiFA.falscheAntwort.setText("Falsche Antworten: " + falscheAntwort);
        guiFA.goOn.setOnAction(event -> setgoOnButton(stage1));
        if(level > 1){
            guiFA.givenMinutes.setText("");
        }
        guiFA.goOn.setVisible(false);
        guiFA.submitButton.setOnAction(event -> correctAnswerFA());
        guiFA.endButton.setOnAction(event -> uhrenspiel.endGame());
        guiFA.saveButton.setOnAction(event -> uhrenspiel.saveProgress());
        System.out.println(key);
        System.out.println(getAnswerFA(key));
        System.out.println(aufgabennummer);
        System.out.println("Richtige Antwort: " + richtigeAntwort);
        System.out.println("Falsche Antwort: " + falscheAntwort);
        System.out.println(playedGames);
    }

    public void correctAnswerFA() {

        if (!guiFA.givenHour.getText().isEmpty()
                & guiFA.givenHour.getText() != null
                & guiFA.givenHour.getText().matches("[0-9]*")
        ){ String answer = guiFA.givenHour.getText() + ":" + guiFA.givenMinutes.getText();
            String answer0 =  "0"+ guiFA.givenHour.getText() + ":" + guiFA.givenMinutes.getText();
            if (answer.equals(getAnswerFA(key))
                    |answer0.equals(getAnswerFA(key))
                    // |(guiFA.givenHour.getText().equals("0"+game.getAnswerFA(game.key))
                    |(guiFA.givenHour.getText().equals(getAnswerFA(key)))
            ) {
                guiFA.submitButton.setStyle("-fx-background-color: #1cf61c");
                guiFA.submitButton.setText("Super!!");
                guiFA.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + key + " Uhr.");
                guiFA.givenHour.setDisable(true);
                guiFA.givenMinutes.setDisable(true);
                guiFA.submitButton.setDisable(true);
                guiFA.goOn.setVisible(true);

                richtigeAntwort++;
                sum++;
            } else {
                guiFA.submitButton.setStyle("-fx-background-color: #dd2323");
                guiFA.submitButton.setText("Leider, falsch!");
                guiFA.questionLabel.setText("Das war leider nicht richtig!\n"
                        + "Deine Antwort: " + answer+ " Uhr.\n"
                        + "Die korrekte Antwort ist: " + key + " Uhr.");
                falscheAntwort++;
                sum++;
                guiFA.givenHour.setDisable(true);
                guiFA.givenMinutes.setDisable(true);
                guiFA.submitButton.setDisable(true);
                guiFA.goOn.setVisible(true);
                //guiFA.goOn.setOnAction(event -> setgoOnButton(stage1));
            }
        } else {
            alertHelper.showAlert(Alert.AlertType.ERROR,"Fehler" ,"Bitte eine Zahl eingeben, z.B. 8 oder 12.");
            guiFA.givenHour.clear();
            guiFA.goOn.setVisible(true);

        }
    }*/



    public void start(Stage primaryStage) {}
      public static void main(String[] args) {
        launch(args);
    }
}
