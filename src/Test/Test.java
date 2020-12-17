package Test;
import Test.Presentation.ClockSkin;
import Test.Presentation.Lernmodus;
import Test.Presentation.Uhrenspiel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * @author Crunchify.com
 *
 */

public class Test extends Application {

  public Label willkommensText;
  public Label labelLevel;
  public Label labelRA;
  public Label labelFA;
  public Button backButton;
  public Button nextGame;
  public Button repeatLevel;
  private Lernmodus lernmodus;
  final Integer[] values = new Integer[] {1,2,3,4,5,6,7,8,9,10};
  Label [] labels = new Label[values.length];
    private ClockSkin clock;
    private Node  node;
    public int anzuzeigendeZiffer =0;
    public String anzuzeigendeZeit = null;
    private int count = 0;
    private final Text text1 = new Text();
    private final Text text2 = new Text();
    private final Text text = new Text();
    private String ziit;
    private int ziffer;





    public void startLernmodus(){

        Stage stage1 = new Stage();
       // for (int i = 0; i < 12; i++) {

            anzuzeigendeZiffer += 1;

            if (anzuzeigendeZiffer < 10) {
                anzuzeigendeZeit = "0" + anzuzeigendeZiffer + ":00";
            } else {
                anzuzeigendeZeit = anzuzeigendeZiffer + ":00";
            }

            System.out.println(anzuzeigendeZeit);
            System.out.println(anzuzeigendeZiffer);

            ziffer = anzuzeigendeZiffer;
            ziit = anzuzeigendeZeit;



            // Pause zwischen den einzelnen angezeigten Uhrzeiten
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           //  lernmodus.start(stage1);
           //  stage1.close();


       // }


    }

  public static void main(String[] args) {
    launch(args);
  }


   private void incrementCount() {
       count++;
       text.setText(Integer.toString(count));
   }
    @Override
    public void start(Stage primaryStage) {

        lernmodus = new Lernmodus();
        VBox root = new VBox();
         ziit = "01:00";
         ziffer = 1;

     //   root.getChildren().addAll(new Text("anzuzeigende Zeit: "),   text1 ,new Text( " anzuzeigende Ziffer: ") ,text2);
        root.getChildren().addAll(clock.clockLerningClock(ziit,ziffer));

        Scene scene = new Scene(root, 500, 200);

        // longrunning operation runs on different thread
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                    //  incrementCount();
                      startLernmodus();

                    }
                };

                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }

            }

        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}



