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
            String edad = parts[2].trim();

            result.add(name + "-" + correo + "-" + edad);
        }
        return result;
    }

    public List<String> loadDataBusqueda(String busqueda) throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim();
            String correo = parts[1].trim();
            if(!correo.contains(busqueda))continue;
            String edad = parts[2].trim();

            result.add(name + "-" + correo + "-" + edad);
        }
        return result;
    }


    public void addPerson(String name, String email, int edad) throws IOException {
        validatePerson(name,email,edad);
        String nameNoComa= name.replace(",", "");
        String emailNoComa= email.replace(",", "");



        repo.appendNewLine(name + "," + email+","+ edad + "\n");
    }
    public void updatePerson(int index,String name, String email, String edad) throws IOException{
        List<String> lines =getAllCleanLines();
        if(index == -1) {
            throw new IllegalArgumentException("El indice recibido es invalido");
        }
        lines.set(index,name+","+email+","+edad);
        repo.appendNewLines(lines);
        }
        public void deletePerson(int index) throws IOException {
            List<String> lines = getAllCleanLines();
            lines.remove(index);
            repo.appendAllLines(lines);
        }


            private List<String> getAllCleanLines() throws IOException {
                List<String> lines = repo.readAllLines();
                List<String> cleanLines = new ArrayList<>();
                for (String line : lines) {
                    if (line != null && !line.isBlank()) {
                        cleanLines.add(line);
                    }
                }

                return cleanLines;
            }

            private void validatePerson (String name, String email,int edad){

                if (name.isEmpty() || name.length() < 3) {
                    throw new IllegalArgumentException("El nombre no cumple con los estandares");
                }
                String em = (email == null) ? "" : email.trim();
                if (em.isEmpty() || !em.contains("@") || !em.contains(".")) {
                    throw new IllegalArgumentException("El correo es incorrecto");
                }
            }

            public List<String> loadDataforList () {
                return List.of();
            }
        }


        
    

