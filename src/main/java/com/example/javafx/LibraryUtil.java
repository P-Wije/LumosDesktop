package com.example.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class LibraryUtil {
    public static void loadWindow(URL loc, String title, Stage parentStage){
        try{
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            }else{
                stage = new Stage(StageStyle.DECORATED);
                stage.initModality(Modality.APPLICATION_MODAL);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void alert(String alertTitle, String alertContent, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(alertTitle);
        alert.setContentText(alertContent);
        alert.show();

    }
}
