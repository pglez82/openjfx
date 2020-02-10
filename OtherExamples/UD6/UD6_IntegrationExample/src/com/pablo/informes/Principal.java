package com.pablo.informes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.sql.DriverManager;


public class Principal extends Application
{
    /**
     * Método que genera el informe. Lo guarda a la carpeta informes
     *
     * @param ciudad ciudad para la cual queremos imprimir los clientes
     */
    private void generarInforme(String ciudad)
    {
        Connection conexion = null;
        try {
            //Obtenemos la conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/test","sa","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conexion);

        //Paso de parámetros al informe
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("CIUDAD",ciudad);

        try {
            JasperPrint print = JasperFillManager.fillReport(
                    getClass().getResourceAsStream("/com/pablo/informes/jasper/primerinforme.jasper"),
                    parametros, conexion);
            JasperExportManager.exportReportToPdfFile(print, "informes/primerinforme.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField("Dallas");
        Button button = new Button("Generar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                generarInforme(textField.getText());
            }
        });
        HBox hBox = new HBox(textField,button);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
