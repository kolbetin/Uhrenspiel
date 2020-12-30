package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class ExpertSummaryGUI extends MainGUI {

     private Label label;
     public Button close;
     private Boolean success = false;
     private FileInputStream input;
     public Button repeatButton;


     public void setSuccess(boolean success){
         this.success = success;
     }

    @Override
    public void start(Stage primaryStage) {
        try{
        primaryStage.setTitle("Uhrenspiel");
        label = new Label();
        label.setText("Super, du bist jetzt ein Experte im Uhren lesen!!!");


        close = new Button("Spiel Beenden");


        repeatButton = new Button ("Nochmal");
            HBox hBox = new HBox(50);
            hBox.getChildren().addAll(repeatButton,close);


        if(success) {
           input  = new FileInputStream("src/Test/Presentation/image/expertHappy.png");
            label.setText("Super, du bist jetzt ein Experte im Uhren lesen!!!");
            repeatButton.setVisible(false);
            hBox.setPadding(new Insets(7,7,7,330));
        }
        else {
            input = new FileInputStream("src/Test/Presentation/image/expertEncourage.png");
            label.setText("Leider, bist du noch kein Experte.\n" + "Versuchs nochmal!!!");
            repeatButton.setVisible(true);
            hBox.setPadding(new Insets(7,7,7,400));
        }
        //prepare image object
        Image image = new Image(input);


        //create ImageView object
        ImageView imageView = new ImageView(image);


      //  hBox.setPadding(new Insets(7,7,7,350));
         VBox root = new VBox(40);

        root.getChildren().addAll(imageView, label, hBox);


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
