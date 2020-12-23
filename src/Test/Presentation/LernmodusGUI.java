package Test.Presentation;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class LernmodusGUI extends MainGUI {

    private ClockSkin clock;
    public Label text = new Label();
    public Label levelLM = new Label();
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

        final VBox top = new VBox(20);
        top.getChildren().addAll(uberschrift,levelLM);
        top.setPadding(new Insets(7, 7, 7, 7));

        final VBox right = new VBox(10);
        right.getChildren().add(text);

        right.setPadding(new Insets(200, 270, 7, 7));

        final BorderPane middle = new BorderPane();
      //  middle.getChildren().addAll (text,clockArea());
        middle.setRight(right);
        middle.setLeft(clockArea());
       // middle.setStyle("-fx-border-color: red");
       // middle.setPadding(new Insets(7, 70, 7, 7));
        final HBox hbox = new HBox(40);

        hbox .setPadding(new Insets(7, 350, 18, 170));
        goOnLevel = new Button ("Nächstes Level");
        preLevel = new Button ("Vorheriges Level");
        repeatButton = new Button("Nochmal");

        hbox.getChildren().addAll( preLevel, repeatButton,goOnLevel );

        //   middle.setPadding(new Insets(70,100,7,70));
        //  middle.setStyle("-fx-border-width:  1; -fx-border-color: blue");
        final BorderPane root = new BorderPane();
        root.setTop(top);
       // root.setPadding(new Insets(70, 450, 7, 70));
        // root.setStyle("-fx-border-width:  1; -fx-border-color: green");
        root.setLeft(middle);
        root.setBottom(hbox);

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


        vbox.getChildren().addAll(  endButton);

        borderPane.setPadding(new Insets(7, 50, 7, 25));

        vbox.setPadding(new Insets(70, 7, 7, 7));

        borderPane.setBottom(vbox);

        return borderPane;
    }


}
