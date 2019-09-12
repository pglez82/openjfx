package org.pablo.javafx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class TitledPaneExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo TitledPane");
        //Usually the content of the pane will be another container (ej. VBox or HBox
        TitledPane titlePane = new TitledPane("Un título", new Label("Contenido"));
        Scene scene = new Scene(titlePane,200,100);
        stage.setScene(scene);
        stage.show();
    }
}