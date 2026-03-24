module com.example.practicaexamen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicaexamen.Controlador to javafx.fxml;
    exports com.example.practicaexamen;
}