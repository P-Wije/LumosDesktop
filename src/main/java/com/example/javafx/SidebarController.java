package com.example.javafx;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class SidebarController implements Initializable {
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private PieChart pieChart;

    @FXML
    void onForgiveFeeButtonAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Fee has been Forgiven!")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }

    @FXML
    void onRemoveBookButtonAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been removed from user successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }

    @FXML
    void onWarningIssueButtonAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Warning has been issued to user successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showWarning();
    }

    @FXML
    void onMemberAddAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("User has been added successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }

    @FXML
    void onMemberDeleteAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("User has been deleted successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showError();
    }

    @FXML
    void onMemberEditAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("User has been changed successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showWarning();
    }
    @FXML
    private AnchorPane contentAnchor;
    @FXML
    private Label dateLabel;
    @FXML
    private Button allBooksNavAdd;

    @FXML
    private Button allBooksNavDelete;

    @FXML
    private Button allBooksNavEdit;
    @FXML
    void onAllBooksNavAddAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been added successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }
    @FXML
    void onAllBooksNavDeleteAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been removed successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }

    @FXML
    void onAllBooksNavEditAction(ActionEvent event) {
        Notifications notifications = Notifications
                .create()
                .text("Book has been changed successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            VBox box = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DrawerContent.fxml")));
            drawer.setSidePane(box);

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


        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (drawer.isOpened()) {
                drawer.close();
                drawer.setVisible(false);
            } else {
                drawer.setVisible(true);
                drawer.open();
            }
        });



    }
}
