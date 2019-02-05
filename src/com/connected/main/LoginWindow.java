package com.connected.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginWindow extends Application {
    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/connected/fxml/LoginWindow.fxml"));
        Parent root =loader.load();
        primaryStage.setTitle("Connected Society");
        primaryStage.setScene(new Scene(root, 510,300));
        primaryStage.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
