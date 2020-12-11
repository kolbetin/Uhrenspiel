package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.ProgressData;
import Test.Persistenz.IOSerialisierung;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Uhrenspiel extends Application  {


    Random random;

    private GUI guiMC;
    private QuestionFreeAnswer guiFA;
    private MainScreen mainScreen;
    private SummaryScreen summaryScreen;
    private Verabschiedungsbildschirm verAbschieden;
    private GamesChoiceScreen choiceScreen;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<GUI> guiList;
    private AlertHelper alertHelper;
    public Game game;
    private ProgressData progressData;
    private File file;
    public int richtigeAntwort;
    public int falscheAntwort;
    private int level = 1;


      public void start(Stage primarystage) {

          stage1 = new Stage();
          stage2 = new Stage();

          mainScreen.start(stage1);

          mainScreen.newGameButton.setOnAction(event -> {
                 setChoiceScreen();
           });
          mainScreen.loadGameButton.setOnAction(event ->
                  loadProgress()
          );
          mainScreen.endGameButton.setOnAction(event -> {
                      Boolean alert = alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Spiel beenden!",
                              "Willst du wirklich beenden? ");
                      if (alert) {
                          stage1.close();
                      }
                  }
          );
      }

    private void setChoiceScreen(){
        choiceScreen.start(stage1);

        choiceScreen.level1.setOnAction(e -> {
            level = 1;
            newGame();
        });
        choiceScreen.level2.setOnAction(e -> {
            level = 2;
            newGame();
        });
        choiceScreen.level3.setOnAction(e -> {
            level = 3;
            newGame();
        });
        choiceScreen.level4.setOnAction(e -> {
            level = 4;
            newGame();
        });
        choiceScreen.backButton.setOnAction(event -> {
            start(stage1);
        });


    }


    public void newGame(){
        game.aufgabennummer = 0;
        richtigeAntwort =0;
        falscheAntwort= 0;
        game.getLevel(level);
        if(level<4){
            newGameMultipleChoice();
        }
        else {
            if (getGUI()== guiFA){
                newGameFreeAnswer();
            }
            else {
                newGameMultipleChoice();
            }
        }
    }

    public void newGameMultipleChoice() {
        game.nextQuestion();
        guiMC.zeit = game.key;
        guiMC.start(stage1);
        guiMC.antwort1.setText((String) game.answers.get(0));
        guiMC.antwort2.setText((String) game.answers.get(1));
        guiMC.antwort3.setText((String) game.answers.get(2));
        guiMC.antwort4.setText((String) game.answers.get(3));
        guiMC.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
        guiMC.level.setText("Level: " + level + choiceScreen.text2);
        guiMC.richtigeAntwort.setText("Richtige Antworten: " + richtigeAntwort);
        guiMC.falscheAntwort.setText("Falsche Antworten: " + falscheAntwort);
        if(level > 1){
            //guiMC.questionLabel.setText("Frage: Es ist __:__ Uhr?");
        }
        guiMC.goOn.setOnAction(event -> {
            if (level < 4) {
                if (game.aufgabennummer < 3) {
                    newGameMultipleChoice();
                } else {
                    newGameFreeAnswer();
                }
            }
            else {if (getGUI()== guiFA){
                newGameFreeAnswer();
            }
            else {
                newGameMultipleChoice();
            }
           }
        });
        guiMC.endButton.setOnAction(event -> endGame());
        guiMC.saveButton.setOnAction(event -> saveProgress());
        correctAnswerMC();
        System.out.println(game.key);
        System.out.println(game.liste);
        System.out.println(game.answers);
        System.out.println(game.aufgabennummer);
        System.out.println("Richtige Antwort; " + richtigeAntwort);
        System.out.println("Falsche Antwort; " + falscheAntwort);
        System.out.println(progressData.progress);

  }
      public void newGameFreeAnswer(){
          game.nextQuestion();
          guiFA.zeit = game.key;
          guiFA.start(stage1);
          guiFA.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
          guiFA.level.setText("Level: " + level);
          guiFA.givenMinutes.setText("00");
          guiFA.richtigeAntwort.setText("Richtige Antworten: " + richtigeAntwort );
          guiFA.falscheAntwort.setText("Falsche Antworten: " + falscheAntwort);
          if(level > 1){
             // guiFA.questionLabel.setText("Frage: Es ist __:__ Uhr?");
              guiFA.givenMinutes.setText("");
          }
          guiFA.goOn.setOnAction(event -> {
          System.out.println(game.aufgabennummer);
              if(game.aufgabennummer<4) {
                newGameFreeAnswer();
                } else {
                  gameEnd();
              }
                });
          guiFA.submitButton.setOnAction(event -> correctAnswerFA());
          guiFA.endButton.setOnAction(event -> endGame());
      //    guiFA.saveButton.setOnAction(event -> saveProgress());
          System.out.println(game.key);
          System.out.println(game.getAnswerFA(game.key));
          System.out.println(game.aufgabennummer);
          System.out.println("Richtige Antwort: " + richtigeAntwort);
          System.out.println("Falsche Antwort: " + falscheAntwort);
          System.out.println(progressData.progress);

      }

      public void correctAnswerFA() {
          if (!guiFA.givenHour.getText().isEmpty()
                  & guiFA.givenHour.getText() != null
                  & guiFA.givenHour.getText().matches("[0-9]*")
           ){ String answer = guiFA.givenHour.getText() + ":" + guiFA.givenMinutes.getText();
              if (answer.equals(game.getAnswerFA(game.key))
                      |answer.equals("0"+game.getAnswerFA(game.key))
                      |(guiFA.givenHour.getText().equals("0"+game.getAnswerFA(game.key))
                        |(guiFA.givenHour.getText().equals(game.getAnswerFA(game.key))))
                ) {
                  guiFA.submitButton.setStyle("-fx-background-color: #1cf61c");
                  guiFA.submitButton.setText("Super!!");
                  guiFA.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.key + " Uhr.");
                  guiFA.givenHour.setDisable(true);
                  guiFA.givenMinutes.setDisable(true);
                  guiFA.submitButton.setDisable(true);
                  richtigeAntwort++;
                  progressData.setProgressData(game.aufgabennummer,"Korrekt");
              } else {
                  guiFA.submitButton.setStyle("-fx-background-color: #dd2323");
                  guiFA.submitButton.setText("Leider, falsch!");
                  guiFA.questionLabel.setText("Das war leider nicht richtig!\n "
                          + "Deine Antwort: " + answer+ " Uhr.\n"
                          + "Die korrekte Antwort ist: " + game.key + " Uhr.");
                  falscheAntwort++;
                  progressData.setProgressData(game.aufgabennummer,"Falsch");
                  guiFA.givenHour.setDisable(true);
                  guiFA.givenMinutes.setDisable(true);
                  guiFA.submitButton.setDisable(true);
              }
          } else {
              alertHelper.showAlert(Alert.AlertType.ERROR,"Fehler" ,"Bitte eine Zahl eingeben, z.B. 8 oder 12.");
              guiFA.givenHour.clear();

          }
      }

     public void gameEnd(){
              summaryScreen.start(stage1);
              summaryScreen.willkommensText.setText("Level: " + level + " wurde abgeschlossen!");
              summaryScreen.labelRA.setText("Richtige Antworten: " + richtigeAntwort);
              summaryScreen.labelFA.setText("Falsche Antworten: " + falscheAntwort);

              summaryScreen.backButton.setOnAction(event -> start(stage1));
              summaryScreen.repeatLevel.setOnAction(event -> newGame());

              if(level< 4){
                    summaryScreen.nextGame.setOnAction(event -> {
                      level = level + 1;
                      newGame();
                      });
                  } else {
                      summaryScreen.nextGame.setDisable(true);
              }


          }


      public void correctAnswerMC() {
          EventHandler<MouseEvent> eventHandler = getEventHandler();
          guiMC.antwort1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.goOn.setDisable(true);
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

                      if (button.getText().contains(game.getAnswerFA(game.key)) ) {
                              button.setStyle("-fx-background-color: green");
                              button.setText("Super!!");
                              guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.key + " Uhr.");
                              richtigeAntwort++;
                              disableButtons();
                              guiMC.goOn.setDisable(false);
                              progressData.setProgressData(game.aufgabennummer,"Korrekt");

                              } else {
                              button.setStyle("-fx-background-color: red");
                              button.setText("Leider falsch!");
                              guiMC.questionLabel.setText("Das war leider nicht richtig! Die korrekte Antwort ist: " + game.key + " Uhr.");
                              falscheAntwort++;
                              disableButtons();
                              guiMC.goOn.setDisable(false);
                              progressData.setProgressData(game.aufgabennummer,"Falsch");
                          }

                      }
                  }

              };
          }






    public void endGame(){
            Boolean alert = alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION,  "Spiel beenden!",
                "Wenn du das Spiel beendest, geht der Fortschritt verloren! Willst du wirklich beenden? " );
            if(alert){
                stage1.close();
                start(stage1);
            }

    }

      public void saveProgress() {
          try {
              file = new File(createFileName());
              progressData.saveProgress(file);

              alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Speichern","Liste gespeichert in Datei " + file + ".");
          } catch (IOException e) {
              alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
          }
      }

      private String createFileName () {
          return  System.getProperty("user.home") + System.getProperty("file.separator") +
                  (progressData.getIOInterface() instanceof IOSerialisierung ?  "Spielstand.ser" : "Spielstand.txt");
      }

      private void loadProgress() {
          try {
              progressData.loadProgress(file);

              alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Speichern", "Liste von Datei " + file + " geladen.");
          } catch (IOException | ClassNotFoundException e) {
              alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
          }
      }

    public void fillGuiList() {
        guiList = new ArrayList<>();

        guiList.add(guiFA);
        guiList.add(guiMC);
    }

    public GUI getGUI() {
        random = new Random();
        int index = random.nextInt(guiList.size());
        return guiList.get(index);
    }


    public Uhrenspiel() {
        guiMC = new GUI();
        guiFA = new QuestionFreeAnswer();
        mainScreen = new MainScreen();
        choiceScreen = new GamesChoiceScreen();
        verAbschieden = new Verabschiedungsbildschirm();
        progressData = new ProgressData();
        game = new Game();
        choiceScreen = new GamesChoiceScreen();
        summaryScreen = new SummaryScreen();




        fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);

    }

     public static void main(String[] args) { launch(args);    }


}




