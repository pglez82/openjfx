package es.pablo.logica;

import es.pablo.models.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Logica {
    private static Logica INSTANCE = null;



    private ObservableList<Persona> listaPersonas;


    private Logica()
    {
         listaPersonas = FXCollections.observableArrayList();
         listaPersonas.add(new Persona("Pablo","González"));
         listaPersonas.add(new Persona("María","Fernández"));
    }

    public static Logica getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Logica();

        return INSTANCE;
    }


    //Estructuras de datos de mi app


    public void addPersona(Persona persona) {
        listaPersonas.add(persona);
    }


    public ObservableList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void borrarPersona(Persona persona) {
        listaPersonas.remove(persona);
    }

    public void modificarPersona(Persona personaM) {
        int posicion = listaPersonas.indexOf(personaM);
        listaPersonas.set(posicion,personaM);
    }
}
