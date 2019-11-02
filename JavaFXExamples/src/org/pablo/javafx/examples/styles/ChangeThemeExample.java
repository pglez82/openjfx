package org.pablo.javafx.examples.styles;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;
import org.pablo.javafx.examples.basiccomponents.dto.Persona;

public class ChangeThemeExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Cambio tema");



        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(Application.STYLESHEET_CASPIAN,Application.STYLESHEET_MODENA);

        comboBox.getSelectionModel().select(Application.getUserAgentStylesheet()); //Este método nos devuelve el tema actual

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (comboBox.getSelectionModel().getSelectedItem()!=null)
                    Application.setUserAgentStylesheet(comboBox.getSelectionModel().getSelectedItem());
            }
        });

        Scene scene = new Scene(new VBox(comboBox),200,100);
        stage.setScene(scene);
        stage.show();
    }
}
