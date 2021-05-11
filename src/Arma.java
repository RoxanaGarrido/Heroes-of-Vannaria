/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public class Arma {

    private String nom;
    private int wpower; //weapon power
    private int wspeed; //weapon speed

    public Arma() {

    }

    public Arma(String nom) {
        this.nom = nom;
    }

    public Arma(String nom, int wpower, int wspeed) {
        this.nom = nom;
        this.wpower = wpower;
        this.wspeed = wspeed;
    }

    /**
     * Método que mediante el parámetro nom establece los atributos dependiendo del arma.
     * @param nom
     */
    public void setAtributos(String nom) {

        if (nom.equalsIgnoreCase("Daga")) {
            this.nom = nom;
            wpower = 5;
            wspeed = 15;
        } else if (nom.equalsIgnoreCase("Espada")) {
            this.nom = nom;
            wpower = 10;
            wspeed = 10;
        } else if (nom.equalsIgnoreCase("Martillo")) {
            this.nom = nom;
            wpower = 15;
            wspeed = 5;
        }
    }

    public int getWpower() {
        return wpower;
    }

    public int getWspeed() {
        return wspeed;
    }

    public String getNom() {
        return nom;
    }
    
    public void setWpower(int wpower) {
        this.wpower = wpower;
    }

    public void setWspeed(int wspeed) {
        this.wspeed = wspeed;
    }

    @Override
    public String toString() {
        return nom + " ---> poder " + wpower + " / velocidad " + wspeed;
    }
    
    

}
