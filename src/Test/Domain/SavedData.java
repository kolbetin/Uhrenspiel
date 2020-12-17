package Test.Domain;

import Test.Persistenz.*;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SavedData extends Application  {

    private IOInterface bufferInterface;
    private Random random;
    public List<String> progress;


    public void start(Stage p){}

    public SavedData() {
        progress = new ArrayList();
        random = new Random();
        bufferInterface = new FileWriter();
    }

    public void setProgress(List<String> newprogress) {
        this.progress.clear();
        this.progress.addAll(newprogress);
    }


    public void saveProgress(File file, List<String> list) throws IOException {
        bufferInterface.save(file,list);
    }

    public void loadProgress(File file) throws ClassNotFoundException, IOException {
          setProgress(bufferInterface.load(file));
        System.out.println("Datei wurde geladen: " + progress);
    }

    public File chooseSaveFile (File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Decision File");
        fileChooser.setInitialDirectory(new File(file.getParent()));
        fileChooser.setInitialFileName(file.getName());

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        return fileChooser.showSaveDialog(stage);
    }

    public File chooseLoadFile (File file, Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Decision File");

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Serialized files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialDirectory(new File(file.getParent()));

        // Show open file dialog
        return fileChooser.showOpenDialog(stage);
    }

 /*   public void setBufferInterface(IOInterface bufferInterface) {
        this.bufferInterface = bufferInterface;
    }

    public IOInterface getBufferInterface() {
        return bufferInterface;
    }*/

    public static void main(String[] args) {
        launch();
    }
}
