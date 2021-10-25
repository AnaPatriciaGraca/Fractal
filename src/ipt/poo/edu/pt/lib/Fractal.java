/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipt.poo.edu.pt.lib;

import ipt.poo.edu.pt.lib.EventListener.FractalEvent;
import ipt.poo.edu.pt.lib.Pallet.AbstractFractalColor;
import ipt.poo.edu.pt.lib.Pallet.FractalHSB;
import ipt.poo.edu.pt.lib.Pallet.FractalRed;
import ipt.poo.edu.pt.lib.func.AbstactFractalFunction;
import ipt.poo.edu.pt.lib.func.BurningShip;
import ipt.poo.edu.pt.lib.func.MandelBroth;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wildm
 */
public class Fractal extends JLabel implements MouseMotionListener, MouseListener,MouseWheelListener {

    public Point2D Center = new Point2D.Double(0, 0);
    public Point2D C = new Point2D.Double(0,0);
    public double windowSize = 4;
    public int itera = 1000;
    public int size = 500;
    FractalEvent listener;
    AbstactFractalFunction func = new MandelBroth();
    AbstractFractalColor color = new FractalHSB();

    public Fractal() {
        getFractalImage();
        addMouseMotionListener(this);
        addMouseListener(this);
        addMouseWheelListener(this);
    }


    public void setListener(FractalEvent e) {
        this.listener = e;
    }

    public Point2D getRealCoordinates(int x, int y) {
        //converter as coordenadas do pixel para o mundo fratal
        double x0 = Center.getX() - windowSize / 2 + windowSize * x / size;
        double y0 = Center.getY() + windowSize / 2 - windowSize * y / size;
        return new Point2D.Double(x0, y0);
    }

    public void getFractalImage() {
        //criar a imagem com dimensão size x size do tipo RGB
        BufferedImage picture = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        //calcular os pixeis da imagem
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Point2D ncenter = getRealCoordinates(x, y);
                //calcular a cor
                int index = func.color(ncenter.getX(), ncenter.getY(),C.getX(),C.getY(), itera);
                
                Color c = color.paint(index);
                //pintar o pixel
                picture.setRGB(x, y, c.getRGB());
            }
        }
        setIcon(new ImageIcon(picture));
    }

    @Override
    public void mouseDragged(MouseEvent me) {
       //listener.onMouseDrag(me);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        listener.onMouseMove(me);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        listener.onMouseClick(me);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
       
    }

}
