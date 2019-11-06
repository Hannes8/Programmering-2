package Calculator;

import java.util.ArrayList;


public class CalculatorCalculations {
    CalculatorController controllerClass = new CalculatorController();
    CalculatorSquareRoot squareRoot = new CalculatorSquareRoot();



    /**
     * Loopar igenom inputen från textfield och checkar varje tecken om det är ett nummer, om det inte är ett nummber så
     * @param textfieldValue
     * @return
     */
    public String result(String textfieldValue){
        String resultString = textfieldValue;
        ArrayList<Double> terms = termFinder(textfieldValue);
        for (int i = 0; i < textfieldValue.length() -1; i++) {
            System.out.println(terms);

          if(checkIfNumber(textfieldValue.charAt(i)) == false) {


              char operator = textfieldValue.charAt(i);
              if(operator=='√'){
                  double squareResult = squareRoot.calculate(0.0,terms.get(1));
                  terms.remove(1);
                  terms.add(0,squareResult);
              }
                else {

                  double result = controllerClass.operatorController(operator, terms.get(0), terms.get(1));


                  // Anropar räknesätts klassen med de första termerna och sedan tar bort de från arrayen och lägger in resultatet istället

                  terms.remove(1);
                  terms.remove(0);
                  terms.add(0, result);

              }
              System.out.println(terms);

                double testt = terms.get(0);
              int test = (int)testt;
              resultString = Integer.toString(test);


            }


        }
        return resultString;
    }

    /**
     * En motod som tar in en string och hittar termer av siffror samt alla tecken som inte är siffror
     * @param input
     * @return
     */
    public ArrayList<Double> termFinder(String input){
        int count=0;
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
