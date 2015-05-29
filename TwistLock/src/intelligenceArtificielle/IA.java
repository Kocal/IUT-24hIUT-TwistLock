/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intelligenceArtificielle;

import static intelligenceArtificielle.EtatPartie.Inscription;
import java.util.ArrayList;
import tablier.Coin;
import tablier.Conteneur;
import tablier.Tablier;
import twistlock.Constante.Couleur;

/**
 *
 * @author Emilien
 */
public class IA {


    public Tablier t;

    public Couleur col;

    public int pointA, pointD;
    public Coordonee c, cA, cD;
    /*public int l, h, c;
    public int lA, hA, cA;
    public int lD, hD, cD;*/
    /*
     10- ah vous de jouer (Vert)
     20: coup adversaire: 9B1
    
    
     //ici chercher coin dont somme conteneur + élevé (voir où est adverse pour maximiser point
     */
    private EtatPartie state;

    public IA(Couleur col) {

        state = Inscription;
        this.col = col;
    }
    
    public void parseMap(String raw) {
        this.t = new Tablier(raw);
    }

    public void choixPlacer() {

        int nb = 0, l = 0, h = 0, nbCoin = 0;
        getBetterCoin(l, h, nbCoin);
        boolean[] bool = getCoinPossible(l, h);

    }

    public void meilleurMethode() {
        ///
        
       cA = methodeAttaque();
       cD = MethodeDefense();

        if (pointA > pointD) {
            c = cA;
        } else {
            c = cD;
        }

    }

    public Coordonee methodeAttaque() {

        //penser modiffier PointA
        Point p = getMeilleurCoin();
        return new Coordonee(0,0,0);
        
    }

    public Coordonee MethodeDefense() {
        
        return new Coordonee(0,0,0);

        //penser modiffier PointD
    }

    public void getBetterCoin(int l, int h, int nbC) {
        int conteneurL = 0;
        int conteneurH = 0;
        int nombreCoin = 0;
        ArrayList<Conteneur> cont;
        Coin c;
        int sum;
        for (int i = 0; i < t.getHauteur(); i++) {
            for (int j = 0; j < t.getLargeur(); j++) {
                for (int k = 0; k < 4; k++) {
                    c = t.getConteneur(i, j).getCoin(i);
                    sum = 0;
                    if (!c.isTaken()) {

                        cont = c.getConteneurs();
                        for (Conteneur cat : cont) {
                            sum += cat.valeur;
                        }
                        if (sum > nombreCoin) {
                            nombreCoin = sum;
                        }
                    }
                }
            }
        }
        l = conteneurL;
        h = conteneurH;
        nbC = nombreCoin;
    }

    // index correspond au type de message (20, 21, 22, 50, 88)
    public void getBetterConteneur(int nb, int l, int h) {

        int nbConteneur = 0;
        int conteneurL = 0;
        int conteneurH = 0;
        for (int i = 0; i < t.getHauteur(); i++) {
            for (int j = 0; j < t.getLargeur(); j++) {
                if (true) { // contenu conteneur > nbConteneur
                    nbConteneur = 1; //contenu conteneur
                    conteneurL = j;
                    conteneurH = i;
                }
            }
        }
        nb = nbConteneur;
        l = conteneurL;
        h = conteneurH;
    }

    public boolean[] getCoinPossible(int l, int h) {

        boolean b[] = new boolean[4];

        b[0] = true;
        b[1] = true;
        b[2] = true;
        b[3] = true;

        return b;
    }

    public int getTotalPoint() {
        int total = 0;

        for (int i = 0; i < t.getHauteur(); i++) {
            for (int j = 0; j < t.getLargeur(); j++) {
                Conteneur conteneur = t.getConteneur(i, j);

                int nombreAllier = 0;
                int nombreEnnemi = 0;
                for (Coin coin : conteneur.getCoins()) {
                    if (coin.getTaken() == col) {
                        nombreAllier++;
                    } else if (coin.getTaken() == Couleur.ROUGE && col == Couleur.VERT) {
                        nombreEnnemi++;
                    } else if (coin.getTaken() == Couleur.VERT && col == Couleur.ROUGE) {
                        nombreEnnemi++;
                    }
                }
                if (nombreAllier > nombreEnnemi) {
                    total += conteneur.valeur;
                }
            }
        }
        return total;
    }

    public void setEtatPartie(EtatPartie s) {
        this.state = s;
    }
    
    public EtatPartie getEtatPartie(){
        return this.state;
    }

    public int getTotalPointEnnemi() {
        int total = 0;

        for (int i = 0; i < t.getHauteur(); i++) {
            for (int j = 0; j < t.getLargeur(); j++) {
                Conteneur conteneur = t.getConteneur(i, j);

                int nombreAllier = 0;
                int nombreEnnemi = 0;
                for (Coin coin : conteneur.getCoins()) {
                    if (coin.getTaken() == col) {
                        nombreAllier++;
                    } else if (coin.getTaken() == Couleur.ROUGE && col == Couleur.VERT) {
                        nombreEnnemi++;
                    } else if (coin.getTaken() == Couleur.VERT && col == Couleur.ROUGE) {
                        nombreEnnemi++;
                    }
                }
                if (nombreEnnemi > nombreAllier) {
                    total += conteneur.valeur;
                }
            }
        }
        return total;
    }

    public Point getMeilleurCoin() {
        int total = this.getTotalPoint();
        int totalEnnemi = this.getTotalPointEnnemi();
        int maxTotal = 0;
        Point p = new Point(0, 0);

        Coin[][] coins = t.getCoins();

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[i].length; j++) {
                if (coins[i][j].getTaken() == Couleur.INNOCUPE) {
                    coins[i][j].setTaken(col);
                    int nouveauTotal = this.getTotalPoint();
                    int nouveauTotalEnnemi = this.getTotalPointEnnemi();

                    int diff = nouveauTotal - total + totalEnnemi - nouveauTotalEnnemi;
                    if (diff > maxTotal) {
                        maxTotal = diff;
                        p.ligne = i;
                        p.colonne = j;
                    }
                    coins[i][j].setTaken(Couleur.INNOCUPE);
           
                }
            }
        }
        return p;
    }

    public Point getMeilleurCoinEnnemi() {
        int totalEnnemi = this.getTotalPoint();
        int total = this.getTotalPointEnnemi();
        int maxTotal = 0;
        Point p = new Point(0, 0);

        Coin[][] coins = t.getCoins();

        Couleur colEnnemi;
        if (col == Couleur.ROUGE) {
            colEnnemi = Couleur.VERT;
        } else {
            colEnnemi = Couleur.ROUGE;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[i].length; j++) {
                if (coins[i][j].getTaken() == Couleur.INNOCUPE) {
                    coins[i][j].setTaken(colEnnemi);
                    int nouveauTotalEnnemi = this.getTotalPoint();
                    int nouveauTotal = this.getTotalPointEnnemi();

                    int diff = nouveauTotal - total + totalEnnemi - nouveauTotalEnnemi;
                    if (diff > maxTotal) {
                        maxTotal = diff;
                        p.ligne = i;
                        p.colonne = j;
                    }
                    coins[i][j].setTaken(Couleur.INNOCUPE);
                }
            }
        }
        return p;
    }
    
    private class Coordonee{
        
        public int h, l, c;

        public Coordonee(int h, int l, int c) {
            this.h = h;
            this.l = l;
            this.c = c;
        }
        
        
    }
}
