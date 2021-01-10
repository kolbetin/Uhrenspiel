/**
 * Die Klasse erstellt die GUI für die Antwortenmoduse und Auswahlbildschirme.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */


package uhrenspiel.Presentation;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class MainGUI {

    public static Scene scene;
    public Button endButton;
    public Button answer1;
    public Button answer2;
    public Button answer3;
    public Button answer4;
    public Button saveButton;
    public Label labelTaskCount;
    public Button goOn;
    public Label labelQuestion;
    public Label header;
    public String time = "08:30"; //Standardwert: 12:00
    public Node node;
    public Label labelLevel;
    public Label labelCorrectAnswer;
    public Label labelWrongAnswer;
    public Label allAnswers;
    public Label levelexplain;
    private int levelNo = 0;
    private int taskNo = 0;
    private int sum = 0;
    private int correctAnswerNo = 0;
    private int wrongAnswerNo = 0;
    private List<String> answers;
    private boolean strictGame;
    private int totalTaskNumber = 0;



    /**
     * Konstruktor der Klasse.
     */

    public MainGUI() {
        answers = new ArrayList<>();
    }


    /**
     * Die Methode erstellt den MainGUI.
     *
     * @param primaryStage nimmt die Stage entgegeben um den Hauptbildschirm anzeigen zu können.
     */


    public void start(Stage primaryStage) {

        final BorderPane borderPane = new BorderPane();

        borderPane.setPadding(new Insets(7, 7, 7, 7));
        borderPane.setTop(upperArea());
        borderPane.setRight(middleArea());
        borderPane.setLeft(leftArea());

        scene = new Scene(borderPane, 1400, 700);
        scene.getStylesheets().add(MainGUI.class.getResource("clock.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Uhrenspiel");
        primaryStage.show();
    }

    /**
     * Die Methode erstellt den Mittelteil der MainGUI.
     *
     * @return Gibt die BorderPane des Mittelteils für die MainGUI zurück.
     */
    public BorderPane middleArea() {

        final BorderPane middleArea = new BorderPane();
        middleArea.setId("middleArea");

        labelTaskCount = new Label("Aufgabe: " + taskNo + "  von " + totalTaskNumber);
        labelLevel = new Label("Level: " + levelNo);

        final HBox upper = new HBox(100);
        upper.getChildren().addAll(labelLevel, labelTaskCount);
        upper.setPadding(new Insets(7, 7, 7, 7));

        final VBox vBox = new VBox(20);

        vBox.getChildren().addAll(questionArea(), answerArea());
        middleArea.setPadding(new Insets(7, 7, 7, 100));

        middleArea.setTop(upper);
        middleArea.setBottom(vBox);
        middleArea.setCenter(clockArea());

        return middleArea;

    }

    /**
     * Die Methode erstellt den Fragenteil im unteren Mittelbildschirm.
     *
     * @return Gibt die Pane zurück für den Fragenteil im Mittelbildschirm.
     */

    public Pane questionArea() {
        BorderPane borderPane = new BorderPane();

        labelQuestion = new Label("Frage: " + "Wie spät ist es?");

        borderPane.setTop(labelQuestion);

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

        if (!strictGame & levelNo > 0) {
            header = new Label("Freies Spiel");
        } else {
            if (strictGame & levelNo > 0) {
                header = new Label("Expertenmodus");
            } else {
                header = new Label("Uhrenspiel");
            }

        }

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


        ClockSkin clock = new ClockSkin();
        node = clock.createClock(time);

        //   borderPane.setStyle("-fx-border-width:  1; -fx-border-color: #882cc1");
        hbox.setPadding(new Insets(70, 7, 7, 200));

        hbox.getChildren().add(node);


        return hbox;
    }

    /**
     * Die Methode erstellt den linken Bildschirmteil im Hauptbildschirm.
     *
     * @return Gibt die Pane zurück für den linken Bildschirmteil im Hauptbildschirm.
     */
    public Pane leftArea() {
        final BorderPane borderPane = new BorderPane();
        borderPane.setId("leftArea");

        final VBox vbox = new VBox(20);

        allAnswers = new Label("Insgesamt beantwortete " + "\n" + "Fragen: " + sum);
        endButton = new Button("Spiel beenden");
        saveButton = new Button("Speichern");
        vbox.getChildren().addAll(saveButton, endButton);


        labelCorrectAnswer = new Label("Richtige Antworten: " + correctAnswerNo);
        labelWrongAnswer = new Label("Falsche Antworten: " + wrongAnswerNo);
        levelexplain = new Label("In diesem Level: ");

        final VBox vb = new VBox(20);
        vb.setSpacing(50);
        vb.getChildren().addAll(levelexplain, labelCorrectAnswer, labelWrongAnswer);

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
        answers.add("4:00");
        answers.add("2:00");
        answers.add("3:00");
        answers.add("5:00");

        hBox.setPadding(new Insets(15, 7, 10, 7));

        answer1 = new Button("Antwort A");
        answer2 = new Button("Antwort B");
        answer3 = new Button("Antwort C");
        answer4 = new Button("Antwort D");

        answer1.setText(answers.get(0));
        answer2.setText(answers.get(1));
        answer3.setText(answers.get(2));
        answer4.setText(answers.get(3));

        goOn = new Button("Weiter");

        Label antwort = new Label("Antwort: Es ist ");
        hBox.getChildren().addAll(antwort, answer1, answer2, answer3, answer4);
        hBox.getChildren().add(goOn);

        return hBox;
    }

    /**
     * Die Methode nimmt die aktuelle Spielparameter entgegen zum erstellen des nächsten Fragebildschirms.
     *
     * @param tasknumber        Übergibt einen Integer der aktuellen Aufgabennummer.
     * @param level             Übergibt einen Integer der aktuellen Level.
     * @param sum               Übergibt einen Integer der Anzahl der aktullen insgesamt beantworteten Fragen.
     * @param correctAnswer     Übergibt einen Integer mit der Anzahl der aktuell korrekt beantworteten Fragen.
     * @param wrongAnswer       Übergibt einen Integer mit der Anzahl der aktuell falsch beantworteten Fragen.
     * @param answers           Übergibt eine Liste der Antworten, für die aktuelle Frage (Uhrzeit).
     * @param strictGame        Übergibt einen Boolean für den Expertenmodus mit true oder false.
     * @param totalTaskNumber   Übergbit einen Integer mit der Anzahl des Aufgabensets.
     */

    public void setGameValues(int tasknumber, int level, double sum, int correctAnswer, int wrongAnswer, List answers, boolean strictGame, int totalTaskNumber) {
        this.answers.clear();
        this.taskNo = tasknumber;
        this.levelNo = level;
        this.sum = (int) sum;
        this.correctAnswerNo = correctAnswer;
        this.wrongAnswerNo = wrongAnswer;
        this.answers.addAll(answers);
        this.strictGame = strictGame;
        this.totalTaskNumber = totalTaskNumber;
    }


    /**
     * Die Methode lädt und erstellt das Bild.
     *
     * @return Gibt den Node für das auszugebende Bild zurück.
     */
    public Node setPicture(String addImage, int height, int width, int left) {
        try {

            String path="src/uhrenspiel/Presentation/image/";
            FileInputStream input = new FileInputStream(path+addImage);

            //prepare image object
            Image image = new Image(input);


            //create ImageView object
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(height);
            imageView.setFitWidth(width);
            HBox hBox = new HBox();
            hBox.getChildren().add(imageView);
            hBox.setPadding(new Insets(7,7,50,left));

            return hBox;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}


