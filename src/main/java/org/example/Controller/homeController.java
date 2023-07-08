package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.App;

import java.io.IOException;

public class homeController {

    public Button btndrivers;
    public Button btntracks;
    public Button btnseason;
    public Button btnteams;

    @FXML
    public void mng_drivers() throws IOException {
        App.setRoot("driversscene");
    }
    @FXML
    public void mng_teams(){

    }
    @FXML
    public void mng_season(){

    }
    @FXML
    public void mng_tracks(){

    }

}
