package org.pablo.javafx.examples.concurrent;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class ConcurrentExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo Button");

        Button button = new Button("Comenzar proceso");
        TextField textField = new TextField();
        textField.setPromptText("Tu nombre");
        Label label = new Label("");
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setVisible(false);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TestService testService = new TestService(textField.getText());
                testService.start();
                testService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent workerStateEvent) {
                        //Recuperamos el valor de retorno
                        String saludo = testService.getValue();
                        label.setText(saludo);
                        progressIndicator.setVisible(false);
                    }
                });
                testService.setOnRunning(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent workerStateEvent) {
                        progressIndicator.setVisible(true);
                    }
                });
            }
        });
        
        Scene scene = new Scene(new VBox(textField,button,label,progressIndicator),150,100);
        stage.setScene(scene);
        stage.show();
    }
}