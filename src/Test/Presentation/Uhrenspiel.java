package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.checkEntryFA;
import Test.Persistenz.SavedData;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private AlertHelper alertHelper;
    private Game game;
    private SavedData data;
    private boolean strictGame = false;
    private Spielanleitung spielanleitung;
    private checkEntryFA checkEntryFA;
    private boolean success = false;



      public void start(Stage primarystage) {

          stage1 = new Stage();
          stage2 = new Stage();
          stage3 = new Stage();



          mainScreen.start(stage1);

          mainScreen.newGameButton.setOnAction(event -> {
                 stage1.close();
                 startChoiceScreenGame();
           });

          mainScreen.loadGameButton.setOnAction(event ->
                  loadProgress()
                            );
          mainScreen.endGameButton.setOnAction(event -> {
                      Boolean alert = alertHelper.confirmationAlert("Spiel beenden!",  "Willst du wirklich beenden? ");
                      if (alert) {
                          stage1.close();
                      }
                  }
          );
          mainScreen.lernmodusButton.setOnAction(event ->
                     startChoiceScreenLernmodus()
          );
          mainScreen.spielanleitungButton.setOnAction(event ->
              spielanleitung.starteSpielanleitung(stage1)
          );
      }


    private void startChoiceScreenGame(){
        choiceScreenGame.start(stage1);

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

    private void startChoiceScreenLernmodus(){
        choiceScreenLernmodus.start(stage1);

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
         private void setLernmodus(int level){
                learnModus.setAnzuzeigendeZeitLernmodus(level);
                learnModus.setStartTime(level);
                learnModus.startLernmodus(stage1,level);
         }


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

    public void newGame(){
        setBackData();

        if(game.level<4){
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
                  if (getGUI() == guiFA) {
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

    public void newGameMultipleChoice() {

        game.nextQuestion();
        guiMC.time = game.key ;
        guiMC.setGameValues(game.taskNumber,
                game.level,
                game.sum,
                game.correctAnswer,
                game.wrongAnswer,
                game.answerList);

        guiMC.start(stage1);

        guiMC.goOn.setOnAction(event -> setgoOnButton());
        guiMC.goOn.setVisible(false);
        guiMC.endButton.setOnAction(event -> endGame());
        guiMC.saveButton.setOnAction(event -> saveProgress());
        answerCheckMC();
        showData();
  }
    private void showData(){
        System.out.println(game.key);
        System.out.println(game.keyList);
        System.out.println(game.taskNumber);
        System.out.println("Richtige Antwort: " + game.correctAnswer);
        System.out.println("Falsche Antwort: " + game.wrongAnswer);
        System.out.println(game.playedGames);
    }

      public void newGameFreeAnswer(){
          game.nextQuestion();
          guiFA.time = game.key;
          guiFA.setGameValues(game.taskNumber,
                  game.level,
                  game.sum,
                  game.correctAnswer,
                  game.wrongAnswer,
                  game.answerList);
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

      private void checkEntry(){
          checkEntryFA.setValues(guiFA.givenHour.getText(),guiFA.givenMinutes.getText());

          if(checkEntryFA.correctEntry){
              answerCheckFA();
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


      public void answerCheckFA() {

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
     private void manageButtonsFA(){
         guiFA.givenHour.setDisable(true);
         guiFA.givenMinutes.setDisable(true);
         guiFA.submitButton.setDisable(true);
         guiFA.goOn.setVisible(true);
     }

    private void answerCheckMC() {
          EventHandler<MouseEvent> eventHandler = getEventHandler();
          guiMC.antwort1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
      }

      private void manageButtonsMC(){
          guiMC.antwort1.setDisable(true);
          guiMC.antwort2.setDisable(true);
          guiMC.antwort3.setDisable(true);
          guiMC.antwort4.setDisable(true);
          guiMC.goOn.setVisible(true);
      }

          EventHandler<MouseEvent> getEventHandler() {
              //Creating the mouse event handler
             return event -> {

                 if (event.getSource() instanceof Button) {
                     Button button = (Button) event.getSource();

                     if (button.getText().contains(game.getAnswerFA(game.key)) ) {
                         button.setId("buttonOkay");
                       //  button.setText("Richtig!");
                         button.setText("");
                         guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                         game.correctAnswer++;
                         manageButtonsMC();
                         game.sum++;

                     }
                     else {
                         button.setId("buttonNotOkay");
                        // button.setText("Falsch!");
                         button.setText("");
                         guiMC.questionLabel.setText("Das war leider nicht richtig! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                         game.wrongAnswer++;
                         manageButtonsMC();
                         game.sum++;
                     }
                 }
             };
        }


    public void gameSummary(){
       stage1.close();
        summaryScreen.start(stage1);
        summaryScreen.setAnswer(game.correctAnswer, game.wrongAnswer);

        summaryScreen.backButton.setOnAction(event ->   endGame() );
        summaryScreen.repeatLevel.setOnAction(event ->  newGame() );

        if(!strictGame){
            summaryScreen.willkommensText.setText("Level: " + game.level + " wurde abgeschlossen!");
            if(game.level< 4){
                summaryScreen.nextGame.setOnAction(event -> {
                    game.level = game.level + 1;
                    newGame();
                });
            }
            else {
                summaryScreen.nextGame.setDisable(true);
            }
            if(game.level >1) {
                summaryScreen.preLevel.setOnAction(event -> {
                    game.level = game.level - 1;
                    newGame();
                });
            }
            else {
                summaryScreen.getPicture().setVisible(false);
                summaryScreen.preLevel.setDisable(true);
            }
        }
        else {

            double internalsum = 0;
            internalsum = internalsum+ game.correctAnswer + game.wrongAnswer;
            float pct;
            pct =  (float) (game.correctAnswer /internalsum);

            if (pct >= 0.6) {
                summaryScreen.willkommensText.setText("Level: " + game.level +  " wurde erfolgreich abgeschlossen!");
            }
            else {
                summaryScreen.willkommensText.setText("Level: " + game.level + " wurde nicht erfolgreich abgeschlossen!");
            }
            if (pct >= 0.6 & game.level< 4){
                    summaryScreen.nextGame.setOnAction(event -> {
                    game.level = game.level + 1;
                    newGame();
                });

            }
            else {
                summaryScreen.nextGame.setVisible(false);
            }

            if (pct>=0.6 & game.level== 4){
               expertSummaryGUI.setSuccess(true);
                expertSummaryGUI.start(stage1);
                expertSummaryGUI.close.setOnAction(event ->  endGame());
            }
            else {
                if (pct <0.6 & game.level== 4) {
                    expertSummaryGUI.setSuccess(false);
                    expertSummaryGUI.start(stage1);
                    expertSummaryGUI.repeatButton.setOnAction(event -> {
                        strictGame=true;
                        game.level = 1;
                        newGame();
                    });
                    expertSummaryGUI.close.setOnAction(event ->  endGame());
                }
            }
        }
    }


    public void endGame(){
          strictGame= false;
          game.sum = 0;
           if (!game.saved) {
               Boolean alert = alertHelper.confirmationAlert("Spiel beenden!",
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
          return  System.getProperty("user.home") + System.getProperty("file.separator") +"Spielstand.ser";
                  //(data.getBufferInterface() instanceof IOSerialisierung ?  "Spielstand.ser" : "Spielstand.txt");
      }

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
                alertHelper.confirmationAlert("Speichern","Spiel wurde in Datei " + file + " gespeichert.");
                game.saved = true;
            }

        } catch (IOException e) {
            alertHelper.errorAlert("Error" ,e.getLocalizedMessage());
            game.saved = false;
        }
    }


    private void loadProgress() {
        try {game.saved = false;
            File file = data.chooseLoadFile(new File(createFileName()), stage1);
            if (file != null) {
                stage1.close();
                data.loadProgress(file);
                updateData();
                game.setLevel(game.level);
                setgoOnButton();
                alertHelper.confirmationAlert("Laden", "Spiel von Datei " + file + " geladen.");

            }
            else {
                stage1.close();
                start(stage1);
            }

        } catch (IOException | ClassNotFoundException e) {
            alertHelper.errorAlert("Error" ,e.getLocalizedMessage());
        }
    }


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


    public MainGUI getGUI() {
        guiList = new ArrayList<>();
        guiList.add(guiFA);
        guiList.add(guiMC);
        random = new Random();
        int index = random.nextInt(guiList.size());
        return guiList.get(index);
    }


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


        System.out.println(getGUI());
        System.out.println(guiList);

    }

     public static void main(String[] args) {
        launch(args);

    }



}




