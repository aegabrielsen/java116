package calculator.model.state;

import calculator.model.Calculator;

public class SNBDD extends SN {
    public SNBDD(Calculator calculator) {
        super(calculator);
    }


    @Override
    public void equalsPressed() {
        this.calculator.stateTransition(new ED(this.calculator));

    }
    @Override
    public void decimalPressed() {
        this.calculator.stateTransition(new SNADD(this.calculator));

    }
}
