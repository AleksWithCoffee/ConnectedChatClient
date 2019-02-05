package com.connected.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;


public class ChatWindow {
    private Socket socket;
    public void displayChatWindow() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/connected/fxml/ChatWindow.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root, 750, 500));
        stage.show();
    }

    public Socket getSocket() {
        return socket;  //socket do chat controllera
    }

    public void connect(String nick) throws IOException {

        final int PORT = 9999;
        final String HOST = "localhost";
        socket = new Socket(HOST, PORT);
        ChatWindowThread chatWindowThread = new ChatWindowThread(socket);
        chatWindowThread.start();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.println(nick);
        printWriter.flush();

    }
}
