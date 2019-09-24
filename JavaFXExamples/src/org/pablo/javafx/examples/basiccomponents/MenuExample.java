package org.pablo.javafx.examples.basiccomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class MenuExample extends ExampleBase {


    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo menus");

        Menu menuArchivo = new Menu("Archivo");
        Menu menuOpciones = new Menu("Opciones");

        MenuItem menuItemAbrir = new MenuItem("Abrir ...");
        MenuItem menuItemGuardar = new MenuItem("Guardar");

        Label mensaje = new Label("");

        //Establecemos las acciones
        menuItemAbrir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mensaje.setText("Menú abrir!!");

            }
        });

        menuItemGuardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mensaje.setText("Menú guardar!!");

            }
        });

        menuArchivo.getItems().addAll(menuItemAbrir,menuItemGuardar);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuArchivo,menuOpciones);

        
        Scene scene = new Scene(new VBox(menuBar,mensaje),200,100);
        stage.setScene(scene);
        stage.show();
    }
}