package calculator.model.state;

import calculator.model.Calculator;

public class SNBDS extends SN {
    public SNBDS(Calculator calculator) {
        super(calculator);
    }


    @Override
    public void equalsPressed() {
        this.calculator.stateTransition(new ES(this.calculator));

    }
    @Override
    public void decimalPressed() {
        this.calculator.stateTransition(new SNADS(this.calculator));

    }
}
