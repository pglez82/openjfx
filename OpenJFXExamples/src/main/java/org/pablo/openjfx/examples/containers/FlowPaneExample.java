package org.pablo.openjfx.examples.containers;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class FlowPaneExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo FlowPane");
        
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(new Label("Label 1"));
        flowPane.getChildren().add(new Label("Label 2"));
        flowPane.getChildren().add(new Label("Label 3"));
        flowPane.setVgap(10); //Vertical spacing
        flowPane.setHgap(10); //Horizontal spacing
        flowPane.setOrientation(Orientation.HORIZONTAL);
        
        Scene scene = new Scene(flowPane,100,100);
        stage.setScene(scene);
        stage.show();
    }
}