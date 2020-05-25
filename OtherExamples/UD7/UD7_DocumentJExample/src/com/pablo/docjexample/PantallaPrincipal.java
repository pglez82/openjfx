package com.pablo.docjexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.docgene.help.JavaHelpFactory;
import org.docgene.help.gui.jfx.JFXHelpContentViewer;


import java.io.File;
import java.net.URL;


public class PantallaPrincipal extends Application
{
    private JFXHelpContentViewer viewer;
    private void initializeHelp(Stage stage)
    {
        try {
            URL url = new File("help/articles.zip").toURI().toURL();
            JavaHelpFactory factory = new JavaHelpFactory(url);
            factory.create();
            viewer = new JFXHelpContentViewer();
            factory.install(viewer);
            viewer.getHelpWindow(stage, "Help Content", 600, 700);
        }catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeHelp(primaryStage);
        Button button = new Button("Mostrar ayuda");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewer.showHelpDialog(button);
            }
        });
        VBox vBox = new VBox(button);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
