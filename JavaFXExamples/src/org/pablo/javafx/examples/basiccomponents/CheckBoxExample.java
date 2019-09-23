package org.pablo.javafx.examples.basiccomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class CheckBoxExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo CheckBox");

        CheckBox checkBox = new CheckBox("Acepto las condiciones");
        checkBox.setSelected(true);

        Button button = new Button("Aplicar");
        Label label = new Label("");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkBox.isSelected())
                    label.setText("Se han aceptado las condiciones");
                else
                    label.setText("No se aceptan las condiciones");
            }
        });

        Scene scene = new Scene(new VBox(checkBox,button,label),200,100);
        stage.setScene(scene);
        stage.show();
    }
}