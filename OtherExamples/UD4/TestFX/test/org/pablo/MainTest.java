package org.pablo;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;


public class MainTest extends ApplicationTest
{
    @Before
    public void setup() throws Exception {
        ApplicationTest.launch(Main.class); //Clase principal de nuestra app
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }

    @Test
    public void textoInicial() {
        verifyThat("#button", hasText("Pulsame!"));
    }

    @Test
    public void textoDespues() {
        clickOn("#button");
        verifyThat("#button", hasText("Pulsado!"));
    }
}
