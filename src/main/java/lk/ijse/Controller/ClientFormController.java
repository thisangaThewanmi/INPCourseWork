package lk.ijse.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientFormController extends Thread {
    public Label txtUsername;

    public VBox vbox_mesages;
    public TextField txtmsg;
    public ScrollPane scrollPanel;

    Socket socket;
    BufferedReader reader;
    PrintWriter writer;




    public void initialize() {
        txtUsername.setText(LoginFormController.username);
        try {
            socket = new Socket("localhost", 6000);
            System.out.println("Socket is connected with server!");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    


    public void btnSendOnAction(ActionEvent actionEvent) {
    }
}
