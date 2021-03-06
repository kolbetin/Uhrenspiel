/**
 * Die Klasse beinhaltet alle Alertvarianten.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */

package uhrenspiel.Presentation;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class AlertHelper {

    /**
     * Die Methode erstellt den Confirmation Alert.

     * @param title nimmt den String für den Titel des Alerts entgegen.
     * @param message nimmt den String für die Nachricht des Alerts entgegen.
     */
    public static boolean  confirmationAlert( String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) {
            return true;
        } else if (option.get() == ButtonType.CANCEL) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * Die Methode erstellt den Information Alert.

     * @param title nimmt den String für den Titel des Alerts entgegen.
     * @param message nimmt den String für die Nachricht des Alerts entgegen.
     */

    public static void informationAlert( String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
     }

    /**
     * Die Methode erstellt den Error Alert.
     *
     * @param title nimmt den String für den Titel des Alerts entgegen.
     * @param message nimmt den String für die Nachricht des Alerts entgegen.
     */



    public static void errorAlert( String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

}// Ende Klasse AlertHelper