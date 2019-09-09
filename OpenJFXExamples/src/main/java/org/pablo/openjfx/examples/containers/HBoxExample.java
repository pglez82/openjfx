package org.pablo.openjfx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class HBoxExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo HBox");
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Label 1"));
        hbox.getChildren().add(new Label("Label 2"));
        hbox.getChildren().add(new Label("Label 3"));
        hbox.setSpacing(10);
        Scene scene = new Scene(hbox,200,100);
        stage.setScene(scene);
        stage.show();
    }
}