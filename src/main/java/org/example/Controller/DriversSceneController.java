package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;

import java.io.IOException;

public class DriversSceneController {

   @FXML
   public Button insertdriver;
   @FXML
   public Button modifydriver;
   @FXML
   public Button deletedriver;
   @FXML
   public TextField searchbar;
   @FXML
   public Button goback;


   @FXML
   public void btn_insert_driver() throws IOException {
      App.setRoot("insertDrivers");
   }
   @FXML
   public void btn_modify_driver(){

   }
   @FXML
   public void btn_delete_driver(){

   }
   @FXML
   public void search(){

   }

   @FXML
   public void exit() throws IOException {
      App.setRoot("home");
   }



}
