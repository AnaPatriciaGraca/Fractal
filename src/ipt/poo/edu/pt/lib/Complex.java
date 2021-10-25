/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipt.poo.edu.pt.lib;

/**
 *
 * @author wildm
 */
public class Complex {
    private double re;
    private double im;
    
    public Complex(){
        this(0,0);
    }
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    public Complex(Complex z){
        this(z.re,z.im);
    }
    
    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
    
    public Complex sum(Complex z){
        return new Complex(this.re+z.re,this.im+z.im);
    }
    public Complex multiply(Complex z){
        return new Complex(this.re*z.re-this.im*z.im,this.re*z.im+this.im*z.re);  
    }
    public double modulus(){
        return Math.hypot(re, im);
    }
}
