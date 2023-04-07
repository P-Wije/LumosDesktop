package com.example.javafx;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;


public class SidebarPieController implements Initializable {
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private PieChart pieChart;
    @FXML
    private AnchorPane contentAnchor;
    @FXML
    private Label dateLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Novels", 2),
                        new PieChart.Data("Magazines", 25),
                        new PieChart.Data("News Papers", 50),
                        new PieChart.Data("Comics", 3));


        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " amount: ", data.pieValueProperty()
                        )
                )
        );

        pieChart.getData().addAll(pieChartData);

        dateLabel.setText(new SimpleDateFormat("MMM dd,yyyy").format(new Date()));



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
