package org.pablo.javafx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class VBoxExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo VBox");
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Label 1"));
        vbox.getChildren().add(new Label("Label 2"));
        vbox.getChildren().add(new Label("Label 3"));
        vbox.setSpacing(10);
        Scene scene = new Scene(vbox,200,100);
        stage.setScene(scene);
        stage.show();
    }
}