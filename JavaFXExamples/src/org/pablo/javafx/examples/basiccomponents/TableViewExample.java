package org.pablo.javafx.examples.basiccomponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

        TableView<Persona> tableView = new TableView<>(listaPersonas);

        //Mapeamos cada columna con una propiedad del objeto Persona. (OJO. Las propiedades deben tener getter y setter públicos)
        TableColumn<Persona, String> column1 = new TableColumn<>("Nombre");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Persona, String> column2 = new TableColumn<>("Apellidos");
        column2.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        tableView.getColumns().addAll(column1,column2);

        //Por ejemplo, cuando hagamos doble click sobre una fila de la tabla, imprimimos por consola la persona seleccionada.
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount()==2)
                    System.out.println(tableView.getSelectionModel().getSelectedItem());
            }
        });

        Scene scene = new Scene(new VBox(tableView),200,100);
        stage.setScene(scene);
        stage.show();
    }
}