package com.pablo.test;

import com.pablo.OnEndCountDown;
import com.pablo.Temporizador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.Date;

public class PantallaPrueba extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Temporizador temporizador = new Temporizador();
        temporizador.setFont(new Font(48));
        temporizador.setSegundos(5);
        temporizador.setColorEncendido(Color.YELLOW);
        temporizador.setColorFin(Color.BLUE);

        //Registramos el evento
        temporizador.addOnEndCountDown(new OnEndCountDown() {
            @Override
            public void ejecuta(Date date) {
                System.out.println("El temporizador llego a cero. Hora del evento:"+date);
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
