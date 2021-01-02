/**
 * Die Klasse erstellt die GUI für die Antwortenmoduse und Auswahlbildschirme.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */


package Test.Presentation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class MainGUI {

    public Button endButton;
    public Button answer1;
    public Button answer2;
    public Button answer3;
    public Button answer4;
    public Button saveButton;
    public Label answerCount;
    public Button goOn;
    private ClockSkin clock;
    public Label questionLabel;
    public Label header;
    public String time = "08:30"; //Standardwert: 12:00
    public Node node;
    public Label level;
    public Label richtigeAntwort;
    public Label falscheAntwort;
    public Label allAnswers;
    public Label levelexplain;
    private int levelnummer = 0;
    private int aufgabennummer = 0;
    private int sum = 0;
    private int richtigeAntwortNummer = 0;
    private int falscheAntwortNummer = 0;
    private List<String> answers;
    private boolean strictGame;


    /**
     * Die Methode erstellt den Hauptbildschirm.
     *
     * @param primaryStage nimmt die Stage entgegeben um den Hauptbildschirm anzeigen zu können.
     */


    public void start(Stage primaryStage) {

        final BorderPane borderPane = new BorderPane();

        borderPane.setPadding(new Insets(7, 7, 7, 7));
        borderPane.setTop(upperArea());
        borderPane.setRight(middleArea());
        borderPane.setLeft(leftArea());
        // borderPane.setStyle("-fx-border-image-width: 1; -fx-border-color: black");

        Scene scene = new Scene(borderPane, 1400, 700);
        scene.getStylesheets().add(MainGUI.class.getResource("clock.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Uhrenspiel");
        primaryStage.show();
    }

    /**
     * Die Methode erstellt den Mittelteil des Hauptbildschirms.
     *
     * @return Gibt die BorderPane des Mittelteils für den Hauptbildschirm zurück.
     */
    public BorderPane middleArea() {

        final BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        answerCount = new Label("Aufgabe: " + aufgabennummer + "  von 10");
        level = new Label("Level: " + levelnummer);

        final HBox upper = new HBox(100);
        upper.getChildren().addAll(level, answerCount);
        upper.setPadding(new Insets(7, 7, 7, 7));

        final VBox vBox = new VBox(30);

        vBox.getChildren().addAll(questionArea(), answerArea());
        middleArea.setPadding(new Insets(7, 7, 7, 100));

        middleArea.setTop(upper);
        middleArea.setBottom(vBox);
        middleArea.setCenter(clockArea());


        //middleArea.setStyle("-fx-border-image-width: 1; -fx-border-color: blue");

        return middleArea;

    }

    /**
     * Die Methode erstellt den Fragenteil im unteren Mittelbildschirm.
     *
     * @return Gibt die Pane zurück für den Fragenteil im Mittelbildschirm.
     */

    public Pane questionArea() {
        BorderPane borderPane = new BorderPane();
        borderPane.setId("questionArea");

        questionLabel = new Label("Frage: " + "Wie spät ist es?");


        borderPane.setTop(questionLabel);


        return borderPane;
    }

    /**
     * Die Methode erstellt den oberen Teil des Hauptbildschirms.
     *
     * @return Gibt die Pane zurück für den oberen Teil im Hauptbildschirms.
     */
    private Pane upperArea() {
        final VBox vBox = new VBox();
        vBox.setId("upperArea");

        //  vBox.setStyle("-fx-border-width:  1; -fx-border-color: yellow");


        if(!strictGame & aufgabennummer>0){
            header = new Label("Freies Spiel");
        }
        else {
            if(strictGame & aufgabennummer>0){
                header = new Label("Expertenmodus");
            }
            else {
                header = new Label("Uhrenspiel");
            }

        }
        System.out.println("ExpertenModus " + strictGame );


        vBox.getChildren().add(header);

        return vBox;
    }

    /**
     * Die Methode erstellt das Uhrenbild im Mittelbildschirm.
     *
     * @return Gibt die Pane zurück für das Uhrenbild im Mittelbildschirm.
     */
    public Pane clockArea() {

        final HBox hbox = new HBox();
        hbox.setId("clockArea");


        clock = new ClockSkin();
        node = clock.createClock(time);

        //   borderPane.setStyle("-fx-border-width:  1; -fx-border-color: #882cc1");
        hbox.setPadding(new Insets(70, 7, 7, 200));

        hbox.getChildren().add(node);


        return hbox;
    }

    /**
     * Die Methode erstellt den linken Bildschirmteil im Hauptbildschirm.
     *
     *  @return Gibt die Pane zurück für den linken Bildschirmteil im Hauptbildschirm.
     */
    public Pane leftArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("leftArea");

        final VBox vbox = new VBox(20);

        allAnswers = new Label("Insgesamt beantwortete " + "\n" + "Fragen: " + sum);
        endButton = new Button("Spiel beenden");
        saveButton = new Button("Speichern");
        vbox.getChildren().addAll(saveButton, endButton);


        richtigeAntwort = new Label("Richtige Antworten: " + richtigeAntwortNummer);
        falscheAntwort = new Label("Falsche Antworten: " + falscheAntwortNummer);
        levelexplain = new Label("In diesem Level: ");

        final VBox vb = new VBox(20);
        vb.setSpacing(50);
        vb.getChildren().addAll(levelexplain, richtigeAntwort, falscheAntwort);

        // borderPane.setStyle("-fx-border-width:  1; -fx-border-color: #59ff00");
        borderPane.setPadding(new Insets(100, 7, 7, 7));
        vb.setPadding(new Insets(50, 7, 7, 7));
        vbox.setPadding(new Insets(7, 7, 7, 7));

        borderPane.setTop(allAnswers);
        borderPane.setCenter(vb);
        borderPane.setBottom(vbox);

        return borderPane;
    }

    /**
     * Die Methode erstellt den Antwortenteil im unteren Mittelbildschirm.
     *
     * @return Gibt die Pane zurück für den Antwortenteil im Mittelbildschirm.
     */


    public Pane answerArea() {

        HBox hBox = new HBox(25);
        hBox.setId("answerArea");
        answers.add("04:00");
        answers.add("02:00");
        answers.add("03:00");
        answers.add("05:00");

        hBox.setPadding(new Insets(15, 7, 10, 7));

        answer1 = new Button("Antwort A");
        answer2 = new Button("Antwort B");
        answer3 = new Button("Antwort C");
        answer4 = new Button("Antwort D");

        answer1.setText(answers.get(0));
        answer2.setText(answers.get(1));
        answer3.setText(answers.get(2));
        answer4.setText(answers.get(3));

        goOn = new Button("weiter");

        Label antwort = new Label("Antwort: Es ist ");
        hBox.getChildren().addAll(antwort, answer1, answer2, answer3, answer4);
        hBox.getChildren().add(goOn);


        return hBox;
    }

    /**
     * Die Methode nimmt die aktuelle Spielparameter entgegen zum erstellen des nächsten Fragebildschirms.
     *
     * @param  tasknumber  Übergibt einen Integer der aktuellen Aufgabennummer.
     * @param  level Übergibt einen Integer der aktuellen Level.
     * @param  sum  Übergibt einen Integer der Anzahl der aktullen insgesamt beantworteten Fragen.
     * @param  correctAnswer Übergibt einen Integer mit der Anzahl der aktuell korrekt beantworteten Fragen.
     * @param  wrongAnswer Übergibt einen Integer mit der Anzahl der aktuell falsch beantworteten Fragen.
     * @param  answers Übergibt eine Liste der Antworten, für die aktuelle Frage (Uhrzeit).
     * @param  strictGame Übergibt einen Boolean ob dies der Expertenmodus ist mit true oder false.
     */

    public void setGameValues(int tasknumber, int level, double sum, int correctAnswer, int wrongAnswer, List answers, boolean strictGame) {
        this.answers.clear();
        this.aufgabennummer = tasknumber;
        this.levelnummer = level;
        this.sum = (int) sum;
        this.richtigeAntwortNummer = correctAnswer;
        this.falscheAntwortNummer = wrongAnswer;
        this.answers.addAll(answers);
        this.strictGame = strictGame;

    }

    /**
     * Konstruktor der Klasse.
     */

    public MainGUI() {
        answers = new ArrayList<>();
    }


}


