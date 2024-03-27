module com.example.javaminigame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.javaminigame to javafx.fxml;
    exports com.example.javaminigame;
}