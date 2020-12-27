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
    private Verabschiedungsbildschirm verAbschieden;
    private ChoiceScreen choiceScreen;
    private Lernmodus learnModus;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<MainGUI> guiList;
    private AlertHelper alertHelper;
    public Game game;
    private SavedData data;
    private boolean setlearnModus = false;
    private boolean strictGame = false;
    private Spielanleitung spielanleitung;
    private boolean testEntry = false;
    private checkEntryFA checkEntryFA;



      public void start(Stage primarystage) {

          stage1 = new Stage();
          stage2 = new Stage();

          mainScreen.start(stage1);

          mainScreen.newGameButton.setOnAction(event -> {
                 stage1.close();
                 setChoiceScreen();
           });
          mainScreen.loadGameButton.setOnAction(event -> {
                  loadProgress();
                  }
          );
          mainScreen.endGameButton.setOnAction(event -> {
                      Boolean alert = alertHelper.confirmationAlert("Spiel beenden!",  "Willst du wirklich beenden? ");
                      if (alert) {
                          stage1.close();
                      }
                  }
          );
          mainScreen.lernmodusButton.setOnAction(event ->
          {
              setlearnModus = true;
              setChoiceScreen();
          });
          mainScreen.spielanleitungButton.setOnAction(event -> {

              spielanleitung.starteSpielanleitung(stage1) ;
          });
      }


    private void setChoiceScreen(){
        choiceScreen.start(stage1);
        if(setlearnModus){
            choiceScreen.text5.setText("Halbe Stunde lernen, zum Beispiel 2:30 Uhr?");
            choiceScreen.level4.setText("Start");
            choiceScreen.level1.setText("Start");
            choiceScreen.level2.setText("Start");
            choiceScreen.level3.setText("Start");
            choiceScreen.willkommensText.setText("Welchen Lernmodus möchtest du starten?");
            choiceScreen.text2.setText("Viertel nach lernen, zum Beispiel 3:15 Uhr?");
            choiceScreen.text3.setText("Viertel vor lernen, zum Beispiel 3:45 Uhr?");
            choiceScreen.text4.setVisible(false);
            choiceScreen.leadedGame.setVisible(false);
        }

        choiceScreen.leadedGame.setOnAction(e ->{
            strictGame=true;
            game.level = 1;
             newGame();
        });

        choiceScreen.level1.setOnAction(e -> {
            game.level = 1;
             setModus(game.level);
        });

        choiceScreen.level2.setOnAction(e -> {
            game.level = 2;
             setModus(game.level);

        });
        choiceScreen.level3.setOnAction(e -> {
            game.level = 3;
            setModus(game.level);

        });
        choiceScreen.level4.setOnAction(e -> {
            game.level=4;
            setModus(game.level);

        });
        choiceScreen.backButton.setOnAction(e -> {
            stage1.close();
            start(stage1);
        });
    }
        private void setModus(int level){
            if(setlearnModus){
                learnModus.setAnzuzeigendeZeitLernmodus(level);
                learnModus.setStartTime(level);
                learnModus.startLernmodus(stage1,level);
            }
            else {
                newGame();
            }
        }
  public void setBackData(){
      game.aufgabennummer = 0;
      game.richtigeAntwort =0;
      game.falscheAntwort= 0;
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

          if( game.aufgabennummer<10) {
              if (game.level < 4) {
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
              gameSummary();
          }
    }

    public void newGameMultipleChoice() {

        game.nextQuestion();
        guiMC.time = game.key ;
        guiMC.setGameValues(game.aufgabennummer,
                game.level,
                game.sum,
                game.richtigeAntwort,
                game.falscheAntwort,
                game.answers);

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
        System.out.println(game.liste);
        System.out.println(game.aufgabennummer);
        System.out.println("Richtige Antwort: " + game.richtigeAntwort);
        System.out.println("Falsche Antwort: " + game.falscheAntwort);
        System.out.println(game.playedGames);
    }

      public void newGameFreeAnswer(){
          game.nextQuestion();
          guiFA.time = game.key;
          guiFA.setGameValues(game.aufgabennummer,
                  game.level,
                  game.sum,
                  game.richtigeAntwort,
                  game.falscheAntwort,
                  game.answers);
          guiFA.start(stage1);
          guiFA.givenMinutes.setText("00");

          if(game.level > 1){
                  guiFA.givenMinutes.setText("");
          }
          guiFA.goOn.setVisible(false);
          guiFA.goOn.setOnAction(event -> setgoOnButton());

          guiFA.submitButton.setOnAction(event -> checkEntry() );

          guiFA.givenHour.setOnKeyPressed(new EventHandler<KeyEvent>() {
              @Override
              public void handle(KeyEvent keyEvent) {
                  if (keyEvent.getCode() == KeyCode.ENTER) {
                      checkEntry();
                  }
              }
          });

          guiFA.givenMinutes.setOnKeyPressed(new EventHandler<KeyEvent>() {
              @Override
              public void handle(KeyEvent keyEvent) {

                  if (keyEvent.getCode() == KeyCode.ENTER) {
                      checkEntry();
                  }
              }
          });

          guiFA.endButton.setOnAction(event -> endGame());
          guiFA.saveButton.setOnAction(event -> saveProgress());
          showData();
      }

      private void checkEntry(){
          checkEntryFA.setValues(guiFA.givenHour.getText(),guiFA.givenMinutes.getText());

          if(checkEntryFA.korrekt){
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
                  guiFA.submitButton.setText("Richtig!");
                  guiFA.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                  game.richtigeAntwort++;
                  manageButtonsFA();
                  game.sum++;
                }
                else {
                  guiFA.submitButton.setId("buttonNotOkay");
                  guiFA.submitButton.setText("Falsch!");
                  guiFA.questionLabel.setText("Das war leider nicht richtig!\n"
                          + "Deine Antwort: " + game.answer+ " Uhr.\n"
                          + "Die korrekte Antwort ist: " + game.getAnswerFA(game.key)+ " Uhr.");
                  game.falscheAntwort++;
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
             return new EventHandler<MouseEvent>() {
              @Override
                  public void handle(MouseEvent event) {

                  if (event.getSource() instanceof Button) {
                      Button button = (Button) event.getSource();

                      if (button.getText().contains(game.getAnswerFA(game.key)) ) {
                          button.setId("buttonOkay");
                          button.setText("Richtig!");
                          guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                          game.richtigeAntwort++;
                          manageButtonsMC();
                          game.sum++;

                      }
                      else {
                          button.setId("buttonNotOkay");
                          button.setText("Falsch!");
                          guiMC.questionLabel.setText("Das war leider nicht richtig! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                          game.falscheAntwort++;
                          manageButtonsMC();
                          game.sum++;
                      }
                  }
              }
          };
        }


    public void gameSummary(){
       stage1.close();
        summaryScreen.start(stage1);

        summaryScreen.labelRA.setText("Richtige Antworten: " + game.richtigeAntwort);
        summaryScreen.labelFA.setText("Falsche Antworten: " + game.falscheAntwort);

        summaryScreen.backButton.setOnAction(event -> {
            stage1.close();
            start(stage1);
        });
        summaryScreen.repeatLevel.setOnAction(event ->
            newGame()
        );

        if(! strictGame){
            summaryScreen.willkommensText.setText("Level: " + game.level + " wurde abgeschlossen!");
            if(game.level< 4){
                summaryScreen.nextGame.setOnAction(event -> {
                    game.level = game.level + 1;
                    newGame();
                });
            } else {
                summaryScreen.nextGame.setDisable(true);
            }
        }
        else {

            double internalsum = 0;
            internalsum = internalsum+ game.richtigeAntwort + game.falscheAntwort;
            float pct = 0;
            pct =  (float) (game.richtigeAntwort/internalsum);


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
            } else {
                summaryScreen.nextGame.setVisible(false);
            }
        }
    }


    public void endGame(){
          strictGame= false;
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
            data.progress.add(Integer.toString(game.aufgabennummer-1));
            data.progress.add(Integer.toString(game.level));
            data.progress.add(Boolean.toString( strictGame));
            data.progress.add(game.playedGames.toString());
            data.progress.add(Integer.toString(game.richtigeAntwort));
            data.progress.add(Integer.toString(game.falscheAntwort));
            data.progress.add(Integer.toString((int)game.sum));

            File file = data.chooseSaveFile(new File(createFileName()), stage1);
            if (file != null) {
                 data.saveProgress(file, data.progress);
                alertHelper.confirmationAlert("Speichern","Spiel wurde in Datei " + file + " gespeichert.");
                game.saved = true;
            }

        } catch (IOException e) {
            alertHelper.errorAlert("Error" ,e.getLocalizedMessage());
        }
    }


    private void loadProgress() {
        try {
            File file = data.chooseLoadFile(new File(createFileName()), stage1);
            if (file != null) {
                stage1.close();
                data.loadProgress(file);
                updateData();
                game.setLevel(game.level);
                setgoOnButton();
                alertHelper.confirmationAlert("Speichern", "Spiel von Datei " + file + " geladen.");

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
        int r = Integer.parseInt(data.progress.get(4));
        game.richtigeAntwort = r;
        int f = Integer.parseInt(data.progress.get(5));
        game.falscheAntwort = f;
        int l = Integer.parseInt(data.progress.get(1));
        game.level = l;
        int s = Integer.parseInt(data.progress.get(6));
        game.sum = s;
        boolean b = Boolean.valueOf(data.progress.get(2));
        strictGame = b;
        game.playedGames.clear();
        game.playedGames.addAll(Arrays.asList(data.progress.get(3)));
        int a = Integer.parseInt(data.progress.get(0));
        game.aufgabennummer = a;
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
        choiceScreen = new ChoiceScreen();
        verAbschieden = new Verabschiedungsbildschirm();
        game = new Game();
        choiceScreen = new ChoiceScreen();
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




