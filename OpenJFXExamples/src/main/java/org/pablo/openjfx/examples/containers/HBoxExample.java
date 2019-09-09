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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.pablo.openjfx.examples.ExampleBase;

/**
 * JavaFX App
 */
public class HBoxExample extends ExampleBase {
    @Override
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Ejemplo HBox");
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Label 1"));
        hbox.getChildren().add(new Label("Label 2"));
        hbox.getChildren().add(new Label("Label 3"));
        hbox.setSpacing(10);
        Scene scene = new Scene(hbox,200,100);
        stage.setScene(scene);
        stage.show();
    }
}