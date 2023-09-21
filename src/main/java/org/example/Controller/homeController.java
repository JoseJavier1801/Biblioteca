package org.example.Controller;

import javafx.fxml.FXML;
import org.example.App;

import java.io.IOException;

public class homeController {

    @FXML
    private void AdminLogin() throws IOException {
        App.setRoot("adminLogin");
    }
    @FXML
    private void UserLogin() throws IOException {
        App.setRoot("UsersLogin");
    }

    @FXML
    private void reg() throws IOException {
        App.setRoot("Register");
    }
}
