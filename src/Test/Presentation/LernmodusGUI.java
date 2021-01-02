package Test.Presentation;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class LernmodusGUI extends MainGUI {

    private ClockSkin clock;
    public Label text = new Label();
    public Text explanation = new Text();
    public Label levelLM = new Label();
    public Label zeiger = new Label();
    private int anzuzeigendeZiffer ;
    private String anzuzeigendeZeit ;
    private Label uberschrift = new Label();
    public Button repeatButton;
    public Button goOnLevel;
    public Button preLevel;

    public void setUhrzeit(String zeit, int ziffer){
        this.anzuzeigendeZeit = zeit;
        this.anzuzeigendeZiffer = ziffer;
    }

    @Override
    public BorderPane middleArea() {

        uberschrift.setText("Lernmodus - Wo stehen die Ziffern auf der Uhr?");
        levelLM.setText("Level");
        explanation.setText("Test");
        explanation.setId("textExplanation");
        zeiger.setText("Legende:\n"
                        +"Stundenzeiger: kurzer schwarzer Zeiger\n"
                        +"Minutenzeiger: langer roter Zeiger");

        final VBox top = new VBox(20);

        top.getChildren().addAll(uberschrift,levelLM);
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

        hbox .setPadding(new Insets(7, 7, 18, 50));
        goOnLevel = new Button ("Nächstes Level");
        preLevel = new Button ("Vorheriges Level");
        repeatButton = new Button("Nochmal");

        hbox.getChildren().addAll( preLevel, repeatButton,goOnLevel );

        final BorderPane root = new BorderPane();
        root.setTop(top);

        root.setLeft(middle);
        root.setBottom(hbox);

        return root;

    }

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


}
