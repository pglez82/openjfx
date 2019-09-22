package org.pablo.javafx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.javafx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class AnchorPaneExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo AnchorPane");
        AnchorPane anchorPane = new AnchorPane();
        Button button = new Button("Prueba");
        AnchorPane.setTopAnchor(button,20d);
        AnchorPane.setBottomAnchor(button,20d);
        AnchorPane.setLeftAnchor(button,20d);
        AnchorPane.setRightAnchor(button,20d);
        anchorPane.getChildren().add(button);

        Scene scene = new Scene(anchorPane,200,100);
        stage.setScene(scene);
        stage.show();
    }
}