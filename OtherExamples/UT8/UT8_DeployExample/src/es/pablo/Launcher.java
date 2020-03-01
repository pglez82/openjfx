package es.pablo;

import es.pablo.views.BaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        BaseController baseController = fxmlLoader.getController();
        stage.setTitle("Pantalla principal");
        stage.setScene(new Scene(root));
        baseController.setStage(stage);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
