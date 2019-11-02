package org.pablo.javafx.examples.styles;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;


public class CustomStyleExample extends ExampleBase
{
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo estilos");

        TextField textField = new TextField();
        textField.setPromptText("Introduce tu nombre");
        textField.setStyle("-fx-background-color:yellow");
        Button button = new Button("Aceptar");

        Scene scene = new Scene(new VBox(10,textField,button),250,100);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
