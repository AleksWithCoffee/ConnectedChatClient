package com.connected.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.*;
import java.net.Socket;


public class ChatWindowController {
    @FXML
    private TextField typingField;
    @FXML
    private ImageView sendImage;
    @FXML
    private  VBox bubbleArea;

    private Socket socket;
    private PrintWriter printWriter;
    private String nick;

    public VBox getBubbleArea() {
        return bubbleArea;
    }

    public void send(MouseEvent mouseEvent) throws FileNotFoundException {
        if (!typingField.getText().equals("")) {
            String request = typingField.getText();
            printWriter.println(nick + "#&#" + request);
            printWriter.flush();
            if (request.equals("q")) {

                printWriter.close();
                System.exit(0);
            }
            TextField text = new TextField(nick + ": " + request);
            bubbleArea.getStylesheets().add("Style.css");
            text.getStyleClass().add("chat-bubble");
            Circle img = new Circle(28, 28, 15);

            FileInputStream inputstream = new FileInputStream("C:\\Users\\Aleks\\IdeaProjects\\ConnectedClient\\src\\com\\connected\\controllers\\Smile-icon.png");
            Image image = new Image(inputstream);
            img.setFill(new ImagePattern(image));
            HBox hBox = new HBox();
            hBox.setPrefWidth(130);
            hBox.getChildren().addAll(img, text);
            bubbleArea.getChildren().add(hBox);
            bubbleArea.setPadding(new Insets(10, 10, 10, 10));

        }
    }

    public void setSocket(Socket socket, String nick) {
        this.nick = nick;
        this.socket = socket;
        try {
            this.printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
