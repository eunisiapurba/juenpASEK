package com.example.minggu10;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import com.example.minggu10.RegistrasiMahasiswa;
import com.example.minggu10.SessionManager;
import java.io.IOException;
public class LoginController {
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "admin";
    @FXML
    private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML
    protected void onKeyPressEvent(KeyEvent event) throws IOException {
        if( event.getCode() == KeyCode.ENTER ) {
            btnLoginClick();
        }
    }
    @FXML
    protected void btnLoginClick() {
        Alert alert;
        if (txtUsername.getText().equals(CORRECT_USERNAME) &&
                txtPassword.getText().equals(CORRECT_PASSWORD)) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Information");
            alert.setContentText("Login success!!");
            SessionManager.getInstance().login();
            alert.showAndWait();
            RegistrasiMahasiswa.setRoot("mahasiswa-view", false);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);alert.setHeaderText("Error");
            alert.setContentText("Login failed!! Please check again.");
            alert.showAndWait();
            txtUsername.requestFocus();
        }
    }
}