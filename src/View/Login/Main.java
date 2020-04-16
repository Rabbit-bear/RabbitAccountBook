package View.Login;

import DAO.Importer;
import Entity.UserAccount;
import Service.Impl.LoginServiceImpl;
import Service.LoginService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.net.StandardSocketOptions;
import java.net.URL;

public class Main extends Application {
    Importer importer = new Importer();
    UserAccount userAccount = importer.start();
    LoginService loginService = new LoginServiceImpl(userAccount);
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage stage = null;
        URL location = getClass().getResource("Login.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        stage = loader.load();
        LoginController loginController = loader.getController();
        loginController.init(loginService,stage);
        stage.show();
        stage.setOnCloseRequest((event -> {
            System.out.println("关闭了");
        }));


    }

}
