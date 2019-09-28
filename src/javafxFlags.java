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
import java.awt.Polygon;

public class javafxFlags extends Application {
    Stage mainStage;
    Scene swedishFlag, czechFlag, thailandFlag, franceFlag,greeceFlag;
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
    czech.setBottom(standardHBox());
    czechFlag = new Scene(czech);





        primaryStage.setScene(swedishFlag);

        primaryStage.show();
    }

    /**
     *
     * @return
     */

    public HBox standardHBox(){

        HBox hbox = new HBox();

        hbox.setPadding(new Insets(15, 12, 15, 12));

        // ger knapparna en margin på 100
        hbox.setSpacing(100);

        // centrerar knapparna
        hbox.setAlignment(Pos.CENTER);

        hbox.setStyle("-fx-background-color: #336699;");

        Button swedenFlag = buttonCreator("Sweden");
        swedenFlag.setOnAction(event -> mainStage.setScene(swedishFlag));
        Button thailandFlag2 = buttonCreator("Thailand");
        thailandFlag2.setOnAction(event -> mainStage.setScene(thailandFlag));


        Button finlandFlag = buttonCreator("Finland");
        finlandFlag.setOnAction(event -> mainStage.setScene(czechFlag));



        Button sswedenFlag = buttonCreator("France");

        Button swesdenFlag = buttonCreator("Greece");

        hbox.getChildren().addAll(swedenFlag,thailandFlag2,finlandFlag,sswedenFlag,swesdenFlag);



        return hbox;


    }

    /**
     * tar in namnet på knappen samt vilken scene som den ska byta till
     * @param buttonName
     * @return
     */
    public Button buttonCreator(String buttonName){

        Button buttonTemp = new Button(buttonName);




        return buttonTemp;

    }

    public StackPane swedishFlag(){
        StackPane flagor = new StackPane();
        flagor.setStyle("-fx-background-color: #6699;");
        Group sweden = new Group();
        flagor.getChildren().add(sweden);

        Rectangle flag = new Rectangle(1000,600);

        flag.setFill(Color.BLUE);

        Rectangle flagSecondaryColor = new Rectangle(300, 0, 100,600);

        flagSecondaryColor.setFill(Color.YELLOW);

        Rectangle flagSecondaryColor2 = new Rectangle(0, 250, 1000,100);

        flagSecondaryColor2.setFill(Color.YELLOW);

        sweden.getChildren().addAll(flag,flagSecondaryColor,flagSecondaryColor2);
        return flagor;
    }

    public  StackPane thaillandFlag(){
        StackPane thaiFlag = new StackPane();
        Group thai = new Group();
        thaiFlag.getChildren().add(thai);

        Rectangle red = new Rectangle(1000,600);
        red.setFill(Color.RED);

        Rectangle white = new Rectangle(0,100,1000,100);
        white.setFill(Color.WHITE);
        Rectangle white2 = new Rectangle(0,400,1000,100);
        white2.setFill(Color.WHITE);

        Rectangle blue = new Rectangle(0,200,1000,200);
        blue.setFill(Color.BLUE);



        thai.getChildren().addAll(red,white,white2,blue);

        return thaiFlag;

    }
    public StackPane czechFlag(){
        StackPane czechFlag = new StackPane();
        Group czech = new Group();
        czechFlag.getChildren().addAll(czech);

        Polygon blueTriangle = new Polygon();

return czechFlag;


    }




}