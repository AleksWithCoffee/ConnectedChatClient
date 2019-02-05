package com.connected.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountWindow {
    public void displayAccountWindow()throws Exception{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/connected/fxml/AccountWindow.fxml"));
            Parent root=loader.load();
            Stage stage =new Stage();
            stage.setScene(new Scene(root, 600,400));
            stage.show();
    }
}
