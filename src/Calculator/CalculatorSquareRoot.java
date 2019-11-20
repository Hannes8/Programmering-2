package Calculator;

public class CalculatorSquareRoot implements CalculatorInterfaceOperators {
        public double calculate(double firstNumber, double secondNumber){
            double result = Math.sqrt(secondNumber);
            return result;
        }
}
