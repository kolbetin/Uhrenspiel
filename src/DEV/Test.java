package PROD;

import java.awt.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class Test  extends Application {

    private Label name;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) {


/*        try {


            // set title
            primaryStage.setTitle("JavaFX ImageView Tutorial - tutorialkart.com");

            //read image as stream
          //  FileInputStream input = new FileInputStream("src/uhrenspiel/Presentation/image/expertHappy.png");
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
        }*/

    }

  /*  public Node picture() throws Exception {

        try {
            //read image as stream
            FileInputStream input = new FileInputStream("src/uhrenspiel/Presentation/image/Success.jfif");
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

    }*/

}


