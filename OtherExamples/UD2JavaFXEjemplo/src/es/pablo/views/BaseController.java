package es.pablo.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseController
{
    private Stage stage;

    protected Stage getStage()
    {
        return stage;
    }

    private void cargarStage(Parent root, int anchura,int altura)
    {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root, anchura,altura));
    }

    /**
     * Método útil para cargar un nuevo diálogo.
     * @param fxml fxml que quiero cargar
     * @param anchura anchura del diáloggo
     * @param altura altura del diálogo
     * @return Controller de la pantalla que estamos abriendo. Hay que llamar al método abrirDialogo para mostrarlo finalmente.
     */
    protected BaseController cargarDialogo(String fxml,int anchura, int altura)
    {
        try {
            //Cargar el fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = fxmlLoader.load();
            BaseController controller = fxmlLoader.getController();
            controller.cargarStage(root,anchura,altura);
            return controller;

        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void abrirDialogo(boolean showAndWait)
    {
        if (stage==null)
            throw new IllegalStateException("Tienes que llamar a cargarDialogo primero");

        if (showAndWait)
            stage.showAndWait();
        else
            stage.show();
    }
}
