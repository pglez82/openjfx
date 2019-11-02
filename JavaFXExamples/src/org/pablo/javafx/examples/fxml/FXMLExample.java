package org.pablo.javafx.examples.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

import java.io.IOException;

public class FXMLExample extends ExampleBase
{

    @Override
    public void show() {
        try {
            //Cargamos el fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Example.fxml"));
            //El método load nos devuelve el AnchorPane principal del fxml
            Parent root = fxmlLoader.load();
            //Cogemos el controller asociado si lo necesitamos (para pasarle alguna cosa por ejemplo)
            ExampleController exampleController = fxmlLoader.getController();
            //Creamos la stage y la escena
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
