/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public class Asesino extends Personaje{

    public Asesino(String nom, String categoria,int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, Arma arma, String devocion) {
        super(nom, categoria, fuerza, constitucion, velocidad, inteligencia, suerte, arma, devocion);
    }

    public Asesino(String nom, String categoria, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, int nivel, int pExperiencia, Arma arma, String devocion) {
        super(nom, categoria, fuerza, constitucion, velocidad, inteligencia, suerte, nivel, pExperiencia, arma, devocion);
    }
    
    public void calculaDerivadas() {
        pSalud = constitucion + fuerza;
        pDany = (fuerza + arma.getWpower())/4;
        pAtacar = inteligencia + suerte + arma.getWspeed() + velocidad;
        pEsquivar = velocidad + suerte + inteligencia;

    }
    
}
