package examination;

import enums.State;

public class T3 implements examination.State {
    private State t3State = State.MISSING;

    public T3(double t3Value) {
        setState(t3Value);
    }

    public void setState(double t3Value) {

        if (t3Value == 0) {
            t3State = State.NOT_READY;
        } else if (t3Value < 1.2 && t3Value > 0) {
            t3State = State.LOW;
        } else if (t3Value >= 1.2 && t3Value <= 2.8) {
            t3State = State.NORMAL;
        } else if (t3Value > 2.8) {
            t3State = State.HIGH;
        } else {
            t3State = State.MISSING;
        }
    }

    public State getT3State() {
        return t3State;
    }
}
