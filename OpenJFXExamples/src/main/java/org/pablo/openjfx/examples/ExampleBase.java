/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pablo.openjfx.examples;

/**
 *
 * @author pablo
 */
public abstract class ExampleBase {
    public abstract void show();

    @Override
    public String toString() {
        return getClass().getName();
    }
    
}
