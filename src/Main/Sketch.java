
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import processing.core.PApplet;
import static processing.core.PApplet.sin;

public class Sketch extends PApplet {

    ButtonFunctions btn = new ButtonFunctions();

    static public void main(String args[]) {
        PApplet.main(new String[]{"Main.Sketch"});
    }

    @Override
    public void setup() {

        textSize(25);
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
//        if (btn.btnClicked(clearButton, x, y)) {
//
//        } else if (btn.btnClicked(learnButton, x, y)) {
//            btn.learn();
//            System.out.println("nauczyl sie");
//
//        } else if (btn.btnClicked(recognizeButton, x, y)) {
//            btn.answer();
//            System.out.println("odpowiedzial");
//        }
    }
        @Override
        public void keyPressed
        
            () {
        if ((int) key > 47 && (int) key < 57) {
                int a = (int) key - 48;
                System.out.println(a);

            }
        }
            
    public class MyButton {

        int x, y;
        int height, width;
        String text;

        public MyButton(int x, int y, int height, int width, String text) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;
            this.text = text;
        }

        public void display() {
            stroke(255);
            fill(204, 102, 0);
            rect(x, y, width, height);
            fill(100, 100, 255);
            text(text, x + width / 4, y + height - height / 4);
        }
    }

}
