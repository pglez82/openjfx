package com.pablo.temporizador;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * Clase principal del componente. Tendremos propiedades (expuestas a través de getters y setters), atributos
 * (internos de la clase) y listeners.
 */
public class Temporizador extends Label {
    private IntegerProperty inicial;
    private int cuentaatras; //Variable auxiliar para no modificar inicial
    private Thread thread;
    //Listener que se ejecuta cuando la cuenta atrás finaliza
    private CuentaAtrasFinListener cuentaAtrasFinListener;

    public Temporizador() {
        super();
        loadCSS();
    }

    public Temporizador(String s) {
        super(s);
        loadCSS();
    }

    public Temporizador(String s, Node node) {
        super(s, node);
        loadCSS();
    }

    public void setCuentaAtrasFinListener(CuentaAtrasFinListener cuentaAtrasFinListener)
    {
        this.cuentaAtrasFinListener = cuentaAtrasFinListener;
    }

    /**
     * Carga los CSS para el componente
     */
    private void loadCSS()
    {
        getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
    }


    public int getInicial() {
        return inicial.get();
    }

    public IntegerProperty inicialProperty() {
        return inicial;
    }

    public void setInicial(int inicial) {
        this.inicial.set(inicial);
        setText(Integer.toString(inicial));
    }

    /**
     * Comienza la ejecución del temporizador
     */
    public void start() {
        cuentaatras = inicial.getValue();
        //Establecer el estilo para cuando el contador está corriendo
        getStyleClass().clear();
        getStyleClass().add("running");
        //Hacemos un hilo para simular el temporizador. Este hilo irá decrementando el contador hasta cero
        if (thread==null) {
            thread = new Thread() {
                public void run() {
                    while (cuentaatras > 0) {
                        //Esto es básico. Solo podemos actualizar los componentes gráficos desde un hilo de JavaFX
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                setText(Integer.toString(--cuentaatras));
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //Llamamos al listener solo si no es null
                    if (cuentaAtrasFinListener!=null)
                    {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                cuentaAtrasFinListener.ejecuta();
                            }
                        });

                    }
                    getStyleClass().clear();
                    getStyleClass().add("stopped");
                    thread = null;
                }
            };
            thread.start();
        }
    }
}
