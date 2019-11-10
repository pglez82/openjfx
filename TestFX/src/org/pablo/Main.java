package org.pablo;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage) {
        VBox vBox = new VBox();
        Button button = new Button("Pulsado!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setText("Pulsame!");
            }
        });
        vBox.getChildren().add(button);
        Scene scene = new Scene(vBox, 100, 100);
        stage.setScene(scene);
        stage.show();
    }
}
