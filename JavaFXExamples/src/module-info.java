module JavaFXExamples {
    requires javafx.controls;
    exports org.pablo.javafx.examples;
    opens org.pablo.javafx.examples.basiccomponents.dto to javafx.base;
}