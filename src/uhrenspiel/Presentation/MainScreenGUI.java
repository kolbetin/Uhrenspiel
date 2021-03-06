/**
 * Die Klasse erstellt die MainGUI für die Antwortenmoduse und Auswahlbildschirme.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */

package uhrenspiel.Presentation;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class MainScreenGUI extends MainGUI {

     private Label willkommensText;
     public Button newGameButton;
     public Button loadGameButton;
     public Button endGameButton;
     public Button lernmodusButton;
     public Button spielanleitungButton;


    /**
     * Die Methode überschreibt den mittleren Teil der MainGUI.
     */
    @Override
    public BorderPane middleArea(){

        willkommensText = new Label();
        willkommensText.setText("Willkommen zum Uhrenspiel");

        newGameButton = new Button("Neues Spiel");
        loadGameButton = new Button("Spiel laden");
        endGameButton = new Button("Beenden");
        lernmodusButton = new Button("Lernmodus");
        spielanleitungButton = new Button("Tutorial");

        final VBox middle = new VBox(10);
        middle.setId("mainscreen");
        middle.getChildren().addAll(newGameButton,loadGameButton,lernmodusButton,spielanleitungButton,endGameButton);
        middle.setPadding(new Insets(70,7,7,70));

        final BorderPane root = new BorderPane();
        root.setTop(willkommensText);
        root.setPadding(new Insets(150,100,7,70));
        root.setLeft(middle);
        root.setRight(setPicture("MainScreenClock.png",250,250, 270));

        return  root;

    }


    /**
     * Die Methode überschreibt den linken Teil der MainGUI.
     */
    @Override
    public Pane leftArea() {
        final VBox vBox = new VBox(5);
        return vBox;
    }




}
