package Test;
import Test.Presentation.Uhrenspiel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import Test.Domain.ProgressData;

/**
 * @author Crunchify.com
 *
 */

public class Test extends Application {
  private ProgressData progressData;
  public Label willkommensText;
  public Label labelLevel;
  public Label labelRA;
  public Label labelFA;
  public Button backButton;
  public Button nextGame;
  public Button repeatLevel;
  final Integer[] values = new Integer[] {1,2,3,4,5,6,7,8,9,10};
  Label [] labels = new Label[values.length];

  HBox hbs [] = new HBox [values.length];


  public Test(){
    progressData = new ProgressData();

    nextGame = new Button("Nächstes Level");
    repeatLevel = new Button("Nochmal");
    backButton = new Button("zurück");
    labelLevel = new Label("Level: ");

    System.out.println(progressData.progress.size());
    System.out.println(progressData.progress.get(1));


  }
  public static void main(String[] args) {
    launch(args);
  }
/*
  @Override
  public void start(Stage primaryStage) {


    willkommensText = new Label();
    willkommensText.setText("Level wurde abgeschlossen");


    nextGame = new Button("Nächstes Level");
    repeatLevel = new Button("Nochmal");
    backButton = new Button("zurück");
    labelLevel = new Label("Level: " );

    for (int i = 0; i < values.length; i++) {
      Label label = labels[i] = new Label();
      label.setText("Aufgabe: " + values[i]);

      Label label2 = labels[i] = new Label();
      label2.setText( progressData.getProgressData(values[i]));



      HBox hb = hbs[i] = new HBox();
      hb.setSpacing(25);
      hb.setAlignment(Pos.CENTER_LEFT);
      hb.getChildren().addAll(label, label2);

    }


    VBox vb = new VBox();
    vb.setSpacing(5);
    vb.getChildren().addAll(hbs);

    HBox middle = new HBox(50);
    VBox right = new VBox(20);
    HBox bottom = new HBox(10);


    middle.getChildren().addAll(labelLevel,vb);
   // right.getChildren().addAll(vb);
    bottom.getChildren().addAll(backButton, nextGame, repeatLevel);

    BorderPane root = new BorderPane();

    root.setTop(willkommensText);
    root.setPadding(new Insets(150,370,7,20));

    middle.setPadding(new Insets(150,7,10,370));
    right.setPadding(new Insets(50,7,10,70));
    bottom.setPadding(new Insets(100,7,200,500));
   // root.setLeft(middle);
    root.setCenter(middle);
    root.setBottom(bottom);

    root.getStylesheets().add
            (Test.class.getResource("clock.css").toExternalForm());
    //return  root;


    Scene scene = new Scene(root, 1400, 850);

    primaryStage.setScene(scene);
    scene.setRoot(root);
    primaryStage.show();
  }*/
    @Override
    public void start(Stage primaryStage) {

      willkommensText = new Label();
      willkommensText.setText("Level wurde abgeschlossen");
      labelRA = new Label("Test");
      labelFA = new Label("Test");


      nextGame = new Button("Nächstes Level");
      repeatLevel = new Button("Nochmal");
      backButton = new Button("zurück");
      labelLevel = new Label("Level: ");


       HBox middle = new HBox(20);
       VBox right = new VBox(50);
       HBox bottom = new HBox(10);


       // middle.getChildren().addAll(willkommensText);
        right.getChildren().addAll(willkommensText,labelRA, labelFA);
        bottom.getChildren().addAll(backButton, nextGame, repeatLevel);

  BorderPane root = new BorderPane();

       // root.setTop(willkommensText);
       // root.setPadding(new Insets(150, 370, 7, 20));

        middle.setPadding(new Insets(50, 7, 10, 370));
        right.setPadding(new Insets(150, 7, 10, 500));
        bottom.setPadding(new Insets(100, 7, 200, 500));
       // root.setLeft(middle);
        root.setCenter(right);
        root.setBottom(bottom);

        root.getStylesheets().add
          (Test.class.getResource("clock.css").toExternalForm());
        //return root;

  Scene scene = new Scene(root, 1400, 850);

    primaryStage.setScene(scene);
    scene.setRoot(root);
    primaryStage.show();
}


}



