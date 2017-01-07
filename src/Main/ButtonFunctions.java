/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Sketch.MyButton;

/**
 *
 * @author Yumis
 */
public class ButtonFunctions {

    public void learn() {
        System.out.println("learn");
    }

    public void answer() {
        System.out.println("asnwer");
    }

    
    public boolean btnClicked(MyButton button, int mouseX, int mouseY) {
        return isOverRec(button.x, button.y, button.width, button.height, mouseX, mouseY);
    }

    public boolean isOverRec(int x, int y, int width, int height, int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width
                && mouseY > y && mouseY < y + height;
    }

}
