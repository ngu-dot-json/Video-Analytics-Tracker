module ytt.app.cpsc233demo3 {

    requires javafx.controls;
    requires javafx.fxml;

    opens ytt.app.cpsc233demo3 to javafx.fxml;
    exports ytt.app.cpsc233demo3;
}