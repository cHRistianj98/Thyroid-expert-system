package examination;

import enums.State;

public class T4U implements examination.State {
    private State t4uState = State.MISSING;

    public T4U(double t4uValue) {
        setState(t4uValue);
    }

    public void setState(double t4uValue) {

        if (t4uValue == 0) {
            t4uState = State.NOT_READY;
        } else if (t4uValue < 0.6 && t4uValue > 0) {
            t4uState = State.LOW;
        } else if (t4uValue >= 0.6 && t4uValue <= 1.25) {
            t4uState = State.NORMAL;
        } else if (t4uValue > 1.25) {
            t4uState = State.HIGH;
        } else {
            t4uState = State.MISSING;
        }
    }

    public State getT4uState() {
        return t4uState;
    }
}
