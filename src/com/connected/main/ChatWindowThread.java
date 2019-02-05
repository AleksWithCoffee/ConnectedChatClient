package com.connected.main;

import com.connected.controllers.ChatWindowController;
import javafx.scene.layout.VBox;

import java.net.Socket;
import java.util.Scanner;

public class ChatWindowThread extends Thread{
    private Socket socket;
    private ChatWindowController chatWindowController;
    public ChatWindowThread(Socket socket, ChatWindowController chatWindowController) {
        this.socket = socket;
        this.chatWindowController=chatWindowController;
    }

    @Override
    public void run() {
        Scanner scanner = null;
       VBox bubbleArea= chatWindowController.getBubbleArea();
        try {
            scanner = new Scanner(socket.getInputStream());

            while (true) {
                if (scanner != null) {
                    if (scanner.hasNextLine()) {

                        String message;
                        {
                            try {
                                message = scanner.nextLine();
                                System.out.println(message);// ta message musi sie przedostac do chat controllera
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }
}
