package com.pablo.ut5;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class ComponenteHolaMundo extends Label
{
    private StringProperty nombrePersona2;


    public ComponenteHolaMundo() {
    }

    public ComponenteHolaMundo(String s) {
        super(s);
    }

    public ComponenteHolaMundo(String s, Node node) {
        super(s, node);
    }

    public String getNombrePersona2() {
        return nombrePersona2.get();
    }

    public StringProperty nombrePersona2Property() {
        return nombrePersona2;
    }

    public void setNombrePersona2(String nombrePersona2) {
        this.nombrePersona2.set(nombrePersona2);
    }

    /**
     * Este método saluda utilizando el nombre que tiene como propiedad.
     */
    public void saluda()
    {
        if (getNombrePersona2() ==null || "".equals(getNombrePersona2()))
            throw new RuntimeException("El nombre no puede estar vacio");

        setText("Hola mundo "+this.nombrePersona2);
    }
}
