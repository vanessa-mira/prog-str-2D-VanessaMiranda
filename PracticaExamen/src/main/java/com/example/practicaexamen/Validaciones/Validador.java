package com.example.practicaexamen.Validaciones;

public class Validador {
    public static String validar(String nombre, String telefono, String parentesco) {

        if (nombre == null || nombre.isEmpty()) {
            return "El nombre no puede estar vacío";
        }

        if (telefono == null || telefono.isEmpty()) {
            return "El teléfono no puede estar vacío";
        }

        if (!telefono.matches("\\d{10}")) {
            return "El teléfono debe tener exactamente 10 dígitos";
        }

        if (parentesco == null || parentesco.isEmpty()) {
            return "Debe seleccionar un parentesco";
        }

        return null;
    }
}

