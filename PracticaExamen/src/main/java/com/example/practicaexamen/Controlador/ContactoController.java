package com.example.practicaexamen.Controlador;

import com.example.practicaexamen.Service.ContactoService;
import com.example.practicaexamen.Validaciones.Validador;
import com.example.practicaexamen.contactoEmergencia.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContactoController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cbParentesco;
    @FXML
    private ListView<Contacto> listViewContactos;

    private ContactoService service = new ContactoService();

    @FXML
    public void initialize() {
        cbParentesco.getItems().addAll(service.getParentescos());
        listViewContactos.setItems(service.getListaContactos());
    }

    @FXML
    private void agregar() {
        String error = Validador.validar(
                txtNombre.getText(),
                txtTelefono.getText(),
                cbParentesco.getValue()
        );

        if (error != null) {
            mostrar(error);
            return;
        }

        Contacto contacto = new Contacto(
                txtNombre.getText(),
                txtTelefono.getText(),
                cbParentesco.getValue()
        );

        if (!service.agregar(contacto)) {
            mostrar("Ya existe ese contacto");
            return;
        }

        limpiar();
    }

    @FXML
    private void buscar() {
        Contacto c = service.buscar(txtNombre.getText());

        if (c != null) {
            txtTelefono.setText(c.getTelefono());
            cbParentesco.setValue(c.getParentesco());
        } else {
            mostrar("No encontrado");
        }
    }

    @FXML
    private void actualizar() {
        String error = Validador.validar(
                txtNombre.getText(),
                txtTelefono.getText(),
                cbParentesco.getValue()
        );

        if (error != null) {
            mostrar(error);
            return;
        }

        if (!service.actualizar(
                txtNombre.getText(),
                txtTelefono.getText(),
                cbParentesco.getValue()
        )) {
            mostrar("No encontrado");
            return;
        }

        listViewContactos.refresh();
        limpiar();
    }

    @FXML
    private void eliminar() {
        if (!service.eliminar(txtNombre.getText())) {
            mostrar("No encontrado");
            return;
        }
        limpiar();
    }

    @FXML
    private void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
    }

    private void mostrar(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}