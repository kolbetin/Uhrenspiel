package Test.Presentation;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class LernmodusGUI extends MainGUI {

    private ClockSkin clock;
    public Label text = new Label();
    private int anzuzeigendeZiffer ;
    private String anzuzeigendeZeit ;
    private Label uberschrift = new Label();
    public Button repeatButton;
    public Button goOnLevel;

    public void setUhrzeit(String zeit, int ziffer){
        this.anzuzeigendeZeit = zeit;
        this.anzuzeigendeZiffer = ziffer;
    }

    @Override
    public BorderPane middleArea() {

        uberschrift.setText("Lernmodus - Wo stehen die Ziffern auf der Uhr?");

        final VBox right = new VBox(20);
        right.getChildren().add(text);
        right.setPadding(new Insets(200, 550, 7, 7));

        final VBox middle = new VBox(10);
        middle.getChildren().addAll(clockArea());
        //   middle.setPadding(new Insets(70,100,7,70));
        //  middle.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        final BorderPane root = new BorderPane();
        root.setTop(uberschrift);
        root.setPadding(new Insets(7, 450, 7, 70));
        // root.setStyle("-fx-border-width:  1; -fx-border-color: green");
        root.setLeft(middle);
        root.setRight(right);

        root.getStylesheets().add
                (MainGUI.class.getResource("clock.css").toExternalForm());
        return root;

    }

    public Pane clockArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("clockArea");

        clock = new ClockSkin();
        node = clock.clockLerningClock(anzuzeigendeZeit, anzuzeigendeZiffer);

        //borderPane.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        borderPane.setPadding(new Insets(7, 170, 7, 250));

       borderPane.setCenter(node);


        return borderPane;
    }

    @Override
    public Pane leftArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("leftArea");

        final VBox vbox = new VBox(20);

        endButton = new Button("Lernmodus beenden");
        goOnLevel = new Button ("Nächstes Level");
        repeatButton = new Button("Nochmal");

        vbox.getChildren().addAll(  goOnLevel,repeatButton, endButton);

        borderPane.setPadding(new Insets(7, 50, 7, 25));

        vbox.setPadding(new Insets(70, 7, 7, 7));

        borderPane.setBottom(vbox);

        return borderPane;
    }


}
