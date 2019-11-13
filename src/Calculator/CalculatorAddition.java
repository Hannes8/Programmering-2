package Calculator;

public class CalculatorAddition implements CalculatorInterfaceOperators {

    public double calculate(double firstNumber,double secondNumber){

        Double result = firstNumber + secondNumber;
        System.out.println(firstNumber+ " " + secondNumber+ " = "+result);
        System.out.println("Addition");

        return result;

    }


}
