module TemporizadorTest {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;
    requires Temporizador;
    exports com.pablo.test;
    exports com.pablo.test.fxml;
    opens com.pablo.test.fxml;
}