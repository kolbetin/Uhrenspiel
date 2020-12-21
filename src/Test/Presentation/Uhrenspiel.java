package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.Lernmodus;
import Test.Persistenz.SavedData;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    private boolean saved = false;
    private Spielanleitung spielanleitung;



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
                      Boolean alert = alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Spiel beenden!",
                              "Willst du wirklich beenden? ");
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
                //learnModus.setLearnLevel(level);
                learnModus.setStartTime(level);
                learnModus.startLernmodus(stage1,level);
            }
            else {
                newGame();
            }
        }


    public void newGame(){
        game.aufgabennummer = 0;
        game.richtigeAntwort =0;
        game.falscheAntwort= 0;
        saved = false;

        if(!strictGame){
            game.sum =0;
        }

        game.playedGames.clear();
        game.setLevel(game.level);
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
              summaryGame();
          }
    }






    public void newGameMultipleChoice() {

        game.nextQuestion();
        guiMC.zeit = game.key ;
        guiMC.start(stage1);
        //Collections.shuffle(game.liste);
        guiMC.antwort1.setText((String) game.answers.get(0));
        guiMC.antwort2.setText((String) game.answers.get(1));
        guiMC.antwort3.setText((String) game.answers.get(2));
        guiMC.antwort4.setText((String) game.answers.get(3));

        guiMC.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
        guiMC.level.setText("Level: " + game.level );
        guiMC.allAnswers.setText("Insgesamt beantwortete "+ "\n"+"Fragen: "+ (int)game.sum );
        guiMC.richtigeAntwort.setText("Richtige Antworten: " + game.richtigeAntwort);
        guiMC.falscheAntwort.setText("Falsche Antworten: " + game.falscheAntwort );
        guiMC.goOn.setOnAction(event -> setgoOnButton());
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
          guiFA.zeit = game.key;
          guiFA.start(stage1);
          guiFA.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
          guiFA.level.setText("Level: " + game.level);
          guiFA.givenMinutes.setText("00");
          guiFA.allAnswers.setText("Insgesamt beantwortete "+ "\n"+"Fragen: "+ (int)game.sum  );
          guiFA.richtigeAntwort.setText("Richtige Antworten: " + game.richtigeAntwort );
          guiFA.falscheAntwort.setText("Falsche Antworten: " + game.falscheAntwort);
          guiFA.goOn.setOnAction(event -> setgoOnButton());
          if(game.level > 1){
                  guiFA.givenMinutes.setText("");
          }
          guiFA.goOn.setVisible(false);
          guiFA.submitButton.setOnAction(event -> answerCheckFA());
          guiFA.endButton.setOnAction(event -> endGame());
          guiFA.saveButton.setOnAction(event -> saveProgress());
          showData();

      }

      public void answerCheckFA() {

          if (!guiFA.givenHour.getText().isEmpty()
                  & guiFA.givenHour.getText() != null
                  & guiFA.givenHour.getText().matches("[0-9]*")
           ){ String answer = guiFA.givenHour.getText() + ":" + guiFA.givenMinutes.getText();
              String answer0 =  "0"+ guiFA.givenHour.getText() + ":" + guiFA.givenMinutes.getText();
              if (answer.equals(game.getAnswerFA(game.key))
                      |answer.equals("0" + game.getAnswerFA(game.key))
                      |(guiFA.givenHour.getText().equals("0"+game.getAnswerFA(game.key))
                        |(guiFA.givenHour.getText().equals(game.getAnswerFA(game.key))))
                ) {
                  guiFA.submitButton.setStyle("-fx-background-color: #1cf61c");
                  guiFA.submitButton.setText("Super!!");
                  guiFA.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                  guiFA.givenHour.setDisable(true);
                  guiFA.givenMinutes.setDisable(true);
                  guiFA.submitButton.setDisable(true);
                  guiFA.goOn.setVisible(true);
                  game.richtigeAntwort++;
                  game.sum++;
                } else {
                  guiFA.submitButton.setStyle("-fx-background-color: #dd2323");
                  guiFA.submitButton.setText("Leider, falsch!");
                  guiFA.questionLabel.setText("Das war leider nicht richtig!\n"
                          + "Deine Antwort: " + answer+ " Uhr.\n"
                          + "Die korrekte Antwort ist: " + game.getAnswerFA(game.key)+ " Uhr.");
                  game.falscheAntwort++;
                  game.sum++;
                  guiFA.givenHour.setDisable(true);
                  guiFA.givenMinutes.setDisable(true);
                  guiFA.submitButton.setDisable(true);
                  guiFA.goOn.setVisible(true);
                 }
          } else {
              alertHelper.showAlert(Alert.AlertType.ERROR,"Fehler" ,"Bitte eine Zahl eingeben, z.B. 8 oder 12.");
              guiFA.givenHour.clear();
              guiFA.goOn.setVisible(true);

          }
      }

    private void answerCheckMC() {
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
                          button.setId("buttonOkay");
                          button.setText("Richtig!!");
                          button.setStyle("-fx-background-color: #0af60a; -fx-alignment:CENTER-LEFT");
                          guiMC.questionLabel.setText("Toll gemacht! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                          game.richtigeAntwort++;
                          game.sum++;
                          disableButtons();
                          guiMC.goOn.setVisible(true);
                      }
                      else {
                          button.setId("buttonNotOkay");
                          button.setText("Falsch");
                          button.setStyle("-fx-background-color: red; -fx-alignment: CENTER-LEFT");
                          guiMC.questionLabel.setText("Das war leider nicht richtig! Die korrekte Antwort ist: " + game.getAnswerFA(game.key) + " Uhr.");
                          game.falscheAntwort++;
                          game.sum++;
                          disableButtons();
                          guiMC.goOn.setVisible(true);

                          }

                      }
                  }

              };
          }

    public void summaryGame(){
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
            System.out.println("Summe: " + internalsum+ " PCT: " + pct);

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
                alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Speichern","Spiel gespeichert in Datei " + file + ".");
                saved = true;
            }

        } catch (IOException e) {
            alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
        }
    }


    private void loadProgress() {
        try {
            File file = data.chooseLoadFile(new File(createFileName()), stage1);
            if (file != null) {
                stage1.close();
                data.loadProgress(file);
                updateDta();
                game.setLevel(game.level);
                setgoOnButton();
                alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "Speichern", "Liste von Datei " + file + " geladen.");

            }
            else {
                stage1.close();
                start(stage1);
            }


        } catch (IOException | ClassNotFoundException e) {
            alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
        }
    }


    public void updateDta(){
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



 /*   public void fillGuiList() {
        guiList = new ArrayList<>();
        guiList.add(guiFA);
        guiList.add(guiMC);
    }*/

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
        learnModus = new Lernmodus();
        data = new SavedData();
        spielanleitung = new Spielanleitung();


        // fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);

    }

     public static void main(String[] args) { launch(args);    }


}




