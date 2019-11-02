package org.pablo.javafx.examples.styles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import org.pablo.javafx.examples.ExampleBase;
import org.pablo.javafx.examples.basiccomponents.dto.Persona;

public class JMetroThemeExample extends ExampleBase
{

    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo tema JMetro");

        ComboBox<Style> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(Style.DARK,Style.LIGHT);
        comboBox.setPromptText("Selecciona un tema para JMetro");
        Button button = new Button("Cambiar tema");

        //Metemos algún componente más para ver como queda el cambio
        ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
        listaPersonas.add(new Persona("Pablo","González"));
        listaPersonas.add(new Persona("María","Suárez"));

        TableView<Persona> tableView = new TableView<>(listaPersonas);

        TableColumn<Persona, String> column1 = new TableColumn<>("Nombre");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Persona, String> column2 = new TableColumn<>("Apellidos");
        column2.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        //Como ajustar el tamaño de las columnas de un tableview
        column1.prefWidthProperty().bind(tableView.widthProperty().divide(2));
        column2.prefWidthProperty().bind(tableView.widthProperty().divide(2));

        tableView.getColumns().addAll(column1,column2);


        Scene scene = new Scene(new VBox(10,comboBox,button,tableView),300,300);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (comboBox.getSelectionModel().getSelectedItem()!=null)
                {
                    //ESTA ES LA LINEA REALMENTE IMPORTANTE!!! El resto es solo para que el interfaz tenga componentes.
                    new JMetro(scene,comboBox.getSelectionModel().getSelectedItem());
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Debes seleccionar una valor en el combo");
                    alert.show();
                }
            }
        });


        stage.setScene(scene);
        stage.show();
    }
}
