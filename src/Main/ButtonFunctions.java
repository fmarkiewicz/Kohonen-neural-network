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

    public void start() {
        int T = Sketch.T;
        Random rand = new Random();
        for (float i = 0; i < T; i++) {
            int randomPoint = rand.nextInt(Sketch.dotList.size());
            MyCircle currentExample = Sketch.dotList.get(randomPoint);
            float currentDistance = Sketch.graphList.get(0).distance(currentExample);

            int itTmp = 0;
            float distanceTmp = 0;

            for (int itWeight = 0; itWeight < Sketch.graphList.size(); itWeight++) {
                
                distanceTmp = Sketch.graphList.get(itWeight).distance(currentExample);
                if (distanceTmp < currentDistance) {
                    currentDistance = distanceTmp;
                    itTmp = itWeight;
                }

                for (float it = 0; it < 2; it++) {
                    float neighbourOrSelf = 1/(it + 1);
//                    System.out.println(neighbourOrSelf);
                    if (itTmp + it < Sketch.graphPointsAmount) {
                        Sketch.graphList.get(itTmp + (int)it).update(Calculations.alpha(i, T), neighbourOrSelf, currentExample);
                    }
                    if (itTmp - it >= 0) {
                        Sketch.graphList.get(itTmp - (int)it).update(Calculations.alpha(i, T), neighbourOrSelf, currentExample);
                    }
                }
            }

        }
        
        
    }

    public void random() {
        System.out.println("losuje");
        Random rand = new Random();
        int color = 0;
        int radius = 6;

        Sketch.graphList.clear();
        

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
