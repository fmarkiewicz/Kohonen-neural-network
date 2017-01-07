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
public class Network {

    int points;
    int[] output;
    int[][] weight;
    public String status = "new";
    
    public Network() {
        
        points = 1600;
        weight = new int[points][points];
        output = new int[points];
        
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                weight[i][j] = 0;
            }
        }
    }

    public double[] getDoubleOutput() {
        double[] tmpOutput = new double[points];
        for (int i = 0; i < points; i++) {
            tmpOutput[i] = output[i];
        }
        return tmpOutput;
    }
}
