package com.connected.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import com.connected.main.AccountWindow;
import com.connected.main.ChatWindow;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable {
    private ChatWindow chatWindow;
    private AccountWindow accountWindow;
    @FXML
    private TextField nickField;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private PasswordField passwordField;
    public void displayChatWindow(MouseEvent mouseEvent)throws Exception {
        if(!nickField.getText().equals("")&&!passwordField.getText().equals("")) {
               // database
            chatWindow.displayChatWindow();
            Stage stage = (Stage) loginPane.getScene().getWindow();
            stage.close();
            chatWindow.connect(nickField.getText());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chatWindow=new ChatWindow();
        accountWindow=new AccountWindow();
    }

    public void displayAccountWindow(MouseEvent mouseEvent)throws Exception{
        accountWindow.displayAccountWindow();
    }
}
