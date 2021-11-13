package examination;

import enums.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TT4Test {

    @Test
    public void notReady() {
        double tt4Value = 0.0d;
        TT4 tt4 = new TT4(tt4Value);
        assertEquals(State.NOT_READY, tt4.getTt4State());
    }

    @Test
    public void low() {
        double tt4Value = 59.0d;
        TT4 tt4 = new TT4(tt4Value);
        assertEquals(State.LOW, tt4.getTt4State());
    }

    @Test
    public void normal() {
        double tt4Value = 60.0d;
        TT4 tt4 = new TT4(tt4Value);
        assertEquals(State.NORMAL, tt4.getTt4State());
    }

    @Test
    public void high() {
        double tt4Value = 151.0d;
        TT4 tt4 = new TT4(tt4Value);
        assertEquals(State.HIGH, tt4.getTt4State());
    }

    @Test
    public void undefined() {
        double tt4Value = -10.0d;
        TT4 tt4 = new TT4(tt4Value);
        assertEquals(State.MISSING, tt4.getTt4State());
    }
}