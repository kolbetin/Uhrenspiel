package Test.Domain;

import Test.Persistenz.*;
import javafx.application.Application;
import javafx.stage.Stage;

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
        bufferInterface = new BufferWriter();
    }

    public void setProgress(List<String> newprogress) {
        this.progress.clear();
        this.progress.addAll(newprogress);
    }


    public void saveProgress(String file) throws IOException {
        bufferInterface.save(file,progress);
    }

    public void loadProgress(String file) throws ClassNotFoundException, IOException {
          setProgress(bufferInterface.load(file));
        System.out.println("Datei wurde geladen: " + progress);
    }

    public void setBufferInterface(IOInterface bufferInterface) {
        this.bufferInterface = bufferInterface;
    }

    public IOInterface getBufferInterface() {
        return bufferInterface;
    }

    public static void main(String[] args) {
        launch();
    }
}
