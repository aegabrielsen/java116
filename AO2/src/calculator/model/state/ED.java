package calculator.model.state;

import calculator.model.Calculator;

public class ED implements CalculatorState {

    protected final Calculator calculator;

    public ED(Calculator calculator){
        this.calculator = calculator;
    }

    public double calculation() {
        double firstVal = Double.parseDouble(this.calculator.getFirstNumberBeforeDecimal()) + Double.parseDouble(this.calculator.getFirstNumberAfterDecimal());
        double secondVal = Double.parseDouble(this.calculator.getSecondNumberBeforeDecimal()) + Double.parseDouble(this.calculator.getSecondNumberAfterDecimal());
        return firstVal / secondVal;

    }

    public void newCalculationSetLeftSide() {
        double newVal = calculation();
        String doubleAsString = String.valueOf(newVal);
        int indexOfDecimal = doubleAsString.indexOf(".");
        this.calculator.setFirstNumberBeforeDecimal(doubleAsString.substring(0, indexOfDecimal));
        this.calculator.setFirstNumberAfterDecimal(doubleAsString.substring(indexOfDecimal));
    }
    public void newCalculationSetRightSide(){
        this.calculator.setSecondNumberBeforeDecimal("0");
        this.calculator.setSecondNumberAfterDecimal("0.");
    }

    @Override
    public double displayNumber() {
//        return Double.parseDouble(this.calculator.getFirstNumberBeforeDecimal());
//        double secondVal = Double.parseDouble(this.calculator.getSecondNumberBeforeDecimal()) + Double.parseDouble(this.calculator.getSecondNumberAfterDecimal());
        return calculation();
    }

//    @Override
//    public void clearPressed() {
//
//    }

    @Override
    public void numberPressed(int number) {
//        this.calculator.setSecondNumberBeforeDecimal(this.calculator.getSecondNumberBeforeDecimal().concat(Integer.toString(number)));
    }

    @Override
    public void dividePressed() {
        newCalculationSetLeftSide();
        newCalculationSetRightSide();
        this.calculator.stateTransition(new SNBDD(this.calculator));
    }

    @Override
    public void multiplyPressed() {
        newCalculationSetLeftSide();
        newCalculationSetRightSide();
        this.calculator.stateTransition(new SNBDM(this.calculator));

    }

    @Override
    public void subtractPressed() {
        newCalculationSetLeftSide();
        newCalculationSetRightSide();
        this.calculator.stateTransition(new SNBDS(this.calculator));
    }

    @Override
    public void addPressed() {
        newCalculationSetLeftSide();
        newCalculationSetRightSide();
        this.calculator.stateTransition(new SNBDA(this.calculator));
    }

    @Override
    public void equalsPressed() {
        newCalculationSetLeftSide();

    }

    @Override
    public void decimalPressed() {

    }
}
