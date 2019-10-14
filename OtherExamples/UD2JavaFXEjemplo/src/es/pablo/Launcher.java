package es.pablo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/MainWindow.fxml"));
        stage.setTitle("Pantalla principal");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

    public static void main(String args[])
    {
        launch(args);
    }
}
