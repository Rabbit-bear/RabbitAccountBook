package View;

import Service.Impl.SignUpServiceImpl;
import Service.SignUpService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpFrame extends Application {

    private boolean isSuccess = false;
    SignUpService signUpService = new SignUpServiceImpl();
    Parent parent = FXMLLoader.load(getClass().getResource("Fxml/SignUpView.fxml"));
    TextField username = (TextField)parent.lookup("#username");
    TextField target = (TextField)parent.lookup("#target");
    Text warning = (Text)parent.lookup("#warning");
    Button signUp = (Button)parent.lookup("#signUp");
    public SignUpFrame() throws IOException {

    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public void start(Stage stage) throws Exception {
        signUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(false){
                    //signUpService.SignUp(username.getText(), Double.parseDouble(target.getText()));
                    System.out.println("注册成功");
                    isSuccess = true;
                    stage.close();
                }
                else {
                    warning.setVisible(true);
                    target.clear();
                }
            }
        });
        stage.setScene(new Scene(parent));
        stage.setResizable(false);
        stage.setTitle("注册");
        stage.centerOnScreen();
        stage.setAlwaysOnTop(true);
        //stage.show();
    }
}
