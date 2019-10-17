package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DialogoPersonaController {

    @FXML
    private Button altaButton;

    @FXML
    private TextField nombreTf;

    @FXML
    private TextField apellidosTf;

    @FXML
    void altaPersona(ActionEvent event) {
        Persona persona = new Persona(nombreTf.getText(),apellidosTf.getText());
        Logica.getInstance().addPersona(persona);
        //Como obtener un Stage desde un evento
        Stage stage = ((Stage)((Node)event.getSource()).getScene().getWindow());
        stage.close();
    }

}