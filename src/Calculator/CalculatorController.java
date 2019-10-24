package Calculator;


public class CalculatorController {
    static CalculatorInterfaceOperators operators[] = new CalculatorInterfaceOperators[999];

    public static void main(String[] args) {
        // gör en array av CalculatorCalculations vid namn operators

        // ger alla räknesätt ett index i form av sina tecken exempelvist addition blir +
        operators ['+'] = new CalculatorAddition();
        operators ['-'] = new CalculatorSubtraction();
        operators ['÷'] = new CalculatorDevision();
        operators ['x'] = new CalculatorMultiplication();
        operators ['s'] = new CalculatorSquareRoot();

    }

    /**
     * Tar in vilken räknetyp det är och den första och andra termen i talet
     * @param operator
     * @param firstNumber
     * @param secondNumber
     */
    public double operatorController(char operator, double firstNumber, double secondNumber){


    return operators[operator].calculate(firstNumber,secondNumber);
    }


}