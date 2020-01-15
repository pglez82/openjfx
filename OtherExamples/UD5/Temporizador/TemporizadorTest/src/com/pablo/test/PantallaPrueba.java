package com.pablo.test;

import com.pablo.OnEndCountDown;
import com.pablo.Temporizador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PantallaPrueba extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Temporizador temporizador = new Temporizador();
        temporizador.setFont(new Font(48));
        temporizador.setSegundos(5);

        temporizador.addOnEndCountDown(new OnEndCountDown() {
            @Override
            public void ejecuta() {
                System.out.println("FIN CUENTA ATRÁS");
            }
        });

        vBox.getChildren().add(temporizador);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        temporizador.comenzar();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
