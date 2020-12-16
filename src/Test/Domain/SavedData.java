package Test.Domain;

import Test.Persistenz.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SavedData extends Application  {

    private BufferInterface bufferInterface;
    private QuestionsAnswer qa;
    private Random random;
    public List progress;
    public int level;
    public int aufgabennummer;
    public boolean strictGame;



    public void start(Stage p){}

    public SavedData() {
        qa = new QuestionsAnswer();
        progress = new ArrayList();
        random = new Random();
        bufferInterface = new BufferWriter();
        System.out.println(progress.size());

    }

    public void setPlayedGames(List playedgames) {
        this.progress.clear();
        this.progress.add(playedgames);
    }

    public void setLevel(int level) {
           this.level = level;
    }
    public void setAufgabennummer(int aufgabennummer) {
        this.aufgabennummer = aufgabennummer;
    }
    public void setStrictGame(boolean strictGame) {
        this.strictGame = strictGame;
    }

    public void saveProgress(File file) throws IOException {
        bufferInterface.save(file,progress);
    }

    public void loadProgress( File file) throws ClassNotFoundException, IOException {
          setPlayedGames(bufferInterface.load(file));


    }

    public void setBufferInterface(BufferInterface bufferInterface) {
        this.bufferInterface = bufferInterface;
    }

    public BufferInterface getBufferInterface() {
        return bufferInterface;
    }
    public int getCount() {
        return this.progress.size();
    }

    public void add(Integer aufgabennummer) {
        progress.add(aufgabennummer);
    }



 /*   public String getProgressValues(){
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

*/

    public static void main(String[] args) {
        launch();
    }
}
