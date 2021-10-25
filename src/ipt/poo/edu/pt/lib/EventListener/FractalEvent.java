/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipt.poo.edu.pt.lib.EventListener;

import java.awt.event.MouseEvent;
import java.util.EventListener;

/**
 *
 * @author wildm
 */
public interface FractalEvent extends EventListener{
    public void onMouseMove(MouseEvent e);
    public void onMouseClick(MouseEvent e);
}
