package tablier;

import java.util.ArrayList;

/**
 *
 * @author Kocal
 */
public class Tablier {
    
    /**
     * Hauteur de la hauteur de jeu
     */
    private int hauteur;
    
    /**
     * Largeur de la grille de jeu
     */
    private int largeur;
    
    private Conteneur[][] grille;
    
    public Tablier(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        
        
        this.initGrille();
    }
    
    private void initGrille() {
        this.grille = new Conteneur[this.hauteur][this.largeur];
        
        for(int i = 0; i < this.hauteur; i++) {
            for(int j = 0; j < this.largeur; j++) {
                this.grille[i][j] = new Conteneur();
            }
        }
    }
    
    /**
     * Retourne la hauteur de la grille
     * @return 
     */
    public int getHauteur() {
        return this.hauteur;
    }
    
    /**
     * Retourne la largeur de la grille
     * @return int
     */
    public int getLargeur() {
        return this.largeur;
    }
    
    @Override
    public String toString() {
        String s = "";
        
        for(int i = 0; i < this.hauteur; i++) {
            for(int j = 0; j < this.largeur; j++) {
                s += "|" + this.grille[i][j];
            }
            
            s += "|\n";
        }
        
        return s;
    }
}
