package Calculator;

import java.util.ArrayList;


public class CalculatorCalculations {
    CalculatorController controllerClass = new CalculatorController();



    /**
     * Loopar igenom inputen från textfield och checkar varje tecken om det är ett nummer, om det inte är ett nummber så
     * @param textfieldValue
     * @return
     */
    public String result(String textfieldValue){
        String resultString = "";
        ArrayList<Double> terms = termFinder(textfieldValue);
        for (int i = 0; i < textfieldValue.length() -1; i++) {
          if(checkIfNumber(textfieldValue.charAt(i)) == false) {
              char operator = textfieldValue.charAt(i);

              // operator, first number, second number


              System.out.println(operator);
              System.out.println("not a number");
              double result = controllerClass.operatorController(operator, terms.get(0),terms.get(1));
              terms.remove(0);
              terms.remove(1);
              terms.add(0,result);
              
              System.out.println(terms);

              int test = (int)result;
              resultString = Integer.toString(test);


            }


        }
        return resultString;
      //  return textfieldValue;



    }

    /**
     * En motod som tar in en string och hittar termer av siffror samt alla tecken som inte är siffror
     * @param input
     * @return
     */
    public ArrayList<Double> termFinder(String input){
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

        System.out.println(doubleArray);


        return doubleArray;
    }

    public Boolean checkIfNumber(char input){
       if(Character.isDigit(input)==false)
           return false;

        return true;
    }

}

// dela up termerna och kör dem separat
