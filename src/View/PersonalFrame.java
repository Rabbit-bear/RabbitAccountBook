package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonalFrame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //定义控件
        Pane pane = new Pane();
        HBox hBox = new HBox();
        Scene scene = new Scene(pane,550,500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("兔子爱记账");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
