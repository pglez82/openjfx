package com.pablo;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Componente que es capaz de hacer una cuenta atrás. Disponemos también de un mecanismo para ejecutar
 * una acción personalizada cuando se acabe la cuenta atras.
 */
public class Temporizador extends Label
{
    private IntegerProperty segundos = new SimpleIntegerProperty(0);
    private ObjectProperty<Paint> colorEncendido= new SimpleObjectProperty<>(Color.GREEN);
    private ObjectProperty<Paint> colorFin= new SimpleObjectProperty<>(Color.RED);

    private OnEndCountDown onEndCountDown;

    public Temporizador()
    {
        super();
    }

    public int getSegundos() {
        return segundos.get();
    }

    public IntegerProperty segundosProperty() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos.set(segundos);
        setText(Integer.toString(segundos));
    }

    public Paint getColorEncendido() {
        return colorEncendido.get();
    }

    public ObjectProperty<Paint> colorEncendidoProperty() {
        return colorEncendido;
    }

    public void setColorEncendido(Paint colorEncendido) {
        this.colorEncendido.set(colorEncendido);
    }

    public Paint getColorFin() {
        return colorFin.get();
    }

    public ObjectProperty<Paint> colorFinProperty() {
        return colorFin;
    }

    public void setColorFin(Paint colorFin) {
        this.colorFin.set(colorFin);
    }

    public void addOnEndCountDown(OnEndCountDown onEndCountDown)
    {
        this.onEndCountDown = onEndCountDown;
    }


    private String colorToString(Paint color)
    {
        return ((Color)color).toString().substring(2);
    }

    /**
     * Comienza la cuenta atrás, desde la propiedad segundos hasta cero. Al llegar a cero se ejecutará la
     * acción personalizada si existe.
     */
    public void comenzar()
    {
        setStyle("-fx-text-fill:#"+colorToString(colorEncendido.get()));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (segundos.get()>0) {
                    segundos.set(segundos.get()-1);
                    //No podemos hacer una modificación del interfaz desde fuera del hilo de JavaFX, para
                    //volver al hilo de JavaFX debemos ejecutar Platform.runLater
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setText(Integer.toString(segundos.get()));
                            if (segundos.get()==0) {
                                setStyle("-fx-text-fill:#"+colorToString(colorFin.get()));
                                if (onEndCountDown!=null)
                                    onEndCountDown.ejecuta(new Date());
                            }
                        }
                    });
                }
                else {
                    timer.cancel();
                    timer.purge();
                }
            }
        },1000,1000);
    }
}
