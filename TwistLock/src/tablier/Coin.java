package tablier;

import java.util.ArrayList;
import twistlock.Constante.couleur;

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
    private couleur col;

    /**
     * Initialise un nouveau Coin
     */
    public Coin() {
        this.conteneurs = new ArrayList<>();
        this.col = couleur.INNOCUPE;
    }

    public Coin(int taken) {
        this.conteneurs = new ArrayList<>();
    }
    public Coin(couleur col){
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

    public void setTaken(couleur col) {
        this.col = col;
    }

    public boolean isTaken() {
        return col != couleur.INNOCUPE;
    }

    public couleur getTaken() {
        return this.col;
    }
}
