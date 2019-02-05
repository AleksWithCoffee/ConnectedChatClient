package com.connected.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.Socket;

public class ChatWindowController {
    @FXML
    private TextField typingField;
    @FXML
    private ImageView sendImage;
    private Socket socket;

    public void send(MouseEvent mouseEvent) {
       if(!typingField.getText().equals("")) {
           String request = typingField.getText();
           printWriter.println(nick + "#&#" + request);
           printWriter.flush();
           if (request.equals("q")) {

               printWriter.close();
               System.exit(0);
           }
       }

    }
}
