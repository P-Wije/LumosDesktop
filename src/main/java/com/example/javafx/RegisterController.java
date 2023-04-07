package com.example.javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private ImageView registerLogoImageView;
    @FXML
    private Button closeRegisterButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField setUsernameTextField;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File registerLogoFile = new File("Images/logo-only-no-background.png");
        Image registerLogoImage = new Image(registerLogoFile.toURI().toString());
        registerLogoImageView.setImage(registerLogoImage);

    }

    public void registerButtonOnAction(ActionEvent event) {

        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            registerUser();
            confirmPasswordLabel.setText("");


        }else{
            confirmPasswordLabel.setText("Passwords Do Not Match!");
        }
    }
    public void closeRegisterButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeRegisterButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstName = firstnameTextField.getText();
        String lastName = lastnameTextField.getText();
        String username = setUsernameTextField.getText();
        String password = setPasswordField.getText();

        String insertFields = "INSERT INTO user_account (lname,fname,username,password) VALUES('";
        String insertValues = firstName +"','"+ lastName +"','" + username +"','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            registrationMessageLabel.setText("Registration Successful");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}

