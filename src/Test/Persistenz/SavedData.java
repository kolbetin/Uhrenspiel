/**
 * Die Klasse "SavedData" ist für das Speichern und Landen von Uhrenspiel Spielständen zuständig. Dazu wird über
 * das Interface "IOInterface" auf die benötigten "save" und "load" Methoden zugegriffen.
 *
 * @author Tina Kolbe & Oliver Piert
 * @version 1.0
 */
package Test.Persistenz;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SavedData {

    // Instanzvariablen
    private IOInterface bufferInterface;
    private Random random;
    public List<String> progress;


    /**
     * Der Konstruktor der Klasse "SavedData" Initialisiert die Instanzvariablen als Objekte.
     */
    public SavedData() {
        progress = new ArrayList();
        random = new Random();
        bufferInterface = new FileWriter();
    }

    /**
     * Die Methode "setProgress" stellt sicher, dass die Liste von Strings "progress" geleert wird bevor diese mit
     * dem neuen abzuspeichernden Spielvortschritt befüllt wird.
     *
     * @param newprogress Der Parameter enthält eine Liste von Strings mit dem neu abzuspeichernden Spielvortschritt.
     */
    public void setProgress(List<String> newprogress) {
        this.progress.clear();
        this.progress.addAll(newprogress);
    }

    /**
     * Die Methode "saveProgress" nutzt das IOInterface und übergibt die zur Speicherung ddes Files benötigten Parameter
     * der Methode "save".
     *
     * @param file Der Parameter wird im Interface "IOInterface" der "save" Methode übergeben und vom FileWriter
     *             verwendet um das File abzuspeichern.
     * @param list Der Parameter wird im Interface "IOInterface" der "save" Methode übergeben und vom BufferedWriter
     *             verwendet um die abzuspeichernden Informationen in das zu speichernde File zu schreiben.
     */
    public void saveProgress(File file, List<String> list) throws IOException {
        bufferInterface.save(file, list);
    }

    /**
     * Die Methode "loadProgress" nutzt das IOInterface und übergibt den zum Laden des Files benötigten Parameter
     * der Methode "load".
     *
     * @param file Der Parameter wird im Interface "IOInterface" der "load" Methode übergeben und vom FileReader
     *             verwendet um das File zu Laden.
     */
    public void loadProgress(File file) throws ClassNotFoundException, IOException {
        setProgress(bufferInterface.load(file));
        System.out.println("Das Spiel wurde geladen: " + progress);
    }

    /**
     * Die Methode "chooseSaveFile" erstellt mit FileChooser das "Speichere Spiel" Dialogfenster
     *
     * @param file Der Parameter übergibt das zu speichernde File dem FileChooser.
     * @param stage Der Parameter übergibt die Stage die zur Darstellung Dialogfensters benötigt wird.
     * @return Die Methode gibt das abzuspeichernte File zurück.
     */
    public File chooseSaveFile(File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Speichere Spiel");
        fileChooser.setInitialDirectory(new File(file.getParent()));
        fileChooser.setInitialFileName(file.getName());

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        return fileChooser.showSaveDialog(stage);
    }

    /**
     * Die Methode "chooseLoadFile" erstellt mit FileChooser das "Lade Spiel" Dialogfenster
     *
     * @param file Der Parameter übergibt das zu ladende File dem FileChooser.
     * @param stage Der Parameter übergibt die Stage die zur Darstellung Dialogfensters benötigt wird.
     * @return Die Methode gibt das zu ladende File zurück.
     */
    public File chooseLoadFile(File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Lade Spiel");

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialDirectory(new File(file.getParent()));

        // Show open file dialog
        return fileChooser.showOpenDialog(stage);
    }

} // Ende Klasse SavedData

