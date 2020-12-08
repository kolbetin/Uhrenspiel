package Test;
import Test.Domain.Game;
import Test.Presentation.ClockSkin;
import Test.Presentation.Uhrenspiel;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import Test.Domain.ProgressData;

/**
 * @author Crunchify.com
 *
 */

public class Test extends Application {
  private ProgressData progressData;
  private Uhrenspiel uhr;
  private Label willkommensText;
  public Label labelLevel;
  public Text text1;
  public Text text2;

  public Button backButton;
  public Button nextGame;
  public Button repeatLevel;
  final Integer[] values = new Integer[] {1,2,3,4,5,6,7,8,9,10};
  final Label [] labels = new Label[values.length];

  final HBox hbs [] = new HBox [values.length];


  public Test(){
    progressData = new ProgressData();
    uhr = new Uhrenspiel();
    uhr.richtigeAntwort= 3;
    progressData.progress.put(5,"korrekt");
    progressData.progress.put(6,"falsch");
    progressData.progress.put(7,"korrekt");
    progressData.progress.put(8,"korrekt");
    progressData.progress.put(9,"korrekt");
    System.out.println(progressData.progress.size());
    System.out.println(progressData.progress.get(1));


  }
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
/*
    Group root = new Group();
    Scene scene = new Scene(root, 400, 450);

    primaryStage.setScene(scene);




    for (int i = 0; i < values.length; i++) {
      final Label label = labels[i] = new Label();
      label.setText("Aufgabe: " + values[i]);

      final Label label2 = labels[i] = new Label();
      label2.setText( progressData.progress.get(values[i]));



      HBox hb = hbs[i] = new HBox();
      hb.setSpacing(25);
      hb.setAlignment(Pos.CENTER_LEFT);
      hb.getChildren().addAll(label, label2);

     }

    final VBox vb = new VBox();
    vb.setSpacing(5);
    vb.getChildren().addAll(hbs);
    scene.setRoot(vb);
    primaryStage.show();

  }*/





    willkommensText = new Label();
    willkommensText.setText("Level wurde abgeschlossen");


    nextGame = new Button("Nächstes Level");
    repeatLevel = new Button("Nochmal");
    backButton = new Button("zurück");
    labelLevel = new Label("Level: " );

    for (int i = 0; i < values.length; i++) {
      final Label label = labels[i] = new Label();
      label.setText("Aufgabe: " + values[i]);

      final Label label2 = labels[i] = new Label();
      label2.setText( progressData.progress.get(values[i]));



      HBox hb = hbs[i] = new HBox();
      hb.setSpacing(25);
      hb.setAlignment(Pos.CENTER_LEFT);
      hb.getChildren().addAll(label, label2);

    }

    final VBox vb = new VBox();
    vb.setSpacing(5);
    vb.getChildren().addAll(hbs);

    VBox middle = new VBox(30);
    VBox right = new VBox(20);
    VBox bottom = new VBox(10);


    middle.getChildren().addAll(labelLevel,text1);
    right.getChildren().addAll(vb);
    bottom.getChildren().addAll(backButton, nextGame, repeatLevel);

    BorderPane root = new BorderPane();

    root.setTop(willkommensText);
    root.setPadding(new Insets(150,370,7,20));

    middle.setPadding(new Insets(50,7,10,7));
    right.setPadding(new Insets(50,7,10,70));
    bottom.setPadding(new Insets(0,7,200,7));
    root.setLeft(middle);
    root.setRight(right);
    root.setBottom(bottom);

    root.getStylesheets().add
            (Test.class.getResource("clock.css").toExternalForm());
    //return  root;


    Scene scene = new Scene(root, 400, 450);

    primaryStage.setScene(scene);
    scene.setRoot(root);
    primaryStage.show();
  }





}



