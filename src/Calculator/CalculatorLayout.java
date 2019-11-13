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
import java.util.Arrays;

import java.awt.*;
import javafx.scene.control.Button;

import java.awt.Label;
import java.time.Clock;
import java.util.ArrayList;



public class CalculatorLayout extends Application {

    BorderPane calculatorLayout = new BorderPane();

    HBox hbox = new HBox();

    ArrayList<Button> numPad = new ArrayList<Button>();


    public static void main(String[] args) {
        launch(args);

    }


        @Override
        public void start (Stage primaryStage){

            CalculatorOutput outputClass = new CalculatorOutput();

            buttonCreator();

            calculatorLayout.setPrefWidth(600);
            calculatorLayout.setPrefHeight(800);


            // Ger hboxen sitt textfield från CalculatorOutput klassen


            calculatorLayout.setTop(hbox);
            // gör första inputen till textfielden som C så att den är tom
            hbox.getChildren().setAll(outputClass.textfieldOutput("C"));
            calculatorLayout.setCenter(borderpaneCenter());

            Scene calculatorScene = new Scene(calculatorLayout);

            primaryStage.setTitle("Calculator");
            primaryStage.setScene(calculatorScene);
            primaryStage.show();

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

            // var femte iteration byter den rad och nollställer columben till sin orginalplats
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

    /**
     * Skapar knappar och tilldelar teckan somt vilken metod som ska anropas när knappen klickas
     */
    public void buttonCreator() {
        CalculatorOutput outputClass = new CalculatorOutput();


        char[] numPadChar = {'7', '8', '9','*','⌫','4','5','6','÷','%','1','2','3','-','√','.','0','=','+','π','(',')','C','D','t'};
        int count = 0;

        for (char t : numPadChar){


            char temporaryChar = numPadChar[count];
            System.out.println(temporaryChar);
            String temporaryString = String.valueOf(temporaryChar);
            Button temp = new Button(temporaryString);
            temp.setStyle("-fx-font: 24 arial;");

            // Vid ett knapptryck så anropas texfieldOutput metoden för att avgöra vad som ska visas i hboxen
            temp.setOnAction(event -> { hbox.getChildren().setAll(outputClass.textfieldOutput(temporaryString)); });
            temp.setPrefWidth(100);
            temp.setPrefHeight(100);
            numPad.add(temp);
            count++;
        }


    }
}