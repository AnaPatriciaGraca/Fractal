/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipt.poo.edu.pt.lib.Pallet;

import java.awt.Color;

/**
 *
 * @author wildm
 */
public class FractalHSB extends AbstractFractalColor {

    @Override
    public Color paint(int index) {
        return new Color(Color.HSBtoRGB(1-index%100, 1f,index*2));
    }
}
