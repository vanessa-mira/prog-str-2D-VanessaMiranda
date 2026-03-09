package com.example.demolistview.services;

import com.example.demolistview.reporitories.PersonFileRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim();
            String correo = parts[1].trim();

            result.add(name + "-" + correo);
        }
        return result;
    }

    public void addPerson (String name, String email) throws IOException {
        validatePerson(name, email);
        String nameNoComa = name.replace(",", "");
        String emailNoComa = email.replace(",", "");
        repo.apprendNewLine(nameNoComa + "," + emailNoComa);
    }

    private void validatePerson(String name, String email){

        if(name==null || name.isBlank() || name.length()<3) {
            throw new IllegalArgumentException("El nombre no cumple co los estandares");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank()|| !em.contains("@") || ! em.contains(".")){
            throw new IllegalArgumentException("El correo es incorrecto");


        }

        }


}
