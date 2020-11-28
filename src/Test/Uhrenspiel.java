package Test;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


  public class Uhrenspiel extends Application  {


    Random random;

    private GUI guiMC;
    private GUIFreeAnswer guiFA;
    private MainScreen mainScreen;
    private QuestionsAnswer qa;
    private Verabschiedungsbildschirm verAbschieden;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<GUI> guiList;
    private GuiVisible gui;
    private AlertHelper alertHelper;
    public Game game;
    private ProgressData progressData;
    private File file;


      public void start(Stage primarystage) {

         stage1 = new Stage();

         mainScreen.start(stage1);
         mainScreen.newGameButton.setOnAction(event ->
                 newGame()
         );
          mainScreen.loadGameButton.setOnAction(event ->
                 loadProgress()
          );
          mainScreen.endGameButton.setOnAction(event -> {
                  Boolean alert = alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION,  "Spiel beenden!",
                  "Willst du wirklich beenden? " );
                  if(alert){
                        stage1.close();
                 }
          }
          );







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

     }

    public void newGame(){
         stage1.close();
         game.start(stage1);

        // qa.antwortenMap.keySet();
      //   game.start(stage2);
       //  game.start(stage2);
        // guiFA.start(stage2);
        // guiMC.start(stage1);
   //     guiFA.endButton.setOnAction(event -> endGame());}
        game.endButton.setOnAction(event -> endGame());
        game.saveButton.setOnAction(event -> saveProgress());


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

              alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "'Was tun?'","Liste gespeichert in Datei " + file + ".");
          } catch (IOException e) {
              alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
          }
      }

      private String createFileName () {
          return  System.getProperty("user.home") + System.getProperty("file.separator") +
                  (progressData.getIOInterface() instanceof IOSerialisierung ?  "decision.ser" : "decision.txt");
      }

      private void loadProgress() {
          try {
              progressData.loadProgress(file);

              alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "'Was tun?'", "Liste von Datei " + file + " geladen.");
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
        guiFA = new GUIFreeAnswer();
        mainScreen = new MainScreen();
        game = new Game();
       // qa = new QuestionsAnswer();
        progressData = new ProgressData();


        verAbschieden = new Verabschiedungsbildschirm();
        fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);

    }

     public static void main(String[] args) { launch(args);    }


}




