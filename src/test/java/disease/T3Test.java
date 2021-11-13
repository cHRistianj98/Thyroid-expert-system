package disease;

import enums.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3Test {

    @Test
    public void notReady() {
        double t3Value = 0.0d;
        T3 t3 = new T3(t3Value);
        assertEquals(State.NOT_READY, t3.getT3State());
    }

    @Test
    public void low() {
        double t3Value = 1.1d;
        T3 t3 = new T3(t3Value);
        assertEquals(State.LOW, t3.getT3State());
    }

    @Test
    public void normal() {
        double t3Value = 1.2d;
        T3 t3 = new T3(t3Value);
        assertEquals(State.NORMAL, t3.getT3State());
    }

    @Test
    public void high() {
        double t3Value = 2.9d;
        T3 t3 = new T3(t3Value);
        assertEquals(State.HIGH, t3.getT3State());
    }

    @Test
    public void undefined() {
        double t3Value = -10.0d;
        T3 t3 = new T3(t3Value);
        assertEquals(State.UNDEFINED, t3.getT3State());
    }
}