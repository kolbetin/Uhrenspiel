package Test;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;


  public class Uhrenspiel extends Application {


    Random random;

    private GUI guiMC;
    private GUIFreieAntwort guiFA;
    private MainScreen mainScreen;
    private Verabschiedungsbildschirm verAbschieden;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<GUI> guiList;
    private GuiVisible gui;
    private AlertHelper alertHelper;


     public void start(Stage primarystage) {
      //  getGUI().start(primaryStage);
     //   guiMC.start(primaryStage);
      //  guiFA.start(primarystage);
         stage1 = new Stage();
         stage2 = new Stage();
         stage3 = new Stage();

        // stage2.show();
        // stage1.show();

       //  getGUI().start(stage 3);
        // guiMC.start(stage 2);
      //   guiFA.start(stage3);
         mainScreen.start(stage1);

         mainScreen.newGameButton.setOnAction(event ->
                    newGame()
                );
        /*

*/

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
         guiFA.start(stage2);
         guiMC.start(stage1);
   //     guiFA.endButton.setOnAction(event -> endGame());}
        guiMC.endButton.setOnAction(event -> endGame());
  }

    public void endGame(){

             // guiFA.endButton.setOnAction(event -> {
           /*   alertHelper.displayAlert(Alert.AlertType.INFORMATION, "Bitte Text eingeben!");*/
            Boolean alert = alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION,  "Spiel beenden!",
                "Wenn du das Spiel beendest, geht der Fortschritt verloren! Willst du wirklich beenden? " );
            if(alert){
                stage2.close();
                mainScreen.start(stage1);
                mainScreen.newGameButton.setOnAction(event ->
                        newGame()
                );
            }


     //
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
        guiFA = new GUIFreieAntwort();
        mainScreen = new MainScreen();
        verAbschieden = new Verabschiedungsbildschirm();
        fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);
    }

     public static void main(String[] args) {
        launch(args);
    }


}




