package Test.Domain;

import Test.Persistenz.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SavedData extends Application  {

    private BufferInterface bufferInterface;
    private QuestionsAnswer qa;
    private Random random;
    public List<String> progress;
    public int level;
    public Game game;
    public boolean strictGame;




    public void start(Stage p){}

    public SavedData() {
        qa = new QuestionsAnswer();
        progress = new ArrayList();
        random = new Random();
        bufferInterface = new BufferWriter();
        game = new Game();
        System.out.println(progress.size());
        System.out.println("Aufgabennummer: " + game.aufgabennummer);
        System.out.println("Level " + game.level);

    }

    public void setProgress(List<String> newprogress) {
        this.progress.clear();
        this.progress.addAll(newprogress);
    }

    public void setPlayedGames() {
        game.playedGames.clear();
        game.playedGames.addAll(Arrays.asList(progress.get(3)));
    }

    public void setLevel() {
        int i = Integer.parseInt(progress.get(1));
        game.level = i;
    }
    public void setAufgabennummer() {
        int i = Integer.parseInt(progress.get(0));
        game.aufgabennummer = i;
    }
    public void setStrictGame() {
        boolean b = Boolean.valueOf(progress.get(2));
        game.strictGame = strictGame;
    }

    public void saveProgress(String file) throws IOException {
        bufferInterface.save(file,progress);
    }

    public void loadProgress(String file) throws ClassNotFoundException, IOException {
          setProgress(bufferInterface.load(file));
        System.out.println("Datei wurde geladen: " + progress.toString());
        setLevel();
        setAufgabennummer();
        setStrictGame();
        setPlayedGames();
        System.out.println(game.aufgabennummer);
        System.out.println("Level: " + game.level);
        System.out.println("Strict Game: " + game.strictGame);
        System.out.println("Played Game: " + game.playedGames);

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

  //  public void add(Integer aufgabennummer) { progress.add(aufgabennummer);   }



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
