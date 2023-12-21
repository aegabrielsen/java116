package calculator.model.state;

import calculator.model.Calculator;

public class SNBDA extends SN {
    public SNBDA(Calculator calculator) {
        super(calculator);
    }


    @Override
    public void equalsPressed() {
        this.calculator.stateTransition(new EA(this.calculator));

    }
    @Override
    public void decimalPressed() {
        this.calculator.stateTransition(new SNADA(this.calculator));

    }
}
