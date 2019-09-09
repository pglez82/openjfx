package org.pablo.openjfx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class AccordionExample extends ExampleBase{
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo Accordion");
        
        Accordion accordion = new Accordion();
        
        TitledPane titlePane1 = new TitledPane("TitledPane1", new Label("Contenido TitledPane1"));
        TitledPane titlePane2 = new TitledPane("TitledPane2", new Label("Contenido TitledPane2"));
        TitledPane titlePane3 = new TitledPane("TitledPane3", new Label("Contenido TitledPane3")); 
        
        accordion.getPanes().add(titlePane1);
        accordion.getPanes().add(titlePane2);
        accordion.getPanes().add(titlePane3);
        
        Scene scene = new Scene(accordion,200,100);
        stage.setScene(scene);
        stage.show();
    }
}