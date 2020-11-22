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

import java.util.ArrayList;
import java.util.Random;


 public class Uhrenspiel extends Application {


        Random random;

        private  GUI guiMC;
        private   GUIFreieAntwort guiFA;
        ArrayList<GUI> gui;


         public void start(Stage primaryStage)
         {
                getGUI().start(primaryStage);



         }

         public void fillGuiList() {
         gui = new ArrayList<>();

         gui.add(guiFA);
         gui.add(guiMC);
     }

         public GUI getGUI(){

             random = new Random();
             int index = random.nextInt(gui.size());
             return gui.get(index);
          }

         public Uhrenspiel() {
             guiMC = new GUI();
             guiFA = new GUIFreieAntwort();
             fillGuiList();
             System.out.println(getGUI());
             System.out.println(gui);
        }

        public static void main(String[] args) {
                        launch(args);
        }


    }




