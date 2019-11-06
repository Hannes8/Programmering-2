package Calculator;

public class CalculatorModulus implements CalculatorInterfaceOperators {
    public double calculate(double firstNumber, double secondNumber){
        double result = firstNumber % secondNumber;

        return result;
    }

}
