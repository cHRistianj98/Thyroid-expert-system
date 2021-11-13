package disease;

import enums.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTITest {

    @Test
    public void notReady() {
        double ftiValue = 0.0d;
        FTI fti = new FTI(ftiValue);
        assertEquals(State.NOT_READY, fti.getFtiState());
    }

    @Test
    public void low() {
        double ftiValue = 64.0d;
        FTI fti = new FTI(ftiValue);
        assertEquals(State.LOW, fti.getFtiState());
    }

    @Test
    public void normal() {
        double ftiValue = 65.0d;
        FTI fti = new FTI(ftiValue);
        assertEquals(State.NORMAL, fti.getFtiState());
    }

    @Test
    public void high() {
        double ftiValue = 156.0d;
        FTI fti = new FTI(ftiValue);
        assertEquals(State.HIGH, fti.getFtiState());
    }

    @Test
    public void undefined() {
        double ftiValue = -10.0d;
        FTI fti = new FTI(ftiValue);
        assertEquals(State.UNDEFINED, fti.getFtiState());
    }
}