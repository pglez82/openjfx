package org.pablo.javafx.examples.windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

public class NewDialogExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo Nueva Ventana");

        Button button = new Button("Abrir");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage newStage = new Stage();
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.setTitle("Diálogo modal");
                Scene sceneDialog = new Scene(new Label("Esto es un diálogo modal"),200,200);
                newStage.setScene(sceneDialog);
                newStage.show();
            }
        });

        Scene scene = new Scene(button,150,150);
        stage.setScene(scene);
        stage.show();
    }
}
