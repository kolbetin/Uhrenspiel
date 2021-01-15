/**
 * Die Klasse QuestionsAnswerTest testet die Korrektheit der Frage/Antwort Logik für die verschiedenen Levels im Spiel.
 * Mit der Uhrzeit als Key wird geprüft ob aus der Klasse QuestionsAnswer der korrekte Wert für die Antwort zurückgegeben wird.
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */

package uhrenspiel.domain;
import org.junit.Assert;
import org.junit.Test;

public class QuestionsAnswerTest {

    // Instanzvariable für den Zugriff auf die antwortenMap der Klasse QuestionsAnswer
    QuestionsAnswer questionsAnswer = new QuestionsAnswer();


    /**
     * Die Methode antwortenMapLevel1Test prüft die Korrektheit der Frage/Antwort Logik für Level 1.
     */
    @Test
    public void antwortenMapLevel1Test(){

        // Erstellen der antwortenMap für Level 1
        questionsAnswer.antwortenMapLevel1();

        // Testen der einzelnen Frage/Antwort Möglichkeiten von Level 1
        Assert.assertEquals ("1:00", questionsAnswer.antwortenMap.get("01:00"));
        Assert.assertEquals ("2:00", questionsAnswer.antwortenMap.get("02:00"));
        Assert.assertEquals ("3:00", questionsAnswer.antwortenMap.get("03:00"));
        Assert.assertEquals ("4:00", questionsAnswer.antwortenMap.get("04:00"));
        Assert.assertEquals ("5:00", questionsAnswer.antwortenMap.get("05:00"));
        Assert.assertEquals ("6:00", questionsAnswer.antwortenMap.get("06:00"));
        Assert.assertEquals ("7:00", questionsAnswer.antwortenMap.get("07:00"));
        Assert.assertEquals ("8:00", questionsAnswer.antwortenMap.get("08:00"));
        Assert.assertEquals ("9:00", questionsAnswer.antwortenMap.get("09:00"));
        Assert.assertEquals ("10:00", questionsAnswer.antwortenMap.get("10:00"));
        Assert.assertEquals ("11:00", questionsAnswer.antwortenMap.get("11:00"));
        Assert.assertEquals ("12:00", questionsAnswer.antwortenMap.get("12:00"));
    }

    /**
     * Die Methode antwortenMapLevel2Test prüft die Korrektheit der Frage/Antwort Logik für Level 2.
     */
    @Test
    public void antwortenMapLevel2Test(){

        // Erstellen der antwortenMap für Level 2
        questionsAnswer.antwortenMapLevel2();

        // Testen der einzelnen Frage/Antwort Möglichkeiten von Level 2
        Assert.assertEquals ("1:30", questionsAnswer.antwortenMap.get("01:30"));
        Assert.assertEquals ("2:30", questionsAnswer.antwortenMap.get("02:30"));
        Assert.assertEquals ("3:30", questionsAnswer.antwortenMap.get("03:30"));
        Assert.assertEquals ("4:30", questionsAnswer.antwortenMap.get("04:30"));
        Assert.assertEquals ("5:30", questionsAnswer.antwortenMap.get("05:30"));
        Assert.assertEquals ("6:30", questionsAnswer.antwortenMap.get("06:30"));
        Assert.assertEquals ("7:30", questionsAnswer.antwortenMap.get("07:30"));
        Assert.assertEquals ("8:30", questionsAnswer.antwortenMap.get("08:30"));
        Assert.assertEquals ("9:30", questionsAnswer.antwortenMap.get("09:30"));
        Assert.assertEquals ("10:30", questionsAnswer.antwortenMap.get("10:30"));
        Assert.assertEquals ("11:30", questionsAnswer.antwortenMap.get("11:30"));
        Assert.assertEquals ("12:30", questionsAnswer.antwortenMap.get("12:30"));
    }

    /**
     * Die Methode antwortenMapLevel3Test prüft die Korrektheit der Frage/Antwort Logik für Level 3.
     */
    @Test
    public void antwortenMapLevel3Test(){

        // Erstellen der antwortenMap für Level 3
        questionsAnswer.antwortenMapLevel3();

        // Testen der einzelnen Frage/Antwort Möglichkeiten von Level 3
        Assert.assertEquals ("1:15", questionsAnswer.antwortenMap.get("01:15"));
        Assert.assertEquals ("2:15", questionsAnswer.antwortenMap.get("02:15"));
        Assert.assertEquals ("3:15", questionsAnswer.antwortenMap.get("03:15"));
        Assert.assertEquals ("4:15", questionsAnswer.antwortenMap.get("04:15"));
        Assert.assertEquals ("5:15", questionsAnswer.antwortenMap.get("05:15"));
        Assert.assertEquals ("6:15", questionsAnswer.antwortenMap.get("06:15"));
        Assert.assertEquals ("7:15", questionsAnswer.antwortenMap.get("07:15"));
        Assert.assertEquals ("8:15", questionsAnswer.antwortenMap.get("08:15"));
        Assert.assertEquals ("9:15", questionsAnswer.antwortenMap.get("09:15"));
        Assert.assertEquals ("10:15", questionsAnswer.antwortenMap.get("10:15"));
        Assert.assertEquals ("11:15", questionsAnswer.antwortenMap.get("11:15"));
        Assert.assertEquals ("12:15", questionsAnswer.antwortenMap.get("12:15"));

        Assert.assertEquals ("1:45", questionsAnswer.antwortenMap.get("01:45"));
        Assert.assertEquals ("2:45", questionsAnswer.antwortenMap.get("02:45"));
        Assert.assertEquals ("3:45", questionsAnswer.antwortenMap.get("03:45"));
        Assert.assertEquals ("4:45", questionsAnswer.antwortenMap.get("04:45"));
        Assert.assertEquals ("5:45", questionsAnswer.antwortenMap.get("05:45"));
        Assert.assertEquals ("6:45", questionsAnswer.antwortenMap.get("06:45"));
        Assert.assertEquals ("7:45", questionsAnswer.antwortenMap.get("07:45"));
        Assert.assertEquals ("8:45", questionsAnswer.antwortenMap.get("08:45"));
        Assert.assertEquals ("9:45", questionsAnswer.antwortenMap.get("09:45"));
        Assert.assertEquals ("10:45", questionsAnswer.antwortenMap.get("10:45"));
        Assert.assertEquals ("11:45", questionsAnswer.antwortenMap.get("11:45"));
        Assert.assertEquals ("12:45", questionsAnswer.antwortenMap.get("12:45"));
    }

} // Ende der Klasse QuestionsAnswerTest
