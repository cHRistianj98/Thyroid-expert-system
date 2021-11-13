package examination;

import enums.State;

public class FTI implements examination.State {
    private State ftiState = State.MISSING;

    public FTI(double ftiValue) {
        setState(ftiValue);
    }

    public void setState(double ftiValue) {

        if (ftiValue == 0) {
            ftiState = State.NOT_READY;
        } else if (ftiValue < 65 && ftiValue > 0) {
            ftiState = State.LOW;
        } else if (ftiValue >= 65 && ftiValue <= 155) {
            ftiState = State.NORMAL;
        } else if (ftiValue > 155) {
            ftiState = State.HIGH;
        } else {
            ftiState = State.MISSING;
        }
    }

    public State getFtiState() {
        return ftiState;
    }
}
