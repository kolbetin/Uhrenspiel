/**
 * Das Interface "IOInterface" stellt die Methoden "save" und "load" zur Verfügung zum Speichern und Laden von
 * Spielständen.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */

package uhrenspiel.persistenz;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IOInterface {

    /**
     * Methode "save" zum Speichern von Uhrenspiel Spielständen.
     *
     * @param file Der Parameter vom Typ File wird vonm FileWriter verwendet um die Datei abzuspeichern.
     * @param progress Der Parameter progress vom Typ String wird vom BufferedWriter verwendet um die abzuspeichernden
     *                 Informationen entgegen zu nehmen und in die abzuspeichernde Datei zu schreiben.
     */
    void save(File file, List<String> progress ) throws IOException;

    /**
     * Methode "load" zum Laden von Uhrenspiel Spielständen.
     *
     * @param file Der Parameter vom Typ File wird vom FileReader verwendet um die Datei zu laden.
     **/
    List<String> load(File file) throws IOException, ClassNotFoundException;

} // Ende Interface IOInterface
