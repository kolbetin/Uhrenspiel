package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Verabschiedungsbildschirm extends MainGUI {

     private Label label;
     private Button close;

    @Override
    public void start(Stage primaryStage) {
        try{
        primaryStage.setTitle("Uhrenspiel");
        label = new Label();
        label.setText("Danke das du unser Spiel gespielt hast!!");


        close = new Button("Beenden");
        close.setOnAction(event -> {
            primaryStage.close();
        });

        FileInputStream input = new FileInputStream("src/Test/Presentation/image/Success.jfif");

        //prepare image object
        Image image = new Image(input);


        //create ImageView object
        ImageView imageView = new ImageView(image);

        // stack pane
        TilePane tilePane = new TilePane();
       VBox root = new VBox();

        root.getChildren().addAll(imageView, label, close);


        root.getStylesheets().add
                (MainGUI.class.getResource("clock.css").toExternalForm());
        primaryStage.setScene(new Scene(root, 1100, 800));
        primaryStage.show();

    } catch (Exception e) {
        e.printStackTrace();
    }
    }



  /*  public static void main(String[] args) {
        launch(args);
    }*/
}
