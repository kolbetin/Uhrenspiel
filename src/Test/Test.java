package Test;

import java.awt.*;
import java.io.FileInputStream;
import java.util.Collection;

import Test.Presentation.MainGUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test  extends Application {

    private Label name;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) {


        try {


            // set title
            primaryStage.setTitle("JavaFX ImageView Tutorial - tutorialkart.com");

            //read image as stream
            FileInputStream input = new FileInputStream("src/Test/Presentation/image/Success.jfif");
            //prepare image object
            Image image = new Image(input);

            //create ImageView object
            ImageView imageView = new ImageView(image);

            // stack pane
            TilePane tilePane = new TilePane();


            // add ImageView to the tile pane
            tilePane.getChildren().addAll(picture());

            tilePane.setPadding(new Insets(170, 7, 7, 570));
            imageView.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            //set up scene
            Scene scene = new Scene(tilePane, 1450, 800);
            scene.getStylesheets().add
                    (MainGUI.class.getResource("clock.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Node picture() throws Exception {

        try {
            //read image as stream
            FileInputStream input = new FileInputStream("src/Test/Presentation/image/Success.jfif");
            //prepare image object
            Image image = new Image(input);

            //create ImageView object
            ImageView imageView = new ImageView(image);

            // stack pane
            TilePane tilePane = new TilePane();


            // add ImageView to the tile pane
            tilePane.getChildren().addAll(imageView);

            tilePane.setPadding(new Insets(170, 7, 7, 570));

            //set up scene
            return tilePane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}


