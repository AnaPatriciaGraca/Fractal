/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipt.poo.edu.pt.lib.func;

import ipt.poo.edu.pt.lib.Complex;

/**
 *
 * @author wildm
 */
public class Mandel3 extends AbstactFractalFunction{

    @Override
    public int color(double re, double im, double a, double b, int itera) {
        double aux;
        while (itera > 0 && a * a + b * b <= 4) {
            aux = (a*a*a)-3*a*(b*b) + re;
            b = 3*((a*a)*b)-(b*b*b) + im;
            a = aux;
            itera--;
        }
        return itera;
    }
    
}
