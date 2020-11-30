package Test.Domain;

import Test.Persistenz.IOInterface;
import Test.Persistenz.IOSerialisierung;
import Test.Test;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class ProgressData extends Application {

    private IOInterface ioInterface;
    private QuestionsAnswer qa;
    private Random random;
    private HashMap<Integer,String> progress;

    public void start(Stage p){


    }

    public ProgressData() {
        qa = new QuestionsAnswer();
        random = new Random();
        ioInterface = new IOSerialisierung();
        qa.antwortenMap.put(5,"fünf");
        qa.antwortenMap.put(6,"sechs");
        System.out.println(qa.antwortenMap);


    }

    public void setProgress(HashMap<Integer, String> key) {
        this.qa.antwortenMap.clear();
        this.qa.antwortenMap.putAll(key);
    }

    public void saveProgress(File file) throws IOException {
        ioInterface.save(file,qa.antwortenMap);
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
        return this.qa.antwortenMap.size();
    }

    public void add(Integer key, String antwort) {
        progress.put(key, antwort);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
