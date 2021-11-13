package disease;

import enums.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TBGTest {

    @Test
    public void notReady() {
        double tbgValue = 0.0d;
        TBG tbg = new TBG(tbgValue);
        assertEquals(State.NOT_READY, tbg.getTbgState());
    }

    @Test
    public void low() {
        double tbgValue = 10.0d;
        TBG tbg = new TBG(tbgValue);
        assertEquals(State.LOW, tbg.getTbgState());
    }

    @Test
    public void normal() {
        double tbgValue = 12.0d;
        TBG tbg = new TBG(tbgValue);
        assertEquals(State.NORMAL, tbg.getTbgState());
    }

    @Test
    public void high() {
        double tbgValue = 31.0d;
        TBG tbg = new TBG(tbgValue);
        assertEquals(State.HIGH, tbg.getTbgState());
    }

    @Test
    public void undefined() {
        double tbgValue = -10.0d;
        TBG tbg = new TBG(tbgValue);
        assertEquals(State.MISSING, tbg.getTbgState());
    }
}