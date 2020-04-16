package View.Login;

import Service.LoginService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;


public class LoginController {
    LoginService loginService;
    Stage stage1;
    public void init(LoginService loginService,Stage stage1) {
        this.loginService = loginService;
        this.stage1 = stage1;
    }
    @FXML
    Stage stage;
    @FXML
    public Button LoginButton;
    @FXML
    private Button SignUpButton;
    @FXML
    TextField usernameField;
    @FXML
    TextField passwordField;
    @FXML
    public void Login(ActionEvent event){

        if(loginService==null){
            System.out.println("服务程序缺失");
            return;
        }
        boolean isLogin = false;
        isLogin = loginService.Login(usernameField.getText(),passwordField.getText());
        if(isLogin){//登录成功
            System.out.println("登录成功");
            stage = null;
            stage.close();
            //转入新窗格


        }else {//登录失败
            System.out.println("登录失败");

        }

    }
}
