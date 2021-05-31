/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garri
 */
public interface Caos {
    /**
     * Interface amb un únic mètode, que rep uns daus i prova 
     * de realitzar un atac amb una PA reduïda en un 50%. Retorna true 
     * o false en funció de si l’atac té o no èxit.
     * @param dados
     * @return 
     */
    public boolean contraataca(Dado ... dados);

}
