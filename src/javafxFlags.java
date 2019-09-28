import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

public class javafxFlags extends Application {
    Stage mainStage;
    Scene swedishFlag, czechFlag, thailandFlag, jamaicaFlag, greeceFlag;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        mainStage.setTitle("Flags");

        // Maximerar fönstret
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        // Sweden
        BorderPane sweden = new BorderPane();
        sweden.setCenter(swedishFlag());
        sweden.setTop(standardHBox());

        swedishFlag = new Scene(sweden);

        // Thailand
        BorderPane thailand = new BorderPane();
        thailand.setCenter(thaillandFlag());
        thailand.setTop(standardHBox());
        thailandFlag = new Scene(thailand);


        // Czech Republic
        BorderPane czech = new BorderPane();
        czech.setTop(standardHBox());
        czech.setCenter(czechFlag());
        czechFlag = new Scene(czech);


        // Greece
        BorderPane greece = new BorderPane();
        greece.setTop(standardHBox());
        greece.setCenter(greeceFlag());
        greeceFlag = new Scene(greece);

        // jamaica
        BorderPane jamaica = new BorderPane();
        jamaica.setTop(standardHBox());
        jamaica.setCenter(jamaicaFlag());
        jamaicaFlag = new Scene(jamaica);

        primaryStage.setScene(swedishFlag);

        primaryStage.show();
    }

    /**
     * @return
     */

    public HBox standardHBox() {

        HBox hbox = new HBox();

        hbox.setPadding(new Insets(15, 12, 15, 12));

        // ger knapparna en margin på 100
        hbox.setSpacing(100);

        // centrerar knapparna
        hbox.setAlignment(Pos.CENTER);

        hbox.setStyle("-fx-background-color: #336699;");

        Button swedenButton = buttonCreator("Sweden");
        swedenButton.setOnAction(event -> mainStage.setScene(swedishFlag));

        Button thailandButton = buttonCreator("Thailand");
        thailandButton.setOnAction(event -> mainStage.setScene(thailandFlag));

        Button finlandButton = buttonCreator("Czech Republic");
        finlandButton.setOnAction(event -> mainStage.setScene(czechFlag));

        Button jamaicaButton = buttonCreator("Jamaica");
        jamaicaButton.setOnAction(event -> mainStage.setScene(jamaicaFlag));

        Button greeceButton = buttonCreator("Greece");
        greeceButton.setOnAction(event -> mainStage.setScene(greeceFlag));

        hbox.getChildren().addAll(swedenButton, thailandButton, finlandButton, jamaicaButton, greeceButton);

        return hbox;

    }

    /**
     * tar in namnet på knappen samt vilken scene som den ska byta till
     *
     * @param buttonName
     * @return
     */
    public Button buttonCreator(String buttonName) {

        Button buttonTemp = new Button(buttonName);

        return buttonTemp;

    }

    public StackPane swedishFlag() {
        StackPane swedenFlag = new StackPane();
        swedenFlag.setStyle("-fx-background-color: #34495E  ;");
        Group sweden = new Group();
        swedenFlag.getChildren().add(sweden);

        Rectangle flag = new Rectangle(1000, 600);

        flag.setFill(Color.BLUE);

        Rectangle flagSecondaryColor = new Rectangle(300, 0, 100, 600);

        flagSecondaryColor.setFill(Color.YELLOW);

        Rectangle flagSecondaryColor2 = new Rectangle(0, 250, 1000, 100);

        flagSecondaryColor2.setFill(Color.YELLOW);

        sweden.getChildren().addAll(flag, flagSecondaryColor, flagSecondaryColor2);
        return swedenFlag;
    }

    public StackPane thaillandFlag() {
        StackPane thaiFlag = new StackPane();
        thaiFlag.setStyle("-fx-background-color: #34495E  ;");
        Group thai = new Group();
        thaiFlag.getChildren().add(thai);

        Rectangle red = new Rectangle(1000, 600);
        red.setFill(Color.RED);

        Rectangle white = new Rectangle(0, 100, 1000, 100);
        white.setFill(Color.WHITE);
        Rectangle white2 = new Rectangle(0, 400, 1000, 100);
        white2.setFill(Color.WHITE);

        Rectangle blue = new Rectangle(0, 200, 1000, 200);
        blue.setFill(Color.BLUE);

        thai.getChildren().addAll(red, white, white2, blue);

        return thaiFlag;

    }

    public StackPane czechFlag() {
        StackPane czechFlag = new StackPane();
        czechFlag.setStyle("-fx-background-color: #34495E  ;");
        Group czech = new Group();
        czechFlag.getChildren().addAll(czech);

        Rectangle red = new Rectangle(1000, 600);
        red.setFill(Color.RED);


        Polygon blueTriangle = new Polygon();
        blueTriangle.getPoints().addAll(0.0, 0.0, 500.0, 300.0, 0.0, 600.0);
        blueTriangle.setFill(Color.BLUE);

        Polygon whiteColor = new Polygon();
        whiteColor.getPoints().addAll(0.0, 0.0, 500.0, 300.0, 1000.0, 300.0, 1000.0, 0.0);
        whiteColor.setFill(Color.WHITE);

        czech.getChildren().addAll(red, blueTriangle, whiteColor);

        return czechFlag;

    }

    public StackPane greeceFlag() {
        StackPane greeceFlag = new StackPane();
        greeceFlag.setStyle("-fx-background-color: #34495E  ;");
        Group greece = new Group();
        greeceFlag.getChildren().add(greece);

        Rectangle blue = new Rectangle(1000, 600);
        blue.setFill(Color.BLUE);

        Rectangle white = new Rectangle(400, 600 / 9, 600, 600 / 9);
        white.setFill(Color.WHITE);

        Rectangle white2 = new Rectangle(400, 600 / 9 * 3, 600, 600 / 9);
        white2.setFill(Color.WHITE);

        Rectangle white3 = new Rectangle(0, 600 / 9 * 5, 1000, 600 / 9);
        white3.setFill(Color.WHITE);

        Rectangle white4 = new Rectangle(0, 600 / 9 * 7, 1000, 600 / 9);
        white4.setFill(Color.WHITE);

        Rectangle whiteCross = new Rectangle(0, 600 / 9 * 2, 400, 600 / 9);
        whiteCross.setFill(Color.WHITE);

        Rectangle whiteCross2 = new Rectangle(166, 0, 600 / 9, 600 / 9 * 5);
        whiteCross2.setFill(Color.WHITE);

        greece.getChildren().addAll(blue, white, white2, white3, white4, whiteCross, whiteCross2);

        return greeceFlag;

    }

    public StackPane jamaicaFlag() {

        StackPane jamaicaFlag = new StackPane();
        jamaicaFlag.setStyle("-fx-background-color: #34495E  ;");
        Group china = new Group();
        jamaicaFlag.getChildren().add(china);

        Rectangle yellow = new Rectangle(1000, 600);
        yellow.setFill(Color.YELLOW);

        Polygon greenTriangle = new Polygon();
        greenTriangle.getPoints().addAll(50.0, 0.0, 500.0, 275.0, 950.0, 0.0);
        greenTriangle.setFill(Color.GREEN);

        Polygon greenTriangle2 = new Polygon();
        greenTriangle2.getPoints().addAll(50.0, 600.0, 500.0, 325.0, 950.0, 600.0);
        greenTriangle2.setFill(Color.GREEN);

        Polygon blackTriangle = new Polygon();
        blackTriangle.getPoints().addAll(0.0, 25.0, 450.0, 300.0, 0.0, 575.0);
        blackTriangle.setFill(Color.BLACK);

        Polygon blackTriangle2 = new Polygon();
        blackTriangle2.getPoints().addAll(1000.0, 25.0, 550.0, 300.0, 1000.0, 575.0);
        blackTriangle2.setFill(Color.BLACK);

        china.getChildren().addAll(yellow, greenTriangle, greenTriangle2, blackTriangle, blackTriangle2);

        return jamaicaFlag;

    }


}