package lk.ijse.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.Server;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginFormController extends Application {
    public JFXTextField txtUsername;
    static String username;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/veiw/LoginPage.fxml"))));
        stage.show();

        new Thread(()->{
           Server server = new Server();
            try {
                server.Server();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }



    public static void main(String[] args) {
        launch(args);
    }



    public void AddUserTotheChat(javafx.event.ActionEvent actionEvent) throws IOException {
        username = txtUsername.getText();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/veiw/client.fxml"))));
        stage.setTitle(txtUsername.getText() + "'s Chat");
        stage.show();
        txtUsername.clear();
    }
}
