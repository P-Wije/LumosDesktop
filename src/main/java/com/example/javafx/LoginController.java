package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button LoginBtn;
    @FXML
    private Button CancelBtn;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField UsernameTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private Button RegisterBtn;
    @FXML
    private Button LoginBtnAdmin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/logo-black.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }

    public void LoginAdminBtnOnAction(ActionEvent event){
        if (!UsernameTextField.getText().isBlank() && !PasswordTextField.getText().isBlank()) {
            validateAdminLogin();
        } else {
            errorMessageLabel.setText("Please enter username and password");
        }
    }

    public void LoginBtnOnAction(ActionEvent event) {
        if (!UsernameTextField.getText().isBlank() && !PasswordTextField.getText().isBlank()) {
            validateLogin();
        } else {
            errorMessageLabel.setText("Please enter username and password");
        }
    }
    public void CancelBtnOnAction(ActionEvent event) {
        Stage stage = (Stage) CancelBtn.getScene().getWindow();
        stage.close();
    }
    public void RegisterBtnOnAction(ActionEvent event) {
        try {
            createAccountForm();
            Stage stage = (Stage) LoginBtn.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + UsernameTextField.getText() + "' AND password = '" + PasswordTextField.getText() + "'";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    //errorMessageLabel.setText("Login Successful");
                    loginUserDashboard();
                    Stage stage = (Stage) LoginBtn.getScene().getWindow();
                    stage.close();
                } else {
                    errorMessageLabel.setText("Invalid Login. Please try again");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void validateAdminLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyAdminLogin = "SELECT count(1) FROM admin_account WHERE username = '" + UsernameTextField.getText() + "' AND password = '" + PasswordTextField.getText() + "'";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyAdminLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    //errorMessageLabel.setText("Login Successful");
                    loginDashboard();
                    Stage stage = (Stage) LoginBtn.getScene().getWindow();
                    stage.close();
                } else {
                    errorMessageLabel.setText("Invalid Login. Please try again");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void loginDashboard(){
        try {
            FXMLLoader fxmlRegister = new FXMLLoader(LibraryApplication.class.getResource("SidebarNav.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(fxmlRegister.load(), 780, 510));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void loginUserDashboard(){
        try {
            FXMLLoader fxmlRegister = new FXMLLoader(LibraryApplication.class.getResource("UserDashboardNav.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(fxmlRegister.load(), 780, 510));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccountForm(){
        try {
            FXMLLoader fxmlRegister = new FXMLLoader(LibraryApplication.class.getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(fxmlRegister.load(), 520, 530));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}