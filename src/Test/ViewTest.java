package Test;

import DAO.Importer;
import Entity.UserAccount;
import Service.Impl.LoginServiceImpl;
import Service.LoginService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;

public class ViewTest extends Application {
    Importer importer = new Importer();
    UserAccount userAccount = importer.start();
    LoginService loginService = new LoginServiceImpl(userAccount);

    public ViewTest() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL location = Thread.currentThread().getContextClassLoader().getResource("src/View/saveView.fxml");//getClass().getResource("Main.fxml");
        Parent parent = FXMLLoader.load(location);
//        LoginFrame frame = new LoginFrame(loginService);
//        try {
//            frame.start(new Stage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //((Stage)FXMLLoader.load(getClass().getResource("src/View/Login/Login.fxml"))).show();
       // LoginController loginController = new LoginController();

    }
}
