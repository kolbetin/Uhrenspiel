/**
 * Die Klasse "LernmodusGUI" stellt die Benutzeroberfläche des Lernmodus dar und erweitert dazu die haupt GUI Klasse
 * "MainGUI". Sie überschreibt die GUI Methoden "middleArea", "clockArea" und "leftArea" um die relevanten Elemente
 * des Lernmodus darzustellen.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */

package Test.Presentation;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class LernmodusGUI extends MainGUI {

    // Instanzvariablen
    private ClockSkin clock;
    public Label text = new Label();
    public Text explanation = new Text();
    public Label levelLM = new Label();
    public Label zeiger = new Label();
    private int anzuzeigendeZiffer;
    private String anzuzeigendeZeit;
    private Label uberschrift = new Label();
    public Button repeatButton;
    public Button goOnLevel;
    public Button preLevel;

    /**
     * Die Methode "setUhrzeit" setzt die zwei Variablen für anzuzeigende Zeit und anzuzeigende Ziffer, welche für die
     * verschiedenen Lernmodus-Levels benötigt werden.
     *
     * @param zeit   Parameter zur Übergabe der anzuzeigenden Uhrzeit als String (Beispiel: "12:30")
     * @param ziffer Parameter zur Übergabe der anzuzeigenden Ziffer als Integer (Beispiel: "12")
     **/
    public void setUhrzeit(String zeit, int ziffer) {
        this.anzuzeigendeZeit = zeit;
        this.anzuzeigendeZiffer = ziffer;
    }

    /**
     * Die Methode "middleArea" überschreibt die entsprechende Methode in "MainGUI" und steuert den angezeigten Text
     * sowie Buttons im mittleren Bereich in den verschiedenen Lernmodus-Levels.
     *
     * @return Gibt eine BorderPane zurück welche den Text sowie Buttons im mittleren Bereich des Lernmodus steuert.
     **/
    @Override
    public BorderPane middleArea() {

        uberschrift.setText("Lernmodus - Wo stehen die Ziffern auf der Uhr?");
        levelLM.setText("Level");
        explanation.setText("Test");
        explanation.setId("textExplanation");
        zeiger.setText("Legende:\n"
                + "Stundenzeiger: kurzer schwarzer Zeiger\n"
                + "Minutenzeiger: langer roter Zeiger");

        final VBox top = new VBox(20);

        top.getChildren().addAll(uberschrift, levelLM);
        top.setPadding(new Insets(7, 7, 7, 7));

        final VBox right = new VBox(30);
        right.getChildren().addAll(text, explanation);

        zeiger.setId("textExplanation");

        final BorderPane middle = new BorderPane();

        VBox vbox = new VBox(80);
        vbox.getChildren().addAll(zeiger, right);
        vbox.setPadding(new Insets(50, 220, 7, 7));

        middle.setRight(vbox);
        middle.setLeft(clockArea());


        final HBox hbox = new HBox(40);

        hbox.setPadding(new Insets(7, 7, 18, 50));
        goOnLevel = new Button("Nächstes Level");
        preLevel = new Button("Vorheriges Level");
        repeatButton = new Button("Nochmal");

        hbox.getChildren().addAll(preLevel, repeatButton, goOnLevel);

        final BorderPane root = new BorderPane();
        root.setTop(top);

        root.setLeft(middle);
        root.setBottom(hbox);

        return root;

    }

    /**
     * Die Methode "clockArea" löst die Erstellung der in der Mitte angezeigten Uhrenbilder (ClockSkin) aus unter
     * Verwendung der zwei vorab definierten Variablen für anzuzeigende Zeit und anzuzeigende Ziffer.
     *
     * @return Gibt eine BorderPane zurück welche das Uhrenbild in der Mitte des Lernmodus Bildschirms anzeigt.
     **/
    public Pane clockArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("clockArea");

        clock = new ClockSkin();
        node = clock.createLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer);

        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(7, 150, 7, 80));

        borderPane.setCenter(node);


        return borderPane;
    }

    /**
     * Die Methode "leftArea" löst die Erstellung des links unten angezeigten Buttons "Lernmodus beenden" aus.
     *
     * @return Gibt eine BorderPane zurück welche den Button "Lernmodus beenden" beinhaltet.
     **/
    @Override
    public Pane leftArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("leftArea");

        final VBox vbox = new VBox(20);

        endButton = new Button("Lernmodus beenden");


        borderPane.setPadding(new Insets(7, 50, 19, 25));

        borderPane.setBottom(endButton);

        return borderPane;
    }


} // Ende Klasse LernmodusGUI
