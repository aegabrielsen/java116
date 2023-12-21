package calculator.model.state;

import calculator.model.Calculator;

public class SNADM extends SN {
    public SNADM(Calculator calculator) {
        super(calculator);
    }

    @Override
    public void numberPressed(int number) {
        this.calculator.setSecondNumberAfterDecimal(this.calculator.getSecondNumberAfterDecimal().concat(Integer.toString(number)));
    }
    @Override
    public void equalsPressed() {
        this.calculator.stateTransition(new EM(this.calculator));

    }
    @Override
    public void decimalPressed() {

    }
}