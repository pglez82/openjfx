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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.basiccomponents.ButtonExample;
import org.pablo.openjfx.examples.basiccomponents.DatePickerExample;
import org.pablo.openjfx.examples.containers.AccordionExample;
import org.pablo.openjfx.examples.containers.FlowPaneExample;
import org.pablo.openjfx.examples.containers.GridPaneExample;
import org.pablo.openjfx.examples.containers.HBoxExample;
import org.pablo.openjfx.examples.containers.ScrollPaneExample;
import org.pablo.openjfx.examples.containers.SplitPaneExample;
import org.pablo.openjfx.examples.containers.TabPaneExample;
import org.pablo.openjfx.examples.containers.TitledPaneExample;
import org.pablo.openjfx.examples.containers.VBoxExample;

/**
 * JavaFX App
 */
public class RunExamples extends Application {
    private TreeView treeView;
    
    private List<ExampleBase> getContainerExamples()
    {
        return Arrays.asList(new HBoxExample(),new VBoxExample(), new TitledPaneExample(), new AccordionExample(), new SplitPaneExample(),
                new TabPaneExample(),new ScrollPaneExample(),new FlowPaneExample(),new GridPaneExample());
    }
    
    private List<ExampleBase> getBasicComponentsExamples()
    {
        return Arrays.asList(new ButtonExample(),new DatePickerExample());
    }
    
    @Override
    public void start(Stage stage) {
        //Load all the classes in the listview
        treeView = new TreeView();
        TreeItem treeItem = new TreeItem("Ejemplos");
        treeItem.setExpanded(true);
        TreeItem treeItemContainers = new TreeItem("Contenedores");
        treeItemContainers.setExpanded(true);
        for (ExampleBase example : getContainerExamples())
            treeItemContainers.getChildren().add(new TreeItem(example));
        treeItem.getChildren().add(treeItemContainers);
        TreeItem treeItemBasicComps = new TreeItem("Componentes básicos");
        treeItemBasicComps.setExpanded(true);
        for (ExampleBase example : getBasicComponentsExamples())
            treeItemBasicComps.getChildren().add(new TreeItem(example));
        treeItem.getChildren().add(treeItemBasicComps);

        //Show the button an its action
        Button button = new Button("Cargar");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               loadSelectedExample();
            }
        });
        
        treeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2)
                    loadSelectedExample();
            }
        });
        
        //Add elements to the container
        VBox vbox = new VBox();
        treeView.setRoot(treeItem);
        vbox.getChildren().add(treeView);
        vbox.getChildren().add(button);
        
        //Set up the Scene and show it
        Scene scene = new Scene(vbox,400,400);
        stage.setScene(scene);
        stage.setTitle("JavaFX examples");
        stage.show();
    }
    
    private void loadSelectedExample()
    {
        ExampleBase exampleBase = (ExampleBase)((TreeItem)treeView.getSelectionModel().getSelectedItem()).getValue();
        if (exampleBase!=null)
            exampleBase.show(); 
    }

    public static void main(String[] args) {
        launch();
    }
}