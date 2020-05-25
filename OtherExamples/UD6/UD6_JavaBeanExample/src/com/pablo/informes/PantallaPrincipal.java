package com.pablo.informes;

import com.pablo.informes.dto.Persona;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PantallaPrincipal extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button botonGenerar = new Button("Generar");
        botonGenerar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                List<Persona> listPersonas = new ArrayList<>(); //Esta lista en una aplicación real vendría de Logica
                listPersonas.add(new Persona("Pablo",34));
                listPersonas.add(new Persona("Juan",18));
                listPersonas.add(new Persona("Ana",50));
                JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(listPersonas);
                try {
                    JasperPrint jasperPrint = JasperFillManager.fillReport(
                            getClass().getResourceAsStream("/com/pablo/informes/jasper/report.jasper"),
                            new HashMap<String,Object>(),
                            jrds);

                    JasperExportManager.exportReportToPdfFile(jasperPrint,"informes/report.pdf");
                    new Thread(() -> {
                        try {
                            Desktop.getDesktop().open(new File("informes/report.pdf"));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }).start();
                } catch (Throwable e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Error generando el informe");
                    alert.setContentText("Ha ocurrido un error generando el informe");
                    alert.show();
                }
            }
        });
        Scene scene = new Scene(new VBox(botonGenerar));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
