package Calculator;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class CalculatorOutput {
    String currentNumbers = "";
    CalculatorLayout layoutClass = new CalculatorLayout();
    CalculatorCalculations calculations = new CalculatorCalculations();

    /**
     * Vid ett knapptryck så körs denna metod
     * @param input
     * @return
     */
    public TextField textfieldOutput(String input){

    currentNumbers = inputEditor(input);

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

    /**
     * Tar in en string och skapar en texfield med olika attribut
     * @param input
     * @return Textfield
     */
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

    /**
     * Tar in en string och returnerar den utan det sista tecknet
     * @param input
     * @return
     */
    public String deleteLastNumber(String input){
        StringBuilder backspace = new StringBuilder(input);
        backspace.deleteCharAt(input.length()-1);
        if(input.contains("⌫"))
        backspace.deleteCharAt(input.length()-2);
        input = backspace.toString();

        return input;
    }
    public String inputEditor(String input){

        currentNumbers =currentNumbers + input;

        if(input.charAt(0)=='π'){
            currentNumbers=deleteLastNumber(currentNumbers);
            currentNumbers=currentNumbers+"3.14";
        }


        if(isStringNumber(input) == false && currentNumbers.length()==1 && !input.contains("-")&& !input.contains("√")){
            currentNumbers = "";
            System.out.println("not - 2");

        }
        if(input.equals("⌫")) {
            if (currentNumbers.length()==0)
                currentNumbers = "";
            else
            currentNumbers = deleteLastNumber(currentNumbers);

        }
        if(currentNumbers.length()>= 2) {
            System.out.println(currentNumbers.charAt(currentNumbers.length() - 2));
            // om inputen och det sista tecknet i currentNumbers är räknesätt, gäller ej -
            if(isStringNumber(input) == false && Character.isDigit(currentNumbers.charAt(currentNumbers.length()-2)) == false && !input.contains("-")){

                currentNumbers = deleteLastNumber(currentNumbers);
            }
        }

        if(input.equals("=")){
            String test = currentNumbers;
            currentNumbers = calculations.result(test);
            if (currentNumbers.contains("=")){
                currentNumbers = deleteLastNumber(currentNumbers);
            }
        }

        if(input.equals("C"))
            currentNumbers = "";
        return currentNumbers;
    }

    /**
     * @return
     */




}
