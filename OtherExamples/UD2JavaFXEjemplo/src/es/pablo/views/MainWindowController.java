package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private MenuItem menuAltaP;

    @FXML
    private TableView<Persona> tableViewPersonas;

    @FXML
    void altaNuevaPersona(ActionEvent event) {
        System.out.println("llamado metodo alta");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewPersonas.setItems(Logica.getInstance().getListaPersonas());
    }
}

