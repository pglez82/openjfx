package es.pablo.views.filters;

import es.pablo.models.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilterApellidos
{
    private ObservableList<Persona> listaPersonas;
    private ObservableList<Persona> listaFiltrada;

    public FilterApellidos(ObservableList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
        listaFiltrada = FXCollections.observableArrayList();
    }

    public ObservableList<Persona> filtrar(String apellidosFiltrar)
    {
        if (apellidosFiltrar!=null && !"".equals(apellidosFiltrar))
        {
            //Necesitamos filtrar
            listaFiltrada.clear();
            for (Persona persona : listaPersonas)
            {
                if (persona.getApellidos().contains(apellidosFiltrar))
                    listaFiltrada.add(persona);
            }
            return listaFiltrada;
        }
        else
        {
            //Tenemos que mostrar todos los registros
            return listaPersonas;
        }

    }
}
