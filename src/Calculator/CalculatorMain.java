package Calculator;

public class CalculatorMain {

    public static void main(String[] args) {
        CalculatorLayout layoutClass = new CalculatorLayout();
        CalculatorCalculations test = new CalculatorCalculations();
        CalculatorController controll = new CalculatorController();
        CalculatorOutput output = new CalculatorOutput();
        controll.main(null);



        // Layout
        layoutClass.main(null);



    }
}
