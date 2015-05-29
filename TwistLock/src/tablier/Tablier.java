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
    
    /**
     * Instancie un nouveau Tablier de dimension "hauteur" * "largeur"
     * @param hauteur Hauteur de la grille
     * @param largeur Largeur de la grille
     */
    public Tablier(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.initGrille(hauteur, largeur);
    }
    
    /**
     * Instancie un nouveau Tablier en fonction de "grilleChaine"
     * @param grilleChaine 
     */
    public Tablier(String grilleChaine) {
        this.initGrille(grilleChaine);
    }
    
    /**
     * Initialise une grille de dimension "hauteur" * "largeur"
     * @param hauteur Hauteur de la grille
     * @param largeur Largeur de la grille
     */
    private void initGrille(int hauteur, int largeur) {
        this.grille = new Conteneur[hauteur][largeur];
        
        for(int i = 0; i < hauteur; i++) {
            for(int j = 0; j < largeur; j++) {
                this.grille[i][j] = new Conteneur(i, j, (int) (Math.random() * 49 + 5));
            }
        }
    }
    
    /**
     * Initialise une grille de dimension "hauteur" * "largeur"
     * @param grilleChaine 
     */
    private void initGrille(String rawMap) {
        
        this.grille = new Conteneur[this.hauteur][this.largeur];

        //rawMap = "MAP=1:2:3:4:5:6:7:8:9:10|11:12:13:14:15:16:17:18:19:20|21:22:23:24:25:26:27:28:29:30|";

        String[] grid_lines = rawMap.substring(4).split("\\|");

        for (int j = 0; j < grid_lines.length; j++) {

            String[] grid_column = grid_lines[j].split(":");

            for (int i = 0; i < grid_column.length; i++) {

                this.grille[i][j] = new Conteneur(i, j, Integer.valueOf(grid_column[i]));

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
                s += "|" + this.grille[i][j].valeur;
            }
            
            s += "|\n";
        }
        
        return s;
    }
    
    /**
     * Retourne le Conteneur à la ligne "ligne" et à la colonne "colonne"
     * @param ligne
     * @param colonne
     * @return Conteneur
     */
    public Conteneur getConteneur(int ligne, int colonne) {
        if(ligne < 0 || ligne >= this.hauteur
        || colonne < 0 || colonne >= this.largeur) {
            return null;
        }
        
        return this.grille[ligne][colonne];
    }
}
