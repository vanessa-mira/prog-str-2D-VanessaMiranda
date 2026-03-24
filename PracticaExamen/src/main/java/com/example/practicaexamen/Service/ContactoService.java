package com.example.practicaexamen.Service;


    import com.example.practicaexamen.contactoEmergencia.Contacto;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;

    public class ContactoService {

        // LISTA
        private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

        // ARREGLO
        private String[] parentescos = {
                "Padre", "Madre", "Hermano", "Hermana",
                "Abuelo", "Abuela", "Tío", "Tía"
        };

        public ObservableList<Contacto> getListaContactos() {
            return listaContactos;
        }

        public String[] getParentescos() {
            return parentescos;
        }

        // AGREGAR
        public boolean agregar(Contacto contacto) {
            for (Contacto c : listaContactos) {
                if (c.getNombre().equalsIgnoreCase(contacto.getNombre())) {
                    return false;
                }
            }
            listaContactos.add(contacto);
            return true;
        }

        // BUSCAR
        public Contacto buscar(String nombre) {
            for (Contacto c : listaContactos) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    return c;
                }
            }
            return null;
        }

        // ACTUALIZAR
        public boolean actualizar(String nombre, String telefono, String parentesco) {
            Contacto c = buscar(nombre);
            if (c != null) {
                c.setTelefono(telefono);
                c.setParentesco(parentesco);
                return true;
            }
            return false;
        }

        // ELIMINAR
        public boolean eliminar(String nombre) {
            Contacto c = buscar(nombre);
            if (c != null) {
                listaContactos.remove(c);
                return true;
            }
            return false;
        }
    }

