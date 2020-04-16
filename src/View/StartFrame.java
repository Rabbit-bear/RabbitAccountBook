package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.logging.Handler;

public class StartFrame extends Application {
    //Stage stage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("跳转");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new openStage().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Pane pane = new Pane();
        pane.getChildren().add(button);
        primaryStage.setScene(new Scene(pane,500,200));
        primaryStage.setTitle("第一个窗口");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
class openStage extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("第二个窗口");
        primaryStage.show();
    }
}
