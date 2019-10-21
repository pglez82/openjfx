package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import es.pablo.views.filters.FilterApellidos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    private FilterApellidos filterApellidos;

    @FXML
    private MenuItem menuAltaP;

    @FXML
    private TextField filterApellidosTf;

    @FXML
    private TableView<Persona> tableViewPersonas;

    @FXML
    void modificarPersona(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DialogoPersona.fxml"));
            Parent root = fxmlLoader.load();
            DialogoPersonaController controller = fxmlLoader.getController();
            Persona persona = tableViewPersonas.getSelectionModel().getSelectedItem();
            controller.setPersonaModificar(persona);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root, 300, 275));
            stage.showAndWait();
            filtrar();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void altaNuevaPersona(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DialogoPersona.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root, 300, 275));
            stage.showAndWait();
            filtrar();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
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

