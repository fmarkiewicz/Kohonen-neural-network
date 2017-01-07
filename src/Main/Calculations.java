/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Hayab_000
 */
public class Calculations {

    public static int signum(double sum) {
        return sum > 0 ? 1 : -1;
    }

    public static boolean isOverRec(int x, int y, int width, int height, int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width
                && mouseY > y && mouseY < y + height;
    }
}
