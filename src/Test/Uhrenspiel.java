package Test;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;


  public class Uhrenspiel extends Application {


    Random random;

    private GUI guiMC;
    private GUIFreieAntwort guiFA;
    private Willkommensbildschirm willKommen;
    private Verabschiedungsbildschirm verAbschieden;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    ArrayList<GUI> guiList;
    Stage nextGui;
    private GuiVisible gui;


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
         //guiFA.start(stage 3);
          willKommen.start(stage1);

         PauseTransition delay = new PauseTransition(Duration.seconds(5));
         delay.setOnFinished( event -> {
             stage1.close();
             verAbschieden.start(stage1);
                 }
         );
         delay.play();
/*
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
        willKommen = new Willkommensbildschirm();
        verAbschieden = new Verabschiedungsbildschirm();
        fillGuiList();

        System.out.println(getGUI());
        System.out.println(guiList);
    }

     public static void main(String[] args) {
        launch(args);
    }


}




