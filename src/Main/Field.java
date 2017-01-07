/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import processing.core.PApplet;

/**
 *
 * @author Hayab_000
 */
public class Field {

    int x;
    int y;
    int height;
    int width;
    PApplet aplet;

    public Field(int x, int y, int height, int width, PApplet aplet) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.aplet = aplet;
    }

    public void display() {
        aplet.stroke(0);
//        aplet.fill(204, 102, 0);
        aplet.fill(255, 255, 255);
        aplet.rect(x, y, width, height);
        aplet.fill(100, 100, 255);
    }

    public boolean clicked(int mouseX, int mouseY) {
        return Calculations.isOverRec(x, y, width, height, mouseX, mouseY);
    }
}
