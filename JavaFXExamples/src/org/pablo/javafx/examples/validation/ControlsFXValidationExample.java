package org.pablo.javafx.examples.validation;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.pablo.javafx.examples.ExampleBase;


public class ControlsFXValidationExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo Validación");

        TextField textField1 = new TextField();
        textField1.setPromptText("Validador 'no vacío'");
        TextField textField2 = new TextField();
        textField2.setPromptText("Validador 'solo números'");
        TextField textField3 = new TextField();
        textField3.setPromptText("Validador 'personalizado (solo números <100)'");
        Button button = new Button("Aceptar");

        ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.registerValidator(textField1, Validator.createEmptyValidator("Este campo no puede estar vacío"));
        validationSupport.registerValidator(textField2, Validator.createRegexValidator("Este campo no puede estar vacío","[0-9]+", Severity.ERROR));
        validationSupport.registerValidator(textField3, new Validator<String>()
        {
            @Override
            public ValidationResult apply(Control control, String value)
            {
                try {
                    int i = Integer.parseInt(value);
                    if (i>=100)
                        return ValidationResult.fromError( control, "El número no es menor de 100");
                } catch (NumberFormatException n)
                {
                    return ValidationResult.fromError( control, "No es un número");
                }
                return null;
            }
        });

        button.disableProperty().bind(validationSupport.invalidProperty());

        Scene scene = new Scene(new VBox(10,textField1,textField2,textField3,button),300,200);
        stage.setScene(scene);
        stage.show();
    }
}
