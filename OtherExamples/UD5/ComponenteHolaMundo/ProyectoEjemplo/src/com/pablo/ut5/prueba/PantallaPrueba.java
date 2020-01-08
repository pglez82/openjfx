package com.pablo.ut5.prueba;

import com.pablo.ut5.ComponenteHolaMundo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaPrueba extends Application
{

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();

        //Creamos los tres componentes
        ComponenteHolaMundo chm = new ComponenteHolaMundo();
        TextField textField = new TextField();
        Button button = new Button("Saludame");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chm.setNombre(textField.getText());
                chm.saluda();
            }
        });
        //Los añadimos al panel
        vBox.getChildren().addAll(textField,button,chm);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
