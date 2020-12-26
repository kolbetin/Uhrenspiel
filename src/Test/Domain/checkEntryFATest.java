package Test.Domain;

import Test.Presentation.AlertHelper;
import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.scene.text.Text;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ContextWrapper;

import java.security.AccessController;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.core.IsEqual.equalTo;
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
        assertTrue(checkEntryFA.korrekt);


        hour = "7";
        minutes = "45";

        checkEntryFA.setValues(hour, minutes);
        assertTrue(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertTrue(checkEntryFA.korrekt);


        hour = "6";
        minutes = "15";

        checkEntryFA.setValues(hour, minutes);
        assertTrue(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertTrue(checkEntryFA.korrekt);


        hour = "5";
        minutes = "30";

        checkEntryFA.setValues(hour, minutes);
        assertTrue(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertTrue(checkEntryFA.korrekt);


        hour = "13";
        minutes = "00";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);


        hour = "00";
        minutes = "33";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);


        hour = "";
        minutes = "";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);


        hour = "11";
        minutes = "33";

        checkEntryFA.setValues(hour, minutes);

        assertTrue(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);


    }

    @Test
    void TestWrongValues()    {

        hour = "-1";
        minutes = "";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);


        hour = "-1";
        minutes = "30";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertTrue(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);


        hour = "12";
        minutes = "-1";

        checkEntryFA.setValues(hour, minutes);

        assertTrue(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);



        hour = "ee";
        minutes = ".";

        checkEntryFA.setValues(hour, minutes);

        assertFalse(checkEntryFA.getCheckHour());
        assertFalse(checkEntryFA.getCheckMinutes());
        assertFalse(checkEntryFA.korrekt);

    }


}