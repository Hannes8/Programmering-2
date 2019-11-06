package Calculator;

public class CalculatorSquareRoot implements CalculatorInterfaceOperators {
        public double calculate(double firstNumber, double secondNumber){
            System.out.println(secondNumber);
            double result = Math.sqrt(secondNumber);
            System.out.println(result);
            return result;
        }
}
