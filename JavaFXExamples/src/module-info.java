module JavaFXExamples {
    requires javafx.controls;
    requires org.jfxtras.styles.jmetro; //para usar el tema jmetro
    requires javafx.fxml; //para tener archivos fxml
    requires org.controlsfx.controls; //para validación
    exports org.pablo.javafx.examples;
    exports org.pablo.javafx.examples.fxml;
    opens org.pablo.javafx.examples.basiccomponents.dto to javafx.base;
}