package Calculator;

import java.util.ArrayList;


public class CalculatorCalculations {
    CalculatorController controllerClass = new CalculatorController();

    public double calculate(double firstNumber, double secondNumber){

        return 0.0;


    }

    /**
     * Loopar igenom inputen från textfield och checkar varje tecken om det är ett nummer, om det inte är ett nummber så
     * @param textfieldValue
     * @return
     */
    public String result(String textfieldValue){
        for (int i = 0; i < textfieldValue.length() -1; i++) {
          if(checkIfNumber(textfieldValue.charAt(i)) == false) {
              char operator = textfieldValue.charAt(i);

              // operator, first number, second number
              double [] terms = termFinder(textfieldValue);



              System.out.println(operator);
              System.out.println("not a number");
              double result = controllerClass.operatorController(operator, terms[0],terms[1]);
              int test = (int)result;
              String resultString = Integer.toString(test);
              return resultString;



            }


        }
        return "error";



    }
    public double[] termFinder(String input){
       String termAsString ="";
        ArrayList <Double> doubleArray = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if(checkIfNumber(input.charAt(i))==true){
            termAsString = termAsString + input.charAt(i);
            }
            else{

                System.out.println(termAsString);
                doubleArray.add(Double.parseDouble(termAsString));

                termAsString ="";


            }

        }


        double [] terms = {doubleArray.get(0),doubleArray.get(1)};
        return terms;
    }

    public Boolean checkIfNumber(char input){
       if(Character.isDigit(input)==false)
           return false;

        return true;
    }

}
