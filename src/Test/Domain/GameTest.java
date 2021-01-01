/**
 * Die Klasse testet den Spielablauf.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */


package Test.Domain;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game;
    private String hour;
    private String minutes;

    /**
     * Die Methode wird vor jedem Test ausgeführt und bereitet das set up für die Tests.
     */

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    /**
     * Die Methode testet die Erstellung der nächsten Frage.
     * Es wird getestet das Uhrzeiten innerhalb eines Aufgabensets nicht doppelt
     * abgefragt werden.

     * Diese Tests werden für alle drei Level durchgeführt.
     */


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
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        Assert.assertEquals(1,game.taskNumber);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        Assert.assertEquals(2,game.taskNumber);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        Assert.assertEquals(3,game.taskNumber);
        System.out.println(game.playedGames);


        game.playedGames.clear();
        game.taskNumber = 0;

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
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.keyList.contains(game.key));
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
        Assert.assertTrue(game.keyList.contains(game.key));
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.nextQuestion();

        Assert.assertNotEquals(game.playedGames, game.key);
        Assert.assertTrue(game.keyList.contains(game.key));
        game.playedGames.add(game.key);
        System.out.println(game.playedGames);

        game.playedGames.clear();

    }

    /**
     * Die Methode prüft, ob im Multiple Choice Mode zu jeder Uhrzeit, die korrekte Antwort in der
     * ausgegebenen Antwortenliste enthalten ist.
     */



    @Test
    void answerSet(){
        game.key = "01:00";
        game.keyList.add(game.key);
        game.setLevel(1);
        game.randomAnswer();
        game.answerSet();
        Assert.assertTrue(game.answerList.contains("1:00"));

        game.keyList.clear();

        game.key = "04:30";
        game.keyList.add(game.key);
        game.setLevel(2);
        game.randomAnswer();
        game.answerSet();
        Assert.assertFalse(game.answerList.contains("4:45"));

        game.keyList.clear();

        game.key = "07:45";
        game.keyList.add(game.key);
        game.setLevel(3);
        game.randomAnswer();
        game.answerSet();
        Assert.assertTrue(game.answerList.contains("7:45"));

    }

    /**
     * Die Methode prüft, ob zu jeder Uhrzeit, die korrekte Antwort im Freie Antwortenmodus ausgegeben wird.
     */

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
    /**
     * Die Methode prüft, ob die korrekte Antwort bei unterschiedlicher Eingabe von hour und minutes im
     * Freien Antwortenmodus erkannt wird.
     */


    @Test
    void checkAnswerFA(){
        hour = "1";
        minutes = "00";
        game.setLevel(1);
        game.key = "01:00";
        Assert.assertTrue(game.checkAnswerFA(hour,minutes));

        hour = "02";
        minutes = "00";
        game.setLevel(1);
        game.key = "02:00";
        Assert.assertTrue(game.checkAnswerFA(hour,minutes));


        hour = "3";
        minutes = "00";
        game.setLevel(1);
        game.key = "02:00";
        Assert.assertFalse(game.checkAnswerFA(hour,minutes));

        hour = "1";
        minutes = "15";
        game.setLevel(3);
        game.key = "01:15";
        Assert.assertTrue(game.checkAnswerFA(hour,minutes));

        hour = "02";
        minutes = "30";
        game.setLevel(2);
        game.key = "02:30";
        Assert.assertTrue(game.checkAnswerFA(hour,minutes));


        hour = "03";
        minutes = "45";
        game.setLevel(3);
        game.key = "02:15";
        Assert.assertFalse(game.checkAnswerFA(hour,minutes));

        hour = "01";
        minutes = "00";
        game.setLevel(1);
        game.key = "11:00";
        Assert.assertFalse(game.checkAnswerFA(hour,minutes));
    }
}