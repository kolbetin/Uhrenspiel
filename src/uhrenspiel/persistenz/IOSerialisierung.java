/**
 * Die Klasse "FileWriter" erstellt einen BufferedWriter mit FileWriter und einen BufferedReader mit FileReader zur
 * Speicherung sowie Laden von Uhrenspiel Spielständen. Dazu implementiert die Klasse das Inferface "IOInterface".
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */
package uhrenspiel.persistenz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class IOSerialisierung implements IOInterface {


    /**
     * Die Methode "save" erstellt den BufferedWriter mit einem FileWriter zur Speicherung von Uhrenspiel Spielständen.
     *
     * @param file Der Parameter vom Typ File wird vom FileWriter verwendet um die Datei abzuspeichern.
     * @param progress Der Parameter progress vom Typ String wird vom BufferedWriter verwendet um die abzuspeichernden
     *                 Informationen entgegen zu nehmen und in die abzuspeichernde Datei zu schreiben.
     **/
    public void save(File file, List<String> progress) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {

            for (String string : progress) {
                writer.write(string);
                writer.newLine();
             }

        } catch (IOException e) {
            throw new IOException("Daten können nicht in der Datei " + file + " gespeichert werden!");
        }
    }

    /**
     * Die Methode "load" erstellt den BufferedReader mit einem FileReader zum Laden von Uhrenspiel Spielständen.
     *
     * @param file Der Parameter vom Typ File wird vom FileReader verwendet um die Datei zu laden.
     **/
    public List<String> load(File file) throws IOException,
            ClassNotFoundException {
             try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                List<String> spielstand = new ArrayList<>();

                String progress = reader.readLine();
                while (progress != null) {
                    spielstand.add(progress);
                    progress = reader.readLine();
                    }

                return spielstand;
            }
        }

} // Ende Klasse FileWriter
