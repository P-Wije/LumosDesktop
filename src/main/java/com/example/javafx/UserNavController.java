package com.example.javafx;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserNavController implements Initializable {
    @FXML
    private ImageView dueSoonImageView;
    @FXML
    private ImageView popularImageView;
    @FXML
    private JFXDrawer userDrawer ;
    @FXML
    private JFXHamburger userHamburger;

    @FXML
    private ImageView recentReadImageView;

    @FXML
    private PieChart chartDePie;

    @FXML
    private Button readAgainUserDashButton;
    @FXML
    private Button dueSoonUserDashButtons;
    @FXML
    private Button popularUserDashButton;


    public void onDueSoonUserDashButtonClicked() {

        // LibraryUtil.alert("Read Again", "Book has been added to your borrow list", Alert.AlertType.INFORMATION);
        Notifications notifications = Notifications
                .create()
                .text("Book has been returned successfully")
                .position(Pos.BASELINE_CENTER)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showConfirm();
    }
    public void onPopularUserDashButtonClicked() {

        // LibraryUtil.alert("Read Again", "Book has been added to your borrow list", Alert.AlertType.INFORMATION);
        Notifications notifications = Notifications
                .create()
                .text("Book has been added to your borrow list")
                .position(Pos.TOP_LEFT)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showInformation();
    }
    public void onReadAgainUserDashButtonClicked() {

       // LibraryUtil.alert("Read Again", "Book has been added to your borrow list", Alert.AlertType.INFORMATION);
        Notifications notifications = Notifications
                .create()
                .text("Book has been added to your borrow list")
                .position(Pos.TOP_LEFT)
                .darkStyle()
                .hideAfter(Duration.seconds(5));
        notifications.showInformation();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Dropped", 13),
                new PieChart.Data("Wishlist", 25),
                new PieChart.Data("Books Read", 10),
                new PieChart.Data("Reading Now", 22));
        chartDePie.setData(pieChartData);
        chartDePie.setStartAngle(90);
        chartDePie.setTitle("Book Breakdown");
        chartDePie.setClockwise(true);
        chartDePie.setLabelLineLength(50);
        chartDePie.setLabelsVisible(true);
        chartDePie.setLegendVisible(true);


        File ThusFile = new File("Images/Thus-Spoke-Zarathustra-by-F.-Nietzsche-ebook-cover.jpg");
        Image ThusImage = new Image(ThusFile.toURI().toString());
        dueSoonImageView.setImage(ThusImage);

        File HarryFile = new File("Images/HrryPotter.jpg");
        Image HarryImage = new Image(HarryFile.toURI().toString());
        popularImageView.setImage(HarryImage);

        File CrimeFile = new File("Images/crime-and-punishment-9781510766709_hr.jpg");
        Image CrimeImage = new Image(CrimeFile.toURI().toString());
        recentReadImageView.setImage(CrimeImage);

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

