/**
 * Die Klasse steuert den Spielablauf. Hier wird die Frage (Uhrzeit) mit der Antwort erstellt.
 *
 *
 *  @author Tina Kolbe & Oliver Piert
 *  @version 1.0
 */

package uhrenspiel.domain;

import java.util.*;


public class Game {

    // Instanzvariablen
    private QuestionsAnswer questionsAnswermap;
    public List playedGames ;
    public ArrayList<String> keyList;
    public List answerList;
    public String key;
    public int taskNumber = 0;
    public int correctAnswer =0;
    public int wrongAnswer = 0;
    public int level = 1;
    public double sum = 0 ;
    public boolean saved = false;
    public String answer;


    /**
     * Konstruktor der Klasse.
     *
     * Die Klasse initialisiert die Listen.
     */
    public Game() {
        questionsAnswermap = new QuestionsAnswer();
        answerList = new ArrayList<String>();
        keyList = new ArrayList<>();
        playedGames = new ArrayList<String>();
    }


    /**
     * Die Methode erstellt die nächste Frage. Es wird die Frage (Uhrzeit) ausgewählt und das
     * Antwortenset zur Verfügung gestellt. Die Aufgabennummer wird hochgezählt.
     *
     */

    public void nextQuestion() {
        keyList.clear();
        answerList.clear();
        getTaskkey();
        randomAnswer();
        answerSet();
        taskNumber++;
    }


    /**
     * Die Methode nimmt das ausgewählte Level entgegen und befüllt den Fragen Antwortenkatalog
     * entsprechend der Level.
     *
     * Das Level wird in der Klasse Uhrenspiel gesetzt.
     *
     * @param  level Übergibt einen Integer mit dem Level
     *
     */

    public void setLevel(int level) {
        questionsAnswermap.antwortenMap.clear();
        if (level == 1) {
            questionsAnswermap.antwortenMapLevel1();
        }
        if (level == 2) {
            questionsAnswermap.antwortenMapLevel2();
        }
        if  (level == 3) {
            questionsAnswermap.antwortenMapLevel3();
        }
        if (level == 4) {
            questionsAnswermap.antwortenMapLevel1();
            questionsAnswermap.antwortenMapLevel2();
            questionsAnswermap.antwortenMapLevel3();
        }

    }


    /**
     * Die Methode nimmt die eingegebenen Parameter im Modus Freie Antwort entgegen und startet
     * den Check ob die Antwort korrekt oder falsch ist. Dieser Check wird erst gestartet, wenn die Eingabe valide ist.
     *
     *
     * @param  hour  Übergibt einen String mit der Stunde im Format "12"
     * @param  minutes Übergibt einen String mit der Minuten im Format "45"
     *
     * @return    Gibt den Boolean zurück, ob die Uhrzeit korrekt oder falsch eingegeben wurde.
     */

    public boolean checkAnswerFA(String hour, String minutes){
        answer = hour + ":" + minutes;
             return answer.equals(getAnswerFA(key))
                | answer.equals("0" + getAnswerFA(key))
                | (hour.equals("0" + getAnswerFA(key))
                | (hour.equals(getAnswerFA(key))));
    }

    /**
     * Die Methode wählt per Zufall eine Uhrzeit (Frage) aus. Die Methode stellt sicher,
     * dass eine Frage nicht doppelt gestellt wird.
     *
     * @return    Gibt das Object Frage (Uhrzeit) zurück.
     */

    public Object getTaskkey() {
        boolean played = false;

        while ( !played ){
            Object[] objects = questionsAnswermap.antwortenMap.keySet().toArray();
            Object randomkey = objects[new Random().nextInt(objects.length)];
            if (!playedGames.contains(randomkey)) {
                keyList.add((String) randomkey);
                key = (String) randomkey;
                played = true;
            }
        }
        return key;
    }

    /**
     * Die Methode befüllt die Uhrzeitenliste mit drei weiteren zufälligen Uhrzeiten, für den Multiple Choice
     * Antwortenmodus.
     *
     * @return    Gibt die Liste mit Uhrzeitmöglichkeiten zurück.
     */


    public List randomAnswer() {

        Object[] objects = questionsAnswermap.antwortenMap.keySet().toArray();

        for (int i = 0; keyList.size() < 4; i++) {
            Object keys = objects[new Random().nextInt(objects.length)];
            if (!keyList.contains(keys) & keys != key  ) {
                keyList.add((String) keys);
            }
        }
        return keyList;
    }

    /**
     * Die Methode erstellt die Antwortenliste von der Uhrzeitenliste für den Multiple
     * Choice Antwortenmodus.
     *
     */

    public void answerSet() {
        for (int i = 0; i < 4; i++) {
            String value = questionsAnswermap.antwortenMap.get(keyList.get(i));
            answerList.add(value);
            Collections.shuffle(answerList);
        }
    }

    /**
     * Die Methode gibt die Antwort für den Freie Antwortenmodus zurück.
     *
     * @param keys Nimmt den String der ausgewählten Frage (Uhrzeit) entgegen.
     *
     * @return Gibt die Anwort für die Frage (Uhrzeit) in Freie Antwort zurück.
     */

    public String getAnswerFA(String keys) {
        return questionsAnswermap.antwortenMap.get(keys);
    }

}// Ende Klasse Game
