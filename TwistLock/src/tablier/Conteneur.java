package tablier;

import java.util.ArrayList;
import twistlock.Constante;
import twistlock.Constante.Couleur;

/**
 *
 * @author Kocal
 */
public class Conteneur {

    public int ligne;
    public int colonne;
    public int valeur;
    
    private Couleur coul;
    
    private ArrayList<Coin> coins;

    public Conteneur(int ligne, int colonne, int valeur) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.valeur = valeur;
        this.coins = new ArrayList<>(4);
        this.coul = Couleur.INNOCUPE;
    }

    public String getColonneAfficher() {
        return Character.toString((char) ('A' + colonne));
    }

    public String getLigneAfficher() {
        return Integer.toString(ligne + 1);
    }

    public String getPositionAfficher(int coin) throws Exception {
        if (coin < 1 || coin > 4) {
            throw new Exception("Erreur : Le numéro de coin doit être dans l'intervalle 1-4");
        }
        return this.getLigneAfficher() + this.getColonneAfficher() + Integer.toString(coin);
    }
    
    public String getPositionAfficher(Coin c) throws Exception {
        return this.getLigneAfficher() + this.getColonneAfficher() + Integer.toString(this.getNumeroCoin(c));
    }

    public int getNumeroCoin(Coin c) throws Exception {
        int numCoin = -1;

        if (c.getConteneurs().size() != 4) {
            throw new Exception("Le conteneur a un nombre anormal de coin");
        }
        for (int i = 0; i < c.getConteneurs().size(); i++) {
            if (c.getConteneurs().get(i) == this) {
                numCoin = i + 1;
            }
        }
        if (numCoin == -1) {
            throw new Exception("Le coin n'appartient pas au conteneur");
        }
        return numCoin;
    }
    
    /**
     * Ajoute un Coin au Conteneur
     * @param coin
     * @return boolean
     */
    public boolean addCoin(Coin coin) {
        if(this.coins.size() >= 4) {
            return false;
        }
        
        return this.coins.add(coin);
    }
    
    /**
     * Retourne le Coin n°"index"
     * Index(0) => Haut-Gauche
     * Index(1) => Haut-Droit
     * Index(2) => Bas-Droit
     * Index(3) => Bas-Gauche
     * 
     * @param index
     * @return 
     */
    public Coin getCoin(int index) {
        return this.coins.get(index);
    }
    
    /**
     * Retourne la liste des Coin
     * @return 
     */
    public ArrayList<Coin> getCoins() {
        return this.coins;
    }
    
    /**
     * Définit la couleur du Conteneur
     * @param coul 
     */
    public void setColor(Couleur coul) {
        this.coul = coul;
    }
    
    /**
     * Retourne la couleur du Conteneur
     * @return 
     */
    public Couleur getColor() {
        return this.coul;
    }
    
    /**
     * Renvoie true si le Conteneur est prit.
     * @return 
     */
    public boolean isTaken() {
        return this.coul != Couleur.INNOCUPE;
    }
}
