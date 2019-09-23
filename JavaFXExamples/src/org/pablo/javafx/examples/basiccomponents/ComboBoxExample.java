package org.pablo.javafx.examples.basiccomponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;
import org.pablo.javafx.examples.basiccomponents.dto.Persona;

/**
 * JavaFX App
 */
public class ComboBoxExample extends ExampleBase {


    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo ComboBox");

        ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
        listaPersonas.add(new Persona("Pablo","González"));
        listaPersonas.add(new Persona("María","Suárez"));

        ComboBox comboBox = new ComboBox<Persona>(listaPersonas);
        comboBox.setPromptText("Selecciona una persona");
        Label label = new Label("Selecciona una persona en el combo");

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (comboBox.getSelectionModel().getSelectedItem()!=null)
                    label.setText(comboBox.getSelectionModel().getSelectedItem().toString());
            }
        });
        
        Scene scene = new Scene(new VBox(comboBox,label),200,100);
        stage.setScene(scene);
        stage.show();
    }
}