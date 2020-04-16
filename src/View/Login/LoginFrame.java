package View.Login;

import Service.LoginService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import sun.applet.Main;

import javax.swing.*;
import java.io.IOException;

public class LoginFrame extends Application {

//    public LoginFrame() {
//        this.setFontAndSoOn();
//        this.addElement();
//        this.addListener();
//        this.setFrameSelf();
//    }
        LoginService loginService;

    public LoginFrame() {
    }

    public LoginFrame(LoginService loginService){
        //super();
        this.loginService = loginService;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //控件定义
        VBox root = new VBox();
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane,300,150);
        TextField usernameField = new TextField();
        TextField passwordField = new TextField();
        Button login = new Button("登录");
        Button SignUp = new Button("注册");

        //添加控件
        pane.add(new Label("用户名"),0,0);
        pane.add(usernameField,1,0);
        pane.add(passwordField,1,1);
        pane.add(new Label("密码"),0,1);
        pane.add(login,0,2);
        pane.add(SignUp,1,2);

        //事件处理程序
        //登录事件
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                boolean isLogin = false;
                isLogin = loginService.Login(username,password);
                if(isLogin){//登录成功
                    System.out.println("登录成功");

                }else {//登录失败
                    System.out.println("登录失败");
                }
            }
        });
        //注册事件
        SignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = usernameField.getText();
                String password = passwordField.getText();

            }
        });

        //属性设置
        pane.setHalignment(login, HPos.CENTER);
        pane.setHalignment(SignUp, HPos.RIGHT);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(20);
        pane.setVgap(10);

        primaryStage.setScene(scene);
        primaryStage.setTitle("登录窗口");
        primaryStage.centerOnScreen();
        //primaryStage.show();
        new Stage().show();
    }

//    public void setFontAndSoOn(){
//
//    }
//    public void addElement(){
//
//    }
//    public void addListener(){
//
//    }
//    public void setFrameSelf(){
//        setLocation(400,200);
//        setSize(400,200);
//        setResizable(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }

    public static void main(String[] args) throws Exception {
        Application.launch();
    }
}
