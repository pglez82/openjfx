package org.pablo.openjfx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.ExampleBase;


public class ScrollPaneExample extends ExampleBase{
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo ScrollPane");
        
        ScrollPane scrollPane = new ScrollPane();
        VBox vbox = new VBox();
        for (int i=0;i<20;i++)
            vbox.getChildren().add(new Label("Linea "+(i+1)));
        scrollPane.setContent(vbox);
        
        Scene scene = new Scene(scrollPane,300,100);
        stage.setScene(scene);
        stage.show();
    }
}