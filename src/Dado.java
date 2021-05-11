/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public class Dado {
    
    private int caras;

    public Dado(int caras) {
        this.caras = caras;
    }
    
    public int tirada(){
        return (int)(Math.random()*caras + 1);
    }
}
