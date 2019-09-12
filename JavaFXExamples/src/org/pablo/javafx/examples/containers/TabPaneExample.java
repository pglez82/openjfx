package org.pablo.javafx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;


public class TabPaneExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo TabPane");
        
        //Usually the content of the tabs will be another container (ej. VBox or HBox
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Pestaña 1",new Label("Contenido pestaña 1"));
        Tab tab2 = new Tab("Pestaña 2",new Label("Contenido pestaña 2"));
        Tab tab3 = new Tab("Pestaña 3",new Label("Contenido pestaña 3"));
        tabPane.getTabs().addAll(tab1,tab2,tab3);
        
        Scene scene = new Scene(tabPane,300,100);
        stage.setScene(scene);
        stage.show();
    }
}