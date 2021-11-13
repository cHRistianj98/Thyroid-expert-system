package examination;

import enums.State;

public class TSH implements examination.State {
    private State tshState = State.MISSING;

    public TSH(double tshValue) {
        setState(tshValue);
    }

    public void setState(double tshValue) {
        if (tshValue == 0) {
            tshState = State.NOT_READY;
        } else if (tshValue < 0.2 && tshValue > 0) {
            tshState = State.LOW;
        } else if (tshValue <= 6 && tshValue >= 0.2) {
            tshState = State.NORMAL;
        } else if (tshValue > 6) {
            tshState = State.HIGH;
        } else {
            tshState = State.MISSING;
        }
    }

    public State getTshState() {
        return tshState;
    }
}
