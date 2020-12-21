package Test.Domain;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.playedGames = new ArrayList<String>();

    }

    @Test
    void nextQuestion() {
        game.playedGames.add("12:00");
        game.playedGames.add("01:00");
        game.playedGames.add("03:00");

        Assert.assertNotEquals("12:00", game.getTaskkey(), game.key);
        Assert.assertNotEquals("01:00", game.getTaskkey(), game.key);
        Assert.assertNotEquals("03:00", game.getTaskkey(), game.key);

    }

    @Test
    void getLevel() {
    }

    @Test
    void getTaskkey() {
    }

    @Test
    void randomAnswer() {
    }

    @Test
    void getAnswerFA() {
    }
}