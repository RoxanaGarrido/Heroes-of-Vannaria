/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public class Personaje {
    
    private String nom;
    private String classe;
    private int fuerza;
    private int constitucion;
    private int velocidad;
    private int inteligencia;
    private int suerte;
    private Arma arma;
    private int pSalud;
    private int pDany;
    private int pAtacar;
    private int pEsquivar;
    private int nivel;
    private int pExperiencia;

    public Personaje(String nom, String classe, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, Arma arma) {
        this.nom = nom;
        this.classe = classe;
        this.fuerza = fuerza;
        this.constitucion = constitucion;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.suerte = suerte;
        this.arma = arma;
        calculaDerivadas();
        nivel = 0;
        pExperiencia = 0;
    }
    
    public Personaje(String nom, String classe, int fuerza, int constitucion, int velocidad, int inteligencia, int suerte, int nivel, int pExperiencia, Arma arma) {
        this.nom = nom;
        this.classe = classe;
        this.fuerza = fuerza;
        this.constitucion = constitucion;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.suerte = suerte;
        this.arma = arma;
        this.nivel = nivel;
        this.pExperiencia = pExperiencia;
         calculaDerivadas();
    }

    private void calculaDerivadas(){
        pSalud = constitucion + fuerza;
        pDany = (fuerza + arma.getWpower())/4;
        pAtacar = inteligencia + suerte + arma.getWspeed();
        pEsquivar = velocidad + suerte + inteligencia;
        
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public boolean ataca(Dado ... dados){
        int tirada = 0;
        for (int i = 0; i < dados.length; i++) {
            tirada += dados[i].tirada();
        }
        
        return tirada <= pAtacar;
    }
    
    public boolean esquiva(Dado ... dados){
        int tirada = 0;
        for (int i = 0; i < dados.length; i++) {
            tirada += dados[i].tirada();
        }
        
        return tirada <= pEsquivar;
    }
    
    public void repDany(Personaje atacante){
        pSalud -= atacante.getpDany();
    }
    
    public void restauraPSalud(){
        pSalud = constitucion + fuerza;
    }
    
    public void sumarPExperiencia(){
        pExperiencia+=1;
    }
    
    public void subirEstadisticas(){
        fuerza++;
        constitucion++;
        velocidad++;
        inteligencia++;
        suerte++;
       calculaDerivadas(); 
    }
    
    @Override
    public String toString() {
        return nom + " - clase " + classe + "\n"+
               "Fuerza: " + fuerza + "\nConstitución: " + constitucion + "\nVelocidad: " 
                + velocidad + "\nInteligencia: " + inteligencia + "\nSuerte: " + suerte + 
                "\nArma: " + arma + "\nPuntos Salud: " + pSalud + "\nPuntos Daño: " + pDany 
                + "\n%Ataque: " + pAtacar + "\n%Esquivar: " + pEsquivar + "\nNivel:" + nivel 
                + "\nPuntos Experiencia: " + pExperiencia;
    }

    public String getNom() {
        return nom;
    }

    public String getClasse() {
        return classe;
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
    
    
    
}
