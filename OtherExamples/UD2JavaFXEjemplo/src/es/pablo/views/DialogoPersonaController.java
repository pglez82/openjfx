package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoPersonaController extends BaseController implements Initializable {

    private Persona personaModificar;


    @FXML
    private Button altaButton;

    @FXML
    private TextField nombreTf;

    @FXML
    private TextField apellidosTf;


    @FXML
    void altaModificarPersona(ActionEvent event) {
        //Diferenciamos el caso de si queremos modificar o alta
        //En este caso es una modificación porque tenemos algo en personaModificar
        if (personaModificar!=null)
        {
            personaModificar.setNombre(nombreTf.getText());
            personaModificar.setApellidos(apellidosTf.getText());
            Logica.getInstance().modificarPersona(personaModificar);
        }
        else {
            Persona persona = new Persona(nombreTf.getText(), apellidosTf.getText());
            Logica.getInstance().addPersona(persona);
        }

        getStage().close();
    }

    public void setPersonaModificar(Persona personaModificar)
    {
        this.personaModificar = personaModificar;
        nombreTf.setText(personaModificar.getNombre());
        apellidosTf.setText(personaModificar.getApellidos());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.registerValidator(nombreTf, Validator.createEmptyValidator("El nombre no puede ser vacío"));
        validationSupport.registerValidator(apellidosTf, Validator.createEmptyValidator("Los apellidos no pueden ser vacíos"));
        //Dos opciones aquí. La tradicional y una con bindings
        //Option 1
        /*validationSupport.invalidProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                System.out.println("Oldvalue="+oldValue+" New value:"+newValue);
                altaButton.setDisable(newValue);
            }
        });*/

        //Option 2: Bindings
        altaButton.disableProperty().bind(validationSupport.invalidProperty());

    }
}