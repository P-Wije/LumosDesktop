module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;
    requires com.jfoenix;
    requires org.controlsfx.controls;

    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
}