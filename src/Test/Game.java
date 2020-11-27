package Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class Game extends GUI {

        private QuestionsAnswer questionsAnswermap;
        private ProgressData progressData;
        private AlertHelper alertHelper;

        @Override
        public Pane answerArea() {
            final HBox hBox = new HBox(35);
            hBox.setId("answerArea");

            hBox.setPadding(new Insets(15, 10, 10, 50));

            antwort1 = new Button(questionsAnswermap.getValue());
            antwort2 = new Button("Antwort B");
            antwort3 = new Button("Antwort C");
            antwort4 = new Button("Antwort D");
            System.out.println(questionsAnswermap.getValue());


            Text antwort = new Text("Antwort");
            hBox.getChildren().addAll(antwort, antwort1,antwort2,antwort3, antwort4);

            return hBox;
        }


    private void saveProgress() {
        try {
            File file = new File(createFileName());
            progressData.saveProgress(file);
            alertHelper.confirmationAlert(Alert.AlertType.CONFIRMATION, "'Was tun?'","Liste gespeichert in Datei " + file + ".");
        } catch (IOException e) {
            alertHelper.showAlert(Alert.AlertType.ERROR,"Error" ,e.getLocalizedMessage());
        }
    }

    private String createFileName () {
        return  System.getProperty("user.home") + System.getProperty("file.separator") +
                (progressData.getIOInterface() instanceof IOSerialisierung ?  "decision.ser" : "decision.txt");
    }



    public static void main(String[] args) {
        launch(args);
    }

}
