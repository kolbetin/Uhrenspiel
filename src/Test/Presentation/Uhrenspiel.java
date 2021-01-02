/**
 * Die Klasse ist die Hauptklasse die alle GUI's zusammenführt und durch das Spiel führt.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */

package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.checkEntryFA;
import Test.Persistenz.SavedData;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Uhrenspiel extends Application  {

    private Random random;
    private MainGUI guiMC;
    private QuestionFreeAnswer guiFA;
    private MainScreenGUI mainScreen;
    private SummaryGUI summaryScreen;
    private ExpertSummaryGUI expertSummaryGUI;
    private ChoiceScreenGame choiceScreenGame;
    private ChoiceScreenLernmodus choiceScreenLernmodus;
    private Lernmodus learnModus;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    private ArrayList<MainGUI> guiList;
    private Game game;
    private SavedData data;
    private boolean strictGame = false;
    private Spielanleitung spielanleitung;
    private checkEntryFA checkEntryFA;
    private boolean success = false;

    /**
     * Die Methode startet den Main Screen GUI.
     */


      public void start(Stage primaryStage) {


          stage1 = new Stage();
          stage2 = new Stage();
          stage3 = new Stage();

      /*  expertSummaryGUI.setSuccess(true);
          expertSummaryGUI.start(stage2);

        expertSummaryGUI.setSuccess(false);
          expertSummaryGUI.start(stage3);*/

          summaryScreen.start(stage3);
          mainScreen.start(stage1);

          mainScreen.newGameButton.setOnAction(event -> {
                 stage1.close();
                 startChoiceScreenGame();
           });

          mainScreen.loadGameButton.setOnAction(event ->
                  loadProgress()
                            );
          mainScreen.endGameButton.setOnAction(event -> {
                      Boolean alert = AlertHelper.confirmationAlert("Spiel beenden!",  "Willst du wirklich beenden? ");
                      if (alert) {
                          stage1.close();
                      }
                  }
          );
          mainScreen.lernmodusButton.setOnAction(event ->
                     startChoiceScreenLernmodus()
          );
          mainScreen.spielanleitungButton.setOnAction(event ->
              spielanleitung.startSpielanleitung(stage1)
          );
      }


    /**
     * Die Methode startet die GUI für die Spielauswahl.
     */

    private void startChoiceScreenGame(){
        choiceScreenGame.start(stage1);
        choiceScreenGame.header.setText("Neues Spiel");

        choiceScreenGame.leadedGame.setOnAction(e ->{
            strictGame=true;
            game.level = 1;
             newGame();
        });

        choiceScreenGame.level1.setOnAction(e -> {
            game.level = 1;
            newGame();
        });

        choiceScreenGame.level2.setOnAction(e -> {
            game.level = 2;
            newGame();

        });
        choiceScreenGame.level3.setOnAction(e -> {
            game.level = 3;
            newGame();

        });
        choiceScreenGame.level4.setOnAction(e -> {
            game.level=4;
            newGame();

        });
        choiceScreenGame.backButton.setOnAction(e -> {
            stage1.close();
            start(stage1);
        });
    }


    /**
     * Die Methode startet die GUI für den Lernmodus.
     */
    private void startChoiceScreenLernmodus(){
        choiceScreenLernmodus.start(stage1);
        choiceScreenLernmodus.header.setText("Lernmodus");

        choiceScreenLernmodus.level1.setOnAction(e -> {
            game.level = 1;
            setLernmodus(game.level);
        });

        choiceScreenLernmodus.level2.setOnAction(e -> {
            game.level = 2;
            setLernmodus(game.level);

        });
        choiceScreenLernmodus.level3.setOnAction(e -> {
            game.level = 3;
            setLernmodus(game.level);

        });
        choiceScreenLernmodus.level4.setOnAction(e -> {
            game.level=4;
            setLernmodus(game.level);

        });
        choiceScreenLernmodus.backButton.setOnAction(e -> {
            stage1.close();
            start(stage1);
        });
    }

    /**
     * Die Methode stellt den Lernmodus ein und startet die Lernmodus GUI.
     */
         private void setLernmodus(int level){
                learnModus.setAnzuzeigendeZeitLernmodus(level);
                learnModus.setStartTime(level);
                learnModus.startLernmodus(stage1,level);
         }

    /**
     * Die Methode stellt alle Spielparameter zurück.
     */

         public void setBackData(){
                game.taskNumber = 0;
                game.correctAnswer =0;
                game.wrongAnswer = 0;
                game.saved = false;
                game.playedGames.clear();
                game.setLevel(game.level);

                if(!strictGame){
                game.sum =0;
                 }
        }
    /**
     * Die Methode startet ein neues Spiel.
     */


    public void newGame(){
        setBackData();

        if(game.level<4){
            newGameMultipleChoice();
        }
        else {
            if (getRandomGUI()== guiFA){
               newGameFreeAnswer();
            }
            else {
                newGameMultipleChoice();
            }
        }
    }

    /**
     * Die Methode startet eine weitere Aufgabe oder beendet eine Level.
     */
     public void setgoOnButton(){
         game.playedGames.add(game.key);

          if( game.taskNumber <10) {
              if (game.level < 4) {
                  if (game.taskNumber < 5) {
                      newGameMultipleChoice();
                  } else {
                      newGameFreeAnswer();
                  }
              } else {
                  if (getRandomGUI() == guiFA) {
                      newGameFreeAnswer();
                  } else {
                     newGameMultipleChoice();
                  }
              }
          }
          else {
              gameSummary();
          }
    }
    /**
     * Die Methode startet den Multiple Choice Bildschirm für eine Frage.
     */

    public void newGameMultipleChoice() {

        game.nextQuestion();

        guiMC.time = game.key ;
        guiMC.setGameValues(game.taskNumber,
                game.level,
                game.sum,
                game.correctAnswer,
                game.wrongAnswer,
                game.answerList,
                strictGame
        );

        guiMC.start(stage1);

        guiMC.goOn.setOnAction(event -> setgoOnButton());
        guiMC.goOn.setVisible(false);
        guiMC.endButton.setOnAction(event -> endGame());
        guiMC.saveButton.setOnAction(event -> saveProgress());
        answerCheckMC();
        showData();
  }
    /**
     * Die Methode gibt alle relevanten Spielparameter in der Konsole aus.
     */
    private void showData(){
        System.out.println(game.key);
        System.out.println(game.keyList);
        System.out.println(game.taskNumber);
        System.out.println("Richtige Antwort: " + game.correctAnswer);
        System.out.println("Falsche Antwort: " + game.wrongAnswer);
        System.out.println(game.playedGames);
    }

    /**
     * Die Methode startet den Freie Antwort Bildschirm für eine Frage.
     */

      public void newGameFreeAnswer(){
          game.nextQuestion();
          guiFA.time = game.key;
          guiFA.setGameValues(game.taskNumber,
                  game.level,
                  game.sum,
                  game.correctAnswer,
                  game.wrongAnswer,
                  game.answerList,
                  strictGame
          );
          guiFA.start(stage1);

          guiFA.goOn.setVisible(false);
          guiFA.goOn.setOnAction(event -> setgoOnButton());

          guiFA.submitButton.setOnAction(event -> checkEntry() );

          guiFA.givenHour.setOnKeyPressed(keyEvent -> {
              if (keyEvent.getCode() == KeyCode.ENTER) {
                  checkEntry();
              }
          });

          guiFA.givenMinutes.setOnKeyPressed(keyEvent -> {
              if (keyEvent.getCode() == KeyCode.ENTER) {
                  checkEntry();
              }
          });

          guiFA.endButton.setOnAction(event -> endGame());
          guiFA.saveButton.setOnAction(event -> saveProgress());

          showData();
      }

    /**
     * Die Methode startet die Kontrolle der Eingabe im Freien Antwortenmodus.
     */

      private void checkEntry(){
          checkEntryFA.setValues(guiFA.givenHour.getText(),guiFA.givenMinutes.getText());

          if(checkEntryFA.correctEntry){
              answerFA();
          }
          else
              checkEntryFA.sendAlert();
               if(checkEntryFA.clearMinute){
                 guiFA.givenMinutes.clear();
             }
            if (checkEntryFA.clearHour) {
              guiFA.givenHour.clear();
            }
      }

    /**
     * Die Methode gibt im Freie Antwortenmodus zurück ob die eingegbene Antwort korrekt oder falsch war.
     */
      public void answerFA() {

                if(game.checkAnswerFA(guiFA.givenHour.getText(), guiFA.givenMinutes.getText()))
                {
                  guiFA.submitButton.setId("buttonOkay");
                  guiFA.submitButton.setText("");
                  guiFA.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                  game.correctAnswer++;
                  manageButtonsFA();
                  game.sum++;
                }
                else {
                  guiFA.submitButton.setId("buttonNotOkay");
                  guiFA.submitButton.setText("");
                  guiFA.questionLabel.setText("Das war leider nicht richtig!\n"
                          + "Deine Antwort: " + game.answer+ " Uhr.\n"
                          + "Die korrekte Antwort ist: " + game.getAnswerFA(game.key)+ " Uhr.");
                  game.wrongAnswer++;
                  manageButtonsFA();
                  game.sum++;
               }
         }

    /**
     * Die Methode verwaltet die Buttons im Freie Antwortenmodus Bildschirm.
     */

     private void manageButtonsFA(){
         guiFA.givenHour.setDisable(true);
         guiFA.givenMinutes.setDisable(true);
         guiFA.submitButton.setDisable(true);
         guiFA.goOn.setVisible(true);
     }

    /**
     * Die Methode fügt alle Multiple Choice Buttons dem Eventhandler hinzu.
     */

    private void answerCheckMC() {
          EventHandler<MouseEvent> eventHandler = getEventHandler();
          guiMC.answer1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.answer2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.answer3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.answer4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
      }

    /**
     * Die Methode verwaltet die Buttons im Mulitple Choice Bildschirm.
     */

      private void manageButtonsMC(){
          guiMC.answer1.setDisable(true);
          guiMC.answer2.setDisable(true);
          guiMC.answer3.setDisable(true);
          guiMC.answer4.setDisable(true);
          guiMC.goOn.setVisible(true);
      }

    /**
     * Die Methode prüft alle Events der Buttons im Multiple Choice Screen und gibt Feedback an den Spieler,
     * ob der korrekte oder falsche Button gedrückt wurde.
     */

          EventHandler<MouseEvent> getEventHandler() {
              //Creating the mouse event handler
             return event -> {

                 if (event.getSource() instanceof Button) {
                     Button button = (Button) event.getSource();

                     if (button.getText().equals(game.getAnswerFA(game.key)) ) {
                         button.setId("buttonOkay");
                         button.setText("");
                         guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                         game.correctAnswer++;
                         manageButtonsMC();
                         game.sum++;

                     }
                     else {
                         button.setId("buttonNotOkay");
                         button.setText("");
                         guiMC.questionLabel.setText("Das war leider nicht richtig! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                         game.wrongAnswer++;
                         manageButtonsMC();
                         game.sum++;
                     }
                 }
             };
        }

    /**
     * Die Methode öffnet den Zusammenfassungsbildscshirm, bei Ende eines Levels.
     * Bei Abschluss des Expertenmodus wird die ExpertenmodusGUI geöffnet.
     */


    public void gameSummary() {
        stage1.close();
        summaryScreen.setAnswer(game.correctAnswer, game.wrongAnswer);
        //   summaryScreen.setSuccess(true);
        summaryScreen.start(stage1);

        summaryScreen.backButton.setOnAction(event -> endGamewithoutsave());
        summaryScreen.repeatLevel.setOnAction(event -> newGame());

        if(game.level>1) {
            summaryScreen.preLevel.setOnAction(event -> {
                game.level = game.level - 1;
                newGame();
            });
        }
         else{
         summaryScreen.preLevel.setDisable(true);
        }

        if (!strictGame) {
            summaryScreen.willkommensText.setText("Level: " + game.level + " wurde abgeschlossen!");
            if (game.level < 4) {
                summaryScreen.nextGame.setOnAction(event -> {
                    game.level = game.level + 1;
                    newGame();
                });
            } else {
                summaryScreen.nextGame.setDisable(true);
            }

        } else {

            double internalsum = 0;
            internalsum = internalsum + game.correctAnswer + game.wrongAnswer;
            float pct;
            pct = (float) (game.correctAnswer / internalsum);

            if (pct >= 0.6) {
                summaryScreen.willkommensText.setText("Level: " + game.level + " wurde erfolgreich abgeschlossen!");
            } else {
                summaryScreen.willkommensText.setText("Level: " + game.level + " wurde nicht erfolgreich abgeschlossen!");
            }
            if (pct >= 0.6 & game.level < 4) {
                summaryScreen.nextGame.setOnAction(event -> {

                    game.level = game.level + 1;
                    newGame();
                });
               } else {
                summaryScreen.nextGame.setVisible(false);


                if (pct >= 0.6 & game.level == 4) {
                    stage1.close();
                    expertSummaryGUI.setSuccess(true);
                    expertSummaryGUI.start(stage1);
                    expertSummaryGUI.close.setOnAction(event -> endGamewithoutsave());
                    } else {
                    if (pct < 0.6 & game.level == 4) {
                        stage1.close();
                        expertSummaryGUI.setSuccess(false);
                        expertSummaryGUI.start(stage1);
                        expertSummaryGUI.repeatButton.setOnAction(event -> {
                            strictGame = true;
                            game.sum = 0;
                            game.level = 1;
                            newGame();
                        });
                        expertSummaryGUI.preLevel.setOnAction(event ->   newGame() );
                        expertSummaryGUI.close.setOnAction(event ->      endGamewithoutsave());
                    }
                }
            }
        }
    }

    /**
     * Die Methode beendet ein Spiel, mit Alert, falls nicht gespeichert wurde.
     * Der Spieler wird zum Main Screen zurückgeleitet.
     */

    public void endGame(){
          strictGame= false;

           if (!game.saved) {
               Boolean alert = AlertHelper.confirmationAlert("Achtung",
                       "Du hast nicht gespeichert! Möchtest du wirklich beenden? ");
               if (alert) {
                  stage1.close();
                   start(stage1);
                   game.sum = 0;
               }
           }
            else{
                stage1.close();
                start(stage1);
            }
    }
    /**
     * Die Methode beendet ein Spiel ohne Alert für Speicherung.
     * Der Spieler wird zum Main Screen zurückgeleitet.
     */
    public void endGamewithoutsave(){
        strictGame= false;
        game.sum = 0;
        stage1.close();
        start(stage1);

    }

    /**
     * Die Methode wählt den Speicherort aus und gibt einen Namen für das File vor,
     * welcher beim speichern abgeändert werden kann.
     */

      private String createFileName () {
          return  System.getProperty("user.home") + System.getProperty("file.separator") +"Spielstand.ser";
          }

    /**
     * Die Methode speichert ein Spiel. Speicherort kann frei gewählt werden.
     */

    public void saveProgress() {
        try {
            data.progress.clear();
            data.progress.add(Integer.toString(game.taskNumber -1));
            data.progress.add(Integer.toString(game.level));
            data.progress.add(Boolean.toString( strictGame));
            data.progress.add(game.playedGames.toString());
            data.progress.add(Integer.toString(game.correctAnswer));
            data.progress.add(Integer.toString(game.wrongAnswer));
            data.progress.add(Integer.toString((int)game.sum));

            File file = data.chooseSaveFile(new File(createFileName()), stage1);
            if (file != null) {
                data.saveProgress(file, data.progress);
                AlertHelper.informationAlert("Speichern","Spiel wurde in Datei " + file + " gespeichert.");
                game.saved = true;
            }

        } catch (IOException e) {
            AlertHelper.errorAlert("Error" ,e.getLocalizedMessage());
            game.saved = false;
        }
    }

    /**
     * Die Methode lädt ein gespeichertes Spiel. File, welches geladen werden muss, kann ausgewählt werden.
     * Es wird eine neue Frage gestartet basierend auf den geladenen Spielparametern.
     */

    private void loadProgress() {
        try {
            File file = data.chooseLoadFile(new File(createFileName()), stage1);
            if (file != null) {
                stage1.close();
                data.loadProgress(file);
                updateData();
                game.setLevel(game.level);
                setgoOnButton();
                AlertHelper.informationAlert("Laden", "Spiel von Datei " + file + " geladen.");
                game.saved = false;
            }
            else {
                stage1.close();
                start(stage1);
                game.saved = false;
            }

        } catch (IOException | ClassNotFoundException e) {
            AlertHelper.errorAlert("Error" ,e.getLocalizedMessage());
        }
    }

    /**
     * Die Methode aktualisiert alle relevanten Spielparameter mit den geladenen Spielparametern
     */
    private void updateData(){
        game.correctAnswer = Integer.parseInt(data.progress.get(4));
        game.wrongAnswer = Integer.parseInt(data.progress.get(5));
        game.level = Integer.parseInt(data.progress.get(1));
        game.sum = Integer.parseInt(data.progress.get(6));
        strictGame = Boolean.valueOf(data.progress.get(2));
        game.playedGames.clear();
        game.playedGames.addAll(Arrays.asList(data.progress.get(3)));
        game.taskNumber= Integer.parseInt(data.progress.get(0));
        showData();
    }

    /**
     * Die Methode wählt per Zufall einen Antwortenmoudsbildschirm aus.
     * @return Gibt die GUI des per Zufall ausgewählten Antwortenmodus zurück.
     */
    public MainGUI getRandomGUI() {
        guiList = new ArrayList<>();
        guiList.add(guiFA);
        guiList.add(guiMC);
        random = new Random();
        int index = random.nextInt(guiList.size());
        return guiList.get(index);
    }

    /**
     * Der Konstruktor der Klasse
     */

    public Uhrenspiel()  {
        guiMC = new MainGUI();
        guiFA = new QuestionFreeAnswer();
        mainScreen = new MainScreenGUI();
        choiceScreenGame = new ChoiceScreenGame();
        expertSummaryGUI = new ExpertSummaryGUI();
        game = new Game();
        choiceScreenGame = new ChoiceScreenGame();
        choiceScreenLernmodus = new ChoiceScreenLernmodus();
        summaryScreen = new SummaryGUI();
        spielanleitung = new Spielanleitung();
        learnModus = new Lernmodus();
        data = new SavedData();
        checkEntryFA = new checkEntryFA();

        System.out.println("Uhrenspiel startet");
    }

     public static void main(String[] args) {
        launch(args);
    }

}




