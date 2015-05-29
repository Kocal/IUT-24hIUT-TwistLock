package tablier;

import java.util.ArrayList;

/**
 * Classe Coin
 * @author Kocal
 */
public class Coin {
    
    /**
     * Liste des Conteneurs
     */
    private ArrayList<Conteneur> conteneurs;
    
    /**
     * Initialise un nouveau Coin
     */
    public Coin() {
        this.conteneurs = new ArrayList<>();
    }
    
    /**
     * Ajoute une référence de Conteneur au Coin.
     * @param conteneur Le Conteneur à ajouter
     * @return boolean
     */
    public boolean addConteneur(Conteneur conteneur) {
        return this.conteneurs.add(conteneur);
    }
    
    /**
     * Supprime une référence de Conteneur du Coin
     * @param conteneur Le Conteneur à supprimer
     * @return int
     */
    public int removeConteneur(Conteneur conteneur) {
        if(this.conteneurs.contains(conteneur)) {
            if(this.conteneurs.remove(conteneur)) {
                return 1;
            }
            return 0;
        } else {
            return -1;
        }
    }
    
    /**
     * @return Les références de Conteneurs associés au Coin
     */
    public ArrayList<Conteneur> getConteneurs() {
        return this.conteneurs;
    }
}
