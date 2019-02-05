package com.connected.main;

import java.net.Socket;
import java.util.Scanner;

public class ChatWindowThread extends Thread{
    private Socket socket;

    public ChatWindowThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scanner = null;
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
