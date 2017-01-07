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
public class MyCircle {

    PApplet aplet;
    int x;
    int y;
    int radius;
    int color;

    public MyCircle(PApplet aplet, int x, int y, int radius, int color) {
        this.aplet = aplet;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public MyCircle( int x, int y, int radius, int color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public void display() {
        aplet.stroke(255);
        aplet.fill(204, 102, 0);
        aplet.ellipse(x, y, radius, radius);
        aplet.fill(100, 100, 255);
    }

    public void setAplet(PApplet aplet) {
        this.aplet = aplet;
    }
}
