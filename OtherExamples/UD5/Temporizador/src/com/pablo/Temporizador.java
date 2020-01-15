package com.pablo;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Componente que es capaz de hacer una cuenta atrás. Disponemos también de un mecanismo para ejecutar
 * una acción personalizada cuando se acabe la cuenta atras.
 */
public class Temporizador extends Label
{
    private int segundos;
    private OnEndCountDown onEndCountDown;

    public Temporizador()
    {
        super();
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
        setText(Integer.toString(this.segundos));
    }

    public void addOnEndCountDown(OnEndCountDown onEndCountDown)
    {
        this.onEndCountDown = onEndCountDown;
    }

    /**
     * Comienza la cuenta atrás, desde la propiedad segundos hasta cero. Al llegar a cero se ejecutará la
     * acción personalizada si existe.
     */
    public void comenzar()
    {
        setStyle("-fx-text-fill:green");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (segundos>0) {
                    segundos--;
                    //No podemos hacer una modificación del interfaz desde fuera del hilo de JavaFX, para
                    //volver al hilo de JavaFX debemos ejecutar Platform.runLater
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setText(Integer.toString(segundos));
                            if (segundos==0) {
                                setStyle("-fx-text-fill:red");
                                if (onEndCountDown!=null)
                                    onEndCountDown.ejecuta();
                            }
                        }
                    });
                }
                else
                    cancel();
            }
        },1000,1000);
    }
}
