/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.pablo.openjfx.examples;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.containers.HBoxExample;
import org.pablo.openjfx.examples.containers.VBoxExample;

/**
 * JavaFX App
 */
public class RunExamples extends Application {
    
    private List<ExampleBase> getListExamples()
    {
        return Arrays.asList(new HBoxExample(),new VBoxExample());
    }
    
    @Override
    public void start(Stage stage) {
        //Load all the classes in the listview
        ListView listView = new ListView();
        for (ExampleBase example : getListExamples())
            listView.getItems().add(example);

        //Show the button an its action
        Button button = new Button("Cargar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExampleBase exampleBase = (ExampleBase)listView.getSelectionModel().getSelectedItem();
                if (exampleBase!=null)
                    exampleBase.show();
            }
        });
        
        //Add elements to the container
        VBox vbox = new VBox();
        vbox.getChildren().add(listView);
        vbox.getChildren().add(button);
        
        //Set up the Scene and show it
        Scene scene = new Scene(vbox,400,400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}