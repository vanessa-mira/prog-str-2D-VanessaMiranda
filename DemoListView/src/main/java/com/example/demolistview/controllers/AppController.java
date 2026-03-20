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
    private TextField txtBusqueda;

    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize() throws IOException { //se va a ejecutar el inicio, en cuanto se cargue el controller
        //Inicializar ListView

        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener((obs,oldValue,newValue) -> {
                    loadDataToForm(String.valueOf(newValue)); //String con el valor del row 0 test-email@gmail.com-18
                }

        );
        listView.setItems(data);
        txtBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Text field changed from " + oldValue + " to " + newValue);
            loadDataBusqueda(newValue);
            // Add your custom logic here (e.g., validation, updating other UI elements)
        });

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
    @FXML
    public void onReload() throws IOException {
        loadFromFile();
    }

    @FXML
    public void onDelete() {
        int index = listView.getSelectionModel().getSelectedIndex();
        try {
            service.deletePerson(index);
            loadFromFile();
            lblMsg.setText("Persona eliminada correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: rojo");
        }
    }

    @FXML
    public void onUpdate() {
        int index = listView.getSelectionModel().getSelectedIndex();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        try {
            service.updatePerson(index, name, email, edad);
            lblMsg.setText("Actualizacion correcta");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill:red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill:red");

        }
    }

    private void loadFromFile() throws IOException {
        List<String> items = service.loadDataForList();
        data.setAll(items);
        lblMsg.setText("Datos cargados exitosamente ");
        lblMsg.setStyle("-fx-text-fill: green");


    }
    private void loadDataBusqueda(String busqueda){
        try{
            List<String> items = service.loadDataBusqueda(busqueda);
            data.setAll(items);

        }catch (IOException e){
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadDataToForm(String item){

        String[] items = item.split("-");
        txtName.setText(items[0]);
        txtEmail.setText(items[1]);
        txtEdad.setText(items[2]);

    }
}

