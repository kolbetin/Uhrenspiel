package Test.Presentation;

import Test.Domain.Game;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UhrenspielTest {
    private Uhrenspiel uhrenspiel;
    private Game game;


  @BeforeEach
    void setUp() {
       uhrenspiel = new Uhrenspiel();
        game = new Game();
      game.level = 1;
      game.setLevel(game.level);
      //  game.setLevel(1);


    }
    @BeforeClass
    void start()
    {
    //    uhrenspiel.launch(Uhrenspiel.class);

    }




        @Test
    void newGame() {
        // Setzen der Test Ausgangslage für Game
        //uhrenspiel.launch(Uhrenspiel.class);
        game.taskNumber = 3;
        game.wrongAnswer = 2;
        game.correctAnswer = 1;
        game.saved = false;
        game.playedGames.add("12:00");
        game.playedGames.add("01:00");
        game.playedGames.add("02:00");

        // Zurücksetzen all Werte in Game

        game.nextQuestion();
        game.nextQuestion();
        game.nextQuestion();

        Assert.assertEquals(6, game.taskNumber);

        uhrenspiel.setBackData();


        Assert.assertEquals(0, game.taskNumber);
      /*  Assert.assertFalse(uhrenspiel.getSaved());
        Assert.assertNotEquals(1,game.richtigeAntwort);
        Assert.assertEquals(0,game.falscheAntwort);
        Assert.assertEquals(0,game.playedGames.size());*/
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