package com.pablo.ut5;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class ComponenteHolaMundo extends Label
{
    private String nombre;


    public ComponenteHolaMundo() {
    }

    public ComponenteHolaMundo(String s) {
        super(s);
    }

    public ComponenteHolaMundo(String s, Node node) {
        super(s, node);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este método saluda utilizando el nombre que tiene como propiedad.
     */
    public void saluda()
    {
        if (nombre==null || "".equals(nombre))
            throw new RuntimeException("El nombre no puede estar vacio");

        setText("Hola mundo "+this.nombre);
    }
}
