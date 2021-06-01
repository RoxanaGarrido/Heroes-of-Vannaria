/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public class CaballeroOrden extends Caballero implements Orden {

    public CaballeroOrden(String nom, String categoria, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, Arma arma, String devocion) {
        super(nom, categoria, fuerza, constitucion, velocidad, inteligencia, suerte, arma, devocion);
    }

    public CaballeroOrden(String nom, String categoria, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, int nivel, int pExperiencia, Arma arma, String devocion) {
        super(nom, categoria, fuerza, constitucion, velocidad, inteligencia, suerte, nivel, pExperiencia, arma, devocion);
    }

    @Override
    public void recuperaParcialmentPS() {
        int pSaludInicial = constitucion + fuerza + inteligencia;
        int recuperacion = (int) pSaludInicial * 10 / 100;

        if (pSalud < pSaludInicial) {
            pSalud += recuperacion;
            if (pSalud > pSaludInicial) {
                pSalud = pSaludInicial;
            }
        }
    }
}
