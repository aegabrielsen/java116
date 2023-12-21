package calculator.model.state;

public interface CalculatorState {
    double displayNumber();

//    void clearPressed();

    void numberPressed(int number);

    void dividePressed();

    void multiplyPressed();

    void subtractPressed();

    void addPressed();

    void equalsPressed();

    void decimalPressed();
}
