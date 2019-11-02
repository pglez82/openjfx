module JavaFXExamples {
    requires javafx.controls;
    requires org.jfxtras.styles.jmetro;
    requires javafx.fxml;
    exports org.pablo.javafx.examples;
    exports org.pablo.javafx.examples.fxml;
    opens org.pablo.javafx.examples.basiccomponents.dto to javafx.base;
}