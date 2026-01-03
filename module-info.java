module com.example.fxfirst {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxfirst to javafx.fxml;
    exports com.example.fxfirst;
}