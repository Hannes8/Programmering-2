package Calculator;

import java.util.ArrayList;


public class CalculatorCalculations {
    private CalculatorController controllerClass = new CalculatorController();
    private String modifiedString;

    public String result(String textfieldValue) {

        if (textfieldValue.contains("√")) {
            textfieldValue = squareRoot(textfieldValue);
        }

        ArrayList<Double> terms = termFinder(textfieldValue);

        textfieldValue = termOrder(terms, textfieldValue);

        return calculating(textfieldValue);
    }

    public String calculating(String textfieldValue) {
        String resultString = textfieldValue;

        ArrayList<Double> terms = termFinder(textfieldValue);

        // gör om inputen så att minus som tillhör termer inte visas
        textfieldValue = makeInputValid(textfieldValue, 0);

        if (terms.size() == 1)
            terms.add(0.0);

        for (int i = 0; i < textfieldValue.length() - 1; i++) {
            if (Character.isDigit(textfieldValue.charAt(i)) == false && textfieldValue.charAt(i) != '.') {

                char operator = textfieldValue.charAt(i);

                double result = controllerClass.operatorController(operator, terms.get(0), terms.get(1));


                // lägger det aktuella resultatet på index 0 i arraylisten
                terms.remove(1);
                terms.remove(0);
                terms.add(0, result);


                double resultAsDouble = terms.get(0);

                // om det är ett heltal så blir result en int annars blir det en double
                if (resultAsDouble % 1 == 0) {
                    int resultAsInt = (int) resultAsDouble;
                    resultString = Integer.toString(resultAsInt);

                } else {
                    resultString = Double.toString(resultAsDouble);
                }

            }
        }
        return resultString;
    }

    /**
     * En motod som tar in en string och hittar termer av siffror samt alla tecken som inte är siffror
     *
     * @param input
     * @return
     */
    public ArrayList<Double> termFinder(String input) {
        String termAsString = "";
        ArrayList<Double> doubleArray = new ArrayList<>();
        String newInput = input;
        String temporary = "";

        for (int i = 0; i < input.length(); i++) {
            // om inputen är en siffra eller minustecken då termen är tom
            if (Character.isDigit(input.charAt(i)) == true || termAsString.length() == 0 && input.charAt(i) == '-' || input.charAt(i) == '.') {

                termAsString += input.charAt(i);

                if (input.charAt(i) == '-') {
                    StringBuilder builder = new StringBuilder(newInput);
                    builder.deleteCharAt(i);
                    newInput = builder.toString();
                }
            } else {
                if (termAsString.length() == 0) {

                } else {
                    doubleArray.add(Double.parseDouble(termAsString));
                    termAsString = "";
                }
            }
        }
        try {
            doubleArray.add(Double.parseDouble(termAsString));
        } catch (Exception e) {

        }
        makeInputValid(newInput, 1);
        return doubleArray;
    }

    public String makeInputValid(String input, int identifier) {
        if (identifier == 1) {
            modifiedString = input;
        }
        return modifiedString;
    }

    /**
     * Tar in input och lägger multiplication och divition längst fram
     * @param terms
     * @param input
     * @return
     */
    public String termOrder(ArrayList<Double> terms, String input) {
        String temporary = "";
        String operatorsString = "";
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.') {
                if (input.charAt(i) == '-' && temporary.length() == 0) {

                }
                else {
                    operatorsString += input.charAt(i);
                }

                temporary = "";
            } else {
                temporary += input.charAt(i);
            }

        }
        for (int i = 0; i < operatorsString.length(); i++) {
            count++;
            if (operatorsString.charAt(i) == '*' || operatorsString.charAt(i) == '÷') {
                StringBuilder moveOperator = new StringBuilder(operatorsString);
                moveOperator.deleteCharAt(i);
                char temp = operatorsString.charAt(i);
                operatorsString = moveOperator.toString();
                operatorsString = temp + operatorsString;

                double firstTerm = terms.get(i);
                double secondTerm = terms.get(i + 1);

                terms.remove(i);
                terms.remove(i);

                terms.add( firstTerm);
                terms.add( secondTerm);
            }

        }
        String test = "";
        for (int i = 0; i < terms.size() + operatorsString.length(); i++) {
            if (terms.size() - 1 >= i)
                test += Double.toString(terms.get(i));

            if (operatorsString.length() - 1 >= i)
                test += operatorsString.charAt(i);
        }

        return test;
    }

    /**
     * räknar ut roten ur separat
     * @param input
     * @return
     */
    public String squareRoot(String input) {
        ArrayList<Integer> indexList = new ArrayList<>();
        String temporary = "";
        String newInput = "";
        int squareRootIndex = 0;
        boolean foundSquareRoot = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '√') {
                indexList.add(i);
                foundSquareRoot = true;
                squareRootIndex = i;
            } else if (Character.isDigit(input.charAt(i)) == false) {
                if (foundSquareRoot == true) {
                    String result = Double.toString(controllerClass.operatorController('√', 0.0, Double.parseDouble(temporary)));
                    try {
                        if (input.charAt(squareRootIndex - 1) == '-') {
                            result = "-" + result;
                        } else {
                            result += "+";
                        }
                    } catch (Exception e) {

                    }

                    newInput += result;

                }
                foundSquareRoot = false;
                temporary = "";
            }
            if (Character.isDigit(input.charAt(i)) && foundSquareRoot == true) {
                temporary += input.charAt(i);
                indexList.add(i);
            }


        }
        if (foundSquareRoot == true) {
            String result = Double.toString(controllerClass.operatorController('√', 0.0, Double.parseDouble(temporary)));
            newInput += result;
            // ändrar tecknet framför roten ur
            try {
                if (input.charAt(squareRootIndex - 1) == '-') {
                    newInput = "-" + result + "+";
                } else {
                    if (!Character.isDigit(input.charAt(squareRootIndex - 1))) {
                        newInput = result + input.charAt(squareRootIndex - 1);
                        indexList.add(squareRootIndex - 1);
                    }
                    // om det är inte är något räknesätt innan roten ur så blir det gånger
                    else {
                        newInput = result + "*";
                    }

                }
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (indexList.contains(i)) {

            } else {
                newInput += input.charAt(i);
            }

        }

        return newInput;
    }

}
