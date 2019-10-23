package org.pablo.javafx.examples.windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

import java.io.File;

public class FileChooserExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo FileChooser");

        Button buttonSalvar = new Button("Salvar");
        buttonSalvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                //Este paso es opcional, para dejar al usuario solo seleccionar ciertos tipos de archivo
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog(stage);

                if (file != null) {
                    //Hacer lo que queramos con el archivo.
                    System.out.println(file.getAbsolutePath());
                }
            }
        });

        Button buttonAbrir = new Button("Abrir");
        buttonAbrir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                //Este paso es opcional, para dejar al usuario solo seleccionar ciertos tipos de archivo
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showOpenDialog(stage);

                if (file != null) {
                    //Hacer lo que queramos con el archivo. Normalmente leerlo y cargarlo.
                    System.out.println(file.getAbsolutePath());
                }
            }
        });

        HBox hbox = new HBox(buttonSalvar,buttonAbrir);
        Scene scene = new Scene(hbox,150,150);
        stage.setScene(scene);
        stage.show();
    }
}
