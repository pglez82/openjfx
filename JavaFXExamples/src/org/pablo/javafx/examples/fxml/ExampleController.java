package org.pablo.javafx.examples.fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.pablo.javafx.examples.basiccomponents.dto.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ExampleController implements Initializable {

    /**
     * Mapeamos cada elemento del interfaz ayudados por la etiqueta @FXML
     */
    @FXML
    public TableView<Persona> tableViewPersonas;


    /**
     * Este método se ejecuta nada más cargar el controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
        listaPersonas.add(new Persona("Pablo","González"));
        listaPersonas.add(new Persona("María","Suárez"));
        tableViewPersonas.getItems().addAll(listaPersonas);
    }
}
