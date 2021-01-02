/**
 * Die Klasse erstellt die GUI für das Ende des Expertenmodus.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */


package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.FileInputStream;


public class ExpertSummaryGUI extends MainGUI {

     private Label label;
     public Button close;
     private Boolean success = false;
     private FileInputStream input;
     public Button repeatButton;
     public Button preLevel;


    /**
     * Die Methode nimmt den Wert entgegen, ob das Spiel erfolreich oder nicht erfolgreich beendet wird.
     *
     * @param success Übergibt einen Boolean ob erfolgreich oder nicht.
     */
     public void setSuccess(boolean success){
         this.success = success;
     }


    /**
     * Die Methode überschreibt den mittleren Teil der Hauptbildschirms.
     */

    @Override
    public BorderPane middleArea() {

        label = new Label();
        label.setText("Super, du bist jetzt ein Experte im Uhren lesen!!!");

        close = new Button("Zurück");

        repeatButton = new Button("Expertenmodus Wiederholen");
        preLevel = new Button("Nochmal Level 4");

        HBox hBox = new HBox(30);
        hBox.getChildren().addAll(preLevel, repeatButton, close);
        hBox.setPadding(new Insets(7, 400, 7, 7));


        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(setPicture(getPicture(),300,400,110), label, hBox);

        vBox.setPadding(new Insets(50, 7, 7, 7));

        BorderPane root = new BorderPane();
        root.setTop(vBox);

        return root;

    }

    /**
     * Die Methode überschreibt den linken Teil des Hauptbildschirms.
     */

    @Override
    public Pane leftArea() {
        final VBox vBox = new VBox(5);
        return vBox;
    }

    /**
     * Die Methode erstellt das Bild.
     *
     * @return Gibt das Node zurück für das auszugebende Bild.
     */

    public String getPicture() {
        try {

            if(success) {
                label.setText("Super, du bist jetzt ein Experte im Uhren lesen!!!");
                repeatButton.setVisible(false);
                preLevel.setVisible(false);
                return "expertHappy.png";

            }
            else {
                label.setText("Leider, bist du noch kein Experte. Versuchs nochmal!!!");
                repeatButton.setVisible(true);
                return "expertEncourage.png";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
