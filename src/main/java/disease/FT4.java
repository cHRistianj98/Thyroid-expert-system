package disease;

import enums.State;

public class FT4 implements disease.State {
    private State ft4State = State.MISSING;

    public FT4() {
    }

    public FT4(double ft4Value) {
        setState(ft4Value);
    }

    public void setState(double ft4Value) {

        if (ft4Value == 0) {
            ft4State = State.NOT_READY;
        } else if (ft4Value < 11 && ft4Value > 0) {
            ft4State = State.LOW;
        } else if (ft4Value >= 11 && ft4Value <= 22) {
            ft4State = State.NORMAL;
        } else if (ft4Value > 22) {
            ft4State = State.HIGH;
        } else {
            ft4State = State.MISSING;
        }
    }

    public State getFt4State() {
        return ft4State;
    }

    public void setFt4State(State ft4State) {
        this.ft4State = ft4State;
    }
}
