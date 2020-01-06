package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogoPersona extends Stage {
    private TextField nombreTf;
    private TextField apellidosTf;
    private Button botonAceptar;

    public DialogoPersona() {
        inicializaVista();
        botonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addPersona();
            }
        });
    }

    public DialogoPersona(Persona persona,int posicion)
    {
        inicializaVista();
        nombreTf.setText(persona.getNombre());
        apellidosTf.setText(persona.getApellidos());
        botonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nombre = nombreTf.getText();
                String apellidos = apellidosTf.getText();
                Persona personaM = new Persona(nombre,apellidos);
                Logica.getInstance().modificarPersona(personaM,posicion);
                close();
            }
        });
    }

    private void inicializaVista()
    {
        initModality(Modality.APPLICATION_MODAL);
        setTitle("Alta persona");
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Nombre:"));
        nombreTf = new TextField();
        vbox.getChildren().add(nombreTf);
        vbox.getChildren().add(new Label("Apellidos:"));
        apellidosTf = new TextField();
        vbox.getChildren().add(apellidosTf);
        botonAceptar = new Button("Aceptar");

        vbox.getChildren().add(botonAceptar);
        Scene sceneDialog = new Scene(vbox, 200, 200);
        setScene(sceneDialog);
    }

    private void addPersona()
    {
        Persona persona = new Persona(nombreTf.getText(), apellidosTf.getText());
        Logica.getInstance().addPersona(persona);
        close();
    }
}
