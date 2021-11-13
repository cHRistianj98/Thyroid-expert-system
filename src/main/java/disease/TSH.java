package disease;

import enums.TSH_BORD;
import enums.TSH_STATE;

public class TSH {
    private TSH_STATE tshState;

    public TSH(double tshValue) {
        setUserTshState(tshValue);
    }

    public void setUserTshState(double tshValue) {
        TSH_BORD tsh_bord;

        if (tshValue < 10 && tshValue > 6) {
            tsh_bord = TSH_BORD.HIGH;
        }

        if (tshValue == 0) {
            tshState = TSH_STATE.NOT_READY;
        } else if (tshValue < 0.2 && tshValue > 0) {
            tshState = TSH_STATE.LOW;
        } else if (tshValue <= 6 && tshValue >= 0.2) {
            tshState = TSH_STATE.NORMAL;
        } else if (tshValue > 6) {
            tshState = TSH_STATE.HIGH;
        } else {
            tshState = TSH_STATE.UNDEFINED;
        }
    }

    public TSH_STATE getTshState() {
        return tshState;
    }

    public void setTshState(TSH_STATE tshState) {
        this.tshState = tshState;
    }
}
