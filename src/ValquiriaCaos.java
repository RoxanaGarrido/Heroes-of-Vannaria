/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public class ValquiriaCaos extends Valquiria implements Caos{

    public ValquiriaCaos(String nom, String categoria, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, Arma arma, String devocion) {
        super(nom, categoria, fuerza, constitucion, velocidad, inteligencia, suerte, arma, devocion);
    }

    public ValquiriaCaos(String nom, String categoria,int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, int nivel, int pExperiencia, Arma arma, String devocion) {
        super(nom, categoria, fuerza, constitucion, velocidad, inteligencia, suerte, nivel, pExperiencia, arma, devocion);
    }
  
    @Override
    public boolean contraataca(Dado... dados) {
        int tirada = 0;
        for (int i = 0; i < dados.length; i++) {
            tirada += dados[i].tirada();
        }

        return tirada <= (pAtacar / 2);
    }
    
    
}
