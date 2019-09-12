package org.pablo.javafx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class GridPaneExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo GridPane");
        
        GridPane gridPane = new GridPane();
        //First parameter row, second column
        gridPane.add(new Label("Label 1"),0,0,1,1);
        gridPane.add(new Label("Label 2"),0,1,1,1);
        gridPane.add(new Label("Label 3"),0,2,1,1);
        gridPane.add(new Label("Label 4"),1,0,1,1);
        gridPane.add(new Label("Label 5"),1,1,1,1);
        gridPane.add(new Label("Label 6"),1,2,1,1);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Scene scene = new Scene(gridPane,200,100);
        stage.setScene(scene);
        stage.show();
    }
}