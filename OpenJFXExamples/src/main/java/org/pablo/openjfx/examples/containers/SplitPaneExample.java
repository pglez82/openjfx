package org.pablo.openjfx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class SplitPaneExample extends ExampleBase{
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo SplitPane");
        
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().add(new VBox(new Label("Parte izquierda")));
        splitPane.getItems().add(new VBox(new Label("Parte derecha")));
        //We could add more than two items
        
        Scene scene = new Scene(splitPane,200,100);
        stage.setScene(scene);
        stage.show();
    }
}