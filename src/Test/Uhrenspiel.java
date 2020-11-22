package Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;


 public class Uhrenspiel extends Application {


        Button antwort1;
        Button antwort2;
        Button antwort3;
        Button antwort4;
        Label uberschrift;
        Text frage;
        Button submitButton;
        TextField textField;
        Random random;
        FlowPane pane;
        VBox root;
        private static  GUI gui;
        private static  GUIFreieAntwort gui2;


         public void start(Stage primaryStage)
         {

                 gui = new GUI();
                //gui = new GUIFreieAntwort();

                 gui.start(primaryStage);
              //   gui.test(primaryStage);



         }
         public Uhrenspiel() {



        }

        public static void main(String[] args) {

                        launch(args);


        }


    }




