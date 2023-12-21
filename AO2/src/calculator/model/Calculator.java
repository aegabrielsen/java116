package calculator.model;

import calculator.model.state.CalculatorState;
import calculator.model.state.FNBD;

public class Calculator {

    private CalculatorState state = new FNBD(this);
    private String firstNumberBeforeDecimal = "0";
    private String firstNumberAfterDecimal = "0.";
    private String secondNumberBeforeDecimal = "0";
    private String secondNumberAfterDecimal = "0.";
    private String leftHandNumber = "";



    public Calculator(){

    }

    public void stateTransition(CalculatorState newState){
        this.state = newState;
    }


    public double displayNumber() {
        return this.state.displayNumber();
    }

    public void clearPressed() {
        this.state = new FNBD(this);
        firstNumberBeforeDecimal = "0";
        firstNumberAfterDecimal = "0.";
        secondNumberBeforeDecimal = "0";
        secondNumberAfterDecimal = "0.";
    }

    public void numberPressed(int number) {
        // TODO
        this.state.numberPressed(number);
    }

    public void dividePressed() {
        this.state.dividePressed();
    }

    public void multiplyPressed() {
        this.state.multiplyPressed();
    }

    public void subtractPressed() {
        this.state.subtractPressed();
    }

    public void addPressed() {
        this.state.addPressed();
    }

    public void equalsPressed() {
        this.state.equalsPressed();
    }

    public void decimalPressed() {
        this.state.decimalPressed();
    }

    public String getFirstNumberBeforeDecimal() {
        return firstNumberBeforeDecimal;
    }

    public void setFirstNumberBeforeDecimal(String firstNumberBeforeDecimal) {
        this.firstNumberBeforeDecimal = firstNumberBeforeDecimal;
    }

    public String getFirstNumberAfterDecimal() {
        return firstNumberAfterDecimal;
    }

    public void setFirstNumberAfterDecimal(String firstNumberAfterDecimal) {
        this.firstNumberAfterDecimal = firstNumberAfterDecimal;
    }

    public String getSecondNumberBeforeDecimal() {
        return secondNumberBeforeDecimal;
    }

    public void setSecondNumberBeforeDecimal(String secondNumberBeforeDecimal) {
        this.secondNumberBeforeDecimal = secondNumberBeforeDecimal;
    }

    public String getSecondNumberAfterDecimal() {
        return secondNumberAfterDecimal;
    }

    public void setSecondNumberAfterDecimal(String secondNumberAfterDecimal) {
        this.secondNumberAfterDecimal = secondNumberAfterDecimal;
    }

    public String getLeftHandNumber() {
        return leftHandNumber;
    }

    public void setLeftHandNumber(String leftHandNumber) {
        this.leftHandNumber = leftHandNumber;
    }
}
