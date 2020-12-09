package Test.Domain;

import Test.Persistenz.IOInterface;
import Test.Persistenz.IOSerialisierung;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProgressData extends Application  {

    private IOInterface ioInterface;
    private QuestionsAnswer qa;
    private Random random;
    public HashMap<Integer,String> progress;

    public void start(Stage p){}

    public ProgressData() {
        qa = new QuestionsAnswer();
        progress = new HashMap<>();
        random = new Random();
        ioInterface = new IOSerialisierung();


        System.out.println(progress.size());

    }

    public void setProgress(HashMap key) {
       // this.progress.clear();
        this.progress.putAll(key);
    }

    public void setProgressData(Integer aufgabe, String key) {
        // this.progress.clear();
        this.progress.put(aufgabe, key);
    }

    public void saveProgress(File file) throws IOException {
        ioInterface.save(file,progress);
    }

    public void loadProgress( File file) throws ClassNotFoundException, IOException {
        setProgress(ioInterface.load(file));
    }

    public void setIoInterface(IOInterface ioInterface) {
        this.ioInterface = ioInterface;
    }

    public IOInterface getIOInterface() {
        return ioInterface;
    }
    public int getCount() {
        return this.progress.size();
    }

    public void add(Integer key, String antwort) {
        progress.put(key, antwort);
    }



    public String getProgressValues(){
        for (int i = 0; i<progress.size(); i++ ){
            System.out.println(progress.get(i));
            return progress.get(i);
        }
        return null;
    }
    public Integer getProgressKeys() {
        for (int i = 0; i < progress.size(); i++) {
            int key = random.nextInt(progress.size());
            return key;
        }
        return null;
    }

    public String getProgressData(int i){
               return progress.get(i);
           }



    public static void main(String[] args) {
        launch();
    }
}
