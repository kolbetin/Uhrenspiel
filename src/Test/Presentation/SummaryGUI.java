/**
 * Die Klasse erstellt die GUI für die Auswertung eines Spiels.
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
    private FileInputStream input;
    private int correctAnswer;
    private int wrongAnswer;

    /**
     * Die Methode nimmt die aktuelle Spielparameter entgegen zum erstellen der Zusammenfassung.
     *
     * @param  correctAnswer Übergibt einen Integer mit der Anzahl der aktuell korrekt beantworteten Fragen.
     * @param  wrongAnswer Übergibt einen Integer mit der Anzahl der aktuell falsch beantworteten Fragen.
     */


    public void setAnswer(int correctAnswer,int wrongAnswer){
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    /**
     * Die Methode überschreibt den mittleren Teil des Hauptbildschirms.
     */

    @Override
    public BorderPane middleArea() {


            willkommensText = new Label();
            willkommensText.setText("Level wurde abgeschlossen");
            labelRA = new Label("Richtige Antworten: " + correctAnswer);
            labelFA = new Label("Falsche Antworten: " + wrongAnswer);


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
            bottom.setPadding(new Insets(50, 7, 200, 200));

            BorderPane root = new BorderPane();

            root.setTop(getPicture());
            root.setBottom(bottom);
            root.setCenter(middle);
            root.setPadding(new Insets(70, 370, 7, 20));

            return root;

    }

    /**
     * Die Methode überschreibt den linken Teil des Hauptbildschirms.
     */

    @Override
    public Pane leftArea() {
        VBox vBox = new VBox(5);

        return vBox;
    }

    /**
     * Die Methode erstellt das Bild.
     *
     * @return Gibt den Node für das auszugebende Bild zurück.
     */
    public Node getPicture() {
        try {

            input = new FileInputStream("src/Test/Presentation/image/summaryWellDone.png");

            //prepare image object
            Image image = new Image(input);


            //create ImageView object
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(140);
            imageView.setFitWidth(150);
            HBox hBox = new HBox();
            hBox.getChildren().add(imageView);
            hBox.setPadding(new Insets(7,7,50,350));

            return hBox;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
