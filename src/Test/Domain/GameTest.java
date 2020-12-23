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
        game.playedGames.clear();
        game.level = 1;
        game.setLevel(game.level);

        game.playedGames.add("12:00");
        game.playedGames.add("01:00");
        game.playedGames.add("02:00");
        game.playedGames.add("03:00");
        game.playedGames.add("05:00");
        game.playedGames.add("10:00");
        game.playedGames.add("09:00");
        game.playedGames.add("07:00");
        game.playedGames.add("08:00");

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        Assert.assertEquals(1,game.aufgabennummer);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        Assert.assertEquals(2,game.aufgabennummer);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        Assert.assertEquals(3,game.aufgabennummer);
        System.out.println(game.playedGames);


        game.playedGames.clear();
        game.aufgabennummer= 0;

        game.level = 2;
        game.setLevel(game.level);

        game.playedGames.add("12:30");
        game.playedGames.add("01:30");
        game.playedGames.add("02:30");
        game.playedGames.add("03:30");
        game.playedGames.add("05:30");
        game.playedGames.add("10:30");
        game.playedGames.add("09:30");
        game.playedGames.add("07:30");
        game.playedGames.add("08:30");

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);


        game.playedGames.clear();

        game.level = 3;

        game.setLevel(game.level);

        game.playedGames.add("12:15");
        game.playedGames.add("01:15");
        game.playedGames.add("02:15");
        game.playedGames.add("03:45");
        game.playedGames.add("05:15");
        game.playedGames.add("10:45");
        game.playedGames.add("09:15");
        game.playedGames.add("07:45");
        game.playedGames.add("07:15");

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.liste.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.playedGames.clear();

    }

    @Test
    void answerSet(){
        game.key = "01:00";
        game.liste.add(game.key);
        game.setLevel(1);
        game.randomAnswer();
        game.answerSet();
        Assert.assertTrue(game.answers.contains("1:00"));

        game.liste.clear();

        game.key = "04:30";
        game.liste.add(game.key);
        game.setLevel(2);
        game.randomAnswer();
        game.answerSet();
        Assert.assertTrue(game.answers.contains("4:30"));

        game.liste.clear();

        game.key = "07:45";
        game.liste.add(game.key);
        game.setLevel(3);
        game.randomAnswer();
        game.answerSet();
        Assert.assertTrue(game.answers.contains("7:45"));

    }
    @Test
    void getAnswerFA() {
        game.key = "03:00";
        game.setLevel(1);
        Assert.assertEquals("3:00",game.getAnswerFA(game.key));

        game.key = "03:30";
        game.setLevel(2);
        Assert.assertNotEquals("3:00",game.getAnswerFA(game.key));

        game.key = "09:15";
        game.setLevel(3);
        Assert.assertEquals("9:15",game.getAnswerFA(game.key));
    }
}