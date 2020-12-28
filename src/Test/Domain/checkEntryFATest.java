package Test.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class checkEntryFATest {
    private checkEntryFA checkEntryFA;
    private String hour;
    private String minutes;

    @BeforeEach
    public void setUp() {
        checkEntryFA = new checkEntryFA();

    }

    @Test
    void setValues() {
        hour = "12";
        minutes = "00";

        checkEntryFA.setValues(hour, minutes);
        assertTrue(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertTrue(checkEntryFA.correctEntry);


        hour = "7";
        minutes = "45";

        checkEntryFA.setValues(hour, minutes);
        assertTrue(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertTrue(checkEntryFA.correctEntry);


        hour = "6";
        minutes = "15";

        checkEntryFA.setValues(hour, minutes);
        assertTrue(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertTrue(checkEntryFA.correctEntry);


        hour = "5";
        minutes = "30";

        checkEntryFA.setValues(hour, minutes);
        assertTrue(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertTrue(checkEntryFA.correctEntry);


        hour = "13";
        minutes = "00";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);


        hour = "00";
        minutes = "33";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);


        hour = "";
        minutes = "";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);


        hour = "11";
        minutes = "60";

        checkEntryFA.setValues(hour, minutes);

        assertTrue(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);


    }

    @Test
    void TestWrongValues()    {

        hour = "-1";
        minutes = "";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);


        hour = "-1";
        minutes = "30";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);

        hour = "123456789101112";
        minutes = "30";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);


        hour = "12";
        minutes = "-1";

        checkEntryFA.setValues(hour, minutes);

        assertTrue(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);



        hour = "ee";
        minutes = ".";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.correctEntry);

    }


}