package Calculator;
import javafx.scene.control.TextField;


public class CalculatorOutput {
    String currentNumbers = "";
    CalculatorLayout layoutClass = new CalculatorLayout();
    CalculatorCalculations calculations = new CalculatorCalculations();

public TextField textfieldOutput(String input){

    currentNumbers =currentNumbers + input;

    // gör om if satserna till metoder

    // gör om currentNumbers till stringbuilder för att ta bort det sista tecknet
    if(input.equals("⌫")){
        StringBuilder backspace = new StringBuilder(currentNumbers);
        backspace.deleteCharAt(currentNumbers.length()-1);
        backspace.deleteCharAt(currentNumbers.length()-2);
        currentNumbers = backspace.toString();
    }


    if(input.equals("C"))
    currentNumbers = "";

    if(input.equals("=")){
        String test = currentNumbers;
        currentNumbers = calculations.result(test);
    }



    // ger textfielden sina attribut
    TextField textfieldOutput = new TextField(currentNumbers);
    textfieldOutput.setStyle(("-fx-font: 50 arial;"));
    if(currentNumbers.length() >= 20){
        textfieldOutput.setStyle("-fx-font: 30 arial;");
    }

    textfieldOutput.setPrefWidth(800.0);
    textfieldOutput.setPrefHeight(200.0);

    return textfieldOutput;

    }




}
