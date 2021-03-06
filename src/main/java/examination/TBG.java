package examination;

import enums.State;

public class TBG implements examination.State {
    private State tbgState = State.MISSING;

    public TBG(double tbgValue) {
        setState(tbgValue);
    }

    public void setState(double tbgValue) {

        if (tbgValue == 0) {
            tbgState = State.NOT_READY;
        } else if (tbgValue < 12 && tbgValue > 0) {
            tbgState = State.LOW;
        } else if (tbgValue >= 12 && tbgValue <= 30) {
            tbgState = State.NORMAL;
        } else if (tbgValue > 30) {
            tbgState = State.HIGH;
        } else {
            tbgState = State.MISSING;
        }
    }

    public State getTbgState() {
        return tbgState;
    }
}
