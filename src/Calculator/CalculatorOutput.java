package Calculator;

import javafx.scene.control.TextField;

public class CalculatorOutput {
    private String currentNumbers = "";
    private CalculatorCalculations calculations = new CalculatorCalculations();

    /**
     * Vid ett knapptryck så körs denna metod
     * @param input
     * @return
     */
    public TextField textfieldOutput(String input) {

        currentNumbers = inputEditor(input);

        TextField textfieldOutput = textFieldCreator(currentNumbers);

        return textfieldOutput;

    }

    /**
     * Tar in en string och skapar ett texfield med olika attribut
     *
     * @param input
     * @return Textfield
     */
    public TextField textFieldCreator(String input) {
        // ger textfielden sina attribut
        TextField textfieldOutput = new TextField(input);
        textfieldOutput.setStyle("-fx-font: 50 arial;");
        textfieldOutput.setEditable(false);
        textfieldOutput.setPrefWidth(800.0);
        textfieldOutput.setPrefHeight(200.0);
        // om inputen är längre eller lika med 17 så blir font storleken mindre
        if (input.length() >= 17) {
            textfieldOutput.setStyle("-fx-font: 30 arial;");
        }
        return textfieldOutput;
    }

    /**
     * Tar in en string och returnerar den utan det sista tecknet
     *
     * @param input
     * @return
     */
    public String deleteLastNumber(String input) {
        StringBuilder backspace = new StringBuilder(input);
        backspace.deleteCharAt(input.length() - 1);
        if (input.contains("⌫"))
            backspace.deleteCharAt(input.length() - 2);
        input = backspace.toString();

        return input;
    }

    /**
     * Hanterar inputen
     *
     * @param input
     * @return
     */
    public String inputEditor(String input) {

        currentNumbers += input;

        // om inputen inte är en siffra eller - , √
        if (Character.isDigit(input.charAt(0)) == false && currentNumbers.length() == 1 && !input.contains("-") && !input.contains("√")) {
            currentNumbers = "";

        }
        if (input.equals("⌫")) {
            if (currentNumbers.length() == 0)
                currentNumbers = "";
            else
                currentNumbers = deleteLastNumber(currentNumbers);

        }
        if (currentNumbers.length() >= 2) {
            // om inputen och det sista tecknet i currentNumbers är räknesätt, gäller ej -
            if (Character.isDigit(input.charAt(0)) == false && Character.isDigit(currentNumbers.charAt(currentNumbers.length() - 2)) == false && !input.contains("-") && !input.contains("√")) {
                currentNumbers = deleteLastNumber(currentNumbers);
            }
        }

        if (input.equals("=")) {

            try {
                currentNumbers = deleteLastNumber(currentNumbers);
                currentNumbers = calculations.result(currentNumbers);
            }
            catch (Exception e){
                System.out.println("ERROR");
            }

        }

        if (input.equals("C"))
            currentNumbers = "";

        return currentNumbers;
    }
}
