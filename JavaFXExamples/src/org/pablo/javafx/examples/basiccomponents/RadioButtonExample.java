package org.pablo.javafx.examples.basiccomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class RadioButtonExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo RadioButton");

        Label label = new Label("Selecciona una opción:");
        RadioButton radioButton1 = new RadioButton("Hombre");
        RadioButton radioButton2 = new RadioButton("Mujer");

        Label mensaje = new Label("");

        //Un toglegroup hace que los botones funcionen de manera exclusiva (solo se puede seleccionar uno)
        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);

        Button button = new Button("Aceptar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
                mensaje.setText("Selección: "+selectedRadioButton.getText());
            }
        });

        Scene scene = new Scene(new VBox(10,label,radioButton1,radioButton2,button,mensaje),200,200);
        stage.setScene(scene);
        stage.show();
    }
}