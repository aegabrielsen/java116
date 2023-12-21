package calculator.model.state;

import calculator.model.Calculator;

public class FNAD implements CalculatorState {

    protected final Calculator calculator;

    public FNAD(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public double displayNumber() {
        double firstVal = Double.parseDouble(this.calculator.getFirstNumberBeforeDecimal()) + Double.parseDouble(this.calculator.getFirstNumberAfterDecimal());
        return firstVal;

    }


    @Override
    public void numberPressed(int number) {
        this.calculator.setFirstNumberAfterDecimal(this.calculator.getFirstNumberAfterDecimal().concat(Integer.toString(number)));
    }

    @Override
    public void dividePressed() {
        this.calculator.stateTransition(new SNBDD(this.calculator));

    }

    @Override
    public void multiplyPressed() {
        this.calculator.stateTransition(new SNBDM(this.calculator));

    }

    @Override
    public void subtractPressed() {
        this.calculator.stateTransition(new SNBDS(this.calculator));
    }

    @Override
    public void addPressed() {
        this.calculator.stateTransition(new SNBDA(this.calculator));
    }

    @Override
    public void equalsPressed() {

    }

    @Override
    public void decimalPressed() {

    }
}
