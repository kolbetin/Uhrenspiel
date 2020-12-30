package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;


public class SummaryGUI extends MainGUI {

    public Label willkommensText;
    public Label labelLevel;
    public Label labelRA;
    public Label labelFA;
    public Button backButton;
    public Button nextGame;
    public Button repeatLevel;
    public Button preLevel;
    private int richtigeAntwort;
    private int falscheAntwort;



    public void setAnswer(int richtigeAntwort,int falscheAntwort){
        this.richtigeAntwort = richtigeAntwort;
        this.falscheAntwort = falscheAntwort;
    }


    @Override
    public BorderPane middleArea() {


            willkommensText = new Label();
            willkommensText.setText("Level wurde abgeschlossen");
            labelRA = new Label("Richtige Antworten: " + richtigeAntwort);
            labelFA = new Label("Falsche Antworten: " + falscheAntwort);


            nextGame = new Button("Nächstes Level");
            repeatLevel = new Button("Nochmal");
            backButton = new Button("Zurück");
            preLevel = new Button("Vorheriges Level");
            labelLevel = new Label("Level: ");


            VBox middle = new VBox(50);
            HBox bottom = new HBox(40);


            middle.getChildren().addAll(willkommensText, labelRA, labelFA);
            middle.setPadding(new Insets(7, 270, 7, 270));

            bottom.getChildren().addAll(backButton, preLevel, repeatLevel, nextGame);
            bottom.setPadding(new Insets(100, 7, 200, 270));

            BorderPane root = new BorderPane();

             root.setBottom(bottom);
             root.setPadding(new Insets(150, 370, 7, 20));
             root.setCenter(middle);


              root.getStylesheets().add
                    (MainGUI.class.getResource("clock.css").toExternalForm());
            return root;


    }


    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

        vBox.setPadding(new Insets(7, 150, 7, 70));

        return vBox;
    }




}
