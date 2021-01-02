/**
 * Die Klasse erstellt die Auswahl GUI für den Spielbeginn.
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;


public class ChoiceScreenGame extends MainGUI {

     public Label willkommensText;
     public Button level1;
     public Button level2;
     public Button level3;
     public Button level4;
     public Button leadedGame;
     public Text text1;
     public Text text2;
     public Text text3;
     public Text text4;
     public Text text5;
     public Button backButton;

    /**
     * Die Methode überschreibt den Mittelteil der Hauptgui.
     */

    @Override
    public BorderPane middleArea(){

        willkommensText = new Label();
        willkommensText.setText("Was möchtest du lernen?");

        level1 = new Button("Starte Level 1");
        level2 = new Button("Starte Level 2");
        level3 = new Button("Starte Level 3");
        level4 = new Button("Starte Level 4");
        leadedGame = new Button("Expertenmodus");
        backButton = new Button("Zurück");
        text1 = new Text("Volle Stunde, zum Beispiel 01:00 Uhr?");
        text2 = new Text("Halbe Stunde lernen, zum Beispiel 01:30 Uhr?");
        text3 = new Text("Viertel Stunde lernen, zum Beispiel 01:15 Uhr?");
        text4 = new Text("Um zum Experten zu werden, musst du 6 von 10 \n"
                +"Fragen pro Level richtig beantworten!");
        text5 = new Text("Level 1-3 gemischt?");

        final VBox middle = new VBox(30);
        final VBox right = new VBox(20);
        final VBox bottom = new VBox(10);
        final BorderPane paneRight = new BorderPane();

        middle.setId("choiceMiddleArea");

        middle.getChildren().addAll(  text1, text2,text3, text5, text4);

        right.getChildren().addAll( level1, level2, level3, level4, leadedGame );
        paneRight.setRight(setPicture("ChoiceScreenSmiley.png",150,150,70));
        paneRight.setLeft(right);

        bottom.getChildren().add(backButton);

        BorderPane root = new BorderPane();

        root.setTop(willkommensText);
        root.setPadding(new Insets(150,170,7,20));

        middle.setPadding(new Insets(50,7,10,7));
        right.setPadding(new Insets(50,7,10,70));
        bottom.setPadding(new Insets(0,7,50,7));
        root.setLeft(middle);
        root.setRight(paneRight);
        root.setBottom(bottom);


        return  root;

    }

    /**
     * Die Methode überschreibt den linken Teil der Hauptgui.
     */


    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

        vBox.setPadding(new Insets(7, 150, 7, 70));

        return vBox;
    }


}
