module com.example.demolistview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolistview to javafx.fxml;
    opens com.example.demolistview.controllers to javafx.fxml;
    opens com.example.demolistview.reporitories to javafx.fxml;
    opens com.example.demolistview.services to javafx.fxml;
    exports com.example.demolistview;
    exports com.example.demolistview.controllers;
    exports com.example.demolistview.reporitories;
    exports com.example.demolistview.services;

}