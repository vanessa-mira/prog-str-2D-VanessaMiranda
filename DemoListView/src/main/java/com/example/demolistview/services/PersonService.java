package com.example.demolistview.services;
import com.example.demolistview.repositories.PersonFileRepository;

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

    public void addPerson(String name, String email) throws IOException {
        repo.appendNewLine(name + "," + email);
    }

    private void validatePerson(String name, String email) {
        
        if (name.isEmpty() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isEmpty()|| !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El correo es incorrecto");
        }
        int edadNum;
        
    

