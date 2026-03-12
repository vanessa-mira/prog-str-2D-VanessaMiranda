package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;

    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize() throws IOException { //se va a ejecutar el inicio, en cuanto se cargue el controller
        //Inicializar ListView

        listView.setItems(data);
        loadFromFile();
    }




    @FXML
    public void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edadText = txtEdad.getText();
            int edad;

            try {
                edad = Integer.parseInt(edadText);
            } catch (Exception e) {
                lblMsg.setText("La edad debe ser numérica");
                lblMsg.setStyle("-fx-text-fill: red");
                return;
            }

            if (edad < 18) {
                lblMsg.setText("Solo mayores de edad");
                lblMsg.setStyle("-fx-text-fill: red");
                return;
            }

            service.addPerson(name, email, edad);
            lblMsg.setText("Persona agregada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException ex) {
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }



    private void loadFromFile() throws IOException {
        List<String> items = service.loadDataForList();
        data.setAll(items);
        lblMsg.setText("Datos cargados exitosamente ");
        lblMsg.setStyle("-fx-text-fill: green");


    }

}
