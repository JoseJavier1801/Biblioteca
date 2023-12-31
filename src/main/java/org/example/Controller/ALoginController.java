package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import org.example.App;
import org.example.DAO.AdminDAO;
import org.example.DOMAIN.Admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Optional;

public class ALoginController {

    @FXML
    private TextField usertxt;

    @FXML
    private PasswordField psswdtxt;


    /**
     * Metodo btnLogin que obtiene los datos  de lusuario, si estos se encuentran en la base de datos permite el acceso al programa
     * @throws IOException
     */
    @FXML
    private void btnLogin() throws IOException {
        String username = usertxt.getText();
        String password = psswdtxt.getText();

        AdminDAO adminDAO = AdminDAO.getInstance();
        try {
            Admin a = adminDAO.findByName(username);
            if (a != null && a.getPassword().equals(org.example.UTILS.Encrypt.EncryptPassword(password))) {
                //  guardar los demas datos del administrador logueado para su futuro uso en otros metodos
                adminDAO.adminId = a.getId();
                adminDAO.adminDNI=a.getDNI();
                adminDAO.adminMail=a.getEmail();
                // Admin autenticado, ir a la pagina admin
                App.setRoot("admin");
            } else {
                // Usuario o contraseña incorrectos, mostrar alerta de error
                showError("Login ERROR");
            }
        } catch (SQLException e) {
            // Error al buscar en la base de datos, mostrar alerta de error
            showError("Admin doesn't exist on the database");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            showError("Wrong password");
            e.printStackTrace();
        }
    }

    /**
     * metodo btndelete que recoge el nombre del administrador a eliminar
     * @throws IOException
     */
    @FXML
    private void btnDelete() throws IOException{
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Delete Admin");
        dialog.setHeaderText("Enter the name of the admin you want to delete:");
        dialog.setContentText("Admin name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            String adminName = result.get();

            AdminDAO adminDAO = AdminDAO.getInstance();
            try {
                Admin a = adminDAO.findByName(adminName);
                if (a != null) {
                    adminDAO.delete(a);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Admin Deleted");
                    alert.setHeaderText(null);
                    alert.setContentText("Admin " + adminName + " has been deleted successfully!");
                    alert.showAndWait();
                } else {
                    showError("Admin " + adminName + " doesn't exist.");
                }
            } catch (SQLException e) {
                showError("Error occurred while deleting admin " + adminName + ".");
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo show Error encargador de los mensajes de error
     * @param mensaje
     */
    private void showError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Log-in Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void goBack() throws IOException {
        App.setRoot("home");
    }

}
