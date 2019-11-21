package Calculator;

public class CalculatorController {
    // skapar en array med klasserna
    static CalculatorInterfaceOperators operators[] = new CalculatorInterfaceOperators[999];

    public static void main(String[] args) {

        // ger alla räknesätt ett index i form av sina tecken exempelvist addition blir +
        operators['+'] = new CalculatorAddition();
        operators['-'] = new CalculatorSubtraction();
        operators['÷'] = new CalculatorDevision();
        operators['*'] = new CalculatorMultiplication();
        operators['v'] = new CalculatorSquareRoot();
        operators['%'] = new CalculatorModulus();

    }

    /**
     * Tar in vilken räknetyp det är och den första och andra termen i talet
     *
     * @param operator
     * @param firstNumber
     * @param secondNumber
     */
    public double operatorController(char operator, double firstNumber, double secondNumber) {

        // eftersom java inte acepterar √ som index så blir v de nya index
        if (operator == '√') {
            operator = 'v';
        }
            return operators[operator].calculate(firstNumber, secondNumber);
    }


}