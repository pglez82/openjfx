package es.pablo.views;

import es.pablo.Launcher;
import es.pablo.logica.Logica;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.control.TableViewMatchers;
import org.testfx.service.query.PointQuery;

import static org.testfx.api.FxAssert.verifyThat;

public class MainWindowControllerTest extends ApplicationTest
{
    @Before
    public void setup() throws Exception {
        ApplicationTest.launch(Launcher.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }

    /**
     * Este método es importante. Si no llamamos a finalizar en el singleton (he creado el método específicamente para esto)
     * el singleton es común en los diferentes casos de prueba y por tanto nuestros tests no podrían ser unitarios.
     * Este código se llama cada vez que finalizamos un singleton y de esta manera nos aseguramos de que es nuevo para
     * cada test.
     */
    @After
    public void finalizar()
    {
        Logica.getInstance().finalizar();
    }

    /**
     * En este test comprobamos que la tabla inicialmente tiene 0 registros
     */
    @Test
    public void testInicial()
    {
        verifyThat("#tableViewPersonas", TableViewMatchers.hasNumRows(0));
    }

    @Test
    public void testAniadirPersona()
    {
        clickOn("#menuPersonas");
        clickOn("#menuAlta");
        clickOn("#nombreTf");
        write("Pablo");
        clickOn("#apellidosTf");
        write("González");
        clickOn("#altaButton");
        verifyThat("#tableViewPersonas", TableViewMatchers.hasNumRows(1));
        verifyThat("#tableViewPersonas",TableViewMatchers.containsRow(new String[]{"Pablo","González"}));

    }

    @Test
    public void testFiltro1()
    {
        clickOn("#menuPersonas");
        clickOn("#menuAlta");
        clickOn("#nombreTf");
        write("Pablo");
        clickOn("#apellidosTf");
        write("González");
        clickOn("#altaButton");
        clickOn("#filterApellidosTf");
        write("Martínez");
        verifyThat("#tableViewPersonas", TableViewMatchers.hasNumRows(0));
    }

    @Test
    public void testFiltro2()
    {
        clickOn("#menuPersonas");
        clickOn("#menuAlta");
        clickOn("#nombreTf");
        write("Pablo");
        clickOn("#apellidosTf");
        write("González");
        clickOn("#altaButton");
        clickOn("#filterApellidosTf");
        write("Gon");
        verifyThat("#tableViewPersonas", TableViewMatchers.hasNumRows(1));
    }
}
