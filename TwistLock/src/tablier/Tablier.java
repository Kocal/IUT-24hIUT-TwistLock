package tablier;

import java.util.ArrayList;
import java.util.Arrays;
import twistlock.Constante;
import twistlock.Constante.Couleur;

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

    /**
     * Tableau 2D de Conteneurs
     */
    private Conteneur[][] grille;
    
    /**
     * Tableau 2D de Coins
     */
    private Coin[][] coins;

    /**
     * Instancie un nouveau Tablier de dimension "hauteur" * "largeur"
     *
     * @param hauteur Hauteur de la grille
     * @param largeur Largeur de la grille
     */
    public Tablier(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.init(hauteur, largeur);
    }

    /**
     * Instancie un nouveau Tablier en fonction de "grilleChaine"
     *
     * @param grilleChaine
     */
    public Tablier(String grilleChaine) {
        this.init(grilleChaine);
    }
    
    public Tablier(Tablier t){
        this.hauteur = t.hauteur;
        
        this.largeur = t.largeur;
        this.init(hauteur, largeur);
        for(int i = 0; i < largeur; i ++){
            for(int j = 0; j < hauteur; j ++){
                this.grille[j][i] = new Conteneur(t.getConteneur(j, i));
                this.coins[j][i] = new Coin(t.getCoin(j, i));
            }
        }
    }

    /**
     * Initialise une grille de dimension "hauteur" * "largeur"
     *
     * @param hauteur Hauteur de la grille
     * @param largeur Largeur de la grille
     */
    private void init(int hauteur, int largeur) {
        this.grille = new Conteneur[hauteur][largeur];
        this.coins = new Coin[hauteur + 1][largeur + 1];

        for (int i = 0; i <= hauteur; i++) {
            for (int j = 0; j <= largeur; j++) {
                if(i != hauteur && j != largeur) {
                    this.grille[i][j] = new Conteneur(i, j, (int) (Math.random() * 49 + 5));
                }
                
                this.coins[i][j] = new Coin();
            }
        }
        
        this.patchCoins();
    }

    /**
     * Initialise une grille de dimension "hauteur" * "largeur"
     *
     * @param grilleChaine
     */
    public String purger(String rawMap)
    {
        try
        {
            rawMap = rawMap.split("\n")[1];
            String[] chaines = rawMap.split("|");
            String chaine = chaines[chaines.length-1];
            rawMap = rawMap.replaceAll(chaine, "");
            rawMap = rawMap.replaceAll(" ", "");
            return rawMap;
        }
        catch(Exception ex)
        {
            return rawMap;
        }
    }
    
    private void init(String rawMap) {

        //rawMap = "MAP=1:2:3:4:5:6:7:8:9:10|11:12:13:14:15:16:17:18:19:20|21:22:23:24:25:26:27:28:29:30|";
//        rawMap = purger(rawMap);
        String[] grid_lines = rawMap.substring(4).split("\\|");
        
        this.hauteur = grid_lines.length - 1;
        this.largeur = grid_lines[0].split(":").length;

        this.grille = new Conteneur[hauteur][largeur];
        this.coins = new Coin[hauteur + 1][largeur + 1];

        for (int j = 0; j < grid_lines.length - 1; j++) {
             
            String[] grid_column = grid_lines[j].split(":");

            for (int i = 0; i < grid_column.length; i++) {
//                System.out.println("Grille["+j+"]["+i+"] = " + grid_column[i]);
                if(!grid_column[i].isEmpty()) {
                    this.grille[j][i] = new Conteneur(j, i, Integer.valueOf(grid_column[i]));
                }
            }
        }
        
        for (int i = 0; i <= hauteur; i++) {
            for (int j = 0; j <= largeur; j++) {
                this.coins[i][j] = new Coin();
            }
        }

        this.patchCoins();
    }

    /**
     * Retourne la hauteur de la grille
     *
     * @return
     */
    public int getHauteur() {
        return this.hauteur;
    }

    /**
     * Retourne la largeur de la grille
     *
     * @return int
     */
    public int getLargeur() {
        return this.largeur;
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                s += "|" + this.grille[i][j].valeur;
            }

            s += "|\n";
        }

        return s;
    }

    /**
     * Retourne le Conteneur à la ligne "ligne" et à la colonne "colonne"
     *
     * @param ligne
     * @param colonne
     * @return Conteneur
     */
    public Conteneur getConteneur(int ligne, int colonne) {
        if (ligne < 0 || ligne >= this.hauteur
                || colonne < 0 || colonne >= this.largeur) {
            return null;
        }

        return this.grille[ligne][colonne];
    }
    
    public Coin getCoin(int ligne, int colonne) {
        if (ligne < 0 || ligne >= this.hauteur
                || colonne < 0 || colonne >= this.largeur) {
            return null;
        }

        return this.coins[ligne][colonne];
    }
    
    /**
     * Retourne un tableau 2D de Coin
     * @return 
     */
    public Coin[][] getCoins() {
        return this.coins;
    }
    
    /**
     * Associe les Coin et Conteneurs
     */
    private void patchCoins() {
        for(int i = 0; i < this.hauteur; i++) {
            for(int j = 0; j < this.largeur; j++) {
                this.grille[i][j].addCoin(this.coins[i][j]);
                this.grille[i][j].addCoin(this.coins[i][j + 1]);
                this.grille[i][j].addCoin(this.coins[i + 1][j + 1]);
                this.grille[i][j].addCoin(this.coins[i + 1][j]);
                
                this.coins[i][j].addConteneur(this.grille[i][j]);
                this.coins[i][j + 1].addConteneur(this.grille[i][j]);
                this.coins[i + 1][j + 1].addConteneur(this.grille[i][j]);
                this.coins[i + 1][j].addConteneur(this.grille[i][j]);
            }
        }
    }
    
    public void mettreAJourPositionEnnemi(String chaine, Couleur colEnnemi)
    {
        int ligne = chaine.charAt(0)-'1';
        int colonne = chaine.charAt(1)-'A';
        int numCoin = chaine.charAt(2)-'1';
        
        this.grille[ligne][colonne].getCoin(numCoin).setTaken(colEnnemi);      
    }
}
