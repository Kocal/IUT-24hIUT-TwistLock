package tablier;

import java.util.ArrayList;
import twistlock.Constante.Couleur;

/**
 * Classe Coin
 *
 * @author Kocal
 */
public class Coin {

    /**
     * Liste des Conteneurs
     */
    private ArrayList<Conteneur> conteneurs;

    public static int INNOCUPE = 0;
    public static int VERT = 1;
    public static int ROUGE = 2;

    // Vrai = Coin occupé, Faux = Coin non-occupé
    private Couleur col;

    /**
     * Initialise un nouveau Coin
     */
    public Coin() {
        this.conteneurs = new ArrayList<>();
        this.col = Couleur.INNOCUPE;
    }

    public Coin(int taken) {
        this.conteneurs = new ArrayList<>();
    }
    public Coin(Couleur col){
        this.conteneurs = new ArrayList<>();
        this.col = col;
    }

    /**
     * Ajoute une référence de Conteneur au Coin.
     *
     * @param conteneur Le Conteneur à ajouter
     * @return boolean
     */
    public boolean addConteneur(Conteneur conteneur) {
        return this.conteneurs.add(conteneur);
    }

    /**
     * Supprime une référence de Conteneur du Coin
     *
     * @param conteneur Le Conteneur à supprimer
     * @return int
     */
    public int removeConteneur(Conteneur conteneur) {
        if (this.conteneurs.contains(conteneur)) {
            if (this.conteneurs.remove(conteneur)) {
                return 1;
            }
            return 0;
        }
        else {
            return -1;
        }
    }

    /**
     * @return Les références de Conteneurs associés au Coin
     */
    public ArrayList<Conteneur> getConteneurs() {
        return this.conteneurs;
    }

    public void setTaken(Couleur col) {
        this.col = col;
        
        System.out.println("Size conteneurs : " + this.conteneurs.size());
        for(Conteneur conteneur : this.conteneurs) {
//            System.out.println(conteneur.valeur);
//            System.out.println(conteneur.isTaken());
            
            if(!conteneur.isTaken()) {
                conteneur.setColor(this.col);
            }
        }
    }

    public boolean isTaken() {
        return col != Couleur.INNOCUPE;
    }

    public Couleur getTaken() {
        return this.col;
    }
}
