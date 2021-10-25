/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipt.poo.edu.pt.lib.func;

/**
 *
 * @author wildm
 */
public class BurningShip extends AbstactFractalFunction {

    @Override
    public int color(double re, double im, double a, double b, int itera) {
        double aux;
        if (a == 0 && b == 0) {
            while (itera > 0 && a * a + b * b <= 4) {

                aux = a * a - b * b - re;
                b = 2 * Math.abs(a * b) - im;
                a = Math.abs(aux);
                itera--;
            }

        } else {
            while (itera > 0 && re * re + im * im <= 4) {

                aux = re * re - im * im - a;
                im = 2 * Math.abs(re * im) - b;
                re = Math.abs(aux);
                itera--;
            }
        }
        return itera;
    }
}
