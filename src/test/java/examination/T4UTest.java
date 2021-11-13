package examination;

import enums.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T4UTest {

    @Test
    public void notReady() {
        double t4uValue = 0.0d;
        T4U t4u = new T4U(t4uValue);
        assertEquals(State.NOT_READY, t4u.getT4uState());
    }

    @Test
    public void low() {
        double t4uValue = 0.5d;
        T4U t4u = new T4U(t4uValue);
        assertEquals(State.LOW, t4u.getT4uState());
    }

    @Test
    public void normal() {
        double t4uValue = 0.6d;
        T4U t4u = new T4U(t4uValue);
        assertEquals(State.NORMAL, t4u.getT4uState());
    }

    @Test
    public void high() {
        double t4uValue = 1.26d;
        T4U t4u = new T4U(t4uValue);
        assertEquals(State.HIGH, t4u.getT4uState());
    }

    @Test
    public void undefined() {
        double t4uValue = -10.0d;
        T4U t4u = new T4U(t4uValue);
        assertEquals(State.MISSING, t4u.getT4uState());
    }
}