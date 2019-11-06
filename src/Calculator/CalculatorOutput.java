package Calculator;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class CalculatorOutput {
    String currentNumbers = "";
    CalculatorLayout layoutClass = new CalculatorLayout();
    CalculatorCalculations calculations = new CalculatorCalculations();


public TextField textfieldOutput(String input){

    currentNumbers =currentNumbers + input;

    // gör om if satserna till metoder
    if(isStringNumber(input) == false && currentNumbers.length()==1 && !input.contains("-")&& !input.contains("√")){
        currentNumbers = "";
        System.out.println("not - 2");

    }
    if(input.equals("⌫")) {
        currentNumbers = deleteLastNumber(currentNumbers);
    }
    if(currentNumbers.length()>= 2) {
        System.out.println(currentNumbers.charAt(currentNumbers.length() - 2));
        // om inputen och det sista tecknet i currentNumbers är räknesätt
         if(isStringNumber(input) == false && Character.isDigit(currentNumbers.charAt(currentNumbers.length()-2)) == false && !input.contains("-")){

        currentNumbers = deleteLastNumber(currentNumbers);
        }
    }


    if(input.equals("=")){
        String test = currentNumbers;
        currentNumbers = calculations.result(test);
    }



    if(input.equals("C"))
    currentNumbers = "";




   TextField textfieldOutput = textFieldCreator(currentNumbers);

    textfieldOutput.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        // för input direkt från tangentbordet
        public void handle(KeyEvent event) {
            if(event.getCode() != KeyCode.ENTER) {
                if (isStringNumber(event.getText().toString())== true)
                    currentNumbers = textfieldOutput.getText();

                System.out.println(textfieldOutput.getText());
            }
            if(event.getCode() == KeyCode.ENTER){
                System.out.println("ENTER");
                String test = currentNumbers;
                currentNumbers = calculations.result(test);
                textfieldOutput.setText(currentNumbers);
            }
        }
    });

    // keyboard backslash, delete


    return textfieldOutput;

    }

    public TextField textFieldCreator(String input){
        // ger textfielden sina attribut
        TextField textfieldOutput = new TextField(input);
        textfieldOutput.setStyle(("-fx-font: 50 arial;"));
        if(input.length() >= 20){
            textfieldOutput.setStyle("-fx-font: 30 arial;");
        }
        // går inte att skriva in bokstäver
        textfieldOutput.setEditable(false);

        textfieldOutput.setPrefWidth(800.0);
        textfieldOutput.setPrefHeight(200.0);

        return textfieldOutput;
    }
    public boolean isStringNumber(String input){
        char inputAsChar = input.charAt(0);
       if(Character.isDigit(inputAsChar) == false)
           return false;
       else
           return true;

    }

    public String deleteLastNumber(String input){
        StringBuilder backspace = new StringBuilder(input);
        backspace.deleteCharAt(input.length()-1);
        if(input.contains("⌫"))
        backspace.deleteCharAt(input.length()-2);
        input = backspace.toString();

        return input;
    }
    public String inputExceptions(){

    return "s";
    }




}
