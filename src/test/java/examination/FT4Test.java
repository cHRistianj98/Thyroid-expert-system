package examination;

import enums.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FT4Test {

    @Test
    public void notReady() {
        double ft4Value = 0.0d;
        FT4 ft4 = new FT4(ft4Value);
        assertEquals(State.NOT_READY, ft4.getFt4State());
    }

    @Test
    public void low() {
        double ft4Value = 10.9d;
        FT4 ft4 = new FT4(ft4Value);
        assertEquals(State.LOW, ft4.getFt4State());
    }

    @Test
    public void normal() {
        double ft4Value = 15.9d;
        FT4 ft4 = new FT4(ft4Value);
        assertEquals(State.NORMAL, ft4.getFt4State());
    }

    @Test
    public void high() {
        double ft4Value = 33.9d;
        FT4 ft4 = new FT4(ft4Value);
        assertEquals(State.HIGH, ft4.getFt4State());
    }

    @Test
    public void undefined() {
        double ft4Value = -33.9d;
        FT4 ft4 = new FT4(ft4Value);
        assertEquals(State.MISSING, ft4.getFt4State());
    }
}