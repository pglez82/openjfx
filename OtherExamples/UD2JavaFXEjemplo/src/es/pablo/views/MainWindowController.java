package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import es.pablo.views.filters.FilterApellidos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
    private FilterApellidos filterApellidos;

    @FXML
    private MenuItem menuAltaP;

    @FXML
    private TextField filterApellidosTf;

    @FXML
    private TableView<Persona> tableViewPersonas;

    @FXML
    void modificarPersona(ActionEvent event) {
        DialogoPersonaController controller = (DialogoPersonaController)cargarDialogo("DialogoPersona.fxml");
        Persona persona = tableViewPersonas.getSelectionModel().getSelectedItem();
        controller.setPersonaModificar(persona);
        controller.mostrarDialogo(true);
        filtrar();
    }

    @FXML
    void altaNuevaPersona(ActionEvent event) {
        BaseController controller = cargarDialogo("DialogoPersona.fxml");
        controller.mostrarDialogo(true);
        filtrar();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewPersonas.setItems(Logica.getInstance().getListaPersonas());
        filterApellidos = new FilterApellidos(Logica.getInstance().getListaPersonas());
        //Nos subscribimos a cambios en la propiedad text del textfield
        filterApellidosTf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                tableViewPersonas.setItems(filterApellidos.filtrar(newValue));
            }
        });
    }

    private void filtrar()
    {
        tableViewPersonas.setItems(filterApellidos.filtrar(filterApellidosTf.getText()));
    }
}

