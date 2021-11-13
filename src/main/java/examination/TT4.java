package examination;

import enums.State;

public class TT4 implements examination.State {
    private State tt4State = State.MISSING;

    public TT4(double tt4Value) {
        setState(tt4Value);
    }

    public void setState(double tt4Value) {

        if (tt4Value == 0) {
            tt4State = State.NOT_READY;
        } else if (tt4Value < 60 && tt4Value > 0) {
            tt4State = State.LOW;
        } else if (tt4Value >= 60 && tt4Value <= 150) {
            tt4State = State.NORMAL;
        } else if (tt4Value > 150) {
            tt4State = State.HIGH;
        } else {
            tt4State = State.MISSING;
        }
    }

    public State getTt4State() {
        return tt4State;
    }
}
