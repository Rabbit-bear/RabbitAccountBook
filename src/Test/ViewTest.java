package Test;

import DAO.Importer;
import Entity.UserAccount;
import Service.Impl.LoginServiceImpl;
import Service.LoginService;
import View.Login.LoginController;
import View.Login.LoginFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class ViewTest extends Application {
    Importer importer = new Importer();
    UserAccount userAccount = importer.start();
    LoginService loginService = new LoginServiceImpl(userAccount);
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        LoginFrame frame = new LoginFrame(loginService);
//        try {
//            frame.start(new Stage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //((Stage)FXMLLoader.load(getClass().getResource("src/View/Login/Login.fxml"))).show();
        LoginController loginController = new LoginController();

    }
}
