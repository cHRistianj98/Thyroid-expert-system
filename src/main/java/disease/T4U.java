package disease;

import enums.State;

public class T4U implements disease.State {
    private State t4uState = State.UNDEFINED;

    public T4U() {
    }

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
            t4uState = State.UNDEFINED;
        }
    }

    public State getT4uState() {
        return t4uState;
    }

    public void setT4uState(State t4uState) {
        this.t4uState = t4uState;
    }
}
