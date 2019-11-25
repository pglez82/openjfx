package org.pablo.javafx.examples.concurrent;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class TestService extends Service<String>
{
    private String name;

    public TestService(String name) {
        this.name = name;
    }

    @Override
    protected Task<String> createTask() {
        return new Task<>() {
            @Override
            protected String call() throws Exception {
                Thread.sleep(3000); //Simular que este Task tarda unos segundos en calcular este resultado
                return "Hello " + name;
            }
        };
    }
}
