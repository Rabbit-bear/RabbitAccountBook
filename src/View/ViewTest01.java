package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewTest01 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent =  FXMLLoader.load(getClass().getResource("Fxml/SignUpView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();

    }
}
