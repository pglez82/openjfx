package com.pablo.test.fxml;

import com.pablo.Temporizador;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaController implements Initializable
{
    @FXML
    private Temporizador temporizador;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        temporizador.comenzar();
    }
}
