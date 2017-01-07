/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author Yumis
 */
public class ButtonFunctions {

    public void learn() {
        System.out.println("uczy");
    }

    public void answer() {
        System.out.println("odpowiada");
    }

    public void random() {
        System.out.println("losuje");
        Random rand = new Random();
        int color = 0;
        int radius = 6;

        Sketch.graphList.clear();
        Sketch.fieldList.get(0).display();
        for (MyCircle c : Sketch.dotList) {
            c.display();
        }

        for (int i = 0; i < Sketch.graphPointsAmount; i++) {
            int x = rand.nextInt(Sketch.FIELD_WIDTH);
            int y = rand.nextInt(Sketch.FIELD_HEIGHT);

            MyCircle c = new MyCircle(x, y, radius, color);
            Sketch.graphList.add(c);
        }

    }

    public void clear() {
        System.out.println("czysci");
        Sketch.dotList.clear();
        Sketch.graphList.clear();
        Sketch.fieldList.get(0).display();
    }
}
