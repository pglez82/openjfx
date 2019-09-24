package org.pablo.javafx.examples.windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

public class ErrorAlertDialogExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo Error Alert Dialog");

        Button button = new Button("Abrir");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert Dialog");
                alert.setHeaderText("Un título del error");
                alert.setContentText("Mensaje de error para el usuario");
                alert.show();
            }
        });

        Scene scene = new Scene(button,150,150);
        stage.setScene(scene);
        stage.show();
    }
}
