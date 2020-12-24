package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.Lernmodus;
import Test.Persistenz.QuestionsAnswer;
import com.sun.javafx.application.PlatformImpl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class UhrenspielTest {
    private Uhrenspiel uhrenspiel;
    private Game game;
    private Stage stage1;
    private MainGUI guiMC;
    private QuestionFreeAnswer guiFA;
    private MainScreenGUI mainScreen;

  @BeforeEach
    void setUp() {
       uhrenspiel = new Uhrenspiel();
       // stage1 = new Stage();

      // uhrenspiel.launch(Uhrenspiel.class);



       // mainScreen = new MainScreenGUI();
        guiMC = new MainGUI();
        guiFA = new QuestionFreeAnswer();
        game = new Game();
        game.setLevel(1);


    }
    @BeforeClass
    void start()
    {
        uhrenspiel.launch(Uhrenspiel.class);

    }




        @Test
    void newGame() {
        // Setzen der Test Ausgangslage für Game
        //uhrenspiel.launch(Uhrenspiel.class);
        game.aufgabennummer = 3;
        game.falscheAntwort = 2;
        game.richtigeAntwort = 1;
        uhrenspiel.setSaved();
        game.playedGames.add("12:00");
        game.playedGames.add("01:00");
        game.playedGames.add("02:00");

        // Zurücksetzen all Werte in Game


        uhrenspiel.newGame();


        Assert.assertEquals(0, game.aufgabennummer);
        Assert.assertFalse(uhrenspiel.getSaved());
        Assert.assertNotEquals(1,game.richtigeAntwort);
        Assert.assertEquals(0,game.falscheAntwort= 0);
        Assert.assertEquals(0,game.playedGames.size());
    }

    @Test
    void setgoOnButton() {
    }

    @Test
    void newGameMultipleChoice() {
    }

    @Test
    void newGameFreeAnswer() {
    }

    @Test
    void answerCheckFA() {
    }

    @Test
    void summaryGame() {
    }

    @Test
    void endGame() {
    }

    @Test
    void saveProgress() {
    }

    @Test
    void updateDta() {
    }
}