module JavaFXExamples {
    requires javafx.controls;
    requires org.jfxtras.styles.jmetro;
    exports org.pablo.javafx.examples;
    opens org.pablo.javafx.examples.basiccomponents.dto to javafx.base;
}