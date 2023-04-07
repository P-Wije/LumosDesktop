package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class LibraryApplication extends Application {

//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApplication.class.getResource("LMS.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setScene(scene);
//        stage.show();
//
//
//    }
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LMS.fxml")));
        Scene scene = new Scene(root, 520, 400);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeScene (String fxml) throws IOException {
            Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
            stg.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch();
    }
}