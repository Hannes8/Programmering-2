package Calculator;


public class CalculatorController {
    static CalculatorCalculations operators[] = new CalculatorCalculations[999];
    public static void main(String[] args) {
        // gör en array av CalculatorCalculations vid namn operators

        // ger alla räknesätt ett index i form av sina tecken exempelvist addition blir +
        operators ['+'] = new CalculatorAddition();
        operators ['-'] = new CalculatorSubtraction();

           System.out.println(operators['+'].calculate(4.5 , 8.6));
           System.out.println(operators['-'].calculate(4.8 , 5.6));

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