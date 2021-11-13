package disease;

import enums.TSH_BORD;
import enums.State;

public class TSH implements disease.State {
    private State tshState;

    public TSH(double tshValue) {
        setState(tshValue);
    }

    public void setState(double tshValue) {
        TSH_BORD tsh_bord;

        if (tshValue < 10 && tshValue > 6) {
            tsh_bord = TSH_BORD.HIGH;
        }

        if (tshValue == 0) {
            tshState = State.NOT_READY;
        } else if (tshValue < 0.2 && tshValue > 0) {
            tshState = State.LOW;
        } else if (tshValue <= 6 && tshValue >= 0.2) {
            tshState = State.NORMAL;
        } else if (tshValue > 6) {
            tshState = State.HIGH;
        } else {
            tshState = State.UNDEFINED;
        }
    }

    public State getTshState() {
        return tshState;
    }

    public void setTshState(State tshState) {
        this.tshState = tshState;
    }
}
