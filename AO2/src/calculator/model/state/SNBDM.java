package calculator.model.state;

import calculator.model.Calculator;

public class SNBDM extends SN {
    public SNBDM(Calculator calculator) {
        super(calculator);
    }


    @Override
    public void equalsPressed() {
        this.calculator.stateTransition(new EM(this.calculator));

    }
    @Override
    public void decimalPressed() {
        this.calculator.stateTransition(new SNADM(this.calculator));

    }
}
