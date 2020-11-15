package Test;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GUIFreieAntwort extends GUI {

    public GUIFreieAntwort(){
        super();
    }
    @Override
    public Pane antwortLeiste() {
        final HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(15, 10, 10, 120));
        submitButton.setOnAction(event -> {
        });

        hBox.getChildren().addAll(
                new Text("Antwort"), textField, submitButton );
        return hBox;
    }
}
