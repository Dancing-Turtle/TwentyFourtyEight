import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MainFrame extends Application{
    int width = 800, height = (width * 3 /4) + 25;
    Border blackBorder = new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    Insets pxPad5 = new Insets(5, 5, 5, 5);
    Insets pxPad1 = new Insets(1, 1, 1, 1);

    private Scene scene;

    //Dummy Tiles
    List<Rectangle> rectangles = new ArrayList<>();
    HBox[] sideBar = {addScores(false), addScores(true)};

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primarystage){
        width -= 20;
        // GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(pxPad5);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setBackground(bgMaker(Color.GRAY));

        // VBox Menu
        VBox menuBar = new VBox(5);
        menuBar.setPadding(pxPad1);
        menuBar.setBorder(blackBorder);
        menuBar.setBackground(bgMaker(Color.DARKGRAY));
        menuBar.getChildren().addAll(sideBar);

        //VBox Button
        Button newGame = new Button("New Game");
        newGame.setTranslateY(190);
        newGame.setMinSize(150, 50);
        menuBar.getChildren().add(newGame);
        gridPane.add(menuBar, 4, 0, 1, 2);

        //Credits
        Text authors = new Text("Faith L Neely\nSean W Fuchel\nDavid M Workley\nAlexander J Martin\nMatthew J Robbins\nRachel A Burnsworth\nTimothy J Hammond");
        authors.setStyle("-fx-text-alignment: right");
        authors.setTranslateX(45);
        authors.setTranslateY(15);
        gridPane.add(authors, 4, 3, 1, 1);

        // Scene
        scene = new Scene(gridPane, width, height);

        //Add Code Under Here
        for (int y = 0; y < 4; y++){
            for (int x = 0; x < 4; x++){
                gridPane.add(new Rectangle(150, 150, Color.RED), y, x);

            }
        }
        //
        primarystage.setScene(scene);
        primarystage.setTitle("2048 Game");
        primarystage.show();
    }

    HBox addScores(boolean isTop){
        TextField scoreField;
        HBox innerContainer = new HBox();
        innerContainer.setAlignment(Pos.CENTER);
        if(isTop){
            scoreField = new TextField("Top Score: 0");
        } else {
            scoreField = new TextField("Score: 0");
        }
        scoreField.setFocusTraversable(false);
        scoreField.setEditable(false);
        innerContainer.getChildren().add(scoreField);

        return innerContainer;
    }

    void updateScore(boolean isTop, int score){
        if(isTop){
            ((TextField)sideBar[1].getChildren().get(0)).setText("Top Score: " + score);
        } else {
            ((TextField)sideBar[0].getChildren().get(0)).setText("Score: " + score);
        }


    }

    Background bgMaker(Color paint){
        return new Background(new BackgroundFill(paint, CornerRadii.EMPTY, Insets.EMPTY));
    }

    void updateTile(int index, int value){
        //Placeholder
    }


}
