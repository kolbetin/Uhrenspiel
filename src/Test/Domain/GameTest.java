package Test.Domain;

import Test.Persistenz.QuestionsAnswer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GameTest {
    private Game game;
    private QuestionsAnswer qa;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.playedGames = new ArrayList<String>();
        qa = new QuestionsAnswer();


    }

    @Test
    void nextQuestion() {
        game.level = 1;
        game.setLevel(1);
        game.playedGames.add("12:00");
        game.playedGames.add("01:00");
        game.playedGames.add("03:00");

        Assert.assertNotEquals("12:00", game.getTaskkey());
        Assert.assertNotEquals("01:00", game.getTaskkey());
        Assert.assertNotEquals("03:00", game.getTaskkey());

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