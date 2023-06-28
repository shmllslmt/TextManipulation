module com.shamilla.textmanipulation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.shamilla.textmanipulation to javafx.fxml;
    exports com.shamilla.textmanipulation;
}