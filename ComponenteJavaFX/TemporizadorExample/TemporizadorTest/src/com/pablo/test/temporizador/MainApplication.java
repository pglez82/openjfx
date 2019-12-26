package com.pablo.test.temporizador;

import com.pablo.temporizador.CuentaAtrasFinListener;
import com.pablo.temporizador.Temporizador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Esta aplicación simplemente tiene la finalidad de verificar que el componente funciona correctamente.
 * Por eso está en un paquete aparte. No queremos que se empaquete con el componente ya que no es necesaria
 * para su uso.
 */
public class MainApplication extends Application
{

    @Override
    public void start(Stage stage) throws Exception {
        Temporizador temporizador = new Temporizador();
        temporizador.setInicial(10);
        temporizador.setCuentaAtrasFinListener(new CuentaAtrasFinListener() {
            @Override
            public void ejecuta() {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("FIN TEMPORIZADOR");
                alert.setHeaderText("Hemos llegado a cero!");
                alert.setContentText("Ya puedes cerrar esta ventana");
                alert.showAndWait(); //Importante para que espere
            }
        });
        Button button = new Button("Empezar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                temporizador.start();
            }
        });
        VBox vbox = new VBox(temporizador,button);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
