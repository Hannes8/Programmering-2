package Calculator;

import java.util.ArrayList;


public class CalculatorCalculations {
   private CalculatorController controllerClass = new CalculatorController();
   private CalculatorSquareRoot squareRoot = new CalculatorSquareRoot();
   private String modifiedString;

    /**
     * Loopar igenom inputen från textfield och checkar varje tecken om det är ett nummer, om det inte är ett nummer så
     * @param textfieldValue
     * @return
     */
    public String result(String textfieldValue){

        if(textfieldValue.contains("(")||textfieldValue.contains(")")){
           // String resultFromParentheses = result();
        }

        // Gör om inputen så räknesätten är i rätt ordning
        termOrder(textfieldValue);

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

                // om det är ett heltal så blir result en int annars blir det en double
                if(resultAsDouble%1==0){
                    int resultAsInt = (int)resultAsDouble;
                    resultString = Integer.toString(resultAsInt);

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

    /**
     * Tar in inputen och lägger multiplication och divition längst fram i stringen för att få beräkningen i rätt ordning
     * @param textfieldInput
     * @return
     */
    public String termOrder(String textfieldInput){
        ArrayList <Integer> indexOfTermsBeingDeleted = new ArrayList<>();
        ArrayList <String> termsBeingMoved = new ArrayList<>();
        String temporary = "";
        boolean foundOperator = false;

        for (int i = 0; i < textfieldInput.length() ; i++) {
            if (textfieldInput.charAt(i)=='*' || textfieldInput.charAt(i)=='÷'){
                // if lenght == 0
                temporary = temporary + textfieldInput.charAt(i);
                indexOfTermsBeingDeleted.add(i);
                foundOperator = true;

            }
            // hittar termerna innan multiplication eller divition
            else {
                // om det är ett annat räknesätt
                if (!Character.isDigit(textfieldInput.charAt(i))){

                    if (foundOperator==true){
                        System.out.println(temporary+ " OperatorOrder");
                    // ändra textfieldinput, lägg temporary längst fram
                        termsBeingMoved.add(temporary);
                        temporary = "";
                    }
                    else {
                        temporary = "";
                        indexOfTermsBeingDeleted.add(i);
                    }
                }
                else {
                    temporary = temporary + textfieldInput.charAt(i);
                    indexOfTermsBeingDeleted.add(i);
                }

            }

        }
        String operatorsInCorrectOrder = stringConstruction(textfieldInput,termsBeingMoved,indexOfTermsBeingDeleted);
return null;
    }
    public String stringConstruction(String input,ArrayList <String> termsBeingMoved, ArrayList <Integer> indexOfTermsBeingDeleted){
        System.out.println(termsBeingMoved+ " being moved");
        System.out.println(indexOfTermsBeingDeleted + " being deleted");


        String termsInCorrectOrder = "";

        for (int i = 0; i < termsBeingMoved.size(); i++) {
            termsInCorrectOrder += termsBeingMoved.get(i);
        }

        for (int i = 0; i < input.length() ; i++) {
            if (!indexOfTermsBeingDeleted.contains(i)){
                termsInCorrectOrder += input.charAt(i);
            }
        }

        System.out.println(termsInCorrectOrder+ " - öööööööööööööööööööööööööööööööööö");
        return termsInCorrectOrder;

    }

}
