package org.pablo.javafx.examples.basiccomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class TextFieldExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo TextField");

        TextField textField = new TextField();
        textField.setPromptText("Introduce tu nombre");
        Button button = new Button("Aceptar");
        Label label = new Label("");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setText("Hola" + ' ' + textField.getText());
            }
        });
        
        
        Scene scene = new Scene(new VBox(new HBox(textField,button),label),250,100);
        stage.setScene(scene);
        stage.show();
    }
}