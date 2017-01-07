
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

public class Sketch extends PApplet {

    int buttonsX = 10;
    int buttonsY = 500;
    int buttonsHeight = 30;
    int buttonsWidth = 120;

    ButtonFunctions btn = new ButtonFunctions();
    List<MyButton> buttonList = new ArrayList<>();

    static public void main(String args[]) {
        PApplet.main(new String[]{"Main.Sketch"});
    }

    @Override
    public void setup() {
        textSize(25);

        buttonList.add(new MyButton("learn"));
        buttonList.add(new MyButton("answer"));

        for (int i = 0; i < buttonList.size(); i++) {
            MyButton but = buttonList.get(i);
            but.setCoordinates(buttonsX, buttonsY + buttonsHeight * i, buttonsHeight, buttonsWidth);
            but.display();
        }
    }

    @Override
    public void settings() {
        size(1000, 700);  // size always goes first!
//  surface.setResizable(true);
    }

    @Override
    public void draw() {

    }

    @Override
    public void mousePressed() {
        update(mouseX, mouseY);
    }

    @Override
    public void mouseDragged() {
        update(mouseX, mouseY);
    }

    void update(int x, int y) {
        for (MyButton but : buttonList) {
            if(but.clicked(x, y)) {
                but.func();
            }
        }
    }

    @Override
    public void keyPressed() {
        if ((int) key > 47 && (int) key < 57) {
            int a = (int) key - 48;
            System.out.println(a);

        }
    }

    public class MyButton {

        int x, y;
        int height, width;
        public Method method;
        String funcName;

        public MyButton(String funcName) {
            this.funcName = funcName;
            try {
                this.method = btn.getClass().getDeclaredMethod(funcName, null);
            } catch (NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(Sketch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void setCoordinates(int x, int y, int height, int width) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;
        }

        public void func() {
            Object obj = new Object();
            try {
                method.invoke(btn, null);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Sketch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void display() {
            stroke(255);
            fill(204, 102, 0);
            rect(x, y, width, height);
            fill(100, 100, 255);
            text(funcName, (int)(x + width / 4), (int)(y + height - height / 4));
        }

        public boolean clicked(int mouseX, int mouseY) {
            return Calculations.isOverRec(x, y, width, height, mouseX, mouseY);
        }
    }

}
