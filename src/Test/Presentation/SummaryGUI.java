/**
 * Die Klasse erstellt die GUI für die Zusammenfassung eines Spiels.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */

package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class SummaryGUI extends MainGUI {

    //Instanzvariablen
    public Label headerSummary;
    public Button backButton;
    public Button nextGame;
    public Button repeatLevel;
    public Button preLevel;
    private int correctAnswer;
    private int wrongAnswer;

    /**
     * Die Methode nimmt die aktuellen Spielparameter entgegen zum erstellen der Zusammenfassung.
     *
     * @param  correctAnswer Übergibt einen Integer mit der Anzahl der aktuell korrekt beantworteten Fragen.
     * @param  wrongAnswer Übergibt einen Integer mit der Anzahl der aktuell falsch beantworteten Fragen.
     */


    public void setAnswer(int correctAnswer,int wrongAnswer){
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    /**
     * Die Methode überschreibt den mittleren Teil der MainGUI.
     */

    @Override
    public BorderPane middleArea() {
            header.setText("Zusammenfassung");

            headerSummary = new Label();

            labelCorrectAnswer = new Label("Richtige Antworten: " + correctAnswer);
            labelWrongAnswer = new Label("Falsche Antworten: " + wrongAnswer);

            nextGame = new Button("Nächstes Level");
            repeatLevel = new Button("Nochmal");
            backButton = new Button("Zurück");
            preLevel = new Button("Vorheriges Level");


            VBox middle = new VBox(50);
            HBox bottom = new HBox(40);


            middle.getChildren().addAll(headerSummary, labelCorrectAnswer, labelWrongAnswer);
            middle.setPadding(new Insets(7, 270, 7, 400));

            bottom.getChildren().addAll(backButton, preLevel, repeatLevel, nextGame);
            bottom.setPadding(new Insets(50, 7, 200, 250));

            BorderPane root = new BorderPane();

            root.setTop(setPicture("summaryWellDone.png",140,150,450));
            root.setBottom(bottom);
            root.setCenter(middle);
            root.setPadding(new Insets(70, 250, 7, 20));

            return root;

    }

    /**
     * Die Methode überschreibt den linken Teil der MainGUI.
     */

    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

        return vBox;
    }



}
