/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intelligenceArtificielle;

import java.util.ArrayList;
import tablier.Coin;
import tablier.Conteneur;
import tablier.Tablier;
import twistlock.Constante.couleur;

/**
 *
 * @author Emilien
 */
public class IA {

    private Tablier t;
    
    public couleur col;
            
    /*
     10- ah vous de jouer (Vert)
     20: coup adversaire: 9B1
    
    
     //ici chercher coin dont somme conteneur + élevé (voir où est adverse pour maximiser point
     */

    public void choixPlacer() {

        int nb = 0, l = 0, h = 0, nbCoin = 0;
        getBetterCoin(l, h, nbCoin);
        boolean[] bool = getCoinPossible(l, h);

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
                        for(Conteneur cat:cont ){
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

}
