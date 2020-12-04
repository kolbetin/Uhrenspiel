package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.ProgressData;
import Test.Domain.QuestionsAnswer;
import Test.Persistenz.IOSerialisierung;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Uhrenspiel extends Application  {


    Random random;

    private GUI guiMC;
    private QuestionFreeAnswer guiFA;
    private MainScreen mainScreen;
    private Verabschiedungsbildschirm verAbschieden;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<GUI> guiList;
    private AlertHelper alertHelper;
    public Game game;
    private ProgressData progressData;
    private File file;
    private int richtigeAntwort;
    private int falscheAntwort;



      public void start(Stage primarystage) {

          stage1 = new Stage();

          mainScreen.start(stage1);
          mainScreen.newGameButton.setOnAction(event -> {
              stage1.close();
              game.aufgabennummer = 0;
              richtigeAntwort =0;
              falscheAntwort= 0;
              newGameMultipleChoice();
              //newGameFreeAnswer()

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


       /*  PauseTransition delay = new PauseTransition(Duration.seconds(5));
         delay.setOnFinished( event -> {
             stage1.close();
             verAbschieden.start(stage1);
                 }
         );
         delay.play();

         Task<Void> sleeper = new Task<Void>() {
             @Override
             protected Void call() throws Exception {
                 try {
                     Thread.sleep(5000);

                 } catch (InterruptedException e) {
                 }
                 return null;
             }
         };
         sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
             @Override
             public void handle(WorkerStateEvent event) {
                 stage1.close();
                 verAbschieden.start(stage2);
                 //guiMC.start(stage2);
             }
         });

         new Thread(sleeper).start();

*/



    public void newGameMultipleChoice() {
        game.nextQuestion();
        guiMC.start(stage1);
       // guiMC.clockArea(game.key);
        guiMC.clockArea("01:00");
        guiMC.antwort1.setText((String) game.answers.get(0));
        guiMC.antwort2.setText((String) game.answers.get(1));
        guiMC.antwort3.setText((String) game.answers.get(2));
        guiMC.antwort4.setText((String) game.answers.get(3));
        guiMC.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
        guiMC.goOn.setOnAction(event -> {
            if(game.aufgabennummer<5) {
                newGameMultipleChoice();
            }
            else {
                newGameFreeAnswer();
            }
        });
        guiMC.endButton.setOnAction(event -> endGame());
        guiMC.saveButton.setOnAction(event -> saveProgress());
        correctAnswerMC();
        System.out.println(game.key);
        System.out.println(game.liste);
        System.out.println(game.answers);
        System.out.println(game.aufgabennummer);
  }
      public void newGameFreeAnswer(){
          game.nextQuestion();
          guiFA.start(stage1);
         // guiFA.clockArea(game.key);
          guiFA.clockArea("01:00");
          guiFA.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
          guiFA.goOn.setOnAction(event -> {
          System.out.println(game.aufgabennummer);
              if(game.aufgabennummer<10) {
                newGameFreeAnswer();
                } else {
                  stage1.close();
                  start(stage1);
                   }
          });
          guiFA.submitButton.setOnAction(event -> correctAnswerFA());
          guiFA.endButton.setOnAction(event -> endGame());
          guiFA.saveButton.setOnAction(event -> saveProgress());
          System.out.println(game.key);
          System.out.println(game.getAnswerFA(game.key));
          System.out.println(game.aufgabennummer);
      }

      public void correctAnswerFA(){
            if(guiFA.givenAnswer.getText().equals(game.getAnswerFA(game.key))) {
                guiFA.submitButton.setStyle("-fx-background-color: #5e8c5e");
                guiFA.submitButton.setText("Super, korrekte Antwort!");
                richtigeAntwort++;
            /*    PauseTransition wait = new PauseTransition(Duration.seconds(5));
                wait.setOnFinished(event -> newGameFreeAnswer());
                wait.play();*/
             }
             else {
                 guiFA.submitButton.setStyle("-fx-background-color: #ea6969");
                 guiFA.submitButton.setText("Leider, falsche Antwort!");
                 guiFA.questionLabel.setText("Die korrekte Antwort ist: " + game.key + "Uhr.");
                 falscheAntwort++;
             }
      }

      public void correctAnswerMC() {
          EventHandler<MouseEvent> eventHandler = getEventHandler();
          guiMC.antwort1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
          guiMC.antwort4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
      }

          EventHandler<MouseEvent> getEventHandler() {
              //Creating the mouse event handler
              return new EventHandler<MouseEvent>() {
              @Override
                  public void handle(MouseEvent event) {

                  if (event.getSource() instanceof Button) {
                      Button button = (Button) event.getSource();
                      if (button.getText().contains(game.getAnswerFA(game.key))) {
                          button.setStyle("-fx-background-color: green");
                          button.setText("Super, korrekte Antwort!");
                      } else {
                          button.setStyle("-fx-background-color: red");
                          button.setText("Leider, falsche Antwort!");
                          guiMC.questionLabel.setText("Die korrekte Antwort ist: " + game.key + "Uhr.");
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
        verAbschieden = new Verabschiedungsbildschirm();
        progressData = new ProgressData();
        game = new Game();




        fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);

    }

     public static void main(String[] args) { launch(args);    }


}




