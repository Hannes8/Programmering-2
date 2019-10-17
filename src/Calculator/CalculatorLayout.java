package Calculator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;

import java.awt.*;
import javafx.scene.control.Button;

import java.awt.Label;
import java.time.Clock;
import java.util.ArrayList;



public class CalculatorLayout extends Application {
    BorderPane calculatorLayout = new BorderPane();



    ArrayList<Button> numPad = new ArrayList<Button>();
    public static void main(String[] args) {
        launch(args);

    }


        @Override
        public void start (Stage primaryStage){
            buttonCreator();

            calculatorLayout.setPrefWidth(1000);
            calculatorLayout.setPrefHeight(800);

            textInput(null);

            calculatorLayout.setCenter(borderpaneCenter());

            Scene calculatorScene = new Scene(calculatorLayout);

            primaryStage.setTitle("Calculator");
            primaryStage.setScene(calculatorScene);
            primaryStage.show();

        }


    public void textInput(String numberInput) {
        String temp = numberInput;
        System.out.println(temp);
        HBox hbox = new HBox();
        TextField input = new TextField(temp);
        input.setStyle(("-fx-font: 50 arial;"));
        input.setPrefWidth(800.0);
        input.setPrefHeight(200.0);
        String hej = input.textProperty().get();
        System.out.println(hej);


        hbox.getChildren().addAll(input);

        calculatorLayout.setTop(hbox);


    }

    /**
     * Skapar numpaden
     * @return
     */
    public StackPane borderpaneCenter(){
        int row = 1;
        int columb= 1;
        StackPane center = new StackPane();
        GridPane buttons = new GridPane();
        buttons.setHgap(10);
        buttons.setVgap(10);
        for (int i = 0; i < numPad.size(); i++) {

            // var tredje iteration byter den rad o
            if (i % 5 ==0) {
                row++;
                columb = 1;
            }


            buttons.add(numPad.get(i),columb,row);
            columb ++;
        }

        center.getChildren().add(buttons);

        return center;
    }

    public void buttonCreator() {
        CalculatorOutput outputClass = new CalculatorOutput();

        char[] numPadChar = {'7', '8', '9','x','t','4','5','6','÷','t','1','2','3','-','t','.','0','=','+','t','(',')','C','D','t'};
        int count = 0;

        for (char t : numPadChar){


            char temporaryChar = numPadChar[count];
            System.out.println(temporaryChar);
            String temporaryString = String.valueOf(temporaryChar);
            Button temp = new Button(temporaryString);
            temp.setStyle("-fx-font: 24 arial;");

            // call output med siffran

            // lägg till array med siffrorna 
            temp.setOnAction(event -> { outputClass.textfieldOutput(temporaryString);});
            temp.setPrefWidth(100);
            temp.setPrefHeight(100);
            numPad.add(temp);
            count++;
        }


    }
}