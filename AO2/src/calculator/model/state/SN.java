package calculator.model.state;

import calculator.model.Calculator;

public abstract class SN implements CalculatorState {

    protected final Calculator calculator;

    public SN(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public double displayNumber() {
//        return Double.parseDouble(this.calculator.getFirstNumberBeforeDecimal());
        double secondVal = Double.parseDouble(this.calculator.getSecondNumberBeforeDecimal()) + Double.parseDouble(this.calculator.getSecondNumberAfterDecimal());
        return secondVal;
    }

//    @Override
//    public void clearPressed() {
//
//    }

    @Override
    public void numberPressed(int number) {
        this.calculator.setSecondNumberBeforeDecimal(this.calculator.getSecondNumberBeforeDecimal().concat(Integer.toString(number)));
    }

    @Override
    public void dividePressed() {

    }

    @Override
    public void multiplyPressed() {

    }

    @Override
    public void subtractPressed() {

    }

    @Override
    public void addPressed() {

    }

    @Override
    public void equalsPressed() {

    }

    @Override
    public void decimalPressed() {

    }
}
