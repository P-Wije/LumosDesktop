package com.example.javafx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserNavControllerPrime implements Initializable {
    @FXML
    private ImageView dueSoonImageView;
    @FXML
    private ImageView popularImageView;
    @FXML
    private JFXDrawer userDrawer ;
    @FXML
    private JFXHamburger userHamburger;
    @FXML
    private JFXButton rateButtonMyBooks;

    @FXML
    private JFXButton renewButtonMyBooks;

    @FXML
    private JFXButton returnButtonMyBooks;

    @FXML
    private Button changeAccountInfoButton;

    @FXML
    void onChangeAccountInfoAction(ActionEvent event) {
        LibraryUtil.alert("Account Change","Account information has been updated", Alert.AlertType.INFORMATION);
    }

    @FXML
    private Button burrowButton;
    @FXML
    private Button returnBookButton;
    @FXML
    void onBorrowButtonAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been borrowed successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showInformation();
    }



    @FXML
    private ImageView recentReadImageView;

    @FXML
    private PieChart chartDePie;

    @FXML
    private Button exitFromUserDashboardButton;
    @FXML
    void onRateMyBooksAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been rated up")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }

    @FXML
    void onRenewButtonMyBooksAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been renewed successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }

    @FXML
    void onReturnButtonMyBooks(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been returned successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            VBox box = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UserDrawerContent.fxml")));
            userDrawer.setSidePane(box);

            for (Node node : box.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, event  -> {
                        switch (node.getAccessibleText()) {
                            case "   All Books" -> System.out.println("All Books");
                            case "   Withdrawals" -> System.out.println("withdrawals");
                            case "   Late Fees" -> System.out.println("fees");
                            case "   Members" -> System.out.println("members");
                            case "   Logout" -> System.out.println("Logout");
                            case "   Exit" -> System.out.println("Exit");
                        }
                    });
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(userHamburger);
        transition.setRate(-1);
        userHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (userDrawer.isOpened()) {
                userDrawer.close();
                userDrawer.setVisible(false);
            } else {
                userDrawer.setVisible(true);
                userDrawer.open();
            }
        });
    }
}

