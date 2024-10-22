package org.example.controlador;

import org.example.modelo.Persona;

import java.io.*;
import java.util.ArrayList;

public class ControladorFicheros {

    /*Entregable*/

    public static ArrayList<Persona> leerPersonas(File fichero) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fichero);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea = bufferedReader.readLine();

            while (linea != null) {

                String campos[] = linea.split(";");

                Persona p = new Persona();
                p.setNombre(campos[0]);
                p.setEdad(Integer.parseInt(campos[1]));
                p.setDni(campos[2]);
                personas.add(p);
                linea = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return personas;

    }


    public static ArrayList<Persona> leerPersonasObject(File fichero) {
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            FileInputStream fileReader = new FileInputStream(fichero);

            ObjectInputStream bufferedReader = new ObjectInputStream(fileReader);

            Persona p = (Persona) bufferedReader.readObject();

            while (p != null) {
                personas.add(p);

                p = (Persona) bufferedReader.readObject();
            }

            fileReader.close();
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
        return personas;

    }

    public static boolean insertarPersona(File fichero, Persona persona) {


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fichero, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(persona.getNombre() + ";");
            bufferedWriter.write(persona.getEdad() + ";");
            bufferedWriter.write(persona.getDni());
            bufferedWriter.newLine();
            //bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
            return true;

        } catch (IOException e) {

        }

        return false;
    }

    public static boolean insertarPersona(File fichero, ArrayList<Persona> personas) {


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fichero, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                bufferedWriter.write(persona.getNombre() + ";");
                bufferedWriter.write(persona.getEdad() + ";");
                bufferedWriter.write(persona.getDni());
                bufferedWriter.newLine();
            }
            //bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
            return true;

        } catch (IOException e) {

        }

        return false;
    }

    public static boolean insertarPersonaObj(File fichero, Persona persona) {


        FileOutputStream fileWriter = null;
        try {
            fileWriter = new FileOutputStream(fichero, true);
            ObjectOutputStream bufferedWriter = new ObjectOutputStream(fileWriter);
            bufferedWriter.writeObject(persona);
            //bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
            return true;

        } catch (IOException e) {

        }

        return false;
    }

    public static boolean insertarPersonaObj(File fichero, ArrayList<Persona> personas) {


        FileOutputStream fileWriter = null;
        try {
            fileWriter = new FileOutputStream(fichero, true);
            ObjectOutputStream bufferedWriter = new ObjectOutputStream(fileWriter);

            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                bufferedWriter.writeObject(persona);
            }
            //bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
            return true;

        } catch (IOException e) {

        }

        return false;
    }


    public static boolean actualzarPersona() {

    }


    public static boolean borrarPersona() {

    }


    public static Persona buscarPersona() {

    }


    /*Practica*/


}
