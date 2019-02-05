module ConnectedClient {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    exports com.connected.main;
    opens com.connected.main;
    exports com.connected.controllers;
    opens com.connected.controllers;


}