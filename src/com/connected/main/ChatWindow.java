package com.connected.main;


import com.connected.controllers.ChatWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;


public class ChatWindow {
    private Socket socket;
    private final String HOST;
    private final int PORT;
    public ChatWindow() {
         PORT = 9999;
         HOST = "localhost";
        try {
            socket = new Socket(HOST, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ChatWindowController displayChat(String nick) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/connected/fxml/ChatWindow.fxml"));
        Parent root = loader.load();
        ChatWindowController chatWindowController=loader.getController();
        chatWindowController.setSocket(socket,nick);
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 750, 500));
        stage.show();
        return chatWindowController;
    }


    public void connect(String nick,ChatWindowController chatWindowController) throws IOException {


        ChatWindowThread chatWindowThread = new ChatWindowThread(socket,chatWindowController);
        chatWindowThread.start();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.println(nick);
        printWriter.flush();

    }
}
