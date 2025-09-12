module com.mining.graphics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mining.graphics to javafx.fxml;
    exports com.mining.graphics;
}