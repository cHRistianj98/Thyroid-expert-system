package examination;

import enums.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TSHTest {

    @Test
    public void notReady() {
        double tshValue = 0.0d;
        TSH tsh = new TSH(tshValue);
        assertEquals(enums.State.NOT_READY, tsh.getTshState());
    }

    @Test
    public void low() {
        double tshValue = 0.1d;
        TSH tsh = new TSH(tshValue);
        assertEquals(State.LOW, tsh.getTshState());
    }

    @Test
    public void normal() {
        double tshValue = 0.2d;
        TSH tsh = new TSH(tshValue);
        assertEquals(State.NORMAL, tsh.getTshState());
    }

    @Test
    public void high() {
        double tshValue = 10.9d;
        TSH tsh = new TSH(tshValue);
        assertEquals(State.HIGH, tsh.getTshState());
    }

    @Test
    public void undefined() {
        double tshValue = -10.9d;
        TSH tsh = new TSH(tshValue);
        assertEquals(State.MISSING, tsh.getTshState());
    }
}