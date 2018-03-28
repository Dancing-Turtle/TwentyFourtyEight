import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainFrame extends Application{
    int width = 800, height = width * 3 /4;
    private Scene scene;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primarystage){
        FlowPane flowPane = new FlowPane();
        flowPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        scene = new Scene(flowPane, width, height);

        //Add Code Under Here
        
        //
        primarystage.setScene(scene);
        primarystage.setTitle("2048 Game");
        primarystage.show();
    }
}
