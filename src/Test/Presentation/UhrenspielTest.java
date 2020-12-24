package Test.Presentation;

import Test.Domain.Game;
import Test.Domain.Lernmodus;
import Test.Persistenz.QuestionsAnswer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UhrenspielTest {
    private Uhrenspiel uhrenspiel;
    private Game game;

    @BeforeEach
    void setUp() {
        uhrenspiel = new Uhrenspiel();
        game = new Game();
        game.setLevel(1);
       // game.playedGames = new ArrayList<String>();
    }

    @Test
    void newGame() {
        // Setzen der Test Ausgangslage für Game
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