package Calculator;

import java.util.ArrayList;


public class CalculatorCalculations {
    CalculatorController controllerClass = new CalculatorController();
    CalculatorSquareRoot squareRoot = new CalculatorSquareRoot();
    String modifiedString;


    /**
     * Loopar igenom inputen från textfield och checkar varje tecken om det är ett nummer, om det inte är ett nummber så
     * @param textfieldValue
     * @return
     */
    public String result(String textfieldValue){

        String resultString = textfieldValue;
        ArrayList<Double> terms = termFinder(textfieldValue);
        // gör om inputen så att minus som tillhör termer inte visas
        textfieldValue = makeInputValid(textfieldValue,0);


        if (terms.size()==1)
        terms.add(0.0);

        for (int i = 0; i < textfieldValue.length() -1; i++) {
            System.out.println(terms);


          if(Character.isDigit(textfieldValue.charAt(i)) == false) {



              char operator = textfieldValue.charAt(i);


              if(operator=='√'){
                  double squareResult = squareRoot.calculate(0.0,terms.get(0));
                  System.out.println(terms.get(0)+" term 1");
                  terms.remove(0);
                  terms.add(0,squareResult);
                  System.out.println(squareResult+" SquareRootCheck");
              }
                else {


                  double result = controllerClass.operatorController(operator, terms.get(0), terms.get(1));


                  // Anropar räknesätts klassen med de första termerna och sedan tar bort de från arrayen och lägger in resultatet istället

                  terms.remove(1);
                  terms.remove(0);
                  terms.add(0, result);

              }
              System.out.println(terms);

                double resultAsDouble = terms.get(0);

                // om det är ett heltal utan decimaler så blir result en int annars blir det en double
                if(resultAsDouble%1==0){
                    int test = (int)resultAsDouble;
                    resultString = Integer.toString(test);

                }else {
                    resultString = Double.toString(resultAsDouble);
                }


              System.out.println(resultString+" ResultOutput");

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
       String termAsString ="";
        ArrayList <Double> doubleArray = new ArrayList<>();
        String newInput = input;
        String temporary="";

        for (int i = 0; i < input.length(); i++) {
            // om inputen är en siffra eller minustecken då termen är tom
            if(Character.isDigit(input.charAt(i))==true || termAsString.length()==0 && input.charAt(i)=='-'|| input.charAt(i)=='.'){

                termAsString = termAsString + input.charAt(i);

                if(input.charAt(i)=='-' || input.charAt(i)=='.') {
                    StringBuilder builder = new StringBuilder(newInput);
                    builder.deleteCharAt(i);
                    newInput = builder.toString();
                    System.out.println(newInput + " modified");
                }


            }
            else{

                if(termAsString.length()==0){

                }
                    else{


                    System.out.println(termAsString);
                    doubleArray.add(Double.parseDouble(termAsString));

                    termAsString = "";
                }


            }


        }
        makeInputValid(newInput,1);

        System.out.println(doubleArray);

        return doubleArray;
    }
    public String makeInputValid(String input,int identifier){
        if (identifier==1){
            modifiedString = input;
        }
        return modifiedString;
    }
    public ArrayList<Double> termOrder(ArrayList<Double> terms,String textfieldInput){


return null;
    }

}
