
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;

public class Sketch extends PApplet {

    static int graphPointsAmount = 15;
    static int T = 5500;

    int buttonsX = 10;
    int buttonsY = 500;
    int buttonsHeight = 30;
    int buttonsWidth = 120;

    static final int FIELD_X = 0;
    static final int FIELD_Y = 0;
    static final int FIELD_WIDTH = 500;
    static final int FIELD_HEIGHT = 450;

    ButtonFunctions btn = new ButtonFunctions();
    List<MyButton> buttonList = new ArrayList<>();
    static List<MyCircle> dotList = new ArrayList<>();
    static List<MyCircle> graphList = new ArrayList<>();
    static List<Field> fieldList = new ArrayList<>();

    static public void main(String args[]) {
        PApplet.main(new String[]{"Main.Sketch"});
    }

    @Override
    public void setup() {
        textSize(25);

        buttonList.add(new MyButton("learn", this));
        buttonList.add(new MyButton("random", this));
        buttonList.add(new MyButton("answer", this));
        buttonList.add(new MyButton("clear", this));

        for (int i = 0; i < buttonList.size(); i++) {
            MyButton but = buttonList.get(i);
            but.setCoordinates(buttonsX, buttonsY + buttonsHeight * i, buttonsHeight, buttonsWidth);
            but.display();
        }

        fieldList.add(new Field(FIELD_X, FIELD_Y, FIELD_HEIGHT, FIELD_WIDTH, this));
        fieldList.get(0).display();

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
        if (fieldList.get(0).clicked(mouseX, mouseY)) {
            update(mouseX, mouseY);
        }
    }

    void update(int x, int y) {
        if (fieldList.get(0).clicked(x, y)) {
            MyCircle c = new MyCircle(this, x, y, 8, 8);
            c.display();
            dotList.add(c);
        } else {
            for (MyButton but : buttonList) {
                if (but.clicked(x, y)) {
                    clearButtonClicked();
                    but.func();
                    but.displayClicked();

                    if (but.funcName.equals("random")) {
                        // cause I have to manualy pass "this" instance to 
                        // graph points to display it
                        drawGraph();
                    }
//                    break;
                }
            }
        }
    }

    @Override
    //klawiatura
    public void keyPressed() {
        if ((int) key > 47 && (int) key < 57) {
            int a = (int) key - 48;
            System.out.println(a);

        }
    }

    public void drawGraph() {
        graphList.get(0).setAplet(this);
        graphList.get(0).display();
        for (int i = 1; i < graphList.size(); i++) {
            MyCircle c = graphList.get(i);
            MyCircle prevC = graphList.get(i - 1);
            c.setAplet(this);
            c.display();
            stroke(126);
            line(c.x, c.y, prevC.x, prevC.y);
        }
    }

    public void clearButtonClicked() {
        for (MyButton b : buttonList) {
            b.display();
        }
    }
}
