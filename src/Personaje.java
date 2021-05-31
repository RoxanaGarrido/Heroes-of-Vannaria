/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public abstract class Personaje {

    protected String nom;
    protected String categoria;
    protected int fuerza;
    protected int constitucion;
    protected int velocidad;
    protected int inteligencia;
    protected int suerte;
    protected Arma arma;
    protected int pSalud;
    protected int pDany;
    protected int pAtacar;
    protected int pEsquivar;
    protected int nivel;
    protected int pExperiencia;
    protected String devocion;

    public Personaje(String nom, String categoria, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, Arma arma, String devocion) {
        this.nom = nom;
        this.categoria = categoria;
        this.fuerza = fuerza;
        this.constitucion = constitucion;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.suerte = suerte;
        this.arma = arma;
        this.devocion = devocion;
        calculaDerivadas();
        nivel = 0;
        pExperiencia = 0;
    }

    public Personaje(String nom, String categoria, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, int nivel, int pExperiencia, Arma arma, String devocion) {
        this.nom = nom;
        this.categoria = categoria;
        this.fuerza = fuerza;
        this.constitucion = constitucion;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.suerte = suerte;
        this.arma = arma;
        this.nivel = nivel;
        this.pExperiencia = pExperiencia;
        this.devocion = devocion;
        calculaDerivadas();
    }

    public abstract void calculaDerivadas();

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public boolean ataca(Dado... dados) {
        int tirada = 0;
        for (int i = 0; i < dados.length; i++) {
            tirada += dados[i].tirada();
        }

        return tirada <= pAtacar;
    }

    public boolean esquiva(Dado... dados) {
        int tirada = 0;
        for (int i = 0; i < dados.length; i++) {
            tirada += dados[i].tirada();
        }

        return tirada <= pEsquivar;
    }

    public void repDany(Personaje atacante) {
        pSalud -= atacante.getpDany();
    }

    public void restauraPSalud() {
        pSalud = constitucion + fuerza;
    }

    public void sumarPExperiencia(int pEx) {
        if (nivel < 5) {
            pExperiencia += pEx;
        }
    }

    public void subirNivel() {
            nivel++;
            fuerza++;
            constitucion++;
            velocidad++;
            inteligencia++;
            suerte++;
            calculaDerivadas();
    }

    public String getNom() {
        return nom;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSuerte() {
        return suerte;
    }

    public Arma getArma() {
        return arma;
    }

    public int getNivel() {
        return nivel;
    }

    public int getpExperiencia() {
        return pExperiencia;
    }

    public int getpDany() {
        return pDany;
    }

    public int getpSalud() {
        return pSalud;
    }

    public int getpAtacar() {
        return pAtacar;
    }

    public int getpEsquivar() {
        return pEsquivar;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setpExperiencia(int pExperiencia) {
        this.pExperiencia = pExperiencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDevocion() {
        return devocion;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSuerte(int suerte) {
        this.suerte = suerte;
    }

    public void setpSalud(int pSalud) {
        this.pSalud = pSalud;
    }
      

    @Override
    public String toString() {
        return nom + " " + categoria + "-" + devocion + "\n"+
               "Fuerza: " + fuerza + "\nConstitución: " + constitucion + "\nVelocidad: " 
                + velocidad + "\nInteligencia: " + inteligencia + "\nSuerte: " + suerte + 
                "\nArma: " + arma + "\nPuntos Salud: " + pSalud + "\nPuntos Daño: " + pDany 
                + "\n%Ataque: " + pAtacar + "\n%Esquivar: " + pEsquivar + "\nNivel:" + nivel 
                + "\nPuntos Experiencia: " + pExperiencia;
    }
}
