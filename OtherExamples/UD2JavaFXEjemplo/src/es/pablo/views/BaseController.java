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

    /**
     * Obtiene el stage asociado a este controller
     * @return stage asociado al controller
     */
    protected Stage getStage()
    {
        return stage;
    }

    /**
     * Recibe un stage y se lo asigna al controller. Solamente debería de ser útil para la primera pantalla de la aplicación.
     * @param stage
     */
    public void setStage(Stage stage)
    {
        if (this.stage!=null)
            throw new IllegalStateException("Ya tenemos un Stage en este controller");

        this.stage = stage;
    }

    private void cargarStage(Parent root)
    {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
    }

    /**
     * Método útil para cargar un nuevo diálogo.
     * @param fxml fxml que quiero cargar
     * @return Controller de la pantalla que estamos abriendo. Hay que llamar al método abrirDialogo para mostrarlo finalmente.
     */
    protected BaseController cargarDialogo(String fxml)
    {
        try {
            //Cargar el fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = fxmlLoader.load();
            BaseController controller = fxmlLoader.getController();
            controller.cargarStage(root);
            return controller;

        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Abre un diálogo cargado. Dará una excepción si no hemos llamado a {@link #cargarDialogo} primero}
     * @param showAndWait si queremos utilizar showandwait en la llamada a show() o no
     */
    protected void mostrarDialogo(boolean showAndWait)
    {
        if (stage==null)
            throw new IllegalStateException("Tienes que llamar a cargarDialogo primero");

        if (showAndWait)
            stage.showAndWait();
        else
            stage.show();
    }
}
