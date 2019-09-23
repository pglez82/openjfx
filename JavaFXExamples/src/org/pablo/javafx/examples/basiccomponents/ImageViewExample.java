package org.pablo.javafx.examples.basiccomponents;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class ImageViewExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo ImageView");

        ImageView imageView = new ImageView(getClass().getResource("resources/imagen.jpg").toExternalForm());
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100); //We resize the image
        Scene scene = new Scene(new VBox(imageView),100,100);
        stage.setScene(scene);
        stage.show();
    }
}