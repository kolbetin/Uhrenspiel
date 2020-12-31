/**
 * Die Klasse erstellt die GUI für die Antwortenmoduse und Auswahlbildschirme.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */

package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class QuestionFreeAnswer extends MainGUI {
    public Button goOn;
    public TextField givenHour;
    public TextField givenMinutes;
    public Button submitButton;


    /**
     * Die Methode überschreibt den unteren Antwortenteil des Mittelteils der Hauptgui.
     */

    @Override
    public Pane answerArea() {

        final HBox hBox = new HBox(10);
        hBox.setId("answerArea");
        hBox.setPadding(new Insets(15, 10, 10, 7));
        submitButton = new Button("Abschicken");
        givenHour = new TextField();
        givenMinutes = new TextField();

        goOn = new Button ("Weiter");

        hBox.getChildren().addAll(
                 new Label("Antwort: Es ist "), givenHour,new Text(":"),givenMinutes,new Label(" Uhr  "), submitButton, goOn);
        return hBox;
    }




}
