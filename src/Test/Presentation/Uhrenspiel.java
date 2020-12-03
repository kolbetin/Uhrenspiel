package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.ProgressData;
import Test.Domain.QuestionsAnswer;
import Test.Persistenz.IOSerialisierung;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


  public class Uhrenspiel extends Application  {


    Random random;

    private GUI guiMC;
    private QuestionFreeAnswer guiFA;
    private MainScreen mainScreen;
    private QuestionsAnswer qa;
    private Verabschiedungsbildschirm verAbschieden;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<GUI> guiList;
    private AlertHelper alertHelper;
    public Game game;
    public Question question;
    private ProgressData progressData;
    private File file;


      public void start(Stage primarystage) {

          stage1 = new Stage();

          mainScreen.start(stage1);
          mainScreen.newGameButton.setOnAction(event ->
                    newGameMultipleChoice()
                    //newGameFreeAnswer()

          );
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



    public void newGameMultipleChoice(){
         stage1.close();
         //getGUI().start(stage1);
         question.start(stage1);
         question.goOn.setOnAction(event -> {

            //  if(game.aufgabennummer< 6) {
                    game.nextQuestion();
                    question.antwort1.setText((String) game.answers.get(0));
                    question.antwort2.setText((String) game.answers.get(1));
                    question.antwort3.setText((String) game.answers.get(2));
                    question.antwort4.setText((String) game.answers.get(3));
                    question.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
           /*     }

                else {
                    stage1.close();
                    start(stage1);
                }*/
                 });

        question.endButton.setOnAction(event -> endGame());
        question.saveButton.setOnAction(event -> saveProgress());
        guiFA.endButton.setOnAction(event -> endGame());
        guiFA.saveButton.setOnAction(event -> saveProgress());
  }
      public void newGameFreeAnswer(){
          stage1.close();
          //getGUI().start(stage1);

          guiFA.start(stage1);
          guiFA.goOn.setOnAction(event -> {
                   System.out.println(game.aufgabennummer);
             // if(game.aufgabennummer< 6) {
                  game.nextQuestion();
                  guiFA.antwortzähler.setText("Aufgabe: " + game.aufgabennummer + "  von 10");
            /*  }
                  else {
                  stage1.close();
                  start(stage1);
              }*/
          });
          //guiFA

          guiFA.endButton.setOnAction(event -> endGame());
          guiFA.saveButton.setOnAction(event -> saveProgress());
      }

    public void endGame(){

            Boolean alert = alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION,  "Spiel beenden!",
                "Wenn du das Spiel beendest, geht der Fortschritt verloren! Willst du wirklich beenden? " );
            if(alert){
                stage1.close();
                start(stage1);
            }

    }

      private void saveProgress() {
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
       // guiMC = new GUI();
        guiFA = new QuestionFreeAnswer();
        mainScreen = new MainScreen();
        verAbschieden = new Verabschiedungsbildschirm();
        question = new Question();
        progressData = new ProgressData();
        game = new Game();



        fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);

    }

     public static void main(String[] args) { launch(args);    }


}




