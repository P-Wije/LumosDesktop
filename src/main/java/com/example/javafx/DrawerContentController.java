package com.example.javafx;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawerContentController implements Initializable {
    @FXML
    private JFXButton myBooksNavButton;
    @FXML
    private JFXButton borrowAndReturnNav;
    @FXML
    private JFXButton allBooksNavButton;
    @FXML
    private Button exitFromUserDashboardButton;
    @FXML
    private JFXButton logoutFromAdminBtn;
    @FXML
    private JFXButton logoutFromUserBtn;
    @FXML
    private void loadAllBooks(ActionEvent event) throws IOException{
        FXMLLoader fxmlRegister = new FXMLLoader(LibraryApplication.class.getResource("AllBooksNav.fxml"));
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(fxmlRegister.load(), 762, 510));
        registerStage.show();

        Stage stage = (Stage) allBooksNavButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private JFXButton exitFromDashboardButton;
    @FXML
    private JFXButton allMembersNavButton;
    @FXML
    private JFXButton lateFeesNavButton;
    @FXML
    private JFXButton myAccountInfoButton;
    @FXML
    private JFXButton userDashboardButton;
    @FXML
    private JFXButton allWithdrawalsButton;
    @FXML
    private JFXButton adminDashButton;

    @FXML
    private void loadMyBooks(ActionEvent event) throws IOException{
        FXMLLoader fxmlBooks = new FXMLLoader(LibraryApplication.class.getResource("MyBooksNav.fxml"));
        Stage bookStage = new Stage();
        bookStage.initStyle(StageStyle.UNDECORATED);
        bookStage.setScene(new Scene(fxmlBooks.load(), 762, 510));
        bookStage.show();

        Stage stage = (Stage) myBooksNavButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loadAllMembers(ActionEvent event) throws IOException{
        FXMLLoader fxmlRegister = new FXMLLoader(LibraryApplication.class.getResource("AllMembersNav.fxml"));
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(fxmlRegister.load(), 762, 510));
        registerStage.show();

        Stage stage = (Stage) allMembersNavButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void loadLateFees(ActionEvent event) throws IOException{
        FXMLLoader fxmlRegister = new FXMLLoader(LibraryApplication.class.getResource("LateFeesNav.fxml"));
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(fxmlRegister.load(), 762, 510));
        registerStage.show();

        Stage stage = (Stage) lateFeesNavButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void loadReturnBorrow(ActionEvent event) throws IOException{
        FXMLLoader fxmlBorrow = new FXMLLoader(LibraryApplication.class.getResource("ReturnAndBorrowNav.fxml"));
        Stage borrowStage = new Stage();
        borrowStage.initStyle(StageStyle.UNDECORATED);
        borrowStage.setScene(new Scene(fxmlBorrow.load(), 762, 510));
        borrowStage.show();

        Stage stage = (Stage) borrowAndReturnNav.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void loadMyAccountInfo(ActionEvent event) throws IOException{
        FXMLLoader fxmlInfo = new FXMLLoader(LibraryApplication.class.getResource("MyAccountInfo.fxml"));
        Stage infoStage = new Stage();
        infoStage.initStyle(StageStyle.UNDECORATED);
        infoStage.setScene(new Scene(fxmlInfo.load(), 762, 510));
        infoStage.show();

        Stage stage = (Stage) myAccountInfoButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void loadAllWithdrawals(ActionEvent event) throws IOException{
        FXMLLoader fxmlwithdraw = new FXMLLoader(LibraryApplication.class.getResource("WithdrawalsNav.fxml"));
        Stage withdrawStage = new Stage();
        withdrawStage.initStyle(StageStyle.UNDECORATED);
        withdrawStage.setScene(new Scene(fxmlwithdraw.load(), 762, 510));
        withdrawStage.show();

        Stage stage = (Stage) allWithdrawalsButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loadAdminDashboard(ActionEvent event) throws IOException{
        FXMLLoader fxmldash = new FXMLLoader(LibraryApplication.class.getResource("SidebarNav.fxml"));
        Stage dashStage = new Stage();
        dashStage.initStyle(StageStyle.UNDECORATED);
        dashStage.setScene(new Scene(fxmldash.load(), 762, 510));
        dashStage.show();

        Stage stage = (Stage) adminDashButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void loadUserDashboard(ActionEvent event) throws IOException{
        FXMLLoader fxmlUserDash = new FXMLLoader(LibraryApplication.class.getResource("UserDashboardNav.fxml"));
        Stage dashStage = new Stage();
        dashStage.initStyle(StageStyle.UNDECORATED);
        dashStage.setScene(new Scene(fxmlUserDash.load(), 762, 510));
        dashStage.show();

        Stage stage = (Stage) userDashboardButton.getScene().getWindow();
        stage.close();
    }

    public void logoutFromDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLogin = new FXMLLoader(LibraryApplication.class.getResource("LMS.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.initStyle(StageStyle.UNDECORATED);
        LoginStage.setScene(new Scene(fxmlLogin.load(), 520, 400));
        LoginStage.show();

        Stage stage = (Stage) logoutFromAdminBtn.getScene().getWindow();
        stage.close();
    }
    public void logoutFromUserDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLogin = new FXMLLoader(LibraryApplication.class.getResource("LMS.fxml"));
        Stage LoginStage = new Stage();
        LoginStage.initStyle(StageStyle.UNDECORATED);
        LoginStage.setScene(new Scene(fxmlLogin.load(), 520, 400));
        LoginStage.show();

        Stage stage = (Stage) logoutFromUserBtn.getScene().getWindow();
        stage.close();
    }
    public void exitFromDashboardButton(ActionEvent event) {
        Stage stage = (Stage) exitFromDashboardButton.getScene().getWindow();
        stage.close();
    }

    public void exitFromUserDashboardButton(ActionEvent event) {
        Stage stage = (Stage) exitFromUserDashboardButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
