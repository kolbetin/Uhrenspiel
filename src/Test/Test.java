package Test;

import Test.Presentation.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.text.Element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author Crunchify.com
 *
 */




    public class Test extends Application {


       /* @Override
                public void start(Stage primaryStage) throws Exception {
                    primaryStage.setTitle("HBox Experiment 1");

                    FileInputStream input = new FileInputStream("src/Test/Presentation/image/Smiley_OKAY.jpg");
                    Image  image = new Image(input, 50,50, false,false);
                   ImageView imageView = new ImageView( image);

                    Button button = new Button("test",imageView);

                    HBox hBox = new HBox(20);
                    hBox.getChildren().add(button);

                   Scene scene = new Scene(hBox, 200, 100);
                    primaryStage.setScene(scene);
                    primaryStage.show();

                }*/

   @Override
    public void start(Stage primaryStage) {
        Button button = new Button();
     //   FileInputStream input = new FileInputStream("src/Test/Presentation/image/Smiley_OKAY.jpg");
       // button.setId("buttonWithImage");
     //   Image image = new Image("Smiley_OKAY.jpg",false );
   //  Image image = new Rectangle(20, 20, Color.TRANSPARENT).snapshot(null, null);
     /*   ImageView imageView = new ImageView(image);
        imageView.getStyleClass().add("graphic");
        button.setGraphic(imageView);*/

        button.setOnAction(e -> button.setDisable(true));

        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 350, 120);
       scene.getStylesheets().add
               (Test.class.getResource("Button.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
        public static void main(String[] args) {
            launch(args);
        }
    }


