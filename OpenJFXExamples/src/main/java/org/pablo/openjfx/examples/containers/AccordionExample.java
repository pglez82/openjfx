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

package org.pablo.openjfx.examples.containers;

import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class AccordionExample extends ExampleBase{
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo Accordion");
        
        Accordion accordion = new Accordion();
        
        TitledPane titlePane1 = new TitledPane("TitledPane1", new Label("Contenido TitledPane1"));
        TitledPane titlePane2 = new TitledPane("TitledPane2", new Label("Contenido TitledPane2"));
        TitledPane titlePane3 = new TitledPane("TitledPane3", new Label("Contenido TitledPane3")); 
        
        accordion.getPanes().add(titlePane1);
        accordion.getPanes().add(titlePane2);
        accordion.getPanes().add(titlePane3);
        
        Scene scene = new Scene(accordion,200,100);
        stage.setScene(scene);
        stage.show();
    }
}