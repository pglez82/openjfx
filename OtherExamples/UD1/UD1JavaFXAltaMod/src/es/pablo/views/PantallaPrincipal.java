package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PantallaPrincipal extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Gestión de personas");
        TableView tableViewPersonas = new TableView(Logica.getInstance().getListaPersonas());
        AnchorPane.setTopAnchor(tableViewPersonas,10d);
        AnchorPane.setLeftAnchor(tableViewPersonas,10d);
        AnchorPane.setRightAnchor(tableViewPersonas,10d);
        AnchorPane.setBottomAnchor(tableViewPersonas,50d);

        TableColumn<String, Persona> column1 = new TableColumn<>("Nombre");
        column1.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<String, Persona> column2 = new TableColumn<>("Apellidos");
        column2.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        tableViewPersonas.getColumns().addAll(column1,column2);

        Button buttonAlta=null; //= new Button("Alta");
        AnchorPane.setBottomAnchor(buttonAlta,10d);
        AnchorPane.setLeftAnchor(buttonAlta,10d);

        Button buttonBorrar = new Button("Borrar");
        AnchorPane.setBottomAnchor(buttonBorrar,10d);
        AnchorPane.setRightAnchor(buttonBorrar,10d);

        Button buttonModificar = new Button("Modificar");
        AnchorPane.setBottomAnchor(buttonModificar,10d);
        AnchorPane.setLeftAnchor(buttonModificar,70d);

        buttonAlta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DialogoPersona dialogoPersona = new DialogoPersona();
                dialogoPersona.show();
            }
        });

        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int indice = tableViewPersonas.getSelectionModel().getSelectedIndex();
                Persona personaSeleccionada = Logica.getInstance().getListaPersonas().get(indice);
                DialogoPersona dialogoPersona = new DialogoPersona(personaSeleccionada,indice);
                dialogoPersona.show();
            }
        });

        buttonBorrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int indiceBorrar = tableViewPersonas.getSelectionModel().getSelectedIndex();
                if (indiceBorrar>=0)
                    Logica.getInstance().borrarPersona(indiceBorrar);
                else {
                    //Todo: mostrar mensaje al usuario
                }
            }
        });
        AnchorPane anchorPane = new AnchorPane(tableViewPersonas,buttonAlta,buttonModificar,buttonBorrar);
        Scene scene = new Scene(anchorPane, 250, 250);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
