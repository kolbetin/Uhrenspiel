package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.SavedData;
import Test.Persistenz.IOSerialisierung;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Uhrenspiel extends Application  {


    Random random;

    private GUI guiMC;
    private QuestionFreeAnswer guiFA;
    private MainScreen mainScreen;
    private SummaryScreen summaryScreen;
    private Verabschiedungsbildschirm verAbschieden;
    private GamesChoiceScreen choiceScreen;
    private Lernmodus lernmodus;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<GUI> guiList;
    private AlertHelper alertHelper;
    public Game game;
    private SavedData data;
    public int richtigeAntwort =0;
    public int falscheAntwort = 0;
    private Thread thread;
    public int level = 1;
    public boolean strictGame = false;
    private boolean saved = false;



      public void start(Stage primarystage) {

          stage1 = new Stage();
          stage2 = new Stage();

          mainScreen.start(stage1);

          mainScreen.newGameButton.setOnAction(event -> {
                 stage1.close();
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
          mainScreen.lernmodusButton.setOnAction(event -> {
              //stage1.close();
              startLernmodus();

          });
      }

    private void setChoiceScreen(){
        choiceScreen.start(stage1);

        choiceScreen.leadedGame.setOnAction(e ->{
            strictGame=true;
            level = 1;
            newGame();
        });
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
        choiceScreen.backButton.setOnAction(e -> {
            start(stage1);
        });
    }


        public void startLernmodus(){
            lernmodus.anzuzeigendeZiffer = 1;
            lernmodus.anzuzeigendeZeit = "01:00";
            lernmodus.start(stage1);
            lernmodus.text.setText("Es ist jetzt: " + lernmodus.anzuzeigendeZeit + " Uhr");

        // longrunning operation runs on different thread
         thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        lernmodus.startLernmodus();
                        lernmodus.start(stage1);
                        lernmodus.endButton.setOnAction(event -> {
                            thread.stop();
                            stage1.close();
                            start(stage1);
                        });
                        lernmodus.repeatButton.setOnAction(event -> {
                         startLernmodus();
                        });

                    }

                };
                boolean ende = false;
                while (!ende) {
                    if (lernmodus.anzuzeigendeZiffer < 11) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                     else {
                       ende = true;

                       }

                        // UI update is run on the Application thread
                        Platform.runLater(updater);
                    }
            }

        });

        thread.start();
    }


    public void newGame(){
        game.aufgabennummer = 0;
        richtigeAntwort =0;
        falscheAntwort= 0;

        game.playedGames.clear();
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

    private void setgoOnButton(){

          if( game.aufgabennummer<10) {
              if (level < 4) {
                  if (game.aufgabennummer < 5) {
                      newGameMultipleChoice();
                  } else {
                      newGameFreeAnswer();
                  }
              } else {
                  if (getGUI() == guiFA) {
                      newGameFreeAnswer();
                  } else {
                      newGameMultipleChoice();
                  }
              }
          }
          else {
              gameEnd();
          }
    }


    public void newGameMultipleChoice() {
        game.nextQuestion();
        guiMC.zeit = game.key ;
        guiMC.start(stage1);
        Collections.shuffle(game.liste);
        guiMC.antwort1.setText((String) game.liste.get(0));
        guiMC.antwort2.setText((String) game.liste.get(1));
        guiMC.antwort3.setText((String) game.liste.get(2));
        guiMC.antwort4.setText((String) game.liste.get(3));

        guiMC.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
        guiMC.level.setText("Level: " + level );
        guiMC.richtigeAntwort.setText("Richtige Antworten: " + richtigeAntwort);
        guiMC.falscheAntwort.setText("Falsche Antworten: " + falscheAntwort );
        guiMC.goOn.setOnAction(event -> setgoOnButton());
        guiMC.endButton.setOnAction(event -> endGame());
        guiMC.saveButton.setOnAction(event -> saveProgress());

        correctAnswerMC();
        System.out.println(game.key);
        System.out.println(game.liste);
        System.out.println(game.aufgabennummer);
        System.out.println("Richtige Antwort: " + richtigeAntwort);
        System.out.println("Falsche Antwort: " + falscheAntwort);
        System.out.println(game.playedGames);
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
                  guiFA.givenMinutes.setText("");
          }
          guiFA.goOn.setVisible(false);
          guiFA.submitButton.setOnAction(event -> correctAnswerFA());
          guiFA.endButton.setOnAction(event -> endGame());
          guiFA.saveButton.setOnAction(event -> saveProgress());
          System.out.println(game.key);
          System.out.println(game.getAnswerFA(game.key));
          System.out.println(game.aufgabennummer);
          System.out.println("Richtige Antwort: " + richtigeAntwort);
          System.out.println("Falsche Antwort: " + falscheAntwort);
          System.out.println(game.playedGames);
      }

      public void correctAnswerFA() {

          if (!guiFA.givenHour.getText().isEmpty()
                  & guiFA.givenHour.getText() != null
                  & guiFA.givenHour.getText().matches("[0-9]*")
           ){ String answer = guiFA.givenHour.getText() + ":" + guiFA.givenMinutes.getText();
              String answer0 =  "0"+ guiFA.givenHour.getText() + ":" + guiFA.givenMinutes.getText();
              if (answer.equals(game.getAnswerFA(game.key))
                      |answer0.equals(game.getAnswerFA(game.key))
                     // |(guiFA.givenHour.getText().equals("0"+game.getAnswerFA(game.key))
                        |(guiFA.givenHour.getText().equals(game.getAnswerFA(game.key)))
                ) {
                  guiFA.submitButton.setStyle("-fx-background-color: #1cf61c");
                  guiFA.submitButton.setText("Super!!");
                  guiFA.questionLabel.setText("Toll gemacht!");
                  guiFA.givenHour.setDisable(true);
                  guiFA.givenMinutes.setDisable(true);
                  guiFA.submitButton.setDisable(true);
                  guiFA.goOn.setVisible(true);
                  guiFA.goOn.setOnAction(event -> setgoOnButton());
                  richtigeAntwort++;
                } else {
                  guiFA.submitButton.setStyle("-fx-background-color: #dd2323");
                  guiFA.submitButton.setText("Leider, falsch!");
                  guiFA.questionLabel.setText("Das war leider nicht richtig!\n "
                          + "Deine Antwort: " + answer+ " Uhr.\n"
                          + "Die korrekte Antwort ist: " + game.key + " Uhr.");
                  falscheAntwort++;
                  guiFA.givenHour.setDisable(true);
                  guiFA.givenMinutes.setDisable(true);
                  guiFA.submitButton.setDisable(true);
                  guiFA.goOn.setVisible(true);
                  guiFA.goOn.setOnAction(event -> setgoOnButton());
              }
          } else {
              alertHelper.showAlert(Alert.AlertType.ERROR,"Fehler" ,"Bitte eine Zahl eingeben, z.B. 8 oder 12.");
              guiFA.givenHour.clear();
              guiFA.goOn.setVisible(true);

          }
      }

     public void gameEnd(){
              stage1.close();
              summaryScreen.start(stage1);

              summaryScreen.labelRA.setText("Richtige Antworten: " + richtigeAntwort);
              summaryScreen.labelFA.setText("Falsche Antworten: " + falscheAntwort);

              summaryScreen.backButton.setOnAction(event -> {
                  stage1.close();
                  start(stage1);

              });
              summaryScreen.repeatLevel.setOnAction(event -> newGame());

              if(! strictGame){
              summaryScreen.willkommensText.setText("Level: " + level + " wurde abgeschlossen!");
              if(level< 4){
                    summaryScreen.nextGame.setOnAction(event -> {
                        level = level + 1;
                      newGame();
                      });
                  } else {
                      summaryScreen.nextGame.setDisable(true);
              }
             }
             else {
                  double sum = 0;
                  sum    = sum + richtigeAntwort + falscheAntwort;

                  float pct = 0;
                  pct =  (float) (richtigeAntwort/sum);
                  System.out.println("Summe: " + sum+ " PCT: " + pct);

                 if (pct >= 0.6) {
                     summaryScreen.willkommensText.setText("Level: " + level +  " wurde erfolgreich abgeschlossen!");
                     System.out.println(sum + pct);
                 }
                 else {
                     summaryScreen.willkommensText.setText("Level: " + level + " wurde nicht erfolgreich abgeschlossen!");
                     System.out.println(sum + pct);
                 }
                 if (pct >= 0.6 & level< 4){
                     summaryScreen.nextGame.setOnAction(event -> {
                         level = level + 1;
                         newGame();
                     });
                 } else {
                     summaryScreen.nextGame.setVisible(false);

                 }
             }
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

                      if (button.getText().contains(game.getAnswerFA(game.key)) ) {
                              button.setStyle("-fx-background-color: green");
                              button.setText("Super!!");
                              guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.key + " Uhr.");
                              richtigeAntwort++;
                              disableButtons();
                              guiMC.goOn.setVisible(true);
                            //  progressData.setProgressData(game.aufgabennummer,"Korrekt");

                              } else {
                              button.setStyle("-fx-background-color: red");
                              button.setText("Leider falsch!");
                              guiMC.questionLabel.setText("Das war leider nicht richtig! Die korrekte Antwort ist: " + game.key + " Uhr.");
                              falscheAntwort++;
                              disableButtons();
                              guiMC.goOn.setVisible(true);
                             // progressData.setProgressData(game.aufgabennummer,"Falsch");
                          }

                      }
                  }

              };
          }


    public void endGame(){
           if (!saved) {
               Boolean alert = alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Spiel beenden!",
                       "Du hast nicht gespeichert! Möchtest du wirklich beenden? ");
               if (alert) {
                   stage1.close();
                   start(stage1);
               }
           }
            else{
                stage1.close();
                start(stage1);

            }
    }

      private String createFileName () {
          return  System.getProperty("user.home") + System.getProperty("file.separator") +
                  (data.getBufferInterface() instanceof IOSerialisierung ?  "Spielstand.ser" : "Spielstand.txt");
      }


    public void saveProgress() {
        try {
            String fileName = createFileName();

            data.progress.add(Integer.toString(game.aufgabennummer));
            data.progress.add(Integer.toString(level));
            data.progress.add(Boolean.toString( strictGame));
            data.progress.add(game.playedGames.toString());
            data.progress.add(Integer.toString(richtigeAntwort));
            data.progress.add(Integer.toString(falscheAntwort));
            data.saveProgress(fileName);
            saved = true;
            alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Speichern","Liste gespeichert in Datei " + fileName + ".");
        } catch (IOException e) {
            alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
        }
    }


    private void loadProgress() {
        try {
            String fileName = createFileName();
            data.loadProgress(fileName);
            updateDta();
            game.getLevel(level);
            setgoOnButton();
            alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Speichern", "Liste von Datei " + fileName + " geladen.");
        } catch (IOException | ClassNotFoundException e) {
            alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
        }
    }

    public void updateDta(){
        int r = Integer.parseInt(data.progress.get(4));
        richtigeAntwort = r;
        int f = Integer.parseInt(data.progress.get(5));
        falscheAntwort = f;
        int l = Integer.parseInt(data.progress.get(1));
        level = l;
        boolean b = Boolean.valueOf(data.progress.get(2));
        strictGame = b;
        game.playedGames.clear();
        game.playedGames.addAll(Arrays.asList(data.progress.get(3)));
        int a = Integer.parseInt(data.progress.get(0));
        game.aufgabennummer = a;

        System.out.println(game.aufgabennummer);
        System.out.println(level);
        System.out.println("Richtige Antwort: " + richtigeAntwort);
        System.out.println("Falsche Antwort: " + falscheAntwort);
        System.out.println(game.playedGames);
        System.out.println(strictGame);
    }



 /*   public void fillGuiList() {
        guiList = new ArrayList<>();
        guiList.add(guiFA);
        guiList.add(guiMC);
    }*/

    public GUI getGUI() {
        guiList = new ArrayList<>();
        guiList.add(guiFA);
        guiList.add(guiMC);
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
        game = new Game();
        choiceScreen = new GamesChoiceScreen();
        summaryScreen = new SummaryScreen();
        lernmodus = new Lernmodus();
        data = new SavedData();

       // fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);

    }

     public static void main(String[] args) { launch(args);    }


}




