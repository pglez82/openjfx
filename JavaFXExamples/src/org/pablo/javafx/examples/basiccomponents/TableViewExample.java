package org.pablo.javafx.examples.basiccomponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;
import org.pablo.javafx.examples.basiccomponents.dto.Persona;

/**
 * JavaFX App
 */
public class TableViewExample extends ExampleBase {


    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo TableView");

        ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
        listaPersonas.add(new Persona("Pablo","González"));
        listaPersonas.add(new Persona("María","Suárez"));

        TableView tableView = new TableView(listaPersonas);

        //Mapeamos cada columna con una propiedad del objeto Persona. (OJO. Las propiedades deben tener getter y setter públicos)
        TableColumn<String, Persona> column1 = new TableColumn<>("Nombre");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<String, Persona> column2 = new TableColumn<>("Apellidos");
        column2.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        tableView.getColumns().addAll(column1,column2);

        Scene scene = new Scene(new VBox(tableView),200,100);
        stage.setScene(scene);
        stage.show();
    }
}