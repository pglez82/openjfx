package org.pablo.javafx.examples.windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

import java.util.Optional;

public class ConfirmationAlertDialogExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo Confirmation Alert Dialog");

        Button button = new Button("Abrir");
        Label label = new Label("");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Alert Dialog");
                alert.setHeaderText("Un título");
                alert.setContentText("¿Seguro que quiere borrar el registro?");

                alert.showAndWait();
                if ((alert.getResult() == ButtonType.OK))
                    label.setText("El usuario ha confirmado el borrado");
                else
                    label.setText("El usuario ha pulsado no o ha cerrado");
            }
        });

        Scene scene = new Scene(new VBox(10,button,label),250,100);
        stage.setScene(scene);
        stage.show();
    }
}
